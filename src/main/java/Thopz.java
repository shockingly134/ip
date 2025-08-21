import java.util.Scanner;

public class Thopz {

    public String bot = "thopz";
    public static String greetings = "Wassup wassup! Life ok? Vibes ok? Family ok? " +
            "I am thopz your virtual chatbot. " +
            "How may I help you?" ;
    public static String goodbye = "Chaoz. See you ! ";

    // Greetings and goodbye with a 3 sec delay
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("" + greetings);
        String repeat = scan.next();

        while (!repeat.equals("bye")) {
            System.out.println("" + repeat);
            repeat = scan.next();
        }

        System.out.println("" + goodbye);


    }
}
