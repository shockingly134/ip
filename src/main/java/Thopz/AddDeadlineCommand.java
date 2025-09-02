package Thopz;

import java.io.IOException;


/**
 * Adding a new deadline task
 */
public class AddDeadlineCommand extends Command  {
    private String desc;
    private String due;

    public AddDeadlineCommand(String desc,String due) {
        this.desc = desc;
        this.due = due;
    }

    @Override
    public void perform (TaskList list, Storage storage, Ui ui) {
        Deadline task = new Deadline(desc,due);
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
