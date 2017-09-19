public class Card {
    public String PatientName;
    public String PatientSurname;
    public Doctor PatientDoctor;

    Card(String PatientName, String surname){
        this.PatientName=PatientName;
        this.PatientSurname=PatientSurname;


    }
    public void setDoctor(Doctor doctor){
    PatientDoctor=doctor;
    }


 public void  PatientName(String PatientName){
        this.PatientName=PatientName;
    }
 public void  PatientSurname(String PatientSurname){
        this.PatientSurname=PatientSurname;
    }
 public void  PatientDoctor(Doctor PatientDoctor){
        this.PatientDoctor=PatientDoctor;
    }
	 public String getPatientName(){
        return this.PatientName;
    }
 public String getPatientSurname(){
        return this.PatientSurname;
    }
     public Doctor getPatientDoctor(){
        return this.PatientDoctor;
    }

}
