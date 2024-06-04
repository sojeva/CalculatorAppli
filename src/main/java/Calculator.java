import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalculation = true;



        while (continueCalculation) {
            int num1, num2;
            int result = 0;
            String operator;



                System.out.println("Please enter the Operator + - * / : ");
                operator = sc.next();
                System.out.println("Please enter the first number: ");
                num1 = sc.nextInt();
                System.out.println("Please enter the second number: ");
                num2 = sc.nextInt();



            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        continue;


                    }
                    result = num1 / num2;
                    break;
                    default:
                    System.out.println("Error! Please enter a valid operator.");
                    continue;
            }

            System.out.println("The result is: " + result);
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String anotherCalculation = sc.next().toLowerCase();
            if (!anotherCalculation.equals("yes")) {
                continueCalculation = false;
                System.out.println("Exiting the calculator. Goodbye!");
            }
        }
        sc.close();
    }
}














