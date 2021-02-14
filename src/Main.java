import ThreadSave.SaveThread;
import dotaBase.DataBase;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class Main{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DataBase dataBase = new DataBase();

        ExecutorService service = Executors.newFixedThreadPool(10);
        int key = 0;

boolean start = false;


        while (!start){


                printMenu();
                key = getAction();
               start = doAction(key, service, dataBase);


        }
        service.shutdown();

    }
// виконання по дії по ключу
    private static boolean doAction(int key, ExecutorService service, DataBase dataBase) {


        if (key == 1) {
            saveUser(new User(getName()), service, dataBase);

        } else if (key ==2){
            getAllUser(dataBase);

        } else if (key == 3){
            return true;
        }
return false;
    }
// отримати всі сохранені дані
    private static void getAllUser(DataBase dataBase) {
        dataBase.prinAll();

    }
// запуск потока для додавання обьєкта в БД
    private static Future<String> saveUser(User user, ExecutorService service, DataBase dataBase) {


        Future<String> submit = service.submit(new SaveThread(user, dataBase));

 return submit;
    }

//    Отримати імья юзера
    private static String getName() {
        System.out.println("введите имя: ");
        String name = null;
        try {
            name = getInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
// отримати ключ для вибора із меню
    private static int getAction() {
        int key = 0;
        try {
            key =Integer.parseInt(getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key;
    }
// метод ля ввода данних із консолі
     private static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();

        return result;
    }
// виводить меню на екран
    private static void printMenu() {
        System.out.println(" Menu");
        System.out.println("1 зберегти user" );
        System.out.println("2 Показати всіх");
        System.out.println("3 вихід");
    }
}
