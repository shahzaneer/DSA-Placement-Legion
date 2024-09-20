class Swap{
    public static void main(String [] shahs){
        int a = 4, b = 7;
        System.out.println("a is " + a + "b is " + b);
        //! Temp way
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Temp way" + "a is " + a + "b is " + b);
        // ! bit manipulation
        int c = 4, d = 7;
        System.out.println("c is " + c + "d is " + d);
        c = c ^ d;
        d = c ^ d;
        c = c ^ d;
        System.out.println("bit way" + "c is " + c + "d is " + d);
        // ! Maths Way
        int x = 4, y = 7;
        System.out.println("x is " + x + " y is " + y);
        x = x + y;
        y = x - y; 
        x = x - y; 
        System.out.println("Maths way: x is " + x + " y is " + y);

        

    }


// int a = Integer.MAX_VALUE; // 2^31 - 1 = 2147483647
// int b = 1;
// a = a + b; // This will result in overflow, and 'a' becomes -2147483648 (minimum value for int)


    
    // static 
}