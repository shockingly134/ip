package Thopz;

import java.io.IOException;
import java.util.ArrayList;


public class Thopz {

    private TaskList ls;
    private Storage storage;
    private Ui ui;

    public Thopz(String filePath) {
        this.storage = new Storage(filePath);
        this.ui = new Ui();
        try {
            ls = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showLoadingError();
            ls = new TaskList(new ArrayList<>());
        }
    }

    /**
     * run command which will call the start of the chatbot
     * will only exit upon bye
     */

    public void run() {
        ui.showGreetings();
        boolean isDone = false;
        while(!isDone) {
            try {
                String fullInput = ui.readInput();
                Command command = Parser.parse(fullInput);
                command.perform(ls,storage,ui);
                isDone = command.isDone();

            } catch (IOException e) {
               e.getMessage();
            }
            catch (IllegalArgumentException e) {
                ui.showError(e.getMessage());
            }

            catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
        ui.showGoodbye();
    }

    public static void main(String[] args) {
        new Thopz("Thopz/TaskStorage.txt").run();
    }







}


    /*public static String greetings = "Wassup wassup! Life ok? Vibes ok? Family ok? " +
            "I am thopz your virtual chatbot. " +
            "How may I help you?" ;
    public static String goodbye = "Chaoz. See you !";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Task> ls = new ArrayList<>();
        Storage storage = new Storage("TaskStorage.txt");

        try {
            ls = storage.load();
        } catch (IOException e) {
            System.out.println("No saved tasks!");;
        }


        System.out.println("" + greetings);
        String inp = scan.nextLine();



        while (!inp.equals("bye")) {
            try {
                if (inp.equals("list")) {

                    if(ls.isEmpty()) {
                        System.out.println("You have no tasks in your list");
                    }
                    else {
                    for (int i = 0; i < ls.size(); i++) {
                        System.out.println((i + 1) + ". " + ls.get(i));
                    }
                    }



                } else if (inp.startsWith("mark ")) {
                    try {
                        String[] parts = inp.split(" ");
                        int no = Integer.parseInt(parts[1]);
                        if (no >= 1 && no <= ls.size()) {
                            ls.get(no - 1).markTask();
                            System.out.println("Solidd! I have marked this task as done \n" + ls.get(no - 1).toString());
                            try {
                                storage.save(ls);
                            } catch (IOException e) {
                                System.out.println("Cannot save");;
                            }
                        } else {
                            System.out.println("bruh, out of range");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("no valid number");
                    }
                }
                // Deadline would have one /, so splitting words and taking the required once
                else if (inp.startsWith("deadline ")) {
                    String des =inp.substring(9);
                    if(des.isEmpty()) {
                        throw new IllegalArgumentException("You should give an description!");
                    }
                    else if (!inp.contains("/")) {
                        throw new IllegalArgumentException("You should add a / after your description to specify deadline");
                    }

                    String[] parts = inp.split("/",2);
                    String desc = parts[0].substring(9);
                    String due = parts[1];
                    ls.add(new Deadline(desc, due));
                    System.out.println("Orrite, I have added " + inp + "\nYou have " + ls.size() + " tasks");
                    try {
                        storage.save(ls);
                    }
                    catch (IOException e) {
                        System.out.println("Cannot save changes");
                    }

                }


                // Event would have // which show start and end, so by splitting can create new Event task
                else if (inp.startsWith("event ")) {
                    String des =inp.substring(6);
                    int count = inp.split(" /", -1).length - 1;
                    if(des.isEmpty()) {
                        throw new IllegalArgumentException("You should give an description!");
                    }
                    else if (count<2) {
                        throw new IllegalArgumentException("You should add 2 slashes / after your description " +
                                "ensure that you have a space before your 2 slashes" +
                                "to specify event start and end date e.g(eating / Monday / Tuesday");
                    }
                    String[] parts = inp.split(" /",3);
                    String desc = parts[0].substring(6);
                    String begin = parts[1];
                    String end = parts[2];
                    ls.add(new Events(desc, begin, end));
                    System.out.println("Orrite, I have added " + inp + "\nYou have " + ls.size() + " tasks");
                    try {
                        storage.save(ls);
                    }
                    catch (IOException e) {
                        System.out.println("Cannot save changes");
                    }
                }

                // Todo task with js a message

                else if (inp.startsWith("todo ")) {
                    String des =inp.substring(5);
                    if(des.isEmpty()) {
                        throw new IllegalArgumentException("You should give an description!");
                    }
                    String desc = inp.substring(5);
                    ls.add(new Todo(desc));
                    System.out.println("Orrite, I have added " + inp + "\nYou have " + ls.size() + " tasks");
                    try {
                        storage.save(ls);
                    }
                    catch (IOException e) {
                        System.out.println("Cannot save changes");
                    }
                }

                else if (inp.startsWith("delete ")) {
                    try {
                        String[] parts = inp.split(" ");
                        int no = Integer.parseInt(parts[1]);
                        if (no >= 1 && no <= ls.size()) {
                            Task removed = ls.remove(no-1);
                            System.out.println("Solidd! I have deleted this task as done \n" + removed);
                            try {
                                storage.save(ls);
                            }
                            catch (IOException e) {
                                System.out.println("Cannot save changes");
                            }
                        } else {
                            System.out.println("bruh, out of range");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("no valid number given");
                    }

                }
                else {
                    throw new IllegalArgumentException("uhh, idk what you are saying! You gotta start with what kind" +
                            "of task you wish to add,(e.g todo homework, deadline eating/Monday, etc");
                }

            }

            catch(IllegalArgumentException e) {

                System.out.println("OOPS!!!!!" +e.getMessage());

            }

            inp = scan.nextLine();

        }



        System.out.println("" + goodbye);


    }
}
*/

