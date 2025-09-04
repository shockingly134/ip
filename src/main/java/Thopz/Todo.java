package Thopz;

/**
 * Implementation of todo task
 * extends task, takes in only a description
 */

public class Todo extends Task {

    public Todo(String desc) {
        super(desc);
    }

    @Override
    public String saveformat() {
        return "T / " + (getTaskStatus() ? "1" : "0") + " / " + getTasks();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
