package com.mksyats.lab6.sweets;

/**
 * Represents a type of sweet that is candy.
 */
public class Candy extends Sweet {

  private final String flavor;

  /**
   * Constructs a new {@code Candy} instance with the specified name, weight, cocoa content, and
   * flavor.
   *
   * @param name        the name of the candy
   * @param weight      the weight of the candy in grams
   * @param cocoaAmount the cocoa content as a fraction
   * @param flavor      the flavor of the candy (must not be null or empty)
   * @throws IllegalArgumentException if any of the parameters are invalid:
   *                                  <ul>
   *                                    <li>name is null or empty</li>
   *                                    <li>weight is negative</li>
   *                                    <li>cocoaAmount is not in range [0, 1]</li>
   *                                    <li>flavor is null or empty</li>
   *                                  </ul>
   */
  public Candy(String name, float weight, double cocoaAmount, String flavor) {
    super(name, weight, cocoaAmount);

    if (flavor == null || flavor.isEmpty()) {
      throw new IllegalArgumentException("flavor cannot be null or empty");
    }
    this.flavor = flavor;
  }

  /**
   * Gets the flavor of this candy.
   *
   * @return the flavor of the candy
   */
  public String getFlavor() {
    return flavor;
  }

  /**
   * Returns a string representation of this candy, including basic sweet information and flavour.
   *
   * @return a formatted string representation of the candy
   */
  @Override
  public String toString() {
    return String.format("%-10s %s, flavor: %s",
        getClass().getSimpleName(), super.toString(), flavor);
  }
}
