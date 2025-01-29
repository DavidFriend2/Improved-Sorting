package sorting;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SortingTest {

  @Test
  void test() {
    Integer[] items = {2,4,5,3,1};
    System.out.println(Arrays.toString(items));
    IntrospectiveSort.introspectiveSort(items);
    System.out.println(Arrays.toString(items));
    
    IntrospectiveSort.introspectiveSort(items);
    System.out.println(Arrays.toString(items));
    
    items = new Integer[]{9,8,7,6,5,4,3,2,1};
    //System.out.println(Arrays.toString(items));
    MergeSortImproved.mergeSortAdaptive(items);
    //System.out.println(Arrays.toString(items));
    MergeSortImproved.mergeSortAdaptive(items);
    //System.out.println(Arrays.toString(items));
    
    items = new Integer[]{9,8,7,6,5,4,3,2,1};
    //System.out.println(Arrays.toString(items));
    MergeSortImproved.mergeSortHalfSpace(items);
    //System.out.println(Arrays.toString(items));
    MergeSortImproved.mergeSortHalfSpace(items);
    //System.out.println(Arrays.toString(items));
    
    items = new Integer[151];
    int count = 0;
    for (int i = 150; i >= 0; i--) {
      items[count] = i;
      count++;
    }
    //items = new Integer[]{9,8,7,6,5,4,3,2,1,0};
    
    //System.out.println(Arrays.toString(items));
    MergeSortImproved.mergeSubsortAdaptive(items, 1, 150);
    //System.out.println(Arrays.toString(items));
    //MergeSortImproved.mergeSubsortAdaptive(items, 0, 9);
    //System.out.println(Arrays.toString(items));
    
    items = new Integer[]{9,8,7,6,5,4,3,2,1};
    //System.out.println(Arrays.toString(items));
    BasicSorts.insertionSubsort(items, 0, 5);
    //System.out.println(Arrays.toString(items));
  }

}
