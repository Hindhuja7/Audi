// import java.util.*;

// class TreapNode {
//     int key, priority;
//     TreapNode left, right;

//     TreapNode(int key) {
//         this.key = key;
//         this.priority = new Random().nextInt(100);
//         left = right = null;
//     }
// }

// public class treap {

//     // RIGHT ROTATION
//     static TreapNode rightRotate(TreapNode y) {
//         TreapNode x = y.left;
//         TreapNode T2 = x.right;

//         x.right = y;
//         y.left = T2;

//         return x;
//     }

//     // LEFT ROTATION
//     static TreapNode leftRotate(TreapNode x) {
//         TreapNode y = x.right;
//         TreapNode T2 = y.left;

//         y.left = x;
//         x.right = T2;

//         return y;
//     }

//     // INSERT
//     static TreapNode insert(TreapNode root, int key) {
//         if (root == null)
//             return new TreapNode(key);

//         if (key < root.key) {
//             root.left = insert(root.left, key);

//             // Fix heap property
//             if (root.left.priority > root.priority)
//                 root = rightRotate(root);
//         } else {
//             root.right = insert(root.right, key);

//             if (root.right.priority > root.priority)
//                 root = leftRotate(root);
//         }

//         return root;
//     }

//     // SEARCH (same as BST)
//     static boolean search(TreapNode root, int key) {
//         if (root == null)
//             return false;

//         if (root.key == key)
//             return true;

//         if (key < root.key)
//             return search(root.left, key);
//         else
//             return search(root.right, key);
//     }

//     // DELETE
//     static TreapNode delete(TreapNode root, int key) {

//         if (root == null)
//             return null;

//         if (key < root.key) {
//             root.left = delete(root.left, key);
//         } 
//         else if (key > root.key) {
//             root.right = delete(root.right, key);
//         } 
//         else {
//             // Node found

//             // Case 1: no child
//             if (root.left == null && root.right == null)
//                 return null;

//             // Case 2: one child
//             else if (root.left == null)
//                 return root.right;

//             else if (root.right == null)
//                 return root.left;

//             // Case 3: two children
//             else {
//                 if (root.left.priority < root.right.priority) {
//                     root = leftRotate(root);
//                     root.left = delete(root.left, key);
//                 } else {
//                     root = rightRotate(root);
//                     root.right = delete(root.right, key);
//                 }
//             }
//         }

//         return root;
//     }

//     // PRINT TREE (inorder)
//     static void inorder(TreapNode root) {
//         if (root == null) return;
//         inorder(root.left);
//         System.out.print(root.key + " ");
//         inorder(root.right);
//     }

//     public static void main(String[] args) {

//         TreapNode root = null;

//         int[] arr = {5, 2, 8, 1, 4};

//         // Insert
//         for (int x : arr)
//             root = insert(root, x);

//         System.out.print("Inorder after insert: ");
//         inorder(root);

//         // Search
//         System.out.println("\nSearch 4: " + search(root, 4));
//         System.out.println("Search 10: " + search(root, 10));

//         // Delete
//         root = delete(root, 2);

//         System.out.print("Inorder after deleting 2: ");
//         inorder(root);
//     }
// }

import java.util.*;

class TreapNode {
    int data, priority;
    TreapNode left, right;

    TreapNode(int data) {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        left = right = null;
    }
}

public class KthLargestTreap {

    static int k;
    static boolean found = false;

    // RIGHT ROTATION
    static TreapNode rotateRight(TreapNode y) {
        TreapNode x = y.left;
        TreapNode T2 = x.right;

        x.right = y;
        y.left = T2;

        return x;
    }

    // LEFT ROTATION
    static TreapNode rotateLeft(TreapNode x) {
        TreapNode y = x.right;
        TreapNode T2 = y.left;

        y.left = x;
        x.right = T2;

        return y;
    }

    // INSERT (BST + Heap)
    static TreapNode insert(TreapNode root, int data) {
        if (root == null)
            return new TreapNode(data);

        if (data < root.data) {
            root.left = insert(root.left, data);

            if (root.left.priority > root.priority)
                root = rotateRight(root);
        } else {
            root.right = insert(root.right, data);

            if (root.right.priority > root.priority)
                root = rotateLeft(root);
        }

        return root;
    }

    // INORDER to find k-th smallest
    static void inorder(TreapNode root) {
        if (root == null || found) return;

        inorder(root.left);

        k--;
        if (k == 0) {
            System.out.println("Answer: " + root.data);
            found = true;
            return;
        }

        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt(); // kth largest

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // Step 1: convert
        k = n - p + 1;

        TreapNode root = null;

        // Step 2: build treap
        for (int x : arr)
            root = insert(root, x);

        // Step 3: inorder
        inorder(root);
    }
}