public class DeleteAllSymbolsAndNumbers {


    public static String deleteAllSymbolsAndNumbers(String text) {

        String textWithoutSymbols = text.replaceAll("[^a-zA-Zа-яА-Я- ]", "");
        textWithoutSymbols = textWithoutSymbols.replaceAll("  ", " ");


        return textWithoutSymbols;


    }
}
