import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static int test(){

        int i = 2;
        try {
            int i1 = i / 0;
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 1;
        }finally {
            System.out.println("Finally");
            //return 2;
        }
    }




    public static void main(String[] args) {

        int test = Main.test();
        System.out.println(test);

    }

}