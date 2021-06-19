import java.util.*;
public class Main {

    public static class Pair {
        int val1;
        int val2;

        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public String toString() {
            return val1 + " " + val2;
        }
    }



    public static void main(String[] args) {
        Pair[] pairs = new Pair[3];

//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(i, i + 1);
        }

//        System.out.println(pairs[0]);
        Arrays.sort(pairs, (a,b)->a.val1 - b.val1);

        for(Pair p : pairs) {
            System.out.println(p);
        }

    }
}
