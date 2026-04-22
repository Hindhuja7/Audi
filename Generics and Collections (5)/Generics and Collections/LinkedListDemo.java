import java.util.*;

public class LinkedListDemo 
{
  	public static void main(String args[]) 
	{
      String elements[] = {"India", "USA", "UK", "Japan", "USA", "China",};
    	LinkedList lst = new LinkedList(Arrays.asList(elements));
    	Iterator iter = lst.iterator();
    
    	while (iter.hasNext()) 
      	System.out.print(iter.next() + " ");

    	System.out.println();

    	lst.add(2, "Singapore");

    	System.out.println("Remove USA " + lst.remove("USA"));
    	System.out.println("Last item removed " + lst.removeLast());
    	System.out.println("First item removed " + lst.removeFirst());
    	System.out.println("Remove China " + lst.remove("China"));

    	iter = lst.iterator();
    
    	while (iter.hasNext()) 
      	System.out.print(iter.next() + " ");        
  	}   
}