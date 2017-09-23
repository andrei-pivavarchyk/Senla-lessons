public class Main {
    public static void main(String[] args) {

        String someText = new String("«Ше́рлок»[1], также известен 444 как «Шерлок Холмс» (англ. Sherlock) — британский телесериал компании Hartswo" );

        String textWithoutSymbolsAndNumbers=DeleteAllSymbolsAndNumbers.deleteAllSymbolsAndNumbers(someText);
        String[] WordArray = PushTextIntoArray.pushTextIntoArray(textWithoutSymbolsAndNumbers);



        for (int i = 0; i < WordArray.length; i++) {
            System.out.println(WordArray[i]);
        }


    }
}

