/**
 * Abstract command class
 */

import java.io.IOException;

public abstract class Command {
    public boolean isDone () {
        return false;
    }
    public abstract void perform(TaskList tasks, Storage storage, Ui ui) throws IOException;

}
