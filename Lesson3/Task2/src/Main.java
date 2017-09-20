public class Main {
public static void main(String[] args){

    RandomNumber firstNumber=new RandomNumber();
    RandomNumber secondNumber=new RandomNumber();
    RandomNumber thirdNumber=new RandomNumber();


    int glueFirstAndSecondNumbers= RandomNumbersService.glueTwoNumbers(firstNumber,secondNumber);
    int forthNumber=glueFirstAndSecondNumbers-thirdNumber.getRandomNumber();


    System.out.println(firstNumber.getRandomNumber()+" "+secondNumber.getRandomNumber()+" "+thirdNumber.getRandomNumber()+" "+forthNumber);

}
}
