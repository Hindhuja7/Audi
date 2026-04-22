import java.util.*;

public class Company {
  	public static void main (String args[]) {
    	Employee emps[] = {
      	new Employee("Software", "Ravi"),
      	new Employee("Software", "Ajay"),
      	new Employee("Sales", "Bharath"),
      	new Employee("HR", "Subbu"),
      	new Employee("Marketing", "Ravi"),
      	new Employee("Finance", "Ajay"),
      	new Employee("Finance", "Manohar"),
      	new Employee("Finance", "Vinod"),
    	};

    	Set set = new TreeSet(Arrays.asList(emps));
    	System.out.println(set);
  	}
}