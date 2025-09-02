
import java.io.IOException;

/**
 * Mark a task from the tasklist
 */

public class Markcommand extends Command {

    private int no;

    public Markcommand(int no) {
        this.no = no;
    }

    @Override
    public void perform(TaskList ls, Storage storage, Ui ui) {
        if (no < 0 || no >= ls.size()) {
            throw new IllegalArgumentException("bruh, out of range");
        }
        else {
            Task task = ls.getTask(no-1);
            task.markTask();

            try {
                storage.save(ls.getAllTasks());
            } catch (IOException e) {
                System.out.println("Cannot save changes");
            }
            ui.showMarked(task);
        }
    }
}
