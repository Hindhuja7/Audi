
// There are n football players standing in the ground, coach wants to know the 
// K-th largest height of the players. Given an array of heights[] and the value 
// of K. 
// Help the coach to find the P'th largest height.

// Note: You are supposed to print the K'th largest height in the sorted order 
// of heights[].
//       Not the P'th distinct height.

// Input Format:
// -------------
// Line-1: Size of array n and P value(space separated)
// Line-2: Array elements of size n.

// Output Format:
// --------------
// Print K'th largest height.

// Sample input-1:
// ---------------
// 8 2
// 1 2 1 3 4 5 5 5

// Sample output-1:
// ----------------
// 5

// Sample input-2:
// ---------------
// 6 3
// 2 4 3 1 2 5

// Sample output-2:
// ----------------
// 3
import java.util.*;
public class kth_treap {

static class TreapNode
{
    int data;
    int priority;
    TreapNode left;
    TreapNode right;
    TreapNode(int data)
    {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}


    static int k;
    static int count=0;
    static int ans=-1;
    public static TreapNode rotateLeft(TreapNode root)
    {
       TreapNode A=root;
       TreapNode B=root.right;
       root.right=B.left;
       B.left=root;
       return B;
    }

    public static TreapNode rotateRight(TreapNode root)
    {
        TreapNode A=root;
        TreapNode B=root.left;
        root.left=B.right;
        B.right=root;
        return B;
        
    }

    public static TreapNode insertNode(TreapNode root, int data){
        if(root==null)
        {
            return new TreapNode(data);
        }
        if(data<root.data)
        {
            root.left=insertNode(root.left,data);
            if(root.left!=null && root.priority<root.left.priority)
            {
                root=rotateRight(root);
            }
        }
        else
        {
            root.right=insertNode(root.right,data);
            if(root.right!=null && root.priority<root.right.priority)
            {
                root=rotateLeft(root);
            }
        }
        return root;
    }
    public static void fKthLargest(TreapNode root)
    {
        if(root==null || count>=k)
        {
            return;
        }
        fKthLargest(root.right);
        count++;
        if(count==k)
        {
            ans=root.data;
            return;
        }
         fKthLargest(root.left);
    }
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        k=p;
         TreapNode root = null;

        for (int i = 0; i < n; i++)
            root = insertNode(root, sc.nextInt());

        fKthLargest(root);

        System.out.println(ans);
    }
}
  

