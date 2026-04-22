import java.util.*;

public class HashSetDemo 
{
  	public static void main(String args[]) 
	{
    	String elements[] = {"India", "USA", "UK", "Japan", "China", "India"};
    	Set set = new HashSet(Arrays.asList(elements));
      set.add("UK");

    	Iterator iter = set.iterator();    
    	while (iter.hasNext()) 
      	System.out.print(iter.next() + " ");
    
    	System.out.println();
    	set.remove("China");
    	set.remove("UK");

    	iter = set.iterator();
    
    	while (iter.hasNext())
      	System.out.print(iter.next() + " ");
    
    	System.out.println();
    	System.out.println("Existing 1 " + set.contains("USA"));
    	System.out.println("Existing 2 " + set.contains("UK"));
  	}   
}