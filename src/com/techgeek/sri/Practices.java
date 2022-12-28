package com.techgeek.sri;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  1. final methods cannot be overridden it will give compiler error
 *
 *  2. static methods cannot be overridden but it will not throw compiler error, instead it will invoke the
 *    implementation of the declared object rather than the instantiated object.
 *
 *  3. Interfaces can have static methods but cannot be overridden by the implementing class, it will throw Compiler error
 *   in the implementing class to use the method call directly. i.e A.staticMethod()
 *
 *
 *  4. Default method declaration allows us to not explicitly implement the interface method in the implementing class
 *
 */

interface A {

      default void func1() {
        System.out.println("this is sri");
    }
}

public class Practices extends B implements A {
    A a;

    Practices(){

    }
    public static void staticMethod() {
        System.out.println("Static Method in Practice class");
    }
    public static void main(String[] args) {
        B b = new Practices();
        b.func1();
        new Practices().func1();
    }
}

class B implements A {
    B() {
        System.out.println("B construct");
    }
    public static void staticMethod() {
        System.out.println("Static Method in B class");
    }
}


class AB {
    public static void main(String[] args) {
        int[] f = new int[3];
        f[0] = 1;
        f[1] = 1;
        Queue<Integer> k = new LinkedList<>();
       // f[2] = true;
        //f[4] = true;
        System.out.println(Arrays.stream(f).anyMatch(s -> s == 0));
        int a = (int) Math.pow(10,1);
        int b = a + 2;
        //System.out.println((solution(new int[]{1,2,3,4,3,3,2,2,1,1,2,5})));
    }
    static public boolean solution(String S, String T) {
        S = processString(S);
        T = processString(T);
        if(S.length() != T.length())
            return false;

        for(int i = 0; i < T.length(); i++){
            if (S.charAt(i) == '?' || T.charAt(i) == '?')
                continue;
            else if (S.charAt(i) != T.charAt(i))
                return false;
        }
        return true;
    }

    static private String processString( String str) {
        StringBuilder builder = new StringBuilder();
        int n = str.length();
        int i = 0;
        while (i < n) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int count = 0;
                while (i < n && Character.isDigit(str.charAt(i))) {
                    count = count * 10 + Character.getNumericValue(str.charAt(i));

                    i++;
                }
                i--;
                for (int k = 0 ; k < count; k++) {
                    builder.append("?");
                }
            } else {
                builder.append(ch);
            }
            i++;
        }
        return builder.toString();
    }


    static private void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 1 || N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }


    public static int[] solution(int[] A, int F, int M) {
        // Implement your solution here
        int totalRolls = A.length + F;

        int totalSum = totalRolls * M;

        int totalNonMissing = IntStream.of(A).sum();

        int sumOfMissing = totalSum - totalNonMissing;

        int[] missing = new int[F];

        if (sumOfMissing < 0 || sumOfMissing / F > 6) {
            return new int[] {0};
        }
        int i = 0;
        while (sumOfMissing > 0 && F > 0) {
            if (F == 1) {

            }
            missing[i] = sumOfMissing / F;
            sumOfMissing -= missing[i++];
            F--;
        }
        return missing;
    }


    static public int solution(int[] A) {
        // Implement your solution here

        boolean constructHill = true;
        boolean constructValley = true;
        //int castleCount = countHill(A);
        int castleCount = countValley(A);
        castleCount += countHill(A);

        return castleCount;
    }

    private static int countHill(int[] A) {
        int i = 0;
        int hill = 0;
        int height = Integer.MIN_VALUE;
        boolean shallow = true;
        while (i < A.length) {
            if (i == A.length - 1 && A[i] > A[i - 1] && A[i] > height) {
                hill++;
            } else if (i - 1 >=  0 && shallow && A[i] < A[i - 1] && A[i - 1] > height) {
                hill++;
                shallow = false;
                height = A[i - 1];
            }
            if (i - 1 > 0 && A[i] < A[i - 1]) {
                shallow = true;
            }
            i++;
        }
        return hill;
    }

    private static int countValley(int[] A) {
        int i = 0;
        int valley = 0;
        boolean shallow = true;
        while (i < A.length) {
            if (i - 1 >  0 && shallow && A[i] > A[i - 1]) {
                valley++;
                shallow = false;
            }
             if (i - 1 > 0 && A[i] < A[i - 1]) {
                shallow = true;
            }
            i++;
        }
        return valley;
    }


}