public class HashMap<K, V> {
    Node<K, V>[] nodes;
    public static int DEFAULT_CAP = 10;
    int cap;

    public static class Node<K, V> {
        K key;
        V val;
        Node<K,V> next;

        public Node (K key, V val) {
            this.key = key;
            this.val = val;
        }
    }


    public HashMap(){
        nodes = new Node[DEFAULT_CAP];
        cap = 0;
    }

    public HashMap(int cap){
        this.cap = cap;
        nodes = new Node[cap];
    }

    public int hash(K key) {
        return key.hashCode() % cap;
    }

    public V get(K key) {
        int i = hash(key);
        Node curr = nodes[i];
        while (curr != null) {
            if (curr.key == key) return (V) curr.val;
            curr = curr.next;
        }
        return null;
    }

    public void insert(K key, V val) {
        int i = hash(key);
        Node curr = nodes[i];
        if (nodes[i] == null) {
            nodes[i] = new Node(key, val);
            return;
        }
        while (curr.next != null) {
            if (key == curr.key && val == curr.val) return;
            if (key == curr.key) {
                curr.val = val;
                return;
            }
            curr = curr.next;
        }
        if (key == curr.key && val == curr.val) return;
        if (key == curr.key) {
            curr.val = val;
            return;
        }
        curr.next = new Node(key, val);

    }


    public boolean delete(K key){
        int i = hash(key);
        Node curr = nodes[i];
        if (curr == null) return false;
        if (curr.key == key) {
            nodes[i] = null;
            return true;
        }
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr = curr.next.next;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashmap = new HashMap<>(20);
        hashmap.insert(2,5);
        hashmap.insert(1,4);
        hashmap.insert(3,4);
        hashmap.insert(1,6);
        System.out.println(hashmap.get(2));
        System.out.println(hashmap.get(1));
        System.out.println(hashmap.delete(3));
        System.out.println(hashmap.get(3));
    }

}
