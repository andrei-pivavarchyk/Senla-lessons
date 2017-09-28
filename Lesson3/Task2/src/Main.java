public class Main {
public static void main(String[] args){

    int firstNumber=new RandomNumber().getRandomNumber();
    int secondNumber=new RandomNumber().getRandomNumber();
    int thirdNumber=new RandomNumber().getRandomNumber();
    //Glue Numbers
    int glueFirstAndSecondNumbers= GlueTwoNumbers.glueTwoNumbers(firstNumber,secondNumber);

    int forthNumber=glueFirstAndSecondNumbers-thirdNumber;

    System.out.println(firstNumber+" "+secondNumber+" "+thirdNumber+" "+forthNumber);

}
}
