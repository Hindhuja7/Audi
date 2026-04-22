import java.util.*;

class treebackedCollection 
{
  public static void main(String args[]) 
  {    
    TreeSet<String> ts = new TreeSet<String>();
    String elements[] = {"Hyderabad", "Delhi", "Bombay", "Madras", "Agra",
      "Srinagar", "Bangalore", "Delhi"};

    for(int i = 0; i < elements.length; i++)
      ts.add(elements[i]);

    System.out.println("original treeset" + " " + ts); 

    TreeSet<String> subts = new TreeSet<String>();
    subts = (TreeSet)ts.subSet("Agra", false, "Madras", true);
    System.out.println("sub treeset" + " " + subts); 

    SortedSet<String> hSet = ts.headSet("Madras");
    System.out.println("headset" + " " + hSet); 

    SortedSet<String> tSet= ts.tailSet("Madras");
    System.out.println("tailset" + " " + tSet); 
  }
}
