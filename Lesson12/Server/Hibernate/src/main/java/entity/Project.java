package entity; /**
 * Created by андрей on 21.12.2017.
 */
import javax.persistence.*;
import java.util.Set;

/**
 * Created by vserdiuk on 2/8/2017.
 */

@Entity
@Table(name = "PROJECT")
public class Project extends Entityy{


    @Column(name = "TITLE")
    private String title;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee>  employees;

    public Project() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "entity.Project{" +
                "id=" + super.getId() +
                ", title='" + title + '\'' +
                '}';
    }
}