import java.util.*;
public class string_compression {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count=1;
        char previous=s.charAt(0);
        StringBuilder str=new StringBuilder("");
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else{
                str.append(previous);
                str.append(count);
                count=1;
                previous=s.charAt(i);
            }
        }
        str.append(previous);
        str.append(count);
        System.out.print(str.toString());
    }
}
