package com.mksyats.lab6.sweets;

/**
 * Represents a type of sweet that is cookie.
 */
public class Cookie extends Sweet {

  private final boolean hasFilling;

  /**
   * Constructs a new {@code Cookie} instance with the specified attributes, including name, weight,
   * cocoa amount, and whether it has a filling.
   *
   * @param name        the name of the cookie
   * @param weight      the weight of the cookie in grams
   * @param cocoaAmount the cocoa amount as a fraction
   * @param hasFilling  {@code true} if the cookie has a filling, {@code false} otherwise
   * @throws IllegalArgumentException if any of the parameters are invalid:
   *                                  <ul>
   *                                    <li>name is null or empty</li>
   *                                    <li>weight is negative</li>
   *                                    <li>cocoaAmount is not in range [0, 1]</li>
   *                                  </ul>
   */
  public Cookie(String name, float weight, double cocoaAmount, boolean hasFilling) {
    super(name, weight, cocoaAmount);
    this.hasFilling = hasFilling;
  }

  /**
   * Checks if the cookie has a filling.
   *
   * @return {@code true} if the cookie has a filling, {@code false} otherwise
   */
  public boolean hasFilling() {
    return hasFilling;
  }

  /**
   * Returns a string representation of this cookie, including basic sweet information and the fact
   * about filling presence.
   *
   * @return a formatted string representation of the cookie
   */
  @Override
  public String toString() {
    return String.format("%-10s %s, filling: %s",
        getClass().getSimpleName(), super.toString(), (hasFilling ? "yes" : "no"));
  }
}
