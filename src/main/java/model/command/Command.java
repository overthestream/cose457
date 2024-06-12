package model.command;

public interface Command {
    void undo();
    void execute();

    boolean isUndoable();
}
