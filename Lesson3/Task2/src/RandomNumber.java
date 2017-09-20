import java.util.Random;

public class RandomNumber {
    private int randomNumber;

    public RandomNumber(){
        randomNumber=(new Random()).nextInt(999);
    }

    public int getRandomNumber(){
        return this.randomNumber;
    }
}