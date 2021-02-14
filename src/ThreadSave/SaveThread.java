package ThreadSave;

import dotaBase.DataBase;
import model.User;

import java.util.concurrent.Callable;

public class SaveThread implements Callable<String>{
    private User user;
    private DataBase dataBase;

    public SaveThread(User user, DataBase dataBase) {
        this.user = user;
        this.dataBase = dataBase;
    }

    public SaveThread(User user) {
    }

    @Override
    public String call() throws Exception {

       dataBase.addUser(user);
        Thread.sleep(5000);
       String result = "user" + user.getId() +"записаний";
        return result ;
    }


}
