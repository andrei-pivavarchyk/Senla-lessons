public class Main {
public static void main(String[] args){

    int firstNumber=RandomNumber.getRandomNumber();
    int secondNumber=RandomNumber.getRandomNumber();
    int thirdNumber=RandomNumber.getRandomNumber();

    //Glue Numbers
    int glueFirstAndSecondNumbers= GlueTwoNumbers.glueTwoNumbers(firstNumber,secondNumber);

    int forthNumber=glueFirstAndSecondNumbers-thirdNumber;


    System.out.println(firstNumber+" "+secondNumber+" "+thirdNumber+" "+forthNumber);

}
}
