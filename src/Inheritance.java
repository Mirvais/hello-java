import java.util.ArrayList;

// ======================================================
// Main (single file container for all demos)
// ======================================================
public class Inheritance {
    public static void main(String[] args) {

        TwoSquares.main(args);
    
        System.out.println("\n-----------------\n");

        BankLoan.main(args);

        System.out.println("\n-----------------\n");

        Member.main(args);
        
        System.out.println("\n-----------------\n");

        ArrayListExample.main(args);

        System.out.println("\n-----------------\n");

        DrawShapes.main(args);
    }
}


// ======================================================
// Shape (abstract class)
// ======================================================
abstract class Shape {

    protected int x; // x-coordinate of the shape
    protected int y; // y-coordinate of the shape

    protected Shape(int x, int y) { // constructor
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) { // method to move shape
        x = x + dx;
        y = y + dy;
    }

    public abstract void draw(); // abstract method (must be implemented in subclasses)
}


// ======================================================
// Square (inherits from Shape)
// ======================================================
class Square extends Shape {

    private int side; // length of the side of the square

    public Square(int x, int y, int side) { // constructor
        super(x, y); // call parent constructor
        this.side = side;
    }

    public int getSide() { // getter
        return side;
    }

    public void setSide(int side) { // setter
        this.side = side;
    }

    public int area() { // compute area of square
        return side * side;
    }

    @Override
    public void draw() { // implementation of abstract draw()
        System.out.println("Drawing a square with side " + side +
                " at point [" + x + "," + y + "]");
    }
}


// ======================================================
// Circle (another subclass of Shape, required for DrawShapes)
// ======================================================
class Circle extends Shape {

    private int radius; // radius of the circle

    public Circle(int x, int y, int radius) { // constructor
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw() { // implementation of abstract draw()
        System.out.println("Drawing a circle with radius " + radius +
                " at point [" + x + "," + y + "]");
    }
}


// ======================================================
// TwoSquares (demonstrates object references and methods)
// ======================================================
class TwoSquares {

    public static void main(String[] args) {

        Square sq1 = new Square(50, 50, 100);   // create square 1
        Square sq2 = new Square(100, 200, 20);  // create square 2
        sq1 = sq2;              // sq1 now refers to the same object as sq2

        sq1.setSide(30);        // changes side of sq2 as well (same object)

        System.out.println(sq2.getSide()); // prints 30
        System.out.println(sq1.area()); // prints area of sq2 (30*30)
        System.out.println(sq2.area()); // same area, since they are the same object
    }
}


// ======================================================
// BankLoan (static and instance members)
// ======================================================
class BankLoan {

    private static double interest = 0.0; // static interest rate (shared by all loans)
    private double amount;                // loan amount (specific to one loan)

    public BankLoan(double amount) { // constructor
        this.amount = amount;
    }

    public static void setInterestRate(double interestRate) { // set global interest rate
        interest = interestRate;
    }

    public double getInterestExpense() { // calculate interest expense for this loan
        return amount * interest / 100.0;
    }

    public static void main(String[] args) {
        BankLoan.setInterestRate(4.0); // set interest rate
        BankLoan loan = new BankLoan(200000); // create new loan
        System.out.println(loan.getInterestExpense()); // print interest expense (200000 * 0.04)
    }
}


// ======================================================
// Member (counting instances with static variable)
// ======================================================
class Member {

    private static int number = 0; // counts how many members have been created

    public Member() {
        number++; // increase counter when new Member is created
    }

    public static int getNumberMembers() { // return number of members created
        return number;
    }

    public static void main(String[] args) {
        Member m1 = new Member(); // create 3 members
        Member m2 = new Member();
        Member m3 = new Member();
        System.out.println("Number of members: " + Member.getNumberMembers());
    }
}


// ======================================================
// ArrayListExample (using ArrayList and generics)
// ======================================================
class ArrayListExample {

    public static void main(String[] args) {
        // Create a list of strings
        ArrayList<String> words = new ArrayList<String>();

        words.add("en");
        words.add("lista");
        words.add("med");
        words.add("ord");
        System.out.println(words); // prints list
        // Search in list
        System.out.println(words.indexOf("ord"));   // index of "ord"
        System.out.println(words.contains("ord")); // check if "ord" is present

        // Create a list of integers
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(53);
        list.add(-11);
        list.add(42);
        list.add(-8);
        list.add(42);

        // Iterate through list and sum all numbers
        int sum = 0;

        for (int n : list) { // for-each loop
            sum = sum + n;
        }

        System.out.println(sum); // prints total sum
    }
}


// ======================================================
// DrawShapes (polymorphism and inheritance demo)
// ======================================================
class DrawShapes {

    public static void main(String[] args) {

        Shape[] theShapes = new Shape[5]; // array of abstract type

        // fill array with Square and Circle objects
        theShapes[0] = new Square(100, 300, 100);
        theShapes[1] = new Square(400, 200, 100);
        theShapes[2] = new Circle(400, 400, 50);
        theShapes[3] = new Square(450, 450, 50);
        theShapes[4] = new Square(200, 200, 35);

        // move all shapes
        for (int i = 0; i < theShapes.length; i++) {
            theShapes[i].move(10, 10);
        }

        // draw all shapes
        for (int i = 0; i < theShapes.length; i++) {
            theShapes[i].draw(); // polymorphic call (Square or Circle version)
        }
    }
}
