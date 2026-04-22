import java.util.*;

class Parent { }
class Child extends Parent { }

class generics2 
{
  public static void main(String args[]) 
  {
    List<String> al = new ArrayList<String>();
    al.add("India");
    al.add("USA");
    System.out.println(al);

    List<Object> al2 = new ArrayList<Integer>();
    al2.add(10);
    al2.add(new Integer(20));
    System.out.println(al2);

    List<Parent> myList = new ArrayList<Child>();
  }
}