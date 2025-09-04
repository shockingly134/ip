package Thopz;

/**
 * Parser class to parse user inputs
 */

public class Parser {

    /**
     * Parser class to parse user inputs
     * if bye end the program,
     * Include various way to split the data to achieve right command
     * Invalid inputs throw and exception
     *  Deadline would have one /, so splitting words and taking the required once
     *  find would require a space before inputting the string to filter the task list
     */
    public static Command parse (String inp) {
        if (inp.equals("bye")) {
            return new ExitCommand();

        } else if (inp.equals("list")) {
            return new ListCommand();

        } else if (inp.startsWith("mark ")) {
            try {
                String[] parts = inp.split(" ");
                int no = Integer.parseInt(parts[1]);
                return new Markcommand(no);

            } catch (Exception e) {
                throw new IllegalArgumentException("invalid number");
            }
        } else if (inp.startsWith("deadline ")) {
            String[] parts = inp.split(" /", 2);
            if (parts.length != 2) {
                throw new IllegalArgumentException("You should add a / after your description to specify deadline" +
                        "Also note that there should be a space between your slash " +
                        "e.g deadline fight / 12/12/2025 19:55");
            }
            String desc = parts[0].substring(9);
            String due = parts[1];
            return new AddDeadlineCommand(desc, due);
        }

        // Event would have // which show start and end, so by splitting can create new Event task
        else if (inp.startsWith("event ")) {

            String des = inp.substring(6);
            int count = inp.split(" /", -1).length - 1;
            if (des.isEmpty()) {
                throw new IllegalArgumentException("You should give an description!");
            } else if (count < 2) {
                throw new IllegalArgumentException("You should add 2 slashes / after your description " +
                        "ensure that you have a space before your 2 slashes" +
                        "to specify event start and end date e.g(eating / Monday / Tuesday");
            }
            String[] parts = inp.split(" /", 3);
            String desc = parts[0].substring(6);
            String begin = parts[1];
            String end = parts[2];
            return new AddEventCommand(desc, begin, end);

        }

        // Todo task with js a message
        else if (inp.startsWith("todo ")) {
            String des = inp.substring(5);
            if (des.isEmpty()) {
                throw new IllegalArgumentException("You should give an description!");
            }
            String desc = inp.substring(5);
            return new AddTODOCommand(desc);

        } else if (inp.startsWith("delete ")) {
            try {
                String[] parts = inp.split(" ");
                int no = Integer.parseInt(parts[1]);
                return new RemoveCommand(no);

            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid delete command, use delete <task_no>, e.g(delete 2)..");
            }

        } else if (inp.startsWith("find ")) {
            String find = inp.substring(5);
            if(find.isEmpty()) {
                throw new IllegalArgumentException("You should give an description!");
            }
            else {
                return new FindCommand(find);
            }
        } else {
            throw new IllegalArgumentException("uhh, idk what you are saying! You gotta start with what kind" +
                    "of task you wish to add,(e.g todo homework, deadline eating/Monday, etc");
        }
    }
}

