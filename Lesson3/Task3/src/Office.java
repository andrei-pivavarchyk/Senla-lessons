import Abstract.Employee;

public class Office {

    private Employee[] listOfEmployees;
    private int count=0;

    public Office(int capacity){
        listOfEmployees=new Employee[capacity];
    }

    public void addEmploee(Employee employee) {
        if( this.count<count){

            this.listOfEmployees[this.count++]=employee;
        }


    }
}
