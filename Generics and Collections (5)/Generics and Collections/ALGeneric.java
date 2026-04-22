import java.util.*;

class ALGeneric {
   public static void main(String args[]) {
    List<String> al = new ArrayList<String>();
    al.add("India");
    al.add("USA");
    al.add("Japan");
    al.add("UK");

    System.out.println("Size of al after additions: " + al.size());
    System.out.println("Contents of al: " + al);

    Iterator<String> ite = al.iterator(); 
    while (ite.hasNext()) {
      String iObj = ite.next(); 
      System.out.println(iObj);
    }

    List<Integer> al2 = new ArrayList<Integer>();
    al2.add(20);
    al2.add(30);
    al2.add(40);
    al2.add(new Integer(50));
    System.out.println("Contents of al2: " + al2);
    System.out.println("Contains 30: " + al2.contains(30));
   }
}
