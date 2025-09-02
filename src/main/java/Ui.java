import java.util.List;
import java.util.Scanner;

/**
 * User interface class for reading and understanding various
 * user inputs and outputs
 *
 */


public class Ui {

    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    /**
     * Read user input
     */

    public String readInput() {
        return sc.nextLine();
    }

    /**
     * Welcome message
     */

    public void showGreetings() {
        System.out.println("Wassup wassup! Life ok? Vibes ok? Family ok? " +
                "I am thopz your virtual chatbot. " +
                "How may I help you?");
    }

    /**
     * Goodbye message
     */

    public void showGoodbye() {
        System.out.println( "Chaoz. See you !");
    }


    public void showError(String msg) {
        System.out.println("OOPS!!!!!" + msg);
    }

    /**
     * Message for addition of task
     */

    public void showAddition(Task task, int size) {
        System.out.println("Orrite, I have added " + task +
                "\nYou have " + size + " tasks");
    }

    /**
     * Message for removal of task
     */

    public void showRemoval(Task task, int size) {
        System.out.println("Solidd! I have deleted this task as done \n" + task
                + "\nYou have " + size + " tasks");
    }

    /**
     * Message for marking of task
     */


    public void showMarked(Task task) {
        System.out.println("Solidd! I have marked this task as done \n" + task);
    }

    /**
     * Message for error in loading of saved task
     */


    public void showLoadingError() {
        System.out.println("No saved tasks");
    }

    /**
     * Message for showing the list of tasks
     * Empty list case is also handled
     */

    public void showList(List<Task> ls) {
        if (ls.isEmpty()) {
            System.out.println("You have no tasks in your list");
        } else {
            for (int i = 0; i < ls.size(); i++) {
                System.out.println((i + 1) + ". " + ls.get(i));
            }

        }
    }
}
