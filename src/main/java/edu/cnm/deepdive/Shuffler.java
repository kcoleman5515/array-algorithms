package edu.cnm.deepdive;

import java.util.Random;

public class Shuffler {

  private final Random rng;

  public Shuffler(Random rng) {
    this.rng = rng;
  }

  //shuffle the array in place but do not create a new array
  //available to everyone, doesn't return, modify the array called data
  public void shuffle(int[] data) {
    for (int targetIndex = data.length - 1; targetIndex > 0; targetIndex--) {
      int sourceIndex = rng.nextInt(targetIndex + 1);
      int temp = data[targetIndex];
      data[targetIndex] = data[sourceIndex];
      data[sourceIndex] = temp;
    }
  }
}
