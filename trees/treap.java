import java.util.*;

public class treap {


static Random rand = new Random();

static class Node {
    int data, priority;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.priority = rand.nextInt(100);
    }
}

static Node root;

public static Node insert(Node root, int key) {
    if (root == null)
        return new Node(key);

    if (key < root.data) {
        root.left = insert(root.left, key);

        if (root.left != null && root.left.priority > root.priority)
            root = rightRotate(root);
    }

    else if (key > root.data) {
        root.right = insert(root.right, key);

        if (root.right != null && root.right.priority > root.priority)
            root = leftRotate(root);
    }

    return root;
}

public static Node search(Node root, int key) {
    if (root == null)
        return null;

    if (root.data == key)
        return root;

    if (key < root.data)
        return search(root.left, key);
    else
        return search(root.right, key);
}

public static Node delete(Node root, int key) {

    if (root == null)
        return null;

    if (key < root.data)
        root.left = delete(root.left, key);

    else if (key > root.data)
        root.right = delete(root.right, key);

    else {

        if (root.left == null && root.right == null)
            return null;

        if (root.right == null || (root.left != null && root.left.priority > root.right.priority)) {
            root = rightRotate(root);
            root.right = delete(root.right, key);
        }
        else {
            root = leftRotate(root);
            root.left = delete(root.left, key);
        }
    }

    return root;
}

public static void preorder(Node root) {
    if (root == null)
        return;

    System.out.println("Key: " + root.data + " Priority: " + root.priority);

    preorder(root.left);
    preorder(root.right);
}

public static Node rightRotate(Node root) {
    Node B = root.left;
    root.left = B.right;
    B.right = root;
    return B;
}

public static Node leftRotate(Node root) {
    Node B = root.right;
    root.right = B.left;
    B.left = root;
    return B;
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    for (int i = 0; i < n; i++)
        root = insert(root, sc.nextInt());

    preorder(root);

    int key = sc.nextInt();
    Node res = search(root, key);

    if (res != null)
        System.out.println("\nElement found: " + res.data + " with Priority: " + res.priority);
    else
        System.out.println("\nElement not found");

    int del = sc.nextInt();

    while (del != -1) {

        root = delete(root, del);

        System.out.println("\nTreap after deletion:");
        preorder(root);

        del = sc.nextInt();
    }
}


}
