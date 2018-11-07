public class Todo extends Task {
    //protected boolean isDone;

    public Todo() {
    }

    public Todo (String description){
        super(description);
        //isDone=false;
    }

    @Override
    public String asString() {
        String yesno = isDone()? "yes": "no";
        return getDescription() + System.lineSeparator()+ "Is done? "+ yesno;
    }
    public String asSaveString() {
        int isTaskDone = isDone ? 1 : 0;
        return "T | " + isTaskDone + " | " + myTaskDescription
                + System.lineSeparator();
    }

    public Todo (String description, boolean isDone){
        super(description,isDone);
        //isDone=false;
    }
    /*public boolean isDone(){
        return isDone;
    }*/

    /*public void setDone(boolean doneOrNot){
        isDone=doneOrNot;
    }*/
    //
}
