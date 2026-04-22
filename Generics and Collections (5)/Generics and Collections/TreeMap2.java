import java.util.*;

class treeMap2 
{
  public static void main(String args[]) 
  {    
    TreeMap<String, String> map = new TreeMap<String, String>();
    map.put("a", "ant"); 
    map.put("d", "dog"); 
    map.put("h", "horse");
    map.put("t", "tiger");

    System.out.println("treemap lowerKey:" + " " + map.lowerKey("h")); 
    System.out.println("treemap floorKey:" + " " + map.floorKey("h")); 

    System.out.println("treemap higherKey:" + " " + map.higherKey("h")); 
    System.out.println("treemap ceilingKey:" + " " + map.ceilingKey("h")); 

    System.out.println("treemap pollFirstEntry:" + " " + map.pollFirstEntry()); 
    System.out.println("treemap pollLastEntry:" + " " + map.pollLastEntry()); 

    NavigableMap<String, String> dmap = map.descendingMap();
    System.out.println("descending treemap:" + " " + dmap); 
  }
}