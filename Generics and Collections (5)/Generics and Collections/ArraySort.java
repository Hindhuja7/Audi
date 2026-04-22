import java.util.*;
class ArraySort {
  public static void main(String [] args) {
    String [] sa = {"three", "four", "five", "six", "seven"};
    Arrays.sort(sa); 
    for(String s : sa)
      System.out.print(s + " ");

    System.out.println();

    List sList = Arrays.asList(sa); 
    System.out.println("size " + sList.size());
    System.out.println("index2 " + sList.get(2));

    System.out.println("one = " + Arrays.binarySearch(sa,"one")); 
    System.out.println("six = " + Arrays.binarySearch(sa,"eight")); 

    System.out.println("now reverse sort");
    ReverseComparator rs = new ReverseComparator(); 
    Arrays.sort(sa,rs);
    for(String s : sa)
      System.out.print(s + " ");
    System.out.println();
    System.out.println("one = " + Arrays.binarySearch(sa,"one")); 
    System.out.println("one = " + Arrays.binarySearch(sa,"one",rs)); 

    System.out.println("six = " + Arrays.binarySearch(sa,"eight")); 
    System.out.println("six = " + Arrays.binarySearch(sa,"eight",rs)); 
  }  

  static class ReverseComparator implements Comparator<String> { 
    public int compare(String a, String b) {
      return b.compareTo(a); 
    }
  }
}

