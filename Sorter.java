package sorting;

/**
 * Functional interface for sorting methods.
 *
 * @author CS240 Instructors
 * @version 2/2019
 *
 */
@FunctionalInterface
public interface Sorter<T extends Comparable<T>> {
  void sort(T[] items);
}
