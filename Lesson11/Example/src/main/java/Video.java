
import javax.persistence.*;

@Entity
@Table(name= "video")
public class Video {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "description", length=64)
    private String description;
    public void setId(Long id){this.id = id;}
    public Long getId(){return id;}
    public void setDescription(String description) {
        this.description = description;
    }
}