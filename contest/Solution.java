import java.util.*;
class Solution {
    public static boolean isDigitorialPermutation(int n) {
        int sum=0;
        int x=n;
        while(n>0)
        {
            int y=n%10;
            int prod=1;
            for(int i=y;i>=1;i--)
            {
                prod*=i;
            }
            sum+=prod;
            n/=10;
        }
        if(sum==x)
        {
            return true;
        }
        return false;
    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    System.out.print(isDigitorialPermutation(x));
    
}
}