public class Card {
    public String PatientName;
    public String PatientSurname;
    public Doctor PatientDoctor;

    Card(String PatientName, String surname){
        this.PatientName=PatientName;
        this.PatientSurname=PatientSurname;


    }
    public void setCard(Doctor doctor){
PatientDoctor=doctor;
    }
}
