import java.util.*;

class HashtableDemo  
{
  public static void main( String[] args ) 
  {
    Hashtable ht = new Hashtable();

    ht.put("City", "Hyderabad");
    ht.put("Animal", "Tiger");
    ht.put("Book", "Da Vinci Code");
    ht.put("Country", "India");
    ht.put("Religion", "Humanity");
    ht.put("Country", "USA");

    Enumeration e = ht.keys ();

    while (e.hasMoreElements())
    {
      Object obj1 = e.nextElement ();
      Object obj2 = ht.get (obj1);
      System.out.println ("key = " + obj1 + ", value = " + obj2);
    }
 	}
}