public class RandomNumbersService {

   public static int glueTwoNumbers( RandomNumber first,RandomNumber second){
       return Integer.parseInt(String.valueOf(first.getRandomNumber())+String.valueOf(second.getRandomNumber()));
    }
}