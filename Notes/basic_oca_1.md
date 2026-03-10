1. main method is static because jvm does not create  objects automatically. jvm cannot create objects for non static methods
    even though a class has default constructor jvm does not use constructors to start a program.

2. why String 'S' is caps and all int,float etc.. are Lower case?
    because String is a class and int,float are primitive data types, we use primitive datatypes for speed and memory efficient but String is immutable they methods etc...main important thing String stores sequence of characters which doesnt contain specific size.

    although we use primitive data types,when we need object creation for primitive there is a concept called WRAPPER CLASSES
    it stores primitives as objects which are helpful in Collections, and when u need to store no value in primitive java doesnt accpet it so wrapper allows to store no values as "null",main important thing is wrapper classes provide methods and utilites like Integer.MAX_VALUE etc..

    Primitives are not objects...collections need objects so we use Wrapper classes

3. Method Signature -  a method with parameter, no return type and order of parameter list matters,no access specifiers,no static and no final
    Example- int add(int a, int b) -> no,it is not a method signature
            void add(int a,int b) -> yes

4. when javac test.java is compiled ,java compiler creates a test.class file so during execution JVM loads the .class file and executes it
        important thing to notice here is...  .class file is just a bytecode file,memory is used only when jvm loads it
    if my test.java has 5 classes -> what does compiler do?
        java compiler creates 5 .class files separately because jvm loads .class file only when required this is called LAZY CLASS LOADING.
    what happens if 5 classes bundled in test.class -> jvm loads only required but now all classes will be load memory wasted,
        modifying one class leads to complexity in .class file due to bundled.


5.  y main(String[] args)?  and y not wrapper classes like main(Integer[] args) ? 
    because when u write this main(Integer[] args) and compile java file, it compiles without errors,but when u run java test it will give an error that main method not found
        we will run with a command "java test" so it takes this command as String. JVM does NOT interpret, parse, or convert command-line arguments.
        example-  public class Zoo {
                    public static void main(String[] args) {
                    System.out.println(args[0]);
                    System.out.println(args[1]);
                    } }   
                    javac Zoo.java 
                     java Zoo Bronx Zoo

                     Output: Bronx
                            Zoo


Packages organize classes into folders and import statement tells for a compiler to search exactly which package for a class.

we use wildcards instead of mentioning java.util.Math etc...simply we write java.util.*;
    the only disadvantages with wildcard is they do not import subfolders,methods,files.
when we compile java file,it only imports the required classes only.

if 2 classes are in same package then no import needed.

when java sees a class name it searches in this order -> Same package > java.lang > imported packages . else compile time error

using wildcard(*) u can only import classes,u cannot import methods,fields
    but if u want to import methods or fields java has special feature
        import static java.util.Math.get ->  using static u can import


Naming Conflicts -> it arises due to same class name example Date ->java.util.Date,java.sql.Date both have the Date class common but packages are different 

    Example: import java.util.*;
        import java.sql.*;
     public s.v.m()
    {
        Date date; // compile time error it says Date is ambiguous
    }

    import java.util.Date;
        import java.sql.*;
     public s.v.m()
    {
        Date date; // explict beats wild card so it uses java.util.Date
    }

    import java.util.Date;
        import java.sql.Date;
     public s.v.m()
    {
        Date date; // compile time error
    }

to avoid ambiguity we introduce fully-qualify which acts like
     import java.util.Date;
     public s.v.m()
    {
        Date date; //  java.util
        java.sql.Date sqldate; //fully qualify
    }
                OR

    public s.v.m()
    {
        java.util.Date date; //  fully qualify
        java.sql.Date sqldate; //fully qualify
    }

if we dont write any packages it uses a default package(Not recommended)


Creation:  C:\temp\packagea\ClassA.java
            C:\temp\packageb\ClassB.java
if -> package packageb;
    import packagea.ClassA;

    public class ClassB {
        public static void main(String[] args) {
            ClassA a;
            System.out.println("Got it");
        }
    }

    compile -> javac packagea/ClassA.java packageb/ClassB.java
    run -> java packageb.ClassB   ->observing carefully while compiling we used package/ClassB [/] while running package.ClassB [.] ,
    while execution java never allows / because compilation happens at OS level,execution happens using JVM

Classpath is a place where java looks for .class files, ina specific location or in JAR file 
    JAR file is nothing but a zip file which consists of .class files.
    Example:  java -cp ".;C:\temp\someOtherLocation;c:\temp\myJar.jar" myPackage.MyClass

    java -cp "C:\temp\directoryWithJars\*" myPackage.MyClass  '*' is used for all JAR files but not subdirectories


*****Objects    -> the real instance of a class.
        what is reference?
            example : Student s = new Student();
                    int x=10;
            here x directly stores the value but s is the reference i.e new Student() creates an object in memory (heap). Student s stores only the address/location of created object new Student(), just "s" stores only location.
        Example: Student s=new Student();
                Student s1=s;
                 s and s1 both are pointing to same Object but it does not happen same in primitives
                int x=5;
                int y=x;
                y=10;
                S.O.P(x); //5  they dont share memory,they are just separate values

Constructor -> Student s=new Student(); -> s is the refernce of the object fine!
                new creates a object in memory and assigns with default values of its type,then after when it sees Student() ,immediately it intializes with a assgined values in a constructor and constructor prepares object for use.

        Example:  public class Student{
                    String name;
        }
        in main method -> Student s = new Student() -> creates a object in memory and assign with a default value name = null

        public class Student{
            String name;
            Student()
            {
                name="greeshma";
            }
        }
        in main method -> Student s=new Student() -> creates a object in memory and assign with a default value name = null and immediately it replaces/assgins the value greeshma so output becomes -> name=greeshma

        Student name="greeshma";
        Student()
        {
            name="hindhuja";
        }
        Student s=new Student(); //hindhuja

        Student name="greeshma";
        Student(String name)
        {
            name="hindhuja";
        }
        Student s=new Student("bhavya") //greeshma

        Student name="greeshma";
        Student(String name)
        {
            this.name="hindhuja";
        }
        Student s=new Student("bhavya") //hindhuja

public class Swan {
    int numberEggs;

    public static void main(String[] args) {
        Swan mother = new Swan();
        mother.numberEggs = 1;
        System.out.println(mother.numberEggs);
    }
}
        mother.numberEggs=1 is called setting a field
        mother.numberEggs is called getting a field

String first = "Theodore";
String last = "Moose";
String full = first + last; //TheodoreMoose  -> fields can write their own value or read from other field

Instance Initializer block -> it is a block of code, which is executed for every object . If we have multiple constructors but, for every constructor i want to execute something very common so instead of writing in each and every constructor i will make use of IIB .

Example: class Demo {
    int a = show("A");

    {
        show("B");   //IIB
    }

    Demo() {
        show("C");
    }

    int show(String s) {
        System.out.print(s);
        return 0;
    }

    public static void main(String[] args) {
        new Demo();
    } 
}   output: ABC

Order of Execution of java after object creation is -> Default value > field Initializer > IIB > constructor
For every new Student()->[Object] creation we store default value and then default value is replaced with field value and then IIB is executed,next constructor

Example: public class basic_prog {
    String s="greeshma";
    {
        s="hindhuja";
    }
    basic_prog(String s)
    {
       // s=s;
        this.s=s;
    }
     public static void main(String[] args)
    {
        basic_prog b=new basic_prog("bhavya");
        System.out.print(b.s); //hindhuja    if this.s answer is //bhavya
    }
}


References -> primitives store actual value but for object a variable stores a address,
    int x=5; 5 is stored in x;
    Object s=new Object(); s stores the address of Object() because it is too large and complex to stores value

refernces can store null values but primitives cannot store
u can only call methods on reference type but we cannot do that for primitives


variables -> int x //declaring  , x=10; //initialization
int i1,i2,i3=0; // i1,i2 are just declared but i3=0 each comma separated space creates itw own mini initialization
        u cannot declare like this double d1,double d2; and [int i1; int i2;] -> same line not allowed


a text must begin with sequence of chars,$,_
a text can end with numbers like hello1 etc..
u cannot use keywords for variable declaration like public,class,int
java is case Sensitive


*******Types of variables:
local,instance,static

when object is garbage collected? ...when no reference is pointing to object and when references go out of scope.

garbage collector deletes object not references

object live as long as one reference point to it