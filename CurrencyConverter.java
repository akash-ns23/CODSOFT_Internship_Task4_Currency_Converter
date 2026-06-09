import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Exchange rates with respect to USD
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("INR", 83.50);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.79);
        rates.put("JPY", 157.20);

        System.out.println("===== CURRENCY CONVERTER =====");
        System.out.println("Available Currencies:");
        System.out.println("USD  INR  EUR  GBP  JPY");

        System.out.print("\nEnter Base Currency: ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        if (!rates.containsKey(base) || !rates.containsKey(target)) {
            System.out.println("Invalid currency code.");
            sc.close();
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // Convert base currency to USD
        double amountInUSD = amount / rates.get(base);

        // Convert USD to target currency
        double convertedAmount = amountInUSD * rates.get(target);

        System.out.println("\n===== RESULT =====");
        System.out.printf("%.2f %s = %.2f %s%n",
                amount, base, convertedAmount, target);

        sc.close();
    }
}
