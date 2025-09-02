import java.io.IOException;

/**
 * Remove a task from the tasklist
 */

public class RemoveCommand extends Command {

    private int no;

    public RemoveCommand(int no) {
        this.no = no;
    }

    @Override
    public void perform(TaskList ls, Storage storage, Ui ui) {
        if (ls.size() == 0) {
            throw new IllegalArgumentException("No more tasks to delete!");
        }

        if (no >= 1 && no <= ls.size()) {

            Task removed = ls.removeTask(no);
            try {
                storage.save(ls.getAllTasks());
            } catch (IOException e) {
                System.out.println("Cannot save changes");
            }
            ui.showRemoval(removed, ls.size());
        }

    }
}
