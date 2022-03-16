package emergon.service;

import emergon.entity.MyUser;
import emergon.entity.Role;
import emergon.repo.RoleRepo;
import emergon.repo.UserRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired //a1.60
    UserRepo userRepo;

    // Κρυπτογράφηση. // 8. 61
    @Autowired    
    PasswordEncoder passwordEncoder; 


    //64. - 18
    @Autowired
    RoleRepo roleRepo;

    //a1.60
    // -------------------------------------------------------------------------
    @Override
    public MyUser findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    // -------------------------------------------------------------------------

    
    //a1.60
    // -------------------------------------------------------------------------
    // Παίρνω τον χρήστη και από custom username τον κάνω αντικείμενο για το Spring Security.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Get MyUser from DB
        MyUser myuser = findByUsername(username);// η από πάνω μέθοδος.

        //if user not exists then throw the exception
        if (myuser == null) {
            throw new UsernameNotFoundException("Invalid username");
        }

        //else return The User Object that Spring Security needs
        List<GrantedAuthority> authorities = convertRolesToGrantedAuthorities(myuser.getRoles());
        User userOfSpringSecurity = new User(myuser.getUsername(), myuser.getPassword(), authorities);

        return userOfSpringSecurity; //(Ctrl+Space), User=standard
    }
    // -------------------------------------------------------------------------

    //a1.60
    // -------------------------------------------------------------------------
    // Βοηθητική μέθοδος:
    private List<GrantedAuthority> convertRolesToGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList();
        for (Role r : roles) { // Για κάθε ρόλο που υπάρχει μέσα στην λίστα roles
            GrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
            authorities.add(authority);
        }
        return authorities;
    }
    // -------------------------------------------------------------------------

    // 8. 61 - Εισαγωγή User από την φόρμα στην βάση δεδομένων
    //64. - 15 
    // -------------------------------------------------------------------------
    // Κρυπτογράφηση.
    // _1 00:14:10    
    
    // Δέχομαι τον myuser σαν παράμετρο
    @Override
    public MyUser saveUser(MyUser myuser) {

        // Ο κωδικός που έβαλε ο χρήστης στης φόρμα, και θέλω να τον κρυπτογραφήσω
        // τον αποθηκεύσω σε μια μεταβλητή.
        String plainPassword = myuser.getPassword(); // 8. 61

        // Θα κρυπτογραφήσω αυτόν τον κωδικό, σε hash password.
        // passwordEncoder: Το Object από την MyWebSecurityConfigurer.
        // Το κάνω απλά encode, και το αποθηκεύω σε ένα String
        // Για να χρησιμοποιήσω το αντικείμενο που είναι στην WebSecurityConfigurer 
        // στην UserServiceImpl έχω κάνει το αντικείμεο Autowired.
        String hashedPassword = passwordEncoder.encode(plainPassword); // 8. 61

        // το ορίζω
        myuser.setPassword(hashedPassword);

        //find By Name, το έχω στην Role.java
        // A' ΤΡΟΠΟΣ: Βρες με βάση το όνομα που να περιέχει αυτήν την λεξούλα. - Βάζω ρόλο.
        // select * from role where rname='ROLE_USER';
        //Role role = roleRepo.findByRname("ROLE_USER");

        //B' ΤΡΟΠΟΣ: Βρες με βάση το όνομα που να περιέχει αυτήν την λεξούλα.
        Role role = roleRepo.findByRnameContaining("USER");      
        myuser.addRole(role); //64. - 17
        // Θα πρέπει να κάνουμε ένα query στην βάση να φέρουμε τον ρόλο.

        // save, επιστρέφει ένα entity.
        myuser = userRepo.save(myuser);

        return myuser;
    }
    // -------------------------------------------------------------------------    

}
