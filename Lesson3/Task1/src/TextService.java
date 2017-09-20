public class TextService {

    public String[] separateTextAndPushIntoArrayAllWords(String text){
       text= this.deleteAllSimbolsAndNumbers(text);
       text=this.deleteExtraSpaces(text);
        String[] WordArray=text.split(" " );
        return WordArray;


    }

    public  String deleteAllSimbolsAndNumbers(String text){
        text=text.replaceAll("[^a-zA-Zа-яА-Я- ]", "");
        return text;
    }
    public  String deleteExtraSpaces(String text){
        text= text.replaceAll("  ", " ");
        return text;
    }
}




