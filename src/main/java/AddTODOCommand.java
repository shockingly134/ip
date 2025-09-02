import java.io.IOException;

/**
 * Adding a new todo task
 */

public class AddTODOCommand extends Command {

    private String desc;

    public AddTODOCommand(String desc) {
        this.desc = desc;
    }

    @Override
    public void perform (TaskList list, Storage storage, Ui ui) {
        Todo task = new Todo(desc);
        list.addTask(task);
        try {
            storage.save(list.getAllTasks());
        }
        catch (IOException e) {
            System.out.println("Cannot save changes");
        }
        ui.showAddition(task,list.size());
    }

}
