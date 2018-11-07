import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public TaskList (List<Task> oldtasks){
        tasks = new ArrayList<>();
        tasks.addAll(oldtasks);

    }

    public void markAsDone(int line){
        Task myTask;
        myTask=tasks.get(line-1);
        myTask.setDone(true);
    }

    public void addTask(Task newTask){

        tasks.add(newTask);
    }

    public int getSize(){
        return tasks.size();
    }

    public Task getTask(int myIndex){
        return tasks.get(myIndex);
    }

    public void saveToFile(){
        new Storage(tasks);
    }

}
