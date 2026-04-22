/*Write a Java Program to read the phone directory(contact_names:phone_numbers)
    and print all the numbers which have the same names

Note: Print the numbers in ascending order.
           for the input abc or ABc output will be 9789 and 9885
           print -1 if the given name is not present in the phone directory

sample input:
ABc:9885
bcd:9866
cda:9490
abc:9789
abc

output:
9789
9885
*/
   
import java.util.*;
import java.util.Map.Entry;

class hashmap1 {
	public static void main(String[] args)  
  {   
    System.out.println("Enter 4 key value pairs");
    Scanner sc=new Scanner(System.in);
    Map<String,String> hm=new HashMap<String,String>();
    for(int i=0;i<4;i++){
      String []str=sc.next().split(":");
      hm.put(str[1],str[0]);
    }

    System.out.println("Enter contact name in lower case");
    String contact_name=sc.next();
			 
		Set<Entry<String, String>> set = hm.entrySet();
    List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(set);

    Collections.sort(list, new Comparator<Map.Entry<String, String>>()   
    {
      public int compare( Map.Entry<String, String> o1, Map.Entry<String, String> o2 )  
      {
        return (o1.getKey()).compareTo( o2.getKey() );
      }
    });

    boolean found = false;

    Set<String> keys=hm.keySet();
    for(String key:keys)
    {
      String value=hm.get(key);
      if(contact_name.equals(value.toLowerCase() ))
      {
        found = true;
        System.out.println(key);
      }
    }
    if (!found) 
      System.out.println(-1);
  }
}