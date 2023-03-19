package searchengine.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Entity
@NoArgsConstructor
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(columnDefinition = "ENUM('INDEXING', 'INDEXED', 'FAILED')")
    private Enum status;

    @Column(name = "status_time")
    private LocalDateTime statusTime;

    @Column(name = "last_error", columnDefinition = "TEXT")
    private String lastError;

    @Column(columnDefinition = "VARCHAR(255)")
    private String url;

    @Column(columnDefinition = "VARCHAR(255)")
    private String name;

    private static AtomicInteger idGeneratorForSite = new AtomicInteger();

    public static int generatedId() {
        return idGeneratorForSite.getAndIncrement();
    }
}
