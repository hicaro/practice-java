package methods;

public class InsertionSort {
    /*
    Insertion Sort sorting algorithm implementation
        - Best case: O(n)
        - Average case: O(n^2)
        - Worst case: O(n^2)
     */

    public static void sort(int[] numbers){
        int len = numbers.length;

        for (int i=1; i < len; i++){
            int to_insert = numbers[i];
            int j = i - 1;

            while (j >= 0 && to_insert < numbers[j]){
                numbers[j+1] = numbers[j];
                j--;
            }

            numbers[j+1] = to_insert;
        }
    }
}
