package emergon.repo;

import emergon.entity.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

    @Query("SELECT p from Author p WHERE p.name LIKE %?1%"
            + " OR p.stathero LIKE %?1%"
            + " OR p.kinito LIKE %?1%"
            + " OR p.perioxi LIKE %?1%"
            + " OR p.eidospolisis LIKE %?1%"
            + " OR p.notes LIKE %?1%"
            + " OR p.mylead LIKE %?1%"
            + " OR p.mydate LIKE %?1%"
    )

//    @Query("SELECT p from Author p WHERE"
//            + "CONCAT(p.name, p.stathero, p.kinito, p.perioxi, p.eidospolisis, p.notes, p.mylead)"
//            + "LIKE %?1%")    
    public List<Author> findAll(String keyword);

}
