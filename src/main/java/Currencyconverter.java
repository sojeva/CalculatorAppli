import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.HashMap;

public class Currencyconverter {


    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {

        exchangeRates.put("SEK_TO_USD", 0.095);
        exchangeRates.put("USD_TO_SEK", 10.50);
        exchangeRates.put("SEK_TO_Euro", 0.089);
        exchangeRates.put("Euro_TO_SEK", 11.28);

        System.out.println(exchangeRates);


        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Currency Converter Menu:");
            System.out.println("1. Convert SEK to USD");
            System.out.println("2. Convert USD to SEK");
            System.out.println("3. Convert SEK to Euro");
            System.out.println("4. Convert Euro to SEK");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    convert(scanner, "SEK",  "USD");
                    break;
                case 2:
                    convert(scanner, "USD", "SEK");
                    break;
                case 3:
                    convert(scanner, "SEK", "Euro");
                    break;
                case 4:
                    convert(scanner, "Euro", "SEK");
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 0.");
                    break;
            }
        }
        scanner.close();
    }

    private static void convert(Scanner scanner, String previousCurrency, String newCurrency) {
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        if(amount < 0){
            System.out.println("Input cannot be negative");
            return;
        }

        String key = previousCurrency + "_TO_" + newCurrency;

        double rate = exchangeRates.get(key);
        double convertedAmount = amount * rate;

        String result = amount + " " + previousCurrency + " is equal to " + convertedAmount + " " + newCurrency;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        System.out.println(result);
        System.out.println("Date and time for conversion " + formattedDateTime);
    }

}
