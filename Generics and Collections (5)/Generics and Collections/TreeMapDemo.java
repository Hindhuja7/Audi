import java.util.*;

class TreeMapDemo 
{
  public static void main(String args[]) 
  {
    Map tm = new TreeMap();
     
    tm.put("One", new Double(3434.34));
    tm.put("Two", new Double(-123.22));
    tm.put("Three", new Double(1378.00));
    tm.put("Four", new Double(99.22));
  
    Set set = tm.entrySet();

    Iterator ite = set.iterator();
    
    while(ite.hasNext()) {
      Map.Entry me = (Map.Entry)ite.next();
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }

    System.out.println(tm.containsKey("two"));

    double balance =  ((Double)tm.get("Two")).doubleValue();
    tm.put("Two", new Double(balance + 1000));
    System.out.println("two's new balance: " + tm.get("Two"));
  }
}