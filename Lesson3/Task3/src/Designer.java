import Abstract.Employee;

public class Designer extends Employee {

    private Enum speciality = EnumSpeciality.designer;


    public Designer(String name, int pay) {
        setName(name);
        setPay(pay);

    }

}
