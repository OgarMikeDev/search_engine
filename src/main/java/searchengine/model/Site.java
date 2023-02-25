package searchengine.model;

import lombok.Getter;
import lombok.Setter;
import searchengine.config.EnumStatusSyte;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
Site
//
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private EnumStatusSyte status;

    @Column(name = "status_time")
    private LocalDateTime statusTime;

    @Column(name = "last_error")
    private String lastError;

    private String url;

    private String name;

}
