package searchengine.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "site_id")
    private int siteId;

    private String path;

    private int code;


    @Column(columnDefinition = "MEDIUMTEXT")
    private String content;

}
