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

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Task> ls = new ArrayList<>();


        System.out.println("" + greetings);
        String inp = scan.nextLine();



        while (!inp.equals("bye")) {
            if(inp.equals("list")) {
                for(int i= 0; i< ls.size(); i++) {
                    System.out.println((i+1) + ". " + ls.get(i));
                }
                }

            else if (inp.startsWith("mark")) {
               try {
                   String[] parts = inp.split(" ");
                   int no = Integer.parseInt(parts[1]);
                   if(no>=1 && no<= ls.size()) {
                       ls.get(no-1).markTask();
                       System.out.println("Solidd! I have marked this task as done \n"  + ls.get(no-1).toString());
                   }
                   else {
                       System.out.println("bruh, out of range");
                   }
               }
               catch (NumberFormatException e) {
                   System.out.println("no valid number");
               }
            }
            // Deadline would have one /, so splitting words and taking the required once
            else if (inp.startsWith("deadline")) {
                String[] parts = inp.split("/");
                String desc = parts[0].substring(9);
                String due = parts[1];
                ls.add(new Deadline(desc, due));
                System.out.println("Orrite, I have added " + inp + "\nYou have " +ls.size() + " tasks");
            }


            // Event would have // which show start and end, so by splitting can create new Event task
            else if (inp.startsWith("event")) {
                String[] parts = inp.split("/");
                String desc = parts[0].substring(6);
                String begin = parts[1];
                String end = parts[2];
                ls.add(new Events(desc, begin, end));
                System.out.println("Orrite, I have added " + inp + "\nYou have " +ls.size() + " tasks");
            }

            // Todo task with js a message

            else if (inp.startsWith("todo")) {
                String desc = inp.substring(5);
                ls.add(new Todo(desc));
                System.out.println("Orrite, I have added " + inp +  "\nYou have " +ls.size() + " tasks");
            }


            else {
                ls.add(new Task(inp));
                System.out.println("added: " + inp);
            }

            inp = scan.nextLine();

        }

        System.out.println("" + goodbye);


    }
}
