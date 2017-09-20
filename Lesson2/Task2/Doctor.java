public class Doctor extends Man{

    public String speciality;

    Doctor(String name,String surname, String speciality){
        this.name=name;
        this.surname=surname;
        this.speciality=speciality;
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
	public void  setSpeciality(String speciality){
        this.speciality=speciality;
    }
    public String getSpeciality(){
        return this.speciality;
    }


}
