package com.mksyats.lab6.collection;

import java.util.Set;
import java.util.Collection;
import java.util.Objects;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.mksyats.lab6.sweets.Sweet;

/**
 * A custom implementation of a set designed to hold {@link Sweet} objects. This set maintains
 * unique elements, disallowing duplicates, and dynamically adjusts its internal storage capacity as
 * elements are added or removed.
 *
 * @param <S> the type of {@link Sweet} objects stored in this set
 */
public class SweetSet<S extends Sweet> implements Set<S> {

  // The initial capacity of the internal array when the set is created
  private static final int INITIAL_CAPACITY = 15;

  // The factor by which the array grows when it exceeds its capacity
  private static final double GROWTH_FACTOR = 1.3;

  // The threshold factor to determine when the array should shrink
  private static final double SHRINK_THRESHOLD_FACTOR = 5;

  private S[] sweets;
  private int size;

  /**
   * Creates an empty {@code SweetSet} with an initial capacity.
   */
  @SuppressWarnings("unchecked cast")
  public SweetSet() {
    sweets = (S[]) new Sweet[INITIAL_CAPACITY];
    size = 0;
  }

  /**
   * Creates a {@code SweetSet} containing a single sweet.
   *
   * @param sweet the sweet to add to the set
   * @throws NullPointerException if the specified sweet is null
   */
  public SweetSet(S sweet) {
    this();
    add(sweet);
  }

  /**
   * Creates a {@code SweetSet} containing all elements in the specified collection.
   *
   * @param sweets the collection of sweets to initialize the set with
   * @throws NullPointerException if the specified collection is null
   */
  public SweetSet(Collection<S> sweets) {
    this();
    addAll(sweets);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean contains(Object o) {
    for (S s : sweets) {
      if (Objects.equals(s, o)) {
        return true;
      }
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Set<?> other)) {
      return false;
    }
    return size == other.size() && containsAll(other);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int hashCode = 0;
    for (S s : this) {
      if (s != null) {
        hashCode += s.hashCode();
      }
    }
    return hashCode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterator<S> iterator() {
    return new Iterator<>() {
      private int curIdx = 0;

      @Override
      public boolean hasNext() {
        return curIdx < size;
      }

      @Override
      public S next() {
        if (!hasNext()) {
          throw new NoSuchElementException("No more sweets...");
        }
        return sweets[curIdx++];
      }
    };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean add(S s) {
    if (contains(s)) {
      return false;
    }
    ensureCapacity();
    sweets[size++] = s;
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean addAll(Collection<? extends S> c) {
    boolean modified = false;
    for (S s : c) {
      if (add(s)) {
        modified = true;
      }
    }
    return modified;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(sweets[i], o)) {
        int numToMove = size - i - 1;
        if (numToMove > 0) {
          System.arraycopy(sweets, i + 1, sweets, i, numToMove);
        }
        sweets[--size] = null;
        tryToShrinkCapacity();
        return true;
      }
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean removeAll(Collection<?> c) {
    boolean modified = false;
    for (Object o : c) {
      if (remove(o)) {
        modified = true;
      }
    }
    return modified;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    for (int i = 0; i < size; i++) {
      if (!c.contains(sweets[i])) {
        remove(sweets[i]);
        i--; // Adjust index after removal
        modified = true;
      }
    }
    return modified;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    Arrays.fill(sweets, 0, size, null);
    size = 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] toArray() {
    return Arrays.copyOf(sweets, size);
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked cast")
  @Override
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      return (T[]) Arrays.copyOf(sweets, size, a.getClass());
    }
    for (int i = 0; i < size; i++) {
      a[i] = (T) sweets[i];
    }
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  /**
   * Ensures the internal array has sufficient capacity to store additional elements. If the current
   * capacity is insufficient, the array size is increased based on {@code GROWTH_FACTOR}.
   */
  private void ensureCapacity() {
    if (size >= sweets.length) {
      int newCapacity = (int) (sweets.length * GROWTH_FACTOR);
      sweets = Arrays.copyOf(sweets, newCapacity);
    }
  }

  /**
   * Reduces the internal array size if the number of elements falls below a shrink threshold. The
   * new capacity will not go below {@code INITIAL_CAPACITY}.
   */
  private void tryToShrinkCapacity() {
    if (size < sweets.length / SHRINK_THRESHOLD_FACTOR && sweets.length > INITIAL_CAPACITY) {
      int newCapacity = Math.max(INITIAL_CAPACITY, (int) (sweets.length / GROWTH_FACTOR));
      sweets = Arrays.copyOf(sweets, newCapacity);
    }
  }
}
