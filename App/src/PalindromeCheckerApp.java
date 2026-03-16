import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Reuse palindrome logic (two-pointer)
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string
        String normalized = input
                .replaceAll("\\s+", "")   // remove spaces using regex
                .toLowerCase();           // ignore case

        // Apply palindrome logic
        boolean result = isPalindrome(normalized);

        // Display result
        if (result) {
            System.out.println("The string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
