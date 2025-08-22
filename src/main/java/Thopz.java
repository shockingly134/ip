import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thopz {

    public String bot = "thopz";
    public static String greetings = "Wassup wassup! Life ok? Vibes ok? Family ok? " +
            "I am thopz your virtual chatbot. " +
            "How may I help you?" ;
    public static String goodbye = "Chaoz. See you ! ";

    // Adding words to list, used Arraylist functions to achieve this
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> ls = new ArrayList<>();

        System.out.println("" + greetings);
        String repeat = scan.next();


        while (!repeat.equals("bye")) {
            if(repeat.equals("list")) {
                for(int i= 0; i< ls.size(); i++) {
                    System.out.println((i+1) + ". " + ls.get(i));
                }
                }
            else {
                ls.add(repeat);
                System.out.println("added: " + repeat);
            }

            repeat = scan.next();

        }

        System.out.println("" + goodbye);


    }
}
