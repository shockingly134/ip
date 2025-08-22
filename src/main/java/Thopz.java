import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Task> ls = new ArrayList<>();


        System.out.println("" + greetings);
        Task repeat = new Task(scan.nextLine());


        while (!repeat.getTasks().equals("bye")) {
            if(repeat.getTasks().equals("list")) {
                for(int i= 0; i< ls.size(); i++) {
                    System.out.println((i+1) + ". " + ls.get(i));
                }
                }

            else if (repeat.getTasks().startsWith("mark")) {
               try {
                   String[] parts = repeat.getTasks().split(" ");
                   int no = Integer.parseInt(parts[1]);
                   if(no>=1 && no<= ls.size()) {
                       ls.get(no-1).markTask();
                       System.out.println("Solidd! I have marked this task as done \n"  + ls.get(no-1).getTasks());
                   }
                   else {
                       System.out.println("bruh, out of range");
                   }
               }
               catch (NumberFormatException e) {
                   System.out.println("no valid number");
               }
            }

            else {
                ls.add(repeat);
                System.out.println("added: " + repeat.getTasks());
            }

            repeat = new Task(scan.nextLine());

        }

        System.out.println("" + goodbye);


    }
}
