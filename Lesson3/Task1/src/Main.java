public class Main {
    public static void main(String[] args) {

        String someText = new String("«Ше́рлок»[1], также известен как «Шерлок Холмс» (англ. Sherlock) — британский телесериал компании Hartswo" );

        String textWithoutSymbolsAndNumbers=new DeleteAllSimbolsAndNumbers(someText).deleteAllSymbolsAndNumbers();
        String[] WordArray = new PushTextIntoArray(textWithoutSymbolsAndNumbers).pushTextIntoArray();



        for (int i = 0; i < WordArray.length; i++) {
            System.out.println(WordArray[i]);
        }


    }
}

