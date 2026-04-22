: Creat/* write a java program to read a set of strings and remove all elements
which occur even number of times using collections without using Set.
  
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
class Set1
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
	int n=sc.nextInt();
    LinkedHashMap<String,Integer> hm = new LinkedHashMap<String,Integer>();
    String[] s = new String[n];

    for(int i=0;i<n;i++)
      s[i]=sc.next();

    for(String x: s) {
      if(hm.containsKey(x)){
        int count=hm.get(x);
        count++;
        hm.put(x,count);
      }
      else{
        hm.put(x,1);
      }
    }
	System.out.println("Result");
    Set<Map.Entry<String,Integer>> me = hm.entrySet();
    Iterator<Entry<String,Integer>> mi = me.iterator();
    while(mi.hasNext())
    {
      Entry<String,Integer> e = mi.next();
      if(e.getValue()%2==1)
        System.out.println(e.getKey());
    }
  }
}