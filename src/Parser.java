public class Parser {

    public static String getCommandWord (String fullCommand){
        return fullCommand.split(" ")[0];
    }

    public static Todo createTodo (String fullCommand) throws TaskManagerException{
        if(fullCommand.length()<6)
            throw new TaskManagerException("Task description not available");
        String todoDescription=(fullCommand.substring("todo".length())).trim();
        return new Todo (todoDescription);
    }

    public static Deadline createDeadline (String fullCommand){
        String deadlineDescription=fullCommand.split("/by")[0];
        String deadline=fullCommand.split("/by")[1];
        return new Deadline(deadlineDescription.substring("deadline".length()).trim(),deadline.trim());
    }

    public static int getLineNumber(String fullCommand){
        return Integer.parseInt(fullCommand.split(" ")[1]);
    }
}
