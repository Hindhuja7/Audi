import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}
public class exp10 {
    public static Node lca(Node root,int p, int q)
    {
        if(root==null || root.data==p || root.data==q)
        {
            return root;
        }
        Node left=lca(root.left,p,q);
        Node right=lca(root.right,p,q);
        if(left!=null && right!=null)
        {
            return root;
        }
        return left!=null ? left:right;
    }
    public static Node build(int[] arr)
    {
        Queue<Node> q=new LinkedList<>();
        Node root=new Node(arr[0]);
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<arr.length)
        {
            Node k=q.poll();
            if(i<arr.length && arr[i]!=-1)
            {
                k.left=new Node(arr[i]);
                q.add(k.left);
            }
            i++;
            if( i<arr.length && arr[i]!=-1)
            {
                k.right=new Node(arr[i]);
                q.add(k.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String[] k=sc.nextLine().trim().split("\\s+");
        int[] arr=new int[k.length];
        for(int i=0;i<k.length;i++)
        {
            arr[i]=Integer.parseInt(k[i]);
        }
        Node root=build(arr);
        int p=sc.nextInt();
        int q=sc.nextInt();
        Node l=lca(root,p,q);
        if(l!=null)
        {
            System.out.print(l.data);
        }
        else{
            System.out.print("-1");
        }
    }
}
