package Strings;
import java.util.*;
public class left_rotate {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().trim().split("\\s+");
        int k=sc.nextInt();
        int count=0;
        for(int i=0;i<s.length;i++)
        {
            int x=s[i].length();
            if(x==0)
            {
                continue;
            }
            int k1=k%x;
            String rev=s[i].substring(k1)+s[i].substring(0,k1);
            if(rev.equals(s[i]))
            {
                count++;
            }
        }
        System.out.print(count);

    }
}
