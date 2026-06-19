import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("      AI CHATBOT");
        System.out.println("Type 'bye' to exit");
        System.out.println("================================");

        while (true) {

            System.out.print("\nYou: ");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("hello") || input.equals("hi")) {
                System.out.println("Bot: Hello! How can I help you?");
            }

            else if (input.contains("your name")) {
                System.out.println("Bot: My name is AI Chatbot.");
            }

            else if (input.contains("how are you")) {
                System.out.println("Bot: I am doing great. Thank you for asking!");
            }

            else if (input.contains("java")) {
                System.out.println("Bot: Java is a popular object-oriented programming language.");
            }

            else if (input.contains("codealpha")) {
                System.out.println("Bot: CodeAlpha provides internship opportunities and projects.");
            }

            else if (input.contains("time")) {
                System.out.println("Bot: Please check your system clock for the current time.");
            }

            else if (input.equals("bye")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            }

            else {
                System.out.println("Bot: Sorry, I don't understand that.");
            }
        }

        sc.close();
    }
}