package Thopz;

/**
 * Find and display a certain list of tasks
 * Narrow down tasklist based on key word
 */


public class FindCommand extends Command {

    private String find;

    public FindCommand(String find) {
        this.find = find;

    }


    @Override
    public void perform(TaskList ls, Storage storage, Ui ui) {

        if (ls.size() > 0) {
            try {
                ls.findTasks(find);
                ui.showFind();
            } catch (IllegalArgumentException e) {
                ui.showError(e.getMessage());
            }

        }
    }
}