package reviewfromlastsemester;

import java.util.Scanner;

public class ReviewFromLastSemester {

    public static void main(String[] args) {

        String fullName = "Eric Charnesky";

        System.out.println(fullName);

        int product = askUserForTwoNumbersAndReturnTheProduct();

        System.out.println(String.format(
                "The product of your numbers is: %d", product));

    }

    public static int askUserForTwoNumbersAndReturnTheProduct() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = keyboard.nextLine();
        
        System.out.println("Enter not a number to break me");
        // I don't recommend using nextInt() - see below
        int number = keyboard.nextInt();
        keyboard.nextLine(); // this reads the enter key after numbers are entered
        
        System.out.println("Enter your major");
        String major = keyboard.nextLine();
        
        
        while (true) {
            try {
                System.out.println("Enter the first number: ");
                int firstNumber = Integer.parseInt(keyboard.nextLine());
                System.out.println("Enter the second number: ");
                int secondNumber = Integer.parseInt(keyboard.nextLine());
                return firstNumber * secondNumber;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number");
            }
        }

    }

}
