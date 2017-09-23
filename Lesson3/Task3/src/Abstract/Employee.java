package Abstract;

public abstract class Employee {
    protected String name;
    private String surname;
    private int payPerDay;


    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }


    public int getPay() {
        return this.payPerDay;
    }

    public void setPay(int pay) {
        this.payPerDay = pay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
