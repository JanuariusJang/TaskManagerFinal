public abstract class Task {
    protected String myTaskDescription;
    protected boolean isDone;

    public Task (){
    }

    public Task (String mytask) {
        myTaskDescription=mytask;
        isDone=false;
    }

    public Task (String mytask, Boolean isDoneOrNot) {
        myTaskDescription=mytask;
        isDone=isDoneOrNot;
    }

    public boolean isDone(){
        return isDone;
    }

    public void setDone(boolean doneOrNot){
        isDone=doneOrNot;
    }

    /*public void setTaskDescription(String mytask){
        myTaskDescription = mytask;
    }*/

    public String getDescription() {
        return myTaskDescription;
    }

    public abstract String asString();

    public abstract String asSaveString();

}

