class demo {
  private int value;  
  demo(int val)  {
    value = val;
  }
  int getValue()  {
    return value;
  }
  void setValue(int val)  {
    value = val;
  }
  public boolean equals(Object obj)  {
    System.out.println("object Equals called");
    if((obj instanceof demo) && (((demo)obj).getValue() == this.value))
      return true;
    else
      return false;
  }

  public int hashcode()
  {
    return value;
  }
}

class equals {
  public static void main(String args[]) {
    demo obj1 = new demo(10);
    demo obj2 = new demo(10);
    
    System.out.println("Comparing using == " + (obj1 == obj2));
    System.out.println("Comparing using equals " + (obj1.equals(obj2)));
    obj2.setValue(20);
    System.out.println("Comparing using equals " + (obj1.equals(obj2)));

  }
}