package heap;

public class Heap<T> {

    public class Item<T>{
        public T value;
        public int key;

        public Item(T value, int key){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Item<T>[] array;

    public Heap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.array = new Item[capacity];
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public static int parent(int index){
        return ((index - 1) / 2);
    }

    public static int leftChild(int index){
        return 2 * index + 1;
    }

    public static int rightChild(int index){
        return 2 * index + 2;
    }

    private void siftUp(int index){
        while (index > 0){
             int parent = Heap.parent(index);

             if (this.array[parent].key < this.array[index].key){
                 Item<T> aux = this.array[parent];
                 this.array[parent] = this.array[index];
                 this.array[index] = aux;

                 index = parent;
             }
             else {
                 break;
             }
        }
    }

    private void siftDown(int index){
        int swap_index = index;

        int left = Heap.leftChild(index);
        int right = Heap.rightChild(index);

        if (left < this.size && this.array[left].key > this.array[swap_index].key){
            swap_index = left;
        }

        if (right < this.size && this.array[right].key > this.array[swap_index].key){
            swap_index = left;
        }

        if (swap_index != index){
            Item<T> aux = this.array[swap_index];
            this.array[swap_index] = this.array[index];
            this.array[index] = aux;

            this.siftDown(swap_index);
        }
    }

    public void insert(int key, T value){
        if (this.size < this.capacity){
            // place new item in the leaf
            this.array[this.size] = new Item<>(value, key);
            // sift the item up to natural position
            this.siftUp(this.size);
            this.size++;
        }
    }

    public Item<T> getMax(){
        if (this.size > 0){
            return this.array[0];
        }
        return null;
    }

    public Item<T> extractMax(){
        if (this.size > 0){
            Item<T> max = this.array[0];
            this.array[0] = this.array[this.size - 1];
            this.array[this.size - 1] = max;
            this.size--;

            this.siftDown(0);
            return max;
        }
        return null;
    }

    public void remove(int index){
        if (index >= 0 && index < this.size){
            Item<T> aux = this.array[index];
            this.array[index] = this.array[this.size - 1];
            this.array[this.size - 1] = aux;

            this.size--;

            this.siftDown(index);
        }
    }

    public static void percolateDown(int[] numbers, int count, int index){
        int swap_index = index;

        int left = Heap.leftChild(index);
        int right = Heap.rightChild(index);

        if (left < count && numbers[left] > numbers[swap_index]) {
            swap_index = left;
        }

        if (right < count && numbers[right] > numbers[swap_index]){
            swap_index = right;
        }

        if (swap_index != index){
            int aux = numbers[swap_index];
            numbers[swap_index] = numbers[index];
            numbers[index] = aux;

            Heap.percolateDown(numbers, count, swap_index);
        }
    }

    public static void heapify(int[] numbers){
        int count = numbers.length;

        for (int index = count / 2; index >= 0; index--){
            Heap.percolateDown(numbers, count, index);
        }
    }

    public static void heapsort(int[] numbers){
        Heap.heapify(numbers);
        for (int index = numbers.length - 1; index > 0; index--){
            int aux = numbers[index];
            numbers[index] = numbers[0];
            numbers[0] = aux;

            Heap.percolateDown(numbers, index, 0);
        }
    }
}
