import java.util.*;

class Car {
}

class Plane {
}

class RentalGeneric<T> { 
  private List<T> rentalPool; 
  private int maxNum;
  public RentalGeneric(int maxNum, List<T> rentalPool) { 
    this.maxNum = maxNum;
    this.rentalPool = rentalPool;
  }

  public T getRental() { 
    return rentalPool.get(0);
  }
  public void returnRental(T returnedThing) { 
    rentalPool.add(returnedThing);
  }
}

class TestRental {
  public static void main (String[] args) {
    Car c1 = new Car();
    Car c2 = new Car();
    List<Car> carList = new ArrayList<Car>();
    carList.add(c1);
    carList.add(c2);
    RentalGeneric<Car> carRental = new RentalGeneric<Car>(2, carList);
    Car carToRent = carRental.getRental();
    carRental.returnRental(carToRent);
    System.out.println(carList);
  }
}
