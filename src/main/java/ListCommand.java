import java.io.IOException;

/**
 *
 */

public class ListCommand extends Command {

    @Override
    public void perform(TaskList ls, Storage storage, Ui ui) {
        ui.showList(ls.getAllTasks());
    }

}