import Abstract.Employee;

public class Coder extends Employee {
    private Enum speciality = EnumSpeciality.coder;


    public Coder(String name, int pay) {
        setName(name);
        setPay(pay);

    }


}
