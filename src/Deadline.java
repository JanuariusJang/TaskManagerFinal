import java.util.Date;

public class Deadline extends Todo {
    protected String by;
    protected Date bydate;

    public Deadline(String description, String byDate){
        super(description);
        by=byDate;
    }

    public Deadline(String description, String byDate, boolean isDone){
        super(description, isDone);
        by=byDate;
    }

    public String getBy(){
        return by;
    }
    public void setBy(String byDate){
        by=byDate;
    }

    @Override
    public String asString() {
        return super.asString() + System.lineSeparator() + "Do by:" + getBy() ;
    }

    public String asSaveString(){
        int isTaskDone = isDone? 1: 0;
        return "D | " + isTaskDone + " | " + myTaskDescription +" | "
                + by + System.lineSeparator();

    }
}
