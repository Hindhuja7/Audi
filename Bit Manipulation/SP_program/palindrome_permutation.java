package SP_program;
import java.util.*;
public class palindrome_permutation {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        boolean found=false;
        int mask=0;
        for(int i=0;i<s.length();i++)
        {
            int bit=s.charAt(i)-'a';
            mask^=(1<<bit);
        }
        if(mask==0||Integer.bitCount(mask)<=1)
        {
            found=true;
        }
        System.out.print(found);
        
    }
}

