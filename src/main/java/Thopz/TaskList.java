package Thopz;

import java.util.List;
import java.util.ArrayList;

/**
 * Task List manages the various tasks in a arraylist
 * Has the functionalities of add,remove,mark and list
 * Double constructor in case nothing to load
 */


public class TaskList {

    private ArrayList<Task> ls = new ArrayList<>();

    public TaskList(List<Task> tasks) {
        ls = new ArrayList<>(tasks);
    }

    public TaskList() {
        ls = new ArrayList<>();
    }

    /**
     * Add tasks into tasklist
     */

    public void addTask(Task task) {
        ls.add(task);
    }

    /**
     * Remove tasks from tasklist
     *
     * @return
     */

    public Task removeTask(int no) {
        return ls.remove(no-1);
    }


    /**
     * Get tasks from tasklist
     */

    public void listTasks () {
        for (int i = 0; i < ls.size(); i++) {
            System.out.println((i + 1) + ". " + ls.get(i));
        }
    }


    /**
     * Get specific tasks from tasklist
     * Throw illegal argument if no tasks found
     */

    public void findTasks (String string) {

        boolean found = false;
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).toString().contains(string)) {
                System.out.println(i+1 +". " + ls.get(i));
                found = true;
            }
        }
        if(!found) {
            throw new IllegalArgumentException("No such tasks with the keywords!");
        }
    }


    /**
     * Get all tasks from tasklist
     */

    public List<Task> getAllTasks() {
       return ls;
        }

    /**
     * Get all tasks from tasklist
     */

    public int size() {
        return ls.size();
    }


    public Task getTask (int no) {
        return ls.get(no-1);
    }

}
