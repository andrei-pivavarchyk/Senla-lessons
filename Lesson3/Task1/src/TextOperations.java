public class TextOperations {

    public String[] separateTextAndPushIntoArrayAllWords(String text){
       text= this.deleteAllSimbolsAndNumbers(text);
       text=this.deleteExtraSpaces(text);
        String[] WordArray=text.split(" " );
        return WordArray;

    }

    private  String deleteAllSimbolsAndNumbers(String text){
        text=text.replaceAll("[^a-zA-Zа-яА-Я- ]", "");
        return text;
    }
    private String deleteExtraSpaces(String text){
        text= text.replaceAll("  ", " ");
        return text;
    }
}




