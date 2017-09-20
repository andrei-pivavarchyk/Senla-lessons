public class TextArray {

    public String[] separateText(String someText){

        someText= someText.replaceAll("[^a-zA-Zа-яА-Я- ]", "");
        someText= someText.replaceAll("  ", " ");
        String[] someTextArray=someText.split(" " );
        return someTextArray;





    }
}
