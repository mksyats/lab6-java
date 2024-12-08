package com.mksyats.lab6.sweets;

/**
 * Represents a generic sweet item with basic attributes. Implements the {@code Comparable}
 * interface to allow comparison between sweets based on their weight.
 */
public abstract class Sweet implements Comparable<Sweet> {

  private final String name;
  private final float weight;
  private final double cocoaAmount;

  /**
   * Constructs a new {@code Sweet} instance with the specified name, weight, and cocoa amount.
   *
   * @param name        the name of the sweet
   * @param weight      the weight of the sweet in grams
   * @param cocoaAmount the cocoa content as a fraction
   * @throws IllegalArgumentException if any of the parameters are invalid:
   *                                  <ul>
   *                                    <li>name is null or empty</li>
   *                                    <li>weight is negative</li>
   *                                    <li>cocoaAmount is not in range [0, 1]</li>
   *                                  </ul>
   */
  protected Sweet(String name, float weight, double cocoaAmount) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("name cannot be null or empty");
    }
    this.name = name;

    if (weight < 0) {
      throw new IllegalArgumentException("weight value cannot be negative");
    }
    this.weight = weight;

    if (cocoaAmount < 0 || cocoaAmount > 1) {
      throw new IllegalArgumentException("cocoa amount value out of range [0, 1]");
    }
    this.cocoaAmount = cocoaAmount;
  }

  /**
   * Gets the name of this sweet.
   *
   * @return the name of the sweet
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the weight of this sweet.
   *
   * @return the weight of the sweet in grams
   */
  public float getWeight() {
    return weight;
  }

  /**
   * Gets the cocoa amount of this sweet.
   *
   * @return the cocoa amount as a fraction (value between 0 and 1)
   */
  public double getCocoaAmount() {
    return cocoaAmount;
  }

  /**
   * Compares this sweet with another based on weight.
   *
   * @param other the other sweet to compare with
   * @return a negative integer, zero, or a positive integer as this sweet is less than, equal to,
   * or greater than the specified sweet
   */
  @Override
  public int compareTo(Sweet other) {
    return Float.compare(weight, other.weight);
  }

  /**
   * Returns a string representation of this sweet, including its name, weight in grams, and cocoa
   * amount in percentage.
   *
   * @return a formatted string representation of the sweet
   */
  @Override
  public String toString() {
    String name = "'" + this.name + "'";

    return String.format("%-20s weight: %6.2fg, cocoa amount: %4.1f%%",
        name, weight, cocoaAmount * 100);
  }
}
