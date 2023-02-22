package searchengine.model;

import javax.persistence.*;

@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

}
