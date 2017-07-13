package methods;

public class Main {

    private static void printArray(int[] array){
        System.out.print("[ ");
        for (int x=0; x < array.length; x++){
            System.out.printf("%d ", array[x]);
        }
        System.out.println("]");
    }

    public static boolean isSorted(int[] array){

        for (int i=1; i < array.length; i++){
            if (array[i-1] > array[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] argv){
        int[] to_sort = {613, 55, 8721, 472, 94, 72, 74, 8, 61, 356};
        //BubbleSort.sort(to_sort);
        //InsertionSort.sort(to_sort);
        //SelectionSort.sort(to_sort);
        //MergeSort.sort(to_sort);
        QuickSort.sort(to_sort);

        printArray(to_sort);
        assert isSorted(to_sort);
    }
}
