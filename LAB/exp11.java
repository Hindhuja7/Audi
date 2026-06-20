import java.util.*;
public class exp11 {
     static int dy[]={-1,-1,0,0};
    static    int dx[]={0,0,-1,-1};
    public static int dfs(int[][] arr,int row,int col)
    {
        int max=1;
        for(int i=0;i<4;i++)
        {
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && nrow<arr.length && ncol>=0 && ncol<arr[0].length && arr[nrow][ncol]>arr[row][col])
            {
                max=Math.max(max,1+dfs(arr,nrow,ncol));
            }
        }
        return max;

    }
    public static int longe(int[][] arr)
    {
        int longest=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                longest=Math.max(longest,dfs(arr,i,j));
            }
        }
        return longest;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int[][] arr=new int[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print(longe(arr));
    }
}
