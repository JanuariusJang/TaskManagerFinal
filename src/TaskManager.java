public class TaskManager {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public TaskManager(String filePath) {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load());
        } catch (TaskManagerException e) {
            ui.showToUser("Problem reading file. Starting with an empty task list");
            tasks = new TaskList();
        }
    }




    public void run() {
        ui.printWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readUserCommand();
                String commandWord = Parser.getCommandWord(fullCommand);
                switch (commandWord) {
                    case "exit":
                    case "": // exit if user input is empty
                        isExit = true;
                        break;
                    case "todo":
                        tasks.addTask(Parser.createTodo(fullCommand));
                        break;
                    case"deadline":
                        tasks.addTask(Parser.createDeadline(fullCommand));
                        break;
                    case "print":
                        ui.printAllTasks(tasks);
                        break;
                    case "done":
                        tasks.markAsDone(Parser.getLineNumber(fullCommand));
                        break;
                    case "save":
                        tasks.saveToFile();
                        break;
                    default:
                        throw new TaskManagerException("Sorry, I do not understand your input");
                }
            } catch (TaskManagerException e) {
                ui.printError(e.getMessage());
            }
        }
        exit();
    }

    public void exit(){
        System.out.println("Good Bye!");
    }
}
