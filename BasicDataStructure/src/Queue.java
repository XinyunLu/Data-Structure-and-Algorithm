public class Queue {
    int[] items; //Queue-array implementation
    int capacity;
    int size;
    int start;
    int end;
    public static int Default_cap = 10;

    public Queue(int capacity) {
        this.capacity = capacity;
        start = 0;
        end = 1;
        items = new int[capacity];
    }

    public Queue() {
        items = new int[Default_cap];
        start = 0;
        end = 1;
    }

   // double-ended queue: deque, implemented by adding two indices
    public void offer(int val) {
        items[end] = val;
        end++;
        if (end > items.length-1) end = 0;
        size++;
    }


    public int poll() {
        if (size == 0) return -1;
        int output = 0;
        if (start == items.length-1) {
            output = items[0];
            start = 0;
        } else {
            output = items[start+1];
            start++;
        }
        size--;
        return output;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.offer(3);
        q.offer(2);
        q.offer(1);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
