package edu.cnm.deepdive;

public class MergeSort {


  public void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public void sort(int[] data, int startPosition, int endPosition) {
    if (endPosition > startPosition + 1) {
      // 1st step = Divide (start to end) get the average
      int midPosition = (startPosition + endPosition) / 2;
      // 2nd step = Conquer (sort separately through multithreading? How could I do this?)
      sort(data, startPosition, midPosition); // Sort left array
      sort(data, midPosition, endPosition); // Sort right array
      // 3rd step = Merge
      int[] merged = new int[endPosition - startPosition];
      int mergedPosition = 0;
      int leftPosition = startPosition;
      int rightPosition = midPosition;
      while (leftPosition < midPosition && rightPosition < endPosition) {
        int leftValue = data[leftPosition];
        int rightValue = data[rightPosition];
        // Now compare the values, depending on higher value, move it into array
        if (leftValue <= rightValue) {
          merged[mergedPosition] = leftValue;
          leftPosition++; // Increments up
        } else {
          merged[mergedPosition] = rightValue;
          rightPosition++;
        }
        mergedPosition++;
        // One pile is exhausted at this point
      }
      // Figure out which pile still has stuff in it, and copy it into merged []
      if (leftPosition < midPosition) {
        System.arraycopy(data, leftPosition, merged, mergedPosition, midPosition - leftPosition);
      } else {
        System.arraycopy(data, rightPosition, merged, mergedPosition, endPosition - rightPosition);
      }
      System.arraycopy(merged, 0, data, startPosition, merged.length);
    }
  }

}
