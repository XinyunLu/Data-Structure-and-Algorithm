public class Stack {
    //define your fields here
    int[] items;
    int cap;
    int end;
    public static int DEFAULT_CAPACITY = 10;

    //initial the stack to have default capacity
    public Stack() {
        cap = DEFAULT_CAPACITY;
        end = 0;
        items = new int[cap];
    }

    //initial capacity of the stack
    public Stack(int cap) {
        this.cap = cap;
        end = 0;
        items = new int[cap];
    }

    //add a value into the stack
    public void push(int val) {
        int[] copy = new int[2*cap];
        for(int i = 0; i < items.length; i++) copy[i] = items[i];


//        System.out.println(copy[0]);
//        System.out.println(copy[1]);
        items = copy;
        items[end] = val;
        end++;
        cap = 2*cap;
    }

    //pop out the last value added and return its value
    public int pop() {
        if (end == 0) return -1;
        int output = items[end-1];
        end--;
        return output;
    }

    //
    public int size() {
        return end;
    }

    public static void main(String[] args) {
        Stack test = new Stack(2);
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}






