/* write a java program to read a set of strings and remove all elements
which occur even number of times using collections using set.
  
sample input:
6
apple
bat
cat
apple
dog
bat

sample output:
cat 
dog

sample input:
6
cat
cat
cat
bat
bat
bat

sample output:
cat 
bat


*/
import java.util.*;
import java.util.Map.Entry;
class Set2
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
    LinkedHashSet<String> hs = new LinkedHashSet<String>();
    String[] s = new String[n];

    for(int i=0;i<n;i++)
      s[i]=sc.next();

    for(String x: s) {
      if(hs.add(x) == false)
        hs.remove(x);    
    }
    System.out.println(hs);
  }
}