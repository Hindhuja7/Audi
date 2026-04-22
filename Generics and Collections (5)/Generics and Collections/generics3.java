import java.util.*;

class Shape {
  Shape() {System.out.println("Shape"); }

}
class Circle extends Shape {
  Circle() {System.out.println("Circle"); }
}

class generics3
{
  public static void main(String args[]) 
  {
    List<Shape> lst = new ArrayList<Shape>();
    lst.add(new Shape()); 
    lst.add(new Circle());

    /*List<Shape> lst2 = new ArrayList<Circle>();

    List<? extends Shape> lst3 = new ArrayList<Circle>();

    List<? super Circle> lst4 = new ArrayList<Shape>();

    List<? super Shape> lst5 = new ArrayList<Circle>();

    List<?> lst6 = new ArrayList<Integer>();

    List<? super Circle> lst7 = new ArrayList<Integer>();
    */

  }
}


