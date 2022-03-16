package emergon;

import emergon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter{
    
    // a1.60 - 4. DaoAuthenticationProvider
    @Autowired
    UserService userService;
    
    //----------------------------------------------------------------------------------
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        // a1.60 - 5. από DaoAuthenticationProvider    
        // Άρα το authentication θα γίνεται χρησιμοποιώντας έναν  authenticationProvider
        // o οποίος είνα αυτός: authenticationProvider(), η μέθοδος πιο κάτω.
        auth.authenticationProvider(authenticationProvider());
        
//        auth.inMemoryAuthentication() // για όσο τρέχει η εφαρμογή μου.
//                .withUser("user").password("{noop}1234").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}1234").roles("USER", "ADMIN")
//                .and()
//                .withUser("teacher").password("{noop}1234").roles("TEACHER");
    }
    //----------------------------------------------------------------------------------
    
    
    
    //----------------------------------------------------------------------------------
    // Θέλουμε άλλους κανόνες και την δικιά μας σελίδα.
    // Η μέθοδος configure με το HttpSecurity αντικείμενο.    //738.jpg
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http    //1ο κομμάτι                
                .authorizeRequests()//Restrict access based on HttpServletRequest
                
                //2ο κομμάτι 
                // Ποιος μπορεί να δει το "/admin"? - Αυτός που έχει ρόλο admin.
                // πχ.-> /admin/create
                .antMatchers("/admin/**").hasRole("ADMIN")//Only Admin has access to /admin
                .antMatchers("/teacher/**").hasRole("TEACHER")
                .antMatchers("/").authenticated()// Αλκίνοος.
                
                //3ο κομμάτι 
                .and()
                .formLogin() //Κάνουμε Override την default login page.
                // άρα θα φτιάξω ένα controller
                .loginPage("/loginPage")//Show my form at this URL - localhost:8080/loginpage
                // Οταν πατήσω το submit σε ποιο URL θα πάει το στείλω.
                .loginProcessingUrl("/authenticate")                 
                .permitAll()// Αφήνω όλους να δουν την login page.
                
                
                .and().logout().permitAll() // default "/logout"
                
                // Οταν υπάρχει ένα exception
                .and().exceptionHandling().accessDeniedPage("/access-denied") //.jsp
                ;
    }
    //----------------------------------------------------------------------------------
    
    
    // a1.60
    // 4. Ερχόμαστε από το emegon.UserServiceImpl    
    //----------------------------------------------------------------------------------
    // Σετάραμε τον PasswordEncoder και του είπαμε για να κάνεις provide το authentication
    // πρώτα θα χρησιμοποιείς την setUserDetailsService που έχει την loadUserByUsername
    // και δεύτερον θα χρησιμοποιείς έναν passwordencoder, για να συγκρίνεις τις τιμές 
    // που είναι αποθηκευμένες στην βάση.
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        
        //object: DaoAuthenticationProvider
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();        
        
        // Για να κάνει  authenticate θα χρησιμοποιείς αυτό το service.
        // Το object: DaoAuthenticationProvider χρησιμοποιεί αυτό το Service.
        provider.setUserDetailsService(userService);        
        
        //61. - 7: Κρυπτογράφηση {bcrypt}
        provider.setPasswordEncoder(passwordEncoder());             
        
        return provider;
    }   
    //----------------------------------------------------------------------------------
    
    
    // 61. - 6: Κρυπτογράφηση {bcrypt}
    //---------------------------------------------------------------------------------- 
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // Object
    }
    //----------------------------------------------------------------------------------
    
}