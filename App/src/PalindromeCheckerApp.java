import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    // Recursive palindrome check
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: pointers crossed or single char left
        if (start >= end) {
            return true;
        }

        // If characters don't match → not palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Palindrome check using recursion
        boolean result = isPalindrome(input, 0, input.length() - 1);

        // Display result
        if (result) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
