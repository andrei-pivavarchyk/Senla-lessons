
public class Program {


    public static void main(String[] args) {
         //creating hospital
        Hospital bestHospital=new Hospital("BestHospital");
        System.out.println("Hospital was created");

        //create patient and add to listOfPatients
        bestHospital.addPatient("Alex","White");

        //print count of patients
        System.out.println("Count Patients " + bestHospital.getCountPatients());

        //create doctor and add doctor in listOfDoctors
        bestHospital.addDoctor("Nastya","Black","Terapevt");
        System.out.println("Count Doctors " + bestHospital.getCountDoctors());

        //create card for last patient
        bestHospital.getPatient(bestHospital.getCountPatients()).createCard();



    }
}

