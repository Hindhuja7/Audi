import java .util.*;

class StringTokenizerDemo  
{
  public static void main( String[] args ) 
  {
    String s = "123/.45.6/-123/Genesis/-66.6/-40/-28";

    StringTokenizer st = new  StringTokenizer (s, "/");
    while (st.hasMoreTokens ())
    {
      String str = st.nextToken ();        
      System.out.println (str);        
    }

    StringTokenizer st2 = new StringTokenizer("Genesis InSoft Limited");
    while (st2.hasMoreTokens()) 
    {
      System.out.println(st2.nextToken());
    }
 	}
}