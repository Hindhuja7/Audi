package Recursion;
import java.util.*;
public class sum {
    public static int print(int n)
    {
        if(n==0)
        {
            return 0;
        }
        int sum=0;
       sum=print(n-1)+n;
        return sum;
    }
    public static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        return factorial(n-1)*n;
    }
    public static int max(int[] arr,int x)
    {
        if(x==arr.length)
        {
            return Integer.MIN_VALUE;
        }
        int max=max(arr,x+1);
        return Math.max(max,arr[x]);
    }
    public static void fun(String s,int x)
    {
        if(x==s.length())
        {
            return;
        }
        fun(s,x+1);
        System.out.print(s.charAt(x));
    }
    public static boolean palindrome(String s,int start,int end)
    {
        if(start>end)
        {
            return true;
        }
        if(s.charAt(start)!=s.charAt(end))
        {
            return false;
        }
        return palindrome(s,start+1,end-1);

    }
    public static int fib(int n)
    {
        if(n==0 || n==1)
        {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static int occur(String s,char ch,int x)
    {
        if(x==s.length())
        {
            return 0;
        }
        int count=0;
        count=occur(s,ch,x+1);
        if(ch==s.charAt(x))
        {
            count+=1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        // palindrome(s,0,s.length()-1);
        char ch=sc.next().charAt(0);
        //int x=sc.nextInt();
        // int[] arr=new int[x];
        // for(int i=0;i<x;i++)
        // {
        //     arr[i]=sc.nextInt();
        // }
        //System.out.print(max(arr,0));
        //System.out.print(palindrome(s,0,s.length()-1));
        System.out.print(occur(s,ch,0));
    }
}
