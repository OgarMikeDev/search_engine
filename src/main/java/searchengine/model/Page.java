package searchengine.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_id")
    private Site site;



    @Column(columnDefinition = "TEXT NOT NULL, INDEX(path(255))")
    private String path;

    private int code;


    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;

}
