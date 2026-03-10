class demo {
  private int value;  

  demo(int val)  {
    value = val;
  }

  @Override public boolean equals(Object obj)  {
    System.out.println("object Equals called");
    if((obj instanceof demo) && (((demo)obj).value == this.value))
      return true;
    else
      return false;
  }
}

class equals {
  public static void main(String args[]) {
    demo obj1 = new demo(10);
    demo obj2 = new demo(10);
    
    System.out.println("using == " + (obj1 == obj2));
    System.out.println("using equals " + obj1.equals(obj2));
  }
}



----------------------------------------
class equals2 {
  public static void main(String args[]) {
    StringBuilder sb1 = new StringBuilder("hello");
    StringBuilder sb2 = new StringBuilder("hello");
    System.out.println(" == " + (sb1 == sb2));
    System.out.println("equals " + sb1.equals(sb2));
    System.out.println("equals2 " + sb1.toString().equals(sb2.toString()));

    String s1 = "kmit";
    String s2 = "kmit";    
    System.out.println(" == " + (s1 == s2));
    System.out.println("equals " + s1.equals(s2));
  }
}

-----------------------------------------
import java.util.*; 
public class hashcode 
{ 
  private String first, last; 
  public hashcode(String first, String last) 
  { 
    this.first = first; 
    this.last = last; 
  } 

  public boolean equals(Object o) 
  { 
    if (!(o instanceof hashcode)) 
      return false; 
    hashcode n = (hashcode)o; 
    return n.first.equals(first) && n.last.equals(last); 
  } 

  // Comment and see the behavior
  public String toString()
  {
    return first + " " + last;
  }

  // Comment and see the behavior
  public int hashCode() {
    return first.hashCode() + last.hashCode();
  }

  public static void main(String[] args) 
  { 
    Set<hashcode> s = new HashSet<hashcode>(); 
    hashcode obj1 = new hashcode("Venkat", "Reddy");
    hashcode obj2 = new hashcode("Venkat", "Reddy");
    System.out.println(obj1.equals(obj2));
    s.add(obj1); 
    s.add(obj2);
    System.out.println(s);
    System.out.println(s.contains(new hashcode("Venkat", "Reddy"))); 
  } 
} 

-------------------------------------
class array1 {
  public static void main(String args[]) {
    int[] arr = new int[] {10, 20, 30};
    System.out.println(arr[0]);

    int [] arr1 = new int[3];
    System.out.println(arr1[0]);

    int [] arr2, arr3 = {3, 9};   // change [] position and test
    System.out.println(arr2[0]);
    System.out.println(arr3[1]);

    String [] stra1 = {"hello", "world"};
    String [] stra2 = stra1;
    System.out.println(stra1.equals(stra2));
    System.out.println(stra1.toString());
    System.out.println(java.util.Arrays.toString(stra1));

    String [] arr4 = new String[2];
    System.out.println(arr4[0]);
    System.out.println(arr4.length);
  }
}
