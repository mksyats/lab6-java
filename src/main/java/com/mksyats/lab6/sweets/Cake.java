package com.mksyats.lab6.sweets;

/**
 * Represents a type of sweet that is cake.
 */
public class Cake extends Sweet {

  /**
   * Constructs a new {@code Cake} instance with the specified name, weight, and cocoa amount.
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
  public Cake(String name, float weight, double cocoaAmount) {
    super(name, weight, cocoaAmount);
  }

  /**
   * Returns a string representation of this cake, including basic sweet information.
   *
   * @return a formatted string representation of the cake
   */
  @Override
  public String toString() {
    return String.format("%-10s %s", getClass().getSimpleName(), super.toString());
  }
}
