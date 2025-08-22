public class Task extends Thopz{
    public String tasks;
    private boolean done;

    public Task (String tasks) {
        this.tasks =tasks;
        this.done = false;
    }

    public String getTasks () {
        return this.tasks;
    }

    public void markTask() {
        this.done = true;
    }

    public void unmarkTask() {
        this.done = false;
    }

    public boolean getTaskStatus() {
        return this.done;

    }

    @Override
    public String toString() {
        if(this.done) {
            return "[x] " + tasks ;
        }
        else {
            return "[] " + tasks;
        }
    }
}

