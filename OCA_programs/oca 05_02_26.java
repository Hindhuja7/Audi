import java.util.*;

class arrayList1 {
  public static void main(String args[]) {
    ArrayList list1 = new ArrayList();
    list1.add("kmit");
    list1.add(Boolean.TRUE);
    list1.set(1, 21);
    System.out.println(list1.size());
    System.out.println(list1);

    System.out.println(list1.remove("ngit"));
    System.out.println(list1.remove(1));
	 System.out.println(list1.remove(1));
    System.out.println(list1);
  }
}

-------------------------------------
import java.util.*;

class arrayList2 {
  public static void main(String args[]) {
    ArrayList <String> list1 = new ArrayList<>();
    list1.add("kmit");
    list1.add(Boolean.TRUE);
    list1.add(21);
    System.out.println(list1);
  }
}
----------------------------------------
import java.util.*;

class arrayList3 {
  public static void main(String args[]) {
    ArrayList list1 = new ArrayList();
    list1.add("kmit");
    list1.add("genesis");
    System.out.println(list1);
    System.out.println(list1.isEmpty());
    list1.set(0,"ngit");
    list1.set(1,"keshav");
    System.out.println(list1);
    list1.clear();
    System.out.println(list1.isEmpty());
  }
}
---------------------------------------
import java.util.*;

class arrayList4 {
  public static void main(String args[]) {
    ArrayList list1 = new ArrayList();
    list1.add("Keshav memorial institute of technology");
    list1.add("genesis");
    System.out.println(list1);

    System.out.println(list1.contains("institute"));
    System.out.println(list1.contains("genesis"));
  }
}
---------------------------------------
import java.util.*;

class arrayList5 {
  public static void main(String args[]) {
    ArrayList list1 = new ArrayList();
    list1.add("kmit");
    list1.add("ngit");

    ArrayList list2 = new ArrayList();
    list2.add("kmit");
    list2.add("ngit");
    System.out.println(list1.equals(list2));

    list2.set(0, "ngit");
    list2.set(1, "kmit");
    System.out.println(list1.equals(list2));
  }
}
------------------------------------
import java.util.*;
class arrayList6 {
  public static void main(String args[]) {
    List<String> list1 = new ArrayList<>();
    list1.add("kmit");
    list1.add("ngit");

    Object[] objectArray = list1.toArray();
    System.out.println(objectArray.length);
    String[] stringArray = list1.toArray(new String[0]);
	list1.add("3");
	 System.out.println(Arrays.toString(stringArray)); 
    System.out.println(stringArray.length); 
  }
}
----------------------------
import java.util.*;

class arrayList7 {
  public static void main(String args[]) {
    String[] array = { "kmit", "ngit" };
    List<String> list1 = Arrays.asList(array);;
    System.out.println(list1.size());
    list1.set(1, "genesis");
    array[0] = "india";
    for (String str : array) 
      System.out.println(str + " "); 
      list1.add("hello0");
    System.out.println(list1);
  }
}