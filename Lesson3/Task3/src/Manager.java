import Abstract.Employee;

public class Manager extends Employee {

    private Enum speciality = EnumSpeciality.manager;


    public Manager(String name, int pay) {
        setName(name);
        setPay(pay);

    }


}
