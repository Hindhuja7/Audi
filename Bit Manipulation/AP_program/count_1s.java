//package AP_program;

import java.util.Scanner;

public class count_1s {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int count=0;
        while(x>0)
        {
            count+=x&1;
            x>>=1;
        }
        System.out.print(count);
    }
}
