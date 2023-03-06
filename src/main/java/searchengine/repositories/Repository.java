package searchengine.repositories;

import org.springframework.data.repository.CrudRepository;
import searchengine.model.Page;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Page, Integer> {
}
