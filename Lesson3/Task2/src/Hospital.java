

public class Hospital {
    private String name;
    Patient [] patients;
    Doctor [] doctors;

    public Hospital(String name) {

    }
    public void setName(String name) {

    }

    public void addPatient(Patient){
        Patient firstPatient = new Patient(name:"Alex");

        patients[0]=firstPatient;
    }
    public void addDoctor(Doctor){
        Doctor firstDoctor = new Doctor(name:"DJak");
        doctors[0]=firstDoctor;

    }

}
