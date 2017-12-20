

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name= "actor")
public class Actor {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "name", length=64)
    private String name;
    @Column(name= "birthday")
    @Temporal(value= TemporalType.DATE)
    private Date birthday;
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id){this.id = id;}
    public Long getId(){return id;}
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}