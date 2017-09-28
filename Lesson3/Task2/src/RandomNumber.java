import java.util.Random;

public class RandomNumber {

    private int randomNumber;

    public RandomNumber(){
        this.randomNumber=(new Random()).nextInt(899)+100;
    }

    public int getRandomNumber(){
        return this.randomNumber;
    }


}