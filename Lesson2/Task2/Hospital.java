import java.util.ArrayList;

public class Hospital {
    private String _title;
    private ArrayList<Doctor> _listOfDoctors=new ArrayList<Doctor>();
    private ArrayList<Patient> _listOfPatients=new ArrayList<Patient>();

    Hospital(String title){
        title=_title;
    }

    public void addPatient(String name,String surname){
        Patient p = new Patient(name,surname);
        p.id=_listOfPatients.size()+1;
        _listOfPatients.add(p);
        System.out.println("Patient "+p.name+" was created");
    }

    public Patient getPatient( int id){
        Patient patient=null;
        for (Patient p :_listOfPatients )
        {
           if (p.id==id){
               patient=p;
               break;
           }
        }
        return patient;
    }
    public int getCountPatients(){
        return _listOfPatients.size();
    }
    public void addDoctor(String name, String surname, String speciality){

        Doctor d = new Doctor(name, surname, speciality);
        d.id=_listOfDoctors.size()+1;
        _listOfDoctors.add(d);
        System.out.println("Doctor "+d.name+" was created");
        _listOfDoctors.add(d);
    }

    public Doctor getDoctor( int index){
        return _listOfDoctors.get(index);
    }
    public int getCountDoctors(){
        return _listOfPatients.size();
    }



}
