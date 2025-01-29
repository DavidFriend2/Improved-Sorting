package sorting;

/**
 * IntrospectiveSort class.
 */

public class IntrospectiveSort {
  /**
   * Sort the provided items using introspective sort.
   */
  public static <T extends Comparable<T>> void introspectiveSort(T[] items) {
    introspectiveSort(items, 2 * (int) Math.floor(Math.log(items.length) / Math.log(2)), 
        0, items.length - 1);
  }
  
  private static <T extends Comparable<T>> void introspectiveSort(T[] items, int depth, 
      int start, int end) {
    if (depth == 0) {
      MergeSortImproved.mergeSubsortAdaptive(items, start, end);
    } else {
      if (start >= end) {
        return;
      }
      int pivot = QuickSort.partition(items, start, end, (start + end) / 2);
      introspectiveSort(items, depth - 1, start, pivot - 1);
      introspectiveSort(items, depth - 1, pivot + 1, end);
    }
  }
}
