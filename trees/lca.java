import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}
public class lca {
    public static Node flca(Node root,int p,int q)
    {
        if(root==null || root.data==p||root.data==q)
        {
            return root;
        }
        Node left=flca(root.left,p,q);
        Node right=flca(root.right,p,q);
        if(left!=null && right!=null)
        {
            return root;
        }
        return(left==null)?right:left;
    }
    public static Node build(int[] arr)
    {
        if(arr.length==0) return null;
        Node root=new Node(arr[0]);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<arr.length)
        {
            Node curr=q.poll();
            if(arr[i]!=-1)
            {
                curr.left=new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
            if(i<arr.length && arr[i]!=-1)
            {
                curr.right=new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;i++)
        {
            arr[i]=Integer.parseInt(s[i]);
        }
        Node root=build(arr);
        System.out.print("Enter 2 nodes: ");
        int p=sc.nextInt();
        int q=sc.nextInt();
        Node l=flca(root,p,q);
        if(l!=null)
        {
            System.out.println("lca: "+l.data);
        }
        else{
            System.out.print("lca not found");
        }

    }
}
