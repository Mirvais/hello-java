// ======================================================
// Demos.java — one public class containing multiple demos
// Run examples:
//   javac Demos.java
//   java Demos$OddOrEven
//   java Demos$Asterisks
//   java Demos$CompareStrings
//   java Demos$ArrayExample
//   java Demos$LinearSearch
//   java Demos$MatrixExample
// ======================================================

import java.util.Scanner;
import java.util.Arrays;

public class Demos {

    // -----------------
    public static class OddOrEven {
        public static void main(String[] args) {
            System.out.print("Skriv ett heltal: ");
            try (Scanner scan = new Scanner(System.in)) {
                int n = scan.nextInt();            // read integer input
                boolean odd = n % 2 != 0;          // check if odd (remainder != 0)
                System.out.println(odd);
                if (odd) {
                    System.out.println(n + " är ett udda tal.");
                } else {
                    System.out.println(n + " är ett jämnt tal.");
                }
            }
        }
    }


    // -----------------
    public static class Asterisks {
        public static void main(String[] args) {
            System.out.print("Antal: ");
            try (Scanner scan = new Scanner(System.in)) {
                int nbr = scan.nextInt();
                printAsterisks(nbr);
            }
        }

        public static void printAsterisks(int n) {
            for (int i = 0; i < n; i++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }


    // -----------------
    public static class CompareStrings {
        public static void main(String[] args) {
            try (Scanner scan = new Scanner(System.in)) {
                String s1 = scan.next();
                String s2 = scan.next();

                if (s1 == s2) {
                    System.out.println("Samma objekt");
                } else {
                    System.out.println("Inte samma objekt");
                }

                if (s1.equals(s2)) {
                    System.out.println("Samma innehåll");
                } else {
                    System.out.println("Inte samma innehåll");
                }
            }
        }
    }


    // -----------------
    public static class ArrayExample {
        public static void main(String[] args) {
            int[] a = new int[4];
            a[0] = 100;
            a[2] = 7;
            a[3] = a[2];
            System.out.println(Arrays.toString(a));

            int[] v = {10, 25, -10, 42, 100};
            int sum = 0;
            for (int i = 0; i < v.length; i++) {
                sum += v[i];
            }
            System.out.println(sum);

            int[] b = a;
            a[0] = 42;
            System.out.println(b[0]); // prints 42
        }
    }


    // -----------------
    public static class LinearSearch {
        public static void main(String[] args) {
            int[] v = {10, 25, -10, 42, 100};
            System.out.println(indexOf(v, 41)); // not found
            System.out.println(indexOf(v, 42)); // found
        }

        /** Search for number in array. */
        public static int indexOf(int[] a, int nbr) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == nbr) {
                    return i;
                }
            }
            return -1; // not found
        }
    }


    // -----------------
    public static class MatrixExample {
        public static void main(String[] args) {
            int[][] matrix = {
                { 7, 9, 123, 41, 1 },
                { 22, -18, 12, 43, -2 },
                { 11, 16, -4, 0, 1 }
            };
            System.out.println(sum(matrix));
        }

        /** Sum all numbers in a matrix. */
        public static int sum(int[][] m) {
            int sum = 0;
            for (int i = 0; i < m.length ; i++) {
                for (int k = 0; k < m[i].length; k++) {
                    sum += m[i][k];
                }
            }
            return sum;
        }
    }
}
