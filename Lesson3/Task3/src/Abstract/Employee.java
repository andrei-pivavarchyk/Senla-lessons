package Abstract;

public abstract class Employee {
    private String name;
    private String surname;
    private String speciality;
    private int pay;

    public String getName(){
       return this.name;
   }
    public String getSurnamesurname(){
       return this.surname;
   }
    public String getSpeciality(){
       return this.speciality;
    }
    public int getPay(){
        return this.pay;
    }


    public void setName(String name){
       this.name=name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }
    public void setPay(int pay){
        this.pay=pay;
    }


}
