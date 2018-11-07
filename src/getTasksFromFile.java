import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class getTasksFromFile {

    public static List<Task> getTasksFromFile(String filepath)throws TaskManagerException {
        List<Task> loadedTasks = new ArrayList<>();
        try {
            List<String> lines = getLines(filepath);
            for (String line : lines) {
                if (line.trim().isEmpty()) { //ignore empty lines
                    continue;
                }
                loadedTasks.add(createTask(line)); //convert the line to a task and add to the list
            }
        } catch (FileNotFoundException e) {
            //printError("problem encountered while loading data: " + e.getMessage());
            throw new TaskManagerException("");


        }
        return loadedTasks;
    }

    private static List<String> getLines(String data) throws FileNotFoundException{
        File f = new File(data);
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        List <String> myStrings=new ArrayList<>();
        while (s.hasNext()) {
            myStrings.add(s.nextLine());
        }
        return myStrings;
    }

    private static Task createTask(String myTask) {
        String TaskType=myTask.split("\\|")[0].trim();
        String DoneOrNot=myTask.split("\\|")[1].trim();
        String TaskDescription=myTask.split("\\|")[2].trim();


        //System.out.println(TaskType);
        if (TaskType.contains("T")){
            boolean done=false;
            if (DoneOrNot=="1")
                done=true;
            //System.out.println("Todo added");
            return new Todo(TaskDescription, done);

        }
        else if (TaskType.contains("D")){
            String Deadline=myTask.split("\\|")[3].trim();
            boolean done=false;
            if (DoneOrNot=="1")
                done=true;
            //System.out.println("deadline added");
            return new Deadline(TaskDescription, Deadline, done);
        }
        else {
            //System.out.println("NULLLLL");
            return null;
        }
    }

    private static void printError(String errorMsg) {
        System.out.println(errorMsg+ " error! please try again");
    }


}
