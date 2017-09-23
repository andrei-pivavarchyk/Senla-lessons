import Abstract.Employee;

public class Office {

    public Employee[] listOfEmployees;
    private int capacity;
    private int count = 0;


    public Office(int capacity) {
        listOfEmployees = new Employee[capacity];
        this.capacity = capacity;
    }

    public void addEmploee(Employee employee) {
        if (this.count < this.capacity) {

            this.listOfEmployees[this.count] = employee;
            this.count = count + 1;
            System.out.println("Add Employee: "+employee.getName()+" All count Employees " + this.count);
        } else {
            System.out.println("No places");
        }


    }

    public int getAllPayPerMonth(int countDays) {
        int allPay = 0;

        for (int i = 0; i <= this.count - 1; i++) {

            allPay = allPay + listOfEmployees[i].getPay();

        }
        System.out.println("All pay Per Month("+countDays+" days): "+allPay*countDays+" $");
        return allPay*countDays;


    }
}
