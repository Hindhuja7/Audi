import java.util.Stack;

public class StackDemo 
{
public static void main (String args[]) {
    	Stack s = new Stack();
 	    s.push("Core Java");
    	s.push("Advanced Java");
    	s.push("EJB architecture");
    
    	// Check out what's next to read
    	System.out.println("Next: " + s.peek());
    	s.push("J2ME");
    
    	// Read a book
    	System.out.println(s.pop());
    	s.push("JNDI");
    
    	// Find that other book
    	int count = s.search("Advanced Java");
    
    	System.out.println("Count " + count);

    	while (count != -1 && count > 1) {
      	s.pop();
      	count--;
    	}
    
    	// Read a book
    	System.out.println(s.pop());

    	// Anything left?
    	System.out.println(s.empty());
  	}
}