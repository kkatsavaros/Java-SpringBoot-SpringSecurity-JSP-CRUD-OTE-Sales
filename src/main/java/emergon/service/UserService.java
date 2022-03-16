package emergon.service;

import emergon.entity.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

// Θα μετατρέψουμε τον δικό μας χρήστη custom user, σε ένα αντικείμενο του Spring Security.
// UserDetailsService: Είναι ένα Service το οποίο μας δείνει μία λειτουργία με την οποία 
// θα φτιάξουμε τα user details που θέλουμε.
// UserDetails: username, password, roles.
public interface UserService extends UserDetailsService {

    MyUser findByUsername(String username);

    //64. - 14
    // Αποθήκευση του User στον χρήστη.
    // Δέχεται: MyUser myuser
    // Επιστρέφει MyUser
    MyUser saveUser(MyUser myuser);

}
