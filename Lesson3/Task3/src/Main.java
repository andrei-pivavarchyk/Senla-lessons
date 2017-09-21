import Abstract.Employee;

public class Main {


    public static void main(String[] args) {


        Office SomeOffice = new Office(3);

        Manager Alex = new Manager("Alex", 10);
        Coder Bob = new Coder("Bob", 11);
        Designer Jak = new Designer("Jak", 12);

        SomeOffice.addEmploee(Alex);
        SomeOffice.addEmploee(Bob);
        SomeOffice.addEmploee(Jak);

        SomeOffice.getAllPayPerMonth(30);


    }


}
