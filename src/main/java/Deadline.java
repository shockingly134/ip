public class Deadline extends Task{
    private String due;

    public Deadline (String tasks, String due) {
        super(tasks);
        this.due = due;

    }

    @Override
    public String saveformat() {
        return  "D / " + (getTaskStatus() ? "1" : "0") + " / " + getTasks() + " / " + due;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (due by " + due + ")";
    }
}
