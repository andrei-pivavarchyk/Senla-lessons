public class Patient extends Man {
    private Card _card;

    Patient(String name,String surname){
        this.name=name;
        this.surname=surname;

    }



    public void  setName(String name){
        this.name=name;
    }
    public void  setSurName(String surName){
        this.surname=surName;
    }

    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }

    public void createCard(){

        Card card=new Card( this.name, this.surname );

        _card=card;
System.out.print("Card for Patient "+ this.name +" was created");


    }



}
