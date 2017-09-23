public class Main {
public static void main(String[] args){

    int firstNumber=RandomNumbersOperations.getRandomNumber();
    int secondNumber=RandomNumbersOperations.getRandomNumber();
    int thirdNumber=RandomNumbersOperations.getRandomNumber();

    //Glue Numbers
    int glueFirstAndSecondNumbers= RandomNumbersOperations.glueTwoNumbers(firstNumber,secondNumber);

    int forthNumber=glueFirstAndSecondNumbers-thirdNumber;


    System.out.println(firstNumber+" "+secondNumber+" "+thirdNumber+" "+forthNumber);

}
}
