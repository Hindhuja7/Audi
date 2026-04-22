import java.util.*;

class mapbackedCollection 
{
  public static void main(String args[]) 
  {    
    TreeMap<String, String> map = new TreeMap<String, String>();
    map.put("a", "ant"); 
    map.put("d", "dog"); 
    map.put("h", "horse");

    SortedMap<String, String> submap;
    submap = map.subMap("b", "g"); // #1 create a backed collection
    System.out.println(map + " " + submap); 

    map.put("b", "bat"); 
    submap.put("f", "fish"); 
    map.put("r", "rhino"); 

    //submap.put("m", "monkey"); 
    System.out.println(map + " " + submap); 

    SortedMap<String, String> hmap = map.headMap("d");
    System.out.println("headmap" + " " + hmap); 

    SortedMap<String, String> tmap = map.tailMap("d");
    System.out.println("tailmap" + " " + tmap); 
  }
}