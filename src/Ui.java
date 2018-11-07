import java.util.Scanner;

public class Ui {

    private Scanner in;

    public Ui(){
        in=new Scanner (System.in);
    }
    public void showToUser(String myMessage){
        System.out.println(myMessage);
    }

    public void printWelcome(){
        System.out.println("Welcome to Task Manager!");
    }

    public void printError(String errorMessage){
        System.out.println("There seems to be an error." + errorMessage);
    }

    public String readUserCommand(){
        System.out.print("Your task? ");
        return in.nextLine();
    }

    public void printAllTasks(TaskList myTaskList){
        for (int i=0; i<myTaskList.getSize(); i++){

            System.out.println("[" + (i + 1) + "] " + "Description: " + myTaskList.getTask(i).asString());
            System.out.println(" ");

        }

    }

}
