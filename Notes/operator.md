double and float are more capable than int
    Example:   System.out.print(6+3.0); //9.0

Java converts char,short,byte to int before performing arthemetic operation
    Example: short x = 5;
            short y = 6;
            short z = x * y;  // ❌ DOES NOT COMPILE
            int z = x * y; // correct
            short z = (short)(x * y);  //correct 



