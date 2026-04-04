import java.util.*;
public class functional_interface
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Concatenation x=((String a,String b)->a+b);
        System.out.print(x.concate("hello","world"));
    }
    @FunctionalInterface
    interface Concatenation{
        String concate(String a,String b);
    }
        
    }

