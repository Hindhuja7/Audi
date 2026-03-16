import java.util.*;
public class gt_min_flips {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int target=s.length()/4;
        int ca=0,cb=0,cc=0,cd=0;
        if(target%4!=0)
        {
            System.out.print(-1);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='A')
            {
                ca++;
            }
            else if(s.charAt(i)=='B')
            {
                cb++;
            }
             else if(s.charAt(i)=='C')
            {
                cc++;
            }
            else{
                cd++;
            }
        }
        int ca1=0,cb1=0,cc1=0,cd1=0;
        if(ca>target)
        {
            ca1=Math.max(0,ca-target);
        }
        else if(cb>target)
        {
            cb1=Math.max(0,cb-target);
        }
        else if(cc>target)
        {
            cc1=Math.max(0,cc-target);
        }
        else{
             cd1=Math.max(0,cd-target);
        }
        System.out.print(ca1+cb1+cc1+cd1);
    }
}
