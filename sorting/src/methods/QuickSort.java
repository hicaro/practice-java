package methods;

public class QuickSort {
    /*
    Quick Sort sorting algorithm implementation
        - Best case: O(n log(n))
        - Average case: O(n log(n))
        - Worst case: O(n ^ 2)

     In place algorithm
     */

    public static void sort(int[] numbers){
        QuickSort._sort(numbers, 0, numbers.length - 1);
    }

    private static void _sort(int[] numbers, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int index = QuickSort.partition(numbers, lo, hi);

        QuickSort._sort(numbers, lo, index - 1);
        QuickSort._sort(numbers, index + 1, hi);
    }

    private static int partition(int numbers[], int lo, int hi){
        int pivot = numbers[(lo + hi)/2];

        int ilo = lo, ihi = hi;

        while (ilo < ihi){
            // find its location coming from the bottom
            while (numbers[ilo] < pivot){
                if (ilo == hi){
                    break;
                }
                ilo++;
            }

            // find its location coming from the top
            while (numbers[ihi] > pivot){
                if (ihi == lo){
                    break;
                }
                ihi--;
            }

            int aux = numbers[ilo];
            numbers[ilo] = numbers[ihi];
            numbers[ihi] = aux;
        }
        // could return either 'ilo' or 'ihi', they are the same by now.
        return ilo;
    }
}
