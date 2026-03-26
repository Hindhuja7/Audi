import java.util.*;
public class thread{
    class mythread extends Thread{
        String name;
        mythread(String name)
        {
            this.name = name;
        }
        public void run() {
            System.out.println(name);
        }
    }
    
    public static void main(String[] args) {
        thread t = new thread();
        mythread t1 = t.new mythread("sort");
        mythread t2 = t.new mythread("search");
        mythread t3 = t.new mythread("sort result");
        
        t1.start();
        t2.start();
        t3.start();
    }
}