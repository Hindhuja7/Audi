/*Write a Java program Using Collections to read set of key value pairs
  (username:password). If the user enters any key and the key is present then
  the corresponding value(password) has to be displayed. If not print "-1".
sample input:
ramu:ramu12@
sam:kmit34$
ramesh:ngit56^
gopal:gopal78&
dev:dev89$
gopal

output:
gopal78&

sample input:
ramu:ramu12@
sam:kmit34$
ramesh:ngit56^
gopal:gopal78&
dev:dev89$
raj

output:
-1
 */
import java.util.*;
class treemap1
{
  public static void main(String [] args)
  {
    System.out.println("Enter 5 key value pairs");
    Scanner sc=new Scanner(System.in);
    TreeMap<String,String> t=new TreeMap<String,String>();
    for(int i=0;i<5;i++){
      String str=sc.next();
      String a[]=str.split(":");
      t.put(a[0],a[1]);
    }
    System.out.println("Enter key to search for");
    String user=sc.next();
    if(t.containsKey(user))
     System.out.println(t.get(user));
    else
     System.out.println("-1");
  }
}
