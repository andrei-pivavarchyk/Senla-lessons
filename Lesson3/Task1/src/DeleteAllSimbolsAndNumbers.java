public class DeleteAllSimbolsAndNumbers {
    private String text;

    public DeleteAllSimbolsAndNumbers(String text){

        this.text=text;
    }

    public String deleteAllSymbolsAndNumbers(){

        String textWithoutSymbolsAndNumbers=this.text.replaceAll("[^a-zA-Zа-яА-Я- ]", "");
        textWithoutSymbolsAndNumbers=textWithoutSymbolsAndNumbers.replaceAll("  ", " ");


        return textWithoutSymbolsAndNumbers;


    }
}
