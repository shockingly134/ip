import java.io.IOException;


/**
 * Adding a new event task
 */
public class AddEventCommand extends Command {
    private String desc;
    private String start;
    private String end;

    public AddEventCommand(String desc, String start, String end) {
        this.desc =desc;
        this.start = start;
        this.end = end;
    }

    @Override
    public void perform (TaskList list, Storage storage, Ui ui) {
        Events task = new Events(desc,start,end);
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