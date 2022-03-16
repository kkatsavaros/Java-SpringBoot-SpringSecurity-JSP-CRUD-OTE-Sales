package emergon.controller;

import emergon.entity.MyUser;
import emergon.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    //64. - 20
    @Autowired
    UserService userService;

    // 64. - 10
    //---------------------------------------------------------------------------------
    // Αν λάβει GET Request /register Θα πάει από την login.jsp στην register-form.jsp.
    // Θα στείλουμε στην φόρμα και ένα άδειο αντικείμενο τύπου "MyUser".
    @GetMapping("/register")
    public String showRegisterForm(@ModelAttribute("myuser") MyUser xrhsths) {
        return "register-form";
    }
    //---------------------------------------------------------------------------------

    //64. - 12
    //---------------------------------------------------------------------------------
    // Αν λάβει POST Request /register (από την φόρμα regiter-form.jsp) 
    // Θα πάει από την register.jsp στην register.jsp.
    // Θα πάρω πίσω το @ModelAttribute("myuser")
    @PostMapping("/register")
    public String Register(@Valid // @NotEmpty(message = "Username is required!")
            @ModelAttribute("myuser") MyUser xrhsths, // από την φόρμα
            BindingResult result, // πάει μαζί με το @Valis, το αποτέλεσμα του έλεγχου θα μπει στο object  result
            RedirectAttributes attributes // για αν θέλω στο redirect, να στείλω μήνυμα.
    ) {

        if (result.hasErrors()) {
            return "register-form";
        }

        //save user to db        
        userService.saveUser(xrhsths); // 'Εχει γίνει Autowired.
        System.out.println(">>>>>>>>>>>>>>>>: " + xrhsths);

        attributes.addFlashAttribute("registered", "Successfully registered");

        // Θα κάνω redirect έτσι ώστε αν ξαναπατήσει Register να μην στείλει τον χρήστη ξανά.
        // Το redirect γίνεται στο URL και όχι στην φόρμα.
        return "redirect:/loginPage?registered"; //του AuthenticationController

        //ή 
        //return "redirect:/loginPage?registered";  
        // αυτό θα πάει στον controller /loginPage και θα περάσει την παράμετρο register
    }
    // ---------------------------------------------------------------------------------

}
