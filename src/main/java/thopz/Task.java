package thopz;

/**
 * Represents task with  description and  status.
 * A task can be marked as done or left unmarked.
 */
public class Task {
    private String tasks;
    private boolean done;

    /**
     * Constructs a task
     *
     * @param tasks  the description of the task
     *
     *
     */

    public Task(String tasks) {
        assert tasks != null : "Task description should not be null";
        this.tasks = tasks;
        this.done = false;
    }

    /**
     * Indicates status of task
     */

    public String getTasks() {
        return this.tasks;
    }

    /**
     * Returns a task
     */

    public void markTask() {
        this.done = true;
    }

    /**
     * Unmarks a task
     */

    public void unmarkTask() {
        this.done = false;
    }

    /**
     * Indicates whether the task has been marked as done.
     */

    public boolean getTaskStatus() {
        return this.done;

    }

    /**
     * Saving format of a task
     */

    public String saveformat() {
        return "NIL";
    }

    /**
     * String representation of the task
     */
    @Override
    public String toString() {
        if (this.done) {
            return "[x] " + tasks;
        } else {
            return "[] " + tasks;
        }
    }

}

