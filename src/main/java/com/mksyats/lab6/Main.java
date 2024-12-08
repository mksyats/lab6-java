package com.mksyats.lab6;

import java.util.Arrays;

import com.mksyats.lab6.sweets.*;
import com.mksyats.lab6.collection.SweetSet;

/**
 * This class demonstrates the usage of the {@link SweetSet} class with various types of sweets,
 * such as {@link Candy}, {@link Cookie}, and {@link Cake}. It performs operations such as adding,
 * removing, clearing, and retaining elements in the sets while showcasing how {@code SweetSet}
 * manages unique elements.
 */
public class Main {

  /**
   * The main method serving as the entry point of the application.
   *
   * @param args the command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Create and manipulate Candy SweetSet
    var candy1 = new Candy("Mint Bliss", 10.5f, 0.267, "Mint");
    var candy2 = new Candy("Choco Delight", 20.3f, 0.5, "Chocolate");
    var candy3 = new Candy("Golden Caramel", 12.25f, 0.125, "Caramel");

    SweetSet<Candy> candies = new SweetSet<>();
    candies.add(candy1);
    candies.add(candy2);
    candies.add(candy3);
    candies.remove(candy1);

    printSweetSet("Candies:", candies);

    // Create and manipulate Cookie SweetSet
    var cookie1 = new Cookie("Creamy Surprise", 30f, 0.35, true);
    var cookie2 = new Cookie("Oat Crunch", 20.4f, 0.155, false);
    var cookie3 = new Cookie("Choco Chip Treat", 25.8f, 0.4, false);

    SweetSet<Cookie> cookies = new SweetSet<>(cookie1);
    cookies.addAll(Arrays.asList(cookie2, cookie3));

    printObjArray("Cookies before:", cookies.toArray());

    if (cookies.contains(cookie2)) {
      cookies.clear();
    }

    printSweetSet("Cookies after:", cookies);

    // Create and manipulate Cake SweetSet
    var cake1 = new Cake("Forest Fantasy", 500.35f, 0.6);
    var cake2 = new Cake("Vanilla Dream", 260f, 0.2);
    var cake3 = new Cake("Molten Magic", 350.25f, 0.7);

    SweetSet<Cake> cakes = new SweetSet<>(Arrays.asList(cake1, cake2, cake3));

    cakes.retainAll(Arrays.asList(cake1, cake3));

    printObjArray("Cakes:", cakes.toArray(Sweet[]::new));
  }

  /**
   * Utility method to print the contents of a {@link SweetSet}.
   *
   * @param message the message to display before printing the set
   * @param sweets  the {@code SweetSet} to be printed
   * @param <S>     the type of {@link Sweet} objects in the set
   */
  private static <S extends Sweet> void printSweetSet(String message, SweetSet<S> sweets) {
    System.out.println(message);
    for (S sweet : sweets) {
      System.out.println(sweet);
    }
    System.out.println();
  }

  /**
   * Utility method to print the contents of an {@code Object} array.
   *
   * @param message the message to display before printing the array
   * @param objs    the array of objects to be printed
   */
  private static void printObjArray(String message, Object[] objs) {
    System.out.println(message);
    for (Object o : objs) {
      System.out.println(o);
    }
    System.out.println();
  }
}
