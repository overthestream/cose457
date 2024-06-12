package model.command;

public class UndoCommand implements Command {

    private Command undidCommand;

    public UndoCommand(Command command) {
        this.undidCommand=command;
    }

    @Override
    public void undo() {
        undidCommand.execute();
    }

    @Override
    public void execute() {
        undidCommand.undo();
    }

    @Override
    public boolean isUndoable(){
        return true;
    }
}
