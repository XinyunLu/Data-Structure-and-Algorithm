import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DisjointSets<E> {
    List<Node<E>> roots;
    Map<E, Node> map;
    Map<Node, Integer> rank; // optimization 2: union by rank

    public DisjointSets () {
        roots = new ArrayList<Node<E>>();
        map = new HashMap<>();
        rank = new HashMap<>();
    }

    public void makeSet(E item) {
        Node<E> root = new Node<E>(item);
        roots.add(root);
        map.put(item, root);
        rank.put(root, 0);
    }

    public Node<E> find(Node node) {
        if (node.parent == null) return node;
        else {
            Node p = find(node.parent);
            node.parent = p;
            return p;
        }
    }

    public Node<E> find(E item) {
        Node node = map.get(item);
        return find(node);
    }

    public void union(Node node1, Node node2) {
        Node root1 = find(node1);
        Node root2 = find(node2);
        if (root1 == root2) return;
        if (rank.get(root1) > rank.get(root2)) {
            root2.parent = root1;
        } else if (rank.get(root1) < rank.get(root2)) {
            root1.parent = root2;
        } else {
            root2.parent = root1;
            rank.put(root1, rank.get(root1)+1);
        }

    }

    public void union(E item1, E item2) {
        Node node1 = map.get(item1);
        Node node2 = map.get(item2);
        union(node1, node2);
    }

    public static class Node<E> {
        public E elem;

        public Node parent;

        public Node(E _elem) {
            elem = _elem;
            parent = null;
        }

        public Node(E _elem, Node _parent) {
            elem = _elem;
            parent = _parent;
        }
    }

    public static void main(String[] args) {
        DisjointSets<String> ds = new DisjointSets<>();
        ds.makeSet("hello");
        ds.makeSet("world");
        ds.makeSet("xiong");
        ds.union("hello", "world");
        Node output1 = ds.find("hello");
        Node output2 = ds.find("world");
        System.out.println(output1.elem);
        System.out.println(output2.elem);
    }


}
