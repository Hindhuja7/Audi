import java.util.*;
class Student {
  int id;
  String name;
  int marks;
  int year;
  Student(int sid,String n,int m,int y)  {
    id=sid;
	name=n;
	marks=m;
	year=y;
  }
 
  @Override
  public boolean equals(Object obj)  {
    System.out.println("object Equals called");
    if(obj instanceof Student){ 
		Student o=(Student)obj;
		if(this.year==o.year && this.name.equals(o.name) && this.marks==o.marks)
			return true;
		else
		  return false;
	}
	else
		  return false;
  }
@Override
  public int hashCode()
  {
    System.out.println("object hashcode called "+year+" "+" "+name.hashCode()+" "+marks);
    return year+name.hashCode()+marks;
  }
}
class equals {
  public static void main(String args[]) {
    Student obj1 = new Student(101,"John1",92,3);
    Student obj2 = new Student(102,"John2",92,3);
    Student obj3 = new Student(103,"John3",92,3);
	Student obj4 = new Student(104,"Bob",65,2);

   Set<Student> set1=new HashSet<Student>();
   set1.add(obj1);
   set1.add(obj2);
   set1.add(obj3);
   set1.add(obj4);

   System.out.println(set1);
  }
}