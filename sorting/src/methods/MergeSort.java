package methods;

public class MergeSort {
    /*
    Merge Sort sorting algorithm implementation
        - Best case: O(n log(n))
        - Average case: O(n log(n))
        - Worst case: O(n log(n))

    Not in place algorithm
     */

    public static void sort(int[] numbers){
        int[] aux = new int[numbers.length];

        MergeSort._sort(numbers, aux, 0, numbers.length - 1);
    }

    private static void _sort(int[] array, int[] aux, int lo, int hi){
        if (lo >= hi){
            return;
        }

        int mid = (lo + hi) / 2;

        MergeSort._sort(array, aux, lo, mid);
        MergeSort._sort(array, aux, mid + 1, hi);

        if (array[mid + 1] > array[mid]){
            return;
        }

        MergeSort.merge(array, aux, lo, mid, hi);

    }

    private static void merge(int numbers[], int[] aux, int lo, int mid, int hi){
        for (int i=lo; i <= hi; i++){
            aux[i] = numbers[i];
        }

        int first = lo, second = mid + 1;

        for (int i=lo; i <= hi; i++){
            // second half is already empty
            if (second > hi){
                numbers[i] = aux[first++];
            }
            // second half is already empty
            else if (first > mid){
                numbers[i] = aux[second++];
            }
            // item in the first half is smaller
            else if (aux[first] < aux[second]){
                numbers[i] = aux[first++];
            }
            // item in the second half is greater or equal
            else{
                numbers[i] = aux[second++];
            }
        }
    }
}
