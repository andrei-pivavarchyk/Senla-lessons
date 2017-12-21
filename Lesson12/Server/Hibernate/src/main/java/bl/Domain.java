package bl; /**
 * Created by андрей on 21.12.2017.
 */
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;


import java.sql.Date;
import java.sql.SQLException;
import java.util.*;


public class Domain {

    public static void main(String[] args) throws SQLException {


        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
      //  project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
       // employee.setProjects(projects);
Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();

        HibernateUtil.shutdown();
    }

}