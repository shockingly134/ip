package Thopz;

/**
 * Stops the chatbot from running
 */

public class ExitCommand extends Command {

    @Override
    public boolean isDone() {
        return true;
    }

    @Override
    public void perform(TaskList ls, Storage storage, Ui ui) {
        return;
    }

}

