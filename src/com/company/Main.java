package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int  a =233, b = 0, f =0, hello =18 , old = 0;
        double c =4.5;
        boolean w=true;
        String d, t;
        d="Hello мир!";
        t="hello";
        char e;

        Box x = new Box;
        //a.name();
        //System.out.println(a-hello);
        //System.out.print(c);
      /*  if(true)
        {System.out.println(c);
        }
        if(false)
        {System.out.println(200);
        } else {
            System.out.println(300);
        }
        if("hello".equals(t))
        {System.out.println(d + false + " "+ "!!");
        }
*/
        //System.out.println("sum3 = " + sum3(1, 2, 3));
        //System.out.println("d1 = " + d1(4));
        ///System.out.println("m1 = " + m1(10));

      /*  while(true) {
            b++;
            System.out.println("b = " + b);
            if(b==30){ break;}
        }*/
         b = 1 ; a = 0; f=1;
        //System.out.println("Fibo - " + fibo(7));

        System.out.println("func - " + func(4, "Hello"));

    }

    public static String func(int n1, String str) {
        int i = 00; String nstr = "";
        while(i < n1 ) {
            nstr = nstr + str;
           i++;
        }
        return   nstr;
    }

    public static int fibo(int n1) {
        int b =1,  a = 0, f=1, old=0;
        while(b <= n1 ) {
            old = a;
            a=f;
            f=f + old;
            b++;
        }
        return   old;
    }

    public static int sum3(int n1, int n2, int n3) {
      return   n1 + n2 + n3;
    }

    public static int d1(int n1) {
        return   n1*n1;
    }

    public static int m1(int n1) {
        return   0 - n1;
    }
}

