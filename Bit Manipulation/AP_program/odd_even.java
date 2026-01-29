package AP_program;
import java.util.*;
public class odd_even {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        if((x&1)==0)
        {
            System.out.print("even");
        }
        else{
            System.out.print("odd");
        }
    }
}
