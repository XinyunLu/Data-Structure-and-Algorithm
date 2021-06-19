public class Heap {
    int[] items;
    int cap;
    int size;
    public static int DEFAULT_CAP = 10;

    public Heap() {
        cap = 0;
        size = 0;
        items = new int[DEFAULT_CAP];
    }


    public Heap(int cap) {
        this.cap = cap;
        items = new int[cap];
        size = 0;
    }

    //push val into the heap
    public void offer(int val) {
        // max-heapify
        items[size++] = val;
        this.upheapify();
//        // debug
//        for (int i = 0; i < items.length; i++) {
//            System.out.println(items[i]);
//        }

    }

    //poll out the smallest element stored in the heap
    public int poll() {
        int output = items[0];
        items[0] = items[size-1];
        size--;
        downheapify();
        return output;
    }

    /* helper function
       reorganize to ensure heap property
     */
    public void upheapify() {
        // using iteration
        // bottom to up
        int i = size-1;
        while (i != 0) {
            int parent = (i - 1) / 2;
            if (items[i] < items[parent]) {
                int temp = items[i];
                items[i] = items[parent];
                items[parent] = temp;
            } else return;
            i = parent;
        }
    }

    public void downheapify() {
        int i = 0;
        while (i < size) {
            int left = 2 * i +1;
            int right = 2 * i + 2;
            if (left >= size) return;
            int next = i;
            if (items[i] > items[left]) {
                next = left;
            }
            if (right < size && items[next] > items[right]) {
                next = right;
            }
            if(next == i) return;
            int temp = items[i];
            items[i] = items[next];
            items[next] = temp;
            i = next;
        }

    }

    //return the number of elements in the heap
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 9, 1, 0, 12};
        Heap.heapSort(arr);
        for (int i =0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }


    public static void heapSort(int[] arr) {
        Heap heap = new Heap(20);
        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }


}
