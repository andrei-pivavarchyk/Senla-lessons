import java.util.Random;

public class RandomNumber {

    public static int getRandomNumber(){
        return (new Random()).nextInt(899)+100;
    }


}