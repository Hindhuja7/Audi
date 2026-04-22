/* write a java program to read a set of strings and remove all the duplicate elements 
   using collections using a set.
Note: assume there are 6 strings 
   
sample input:
apple
bat
cat
apple
dog
bat
sample output:
cat 
dog
*/
import java.util.*;
import java.util.Map.Entry;
class Set1
{
  public static void main(String [] args)
  {
    System.out.println("Enter 6 strings");
    Scanner sc = new Scanner(System.in);
    LinkedHashSet<String> hs = new LinkedHashSet<String>();
    String[] s = new String[6];

    for(int i=0;i<6;i++)
      s[i]=sc.next();

    for(String x: s) {
      if(hs.add(x) == false)
        hs.remove(x);    
    }
    System.out.println(hs);
  }
}