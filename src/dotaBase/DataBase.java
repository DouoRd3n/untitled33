package dotaBase;


import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataBase {
    private static DataBase dataBase;
    private Map<String , User> map = new HashMap<>();

    public static DataBase getInstanse(){
        if (dataBase == null){
            return new DataBase();
        } else {
            return dataBase;
        }

    }

    public String getId(User user){
        String id = UUID.randomUUID().toString();
        return id;
    }
// вивести весь зміст бази данних на екран
    public void prinAll(){
        for (Map.Entry<String, User> me: map.entrySet()
             ) {
            System.out.println(me.getValue());

        }
    }
// додати юзера в базу данних
public void addUser(User user){
        String id = getId(user);
        user.setId(id);
        map.put(id, user);


}

}
