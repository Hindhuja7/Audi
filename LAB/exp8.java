import java.util.*;
public class exp8 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Integer bit=0;
        for(int i=0;i<s.length();i++)
        {
            bit^=1<<(s.charAt(i)-'a'+1);
        }
        System.out.print(Integer.bitCount(bit)<=1);
    }
}
