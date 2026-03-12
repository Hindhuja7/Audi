import java.util.*;
public class treap {
    static class Node{
        Node left;
        Node right;
        int priority;
        int data;
        Node(int data)
        {
            this.data=data;
            this.priority=new Random().nextInt(100);
            this.left=null;
            this.right=null;
        }
    }
    static Node root;
    public static Node insert(Node root,int key)
    {
        if(root==null)
        {
            return new Node(key);
        }
        if(key<root.data)
        {
            root.left=insert(root.left,key);
            if(root.left!=null && root.priority<root.left.priority)
            {
                root=rightrotate(root);
            }
        }
        else if(key>root.data)
        {
            root.right=insert(root.right,key);
            if(root.right!=null && root.priority<root.right.priority)
            {
                root=leftrotate(root);
            }
        }
        return root;
    }
    public static Node rightrotate(Node root)
    {
       Node A=root;
       Node B=root.left;
       A.left=B.right;
       B.right=A;
       return B;
    }
    public static Node leftrotate(Node root)
    {
        Node A=root;
        Node B=root.right;
        root.right=B.left;
        B.left=root;
        return B;
    }
}
