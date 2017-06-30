package heap;

import heap.Heap;

public class Tests {
    
    public static void run(){
        test_isEmpty();
        test_insert();
        test_getMax();
        test_extractMax();
        test_remove();
        test_heapsort();
    }
    
    public static void test_isEmpty() {
        Heap<String> _heap = new Heap<>(10);

        assert _heap.isEmpty();
        assert _heap.getSize() == 0;
    }

    public static void test_insert() {
        Heap<String> _heap = new Heap<>(10);

        _heap.insert(23, "hello");
        assert !_heap.isEmpty();
        assert _heap.getSize() == 1;

        _heap.insert(9827, "world");
        assert _heap.getSize() == 2;

        _heap.insert(662, "C++");
        _heap.insert(551, "nice");
        _heap.insert(1221, "things");
        assert _heap.getSize() == 5;
    }

    public static void test_getMax() {
        Heap<String> _heap = new Heap<>(10);

        _heap.insert(23, "hello");
        _heap.insert(9827, "world");
        _heap.insert(662, "C++");
        _heap.insert(551, "nice");
        _heap.insert(1221, "things");

        Heap.Item _max = _heap.getMax();

        assert _max.key == 9827;
        assert _max.value == "world";
    }

    public static void test_extractMax() {
        Heap<String> _heap = new Heap<>(10);

        _heap.insert(23, "hello");
        _heap.insert(9827, "world");
        _heap.insert(662, "C++");
        _heap.insert(551, "nice");
        _heap.insert(1221, "things");

        Heap.Item _max = _heap.extractMax();

        assert _max.key == 9827;
        assert _max.value == "world";
        assert _heap.getSize() == 4;

        _max = _heap.extractMax();

        assert _max.key == 1221;
        assert _max.value == "things";
        assert _heap.getSize() == 3;
    }

    public static void test_remove() {
        Heap<String> _heap = new Heap<>(10);

        _heap.insert(23, "hello");
        _heap.insert(662, "C++");
        _heap.insert(551, "nice");

        _heap.remove(2); 
        assert _heap.getSize() == 2;
        _heap.remove(0);
        _heap.remove(0);
        assert _heap.getSize() == 0;
    }

    public static void test_heapsort() {
        int[] to_sort = {613, 55, 8721, 472, 94, 72, 74, 8, 61, 356};
        printArray("To sort",to_sort);

        Heap.heapsort(to_sort);
        printArray("Sorted",to_sort);
    }

    private static void printArray(String msg, int[] array){
        System.out.printf("%s: [ ", msg);
        for (int x=0; x < array.length; x++){
            System.out.printf("%d ", array[x]);
        }
        System.out.println("]");
    }

}