package thopz;

/**
 *
 */

public class ListCommand extends Command {

    @Override
    public String perform(TaskList ls, Storage storage, Ui ui) {
       return ui.showList(ls.getAllTasks());
    }

}
