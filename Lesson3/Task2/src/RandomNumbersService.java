import java.util.Random;

public class RandomNumbersService {

    public static int getRandomNumber(){
        return (new Random()).nextInt(999);
    }

    public static int glueTwoNumbers(int first, int second){
       return Integer.parseInt(String.valueOf(first)+String.valueOf(second));
    }
}