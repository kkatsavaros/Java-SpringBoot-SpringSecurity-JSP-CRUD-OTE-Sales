package emergon.repo;

import emergon.entity.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    //64. - 17
    // Θα φέρει από την βάση δεδομένων όλους τους ρόλους.
    // List<Role> findAll();
    //64. - 19
    public Role findByRname(String name);

    // @NamedQuery(name = "Role.findByRname", query = "SELECT r FROM Role r WHERE r.rname = :rname")})  
    //   public Role findByRname(@Param("rname") String rname);
    public Role findByRnameContaining(String name);

}
