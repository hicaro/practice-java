package methods;

public class SelectionSort {

    /*
    Selection Sort sorting algorithm implementation
        - Best case: O(n^2)
        - Average case: O(n^2)
        - Worst case: O(n^2)
     */

    public static void sort(int[] numbers){
        int len = numbers.length;

        for (int i=0; i < len-1; i++){
            int min = i;

            for (int j=i+1; j < len; j++){
                if(numbers[j] < numbers[min]){
                    min = j;
                }
            }

            if (min != i){
                int aux = numbers[i];
                numbers[i] = numbers[min];
                numbers[min] = aux;
            }
        }
    }
}
