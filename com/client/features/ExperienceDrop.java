package com.client.features;

import java.text.NumberFormat;

public class ExperienceDrop
{
  private final long amount;
  private final int[] skills;
  private int yPosition = 150;
  public static final int END_Y = 41;
  public static final int START_Y = 150;
  public static final int EXCESS_DISTANCE = 164;
  private static final int INTERVAL = 1;
  
  public ExperienceDrop(long amount, int... skills)
  {
    this.amount = amount;
    this.skills = skills;
  }
  
  public void pulse()
  {
    yPosition -= 1;
    if (yPosition < 41) {
      yPosition = -1;
    }
  }
  
  public void increasePosition(int offset)
  {
    yPosition += offset;
  }
  
  public byte getTransparency()
  {
    int halfway = 75;
    if (yPosition > halfway) {
      return 100;
    }
    byte percentile = 1;
    if (percentile < 0) {
      return 0;
    }
    return (byte)Math.abs(percentile * yPosition);
  }
  
  public final long getAmount()
  {
    return amount;
  }
  
  public final int[] getSkills()
  {
    return skills;
  }
  
  public final int getYPosition()
  {
    return yPosition;
  }
  
  public String toString()
  {
    return NumberFormat.getInstance().format(amount);
  }
}
