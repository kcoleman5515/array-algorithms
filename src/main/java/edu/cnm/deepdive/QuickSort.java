package edu.cnm.deepdive;

public class QuickSort {

  public void sort(int[] data) {
    sort(data, 0, data.length);  // Order of params
    // sort data, starting and including, up to but not including...

  }

  public void sort(int[] data, int startPosition, int endPosition) {
    // Below: What if startPosition is equal to or only one greater than endPosition?
    if (endPosition > startPosition + 1) {
      // All of this is part of the Divide
      int pivotValue = data[startPosition];
      int dividerPosition = startPosition;
      for (int currentPosition = startPosition + 1; currentPosition < endPosition; currentPosition++) {
        int currentValue = data[currentPosition];
        if (currentValue <= pivotValue) {
          dividerPosition++;
          if (dividerPosition < currentPosition) {
            data[currentPosition] = data[dividerPosition];
            data[dividerPosition] = currentValue;
          }
        }
      }
      data[startPosition] = data[dividerPosition];
      data[dividerPosition] = pivotValue; // Value is FIXED in final position!!!
      sort(data, startPosition, dividerPosition); // Sort left-hand partition.
      sort(data, dividerPosition + 1, endPosition); // Sort right-hand partition.
      // Conquer?????
    }
  }

}
