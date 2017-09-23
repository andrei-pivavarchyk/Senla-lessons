public class PushTextIntoArray {

    private String text;

    public PushTextIntoArray(String text) {
        this.text = text;
    }


    public String[] pushTextIntoArray() {


        String[] wordArray = text.split(" ");
        return wordArray;

    }



}




