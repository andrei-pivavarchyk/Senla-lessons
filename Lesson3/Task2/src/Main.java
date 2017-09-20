public class Main {
public static void main(String[] args){

    int firstNumber=RandomNumbersService.getRandomNumber();
    int secondNumber=RandomNumbersService.getRandomNumber();
    int thirdNumber=RandomNumbersService.getRandomNumber();

    //Glue Numbers
    int glueFirstAndSecondNumbers= RandomNumbersService.glueTwoNumbers(firstNumber,secondNumber);

    int forthNumber=glueFirstAndSecondNumbers-thirdNumber;


    System.out.println(firstNumber+" "+secondNumber+" "+thirdNumber+" "+forthNumber);

}
}
