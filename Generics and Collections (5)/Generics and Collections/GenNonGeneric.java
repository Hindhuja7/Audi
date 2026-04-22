import java.util.*;

class TestMix {
  int i;
  public static void main(String[] args) {
    Integer o1 = new Integer(10);
    Integer o2 = new Integer(15);
    System.out.println(o1== o2);
    System.out.println(o1.equals(o2));

    o1 = o1 + 5;
    System.out.println(o1.equals(o2));
  }
  TestMix(int val)
  {
    i = val;
  }
}