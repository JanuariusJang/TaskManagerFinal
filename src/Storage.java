import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Task> tasks; //= new ArrayList<>() not required as object will be created elsewhere.
    //private int currentTaskCount=0;

    public Storage(String filepath) throws TaskManagerException{

        tasks=getTasksFromFile.getTasksFromFile(filepath);
        //System.out.println("Storage ok");
        //currentTaskCount=tasks.size();
    }

    public List<Task> load(){
        return tasks;
    }



    public  Storage (List<Task> mytasks){
        SaveTaskToFile.saveFile(mytasks);
        //currentTaskCount=0;
    }
}
