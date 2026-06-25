import java.util.*;
public class String_Expansion {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Stack<String> s=new Stack<>();
        String k=sc.next();
        String current="";
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<k.length();i++)
        {
            if(k.charAt(i)=='(')
            {
                if(!current.equals(""))
                    s.push(current);
                    current="";
            }
            if(Character.isLetter(k.charAt(i)))
            {
                current+=k.charAt(i);
            }
            if(Character.isDigit(k.charAt(i)))
            {
             String temp=current;
             current="";  
                int l=k.charAt(i)-'0';
                while(l-->0)
                {
                    current+=temp;
                }
                if(!s.isEmpty())
                {
                    current=s.pop()+current;
                }
            }

        }
        System.out.print(current);
    }
}
