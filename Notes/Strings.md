1.Strings are immutable but string reference are mutable
2.For each is not applicable for String iterable
3.auto boxing converts int to Integer,(auto unboxing)

4.Integer r=20;
    Integer r1=r;
    r=r+5;
    S.O.P(r+""+r1); //25 20 because wrapper classes in java are immutable, auto unboxing,auto boxing happens.

5.StringBuilder s=new StringBuilder("hello");
  StringBuilder s1=s;
  s1.append("world");
  S.O.P(s+""+s1); // helloworld helloworld ->  StringBuilder is mutable 

6.int x=10
while(x>0)
{
    do
    {
        x-=3;
    }while(x>5);
    x--;
    S.O.P(x);       //-1 final output
}

7.==,equals() -> by default checks the object reference 
8. StringBuilder s=new StringBuilder("hello");
    StringBuilder s1=new StringBuilder("hello");
    S.O.P(s==s1);   //false
    S.O.P(s.equals(s1));  //false
    S.O.P(s.toString().equals(s1.toString()));   //true

9.String s="hello";
    String s1="hello";
    S.O.P(s==s1);   //true   because s and s1 both point same literal
    S.O.P(s.equals(s1));  //true

10.Strings are final class,and they are not sub classable

11.String[] s=new String[2];
S.O.P(s[0]);//null
S.O.P(s.length); //2
S.O.P(s[0].length()); //NullPointer Exception
