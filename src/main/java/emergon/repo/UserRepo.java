package emergon.repo;

import emergon.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer>{
    
    // Explicity έβαλα ένα query.    
            
    //findByUsername: Είναι το ερώτημα, μέθοδος που θα φέρει από την βάση το username.
            
    @Query(value = "SELECT u FROM MyUser u WHERE u.username = ?1")
    MyUser findByUsername(String username);
    
}
