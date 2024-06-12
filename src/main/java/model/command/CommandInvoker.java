package model.command;

import java.util.Stack;

public class CommandInvoker {
    private CommandInvoker(){}

    private Stack<Command> executeHistory = new Stack<>();
    private Stack<UndoCommand> undoHistory = new Stack<>();

    private static CommandInvoker instance;

    public static CommandInvoker getInstance() {
        if(instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }

    public void executeCommand(Command command) {
        command.execute();
        if(command.isUndoable()){
            executeHistory.push(command);
        }
        undoHistory.clear();
    }

    public void undo(){
        if(!isUndoable()) return;
        Command command = executeHistory.pop();
        UndoCommand undoCommand = new UndoCommand(command);

        undoCommand.execute();
        undoHistory.push(undoCommand);

    }

    public void redo(){
        if(!isRedoable()) return;
        UndoCommand undoCommand = undoHistory.pop();
        UndoCommand redoCommand = new UndoCommand(undoCommand);
        redoCommand.execute();
        executeHistory.push(redoCommand);
    }

    public boolean isUndoable(){
        return executeHistory.size() > 0;
    }

    public boolean isRedoable(){
        return undoHistory.size()>0;
    }

}
