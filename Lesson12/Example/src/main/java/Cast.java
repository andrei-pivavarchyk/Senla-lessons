

import javax.persistence.*;

@Entity
@Table(name= "video")
public class Cast {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name= "video")
    private Video video;
    @ManyToOne
    @JoinColumn(name= "actor")
    private Actor actor;

    public void setId(Long id){this.id = id;}
    public Long getId(){return id;}

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}