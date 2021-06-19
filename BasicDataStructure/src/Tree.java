public class Tree {
    TreeNode root;

    public Tree() {}

    // given sorted array arr, construct a binary search tree out of it.
    public Tree(int[] arr) {
        for (int i : arr) {
            insert(i);
        }

    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.val > val) {
                prev = curr;
                curr = curr.left;
            } else if (curr.val == val) {
                return;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }
        if (prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }

    }

    public boolean search(int val) {
        if (root == null) return false;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > val) {
                curr = curr.left;
            } else if (curr.val < val) {
                curr = curr.right;
            } else return true;
        }
        return false;
    }

    public boolean remove(int val) {
        return false;
    }


    //in-order traversal, print out the values of the whole tree using in-order
    public void Inorder() {
        Inorder(root);
    }

    public void Inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.println(root.val);
        Inorder(root.right);
    }

    public void Preorder() {
        Preorder(root);
    }

    public void Preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        Preorder(root.left);
        Preorder(root.right);
    }

    public void Postorder() {
        Postorder(root);
    }

    public void Postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.println(root.val);
    }





    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode l, TreeNode r) {
            this.val = val;
            left = l;
            right = r;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
//        tree.Inorder();
//        tree.Preorder();
//        tree.Postorder();
        System.out.println(tree.search(3));

    }
}
