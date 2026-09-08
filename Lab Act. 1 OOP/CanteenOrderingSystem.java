import java.util.Scanner;

public class CanteenOrderingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int total = 0;
        char orderAgain;

        do {
            System.out.println("(๑ᵔ⤙ᵔ๑) WELCOME TO THEA'S CANTEEN! (๑ᵔ⤙ᵔ๑)");
            System.out.println("\n--- Canteen Menu ---");
            System.out.println("1. Burger ni buseng - ₱50");
            System.out.println("2. Bisaya Fries  - ₱30");
            System.out.println("3. Choke float - ₱20");
            System.out.println("4. Footlong w/extra kiss - ₱45");
            System.out.println("5. Sandwich w/peanut butterbonia - ₱65");
            System.out.println("6. 1 Rice w/pork sinigang - ₱65");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            
            choice = input.nextInt();

            if (choice >= 1 && choice <= 6) {
                System.out.print("Enter quantity: ");
                int quantity = input.nextInt();

                int price = 0;
                switch (choice) {
                    case 1: price = 50; System.out.println("You ordered Burger ni buseng."); break;
                    case 2: price = 30; System.out.println("You ordered Bisaya Fries."); break;
                    case 3: price = 20; System.out.println("You ordered Choke Float."); break;
                    case 4: price = 45; System.out.println("You ordered Footlong w/extra kiss."); break;
                    case 5: price = 65; System.out.println("You ordered Sandwich w/peanut butterbonia."); break;
                    case 6: price = 65; System.out.println("You ordered 1 Rice w/pork sinigang."); break;
                }

                total += price * quantity;

                // Ask if they want to order again right after quantity
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = input.next().charAt(0);

            } else if (choice == 7) {
                System.out.println("Exit na'ko busengg...");
                orderAgain = 'N';
            } else {
                System.out.println("Invalid choice. Can we try again? (Depende kung 3 yan)");
                orderAgain = 'Y';
            }

        } while (orderAgain == 'Y' || orderAgain == 'y');

        // Ask if student for discount
        System.out.print("\nAre you a student? (Y/N): ");
        char student = input.next().charAt(0);

        double discount = 0;

        // Apply discounts
        if (student == 'Y' || student == 'y') {
            discount = total * 0.10; // 10% student discount
        }
        if (total > 500) {
            double bulkDiscount = total * 0.05; // 5% discount for > ₱500
            // Choose the higher discount
            if (bulkDiscount > discount) {
                discount = bulkDiscount;
            }
        }

        double finalAmount = total - discount;

        System.out.println("\n===== BILL SUMMARY =====");
        System.out.println("Total before discount: ₱" + total);
        System.out.println("Discount: ₱" + discount);
        System.out.println("Final amount: ₱" + finalAmount);
        System.out.println("Salamat sa pag order buseng!");

        input.close();
    }
}
