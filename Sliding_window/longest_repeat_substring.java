import java.util.*;
public class longest_repeat_substring
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int start=0,end=0;
        String rem="";
        String longe="";
        while(start<s.length())
        {
            while(end<s.length())
            {
                rem=s.substring(start,end+1);

                String remaining=s.substring(start+1);
                if(remaining.contains(rem))
                {
                    if(rem.length()>longe.length())
                    {
                        longe=rem;
                    }
                }
                end++;
            }
            start++;
            end=start;
        }
        System.out.print(longe);
    }
}