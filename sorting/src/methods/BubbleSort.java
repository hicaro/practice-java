package methods;

public class BubbleSort {

    /*
    Bubble Sort sorting algorithm implementation
        - Best case: O(n)
        - Average case: O(n^2)
        - Worst case: O(n^2)
    */

    public static void sort(int[] numbers){
        int len = numbers.length;

        for( int i=0; i < len - 1; i++ ){
            for ( int j=1; j < len - i; j++ ){
                if( numbers[j-1] > numbers[j] ){
                    int aux = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = aux;
                }
            }
        }
    }
}
