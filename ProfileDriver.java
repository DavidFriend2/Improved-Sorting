package sorting;

import java.util.List;

/**
 * Driver used to run SortProfiler.
 *
 * @author David Friend
 * @version 11/2023
 */
public class ProfileDriver {
  
  /**
   * Main method used to run SortProfiler.
   */
  public static void main(String[] args) {

    // Create a SortProfiler object.
    // See the JavaDoc for an explanation of the parameters.
    SortProfiler mergeAdapt = new SortProfiler(List.of(MergeSortImproved::mergeSortAdaptive),
                                               List.of("MergeSortAdaptive"),
                                               0, 100, 1000, 50000,
                                               Generators::generateOrdered);
    
    SortProfiler mergeHalfSpace = new SortProfiler(List.of(MergeSortImproved::mergeSortHalfSpace),
                                                   List.of("MergeSortHalfSpace"),
                                                   100, 5, 125, 50000,
                                                   Generators::generateRandom);

    SortProfiler origMerge = new SortProfiler(List.of(MergeSort::mergeSort),
                                              List.of("MergeSort"),
                                              0, 100, 1000, 50000,
                                              Generators::generateOrdered);

    SortProfiler introspective = new SortProfiler(List.of(IntrospectiveSort::introspectiveSort),
                                                       List.of("IntrospectiveSort"),
                                                       0, 100, 1000, 50000,
                                                       Generators::generateEvil);
    
    SortProfiler quicksort = new SortProfiler(List.of(QuickSort::quickSort),
                                                   List.of("QuickSort"),
                                                   0, 100, 1000, 50000,
                                                   Generators::generateOrdered);

    SortProfiler insertion = new SortProfiler(List.of(BasicSorts::insertionSort),
                                              List.of("InsertionSort"),
                                              100, 5, 125, 50000,
                                              Generators::generateRandom);
    // Run the profiler and send the output to stdout.
    // introspective.run(System.out);
    //  System.out.println();
    // quicksort.run(System.out);
    
    //mergeAdapt.run(System.out);
    //System.out.println();
    mergeHalfSpace.run(System.out);
    //introspective.run(System.out);
    System.out.println();
    insertion.run(System.out);
    //quicksort.run(System.out);
    //origMerge.run(System.out);
  }

}
