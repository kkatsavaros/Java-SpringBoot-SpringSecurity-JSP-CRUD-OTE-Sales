package emergon.controller;

import emergon.entity.Author;
import emergon.repo.AuthorRepo;
import emergon.service.AdminService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    private AdminService service;

//    @GetMapping
//    public String adminHome(){        
//        return "admin-home";//.jsp
//    }
    //----------------------------------------------------------------------------------
    @GetMapping
    public String showSales(Model model, @Param("keyword") String keyword) {
        //List<Author> listOfAuthors = authorRepo.findAll(); // Lelakis        
        //String keyword="77"; //Manual Search Field     

        if (keyword == null) {
            long number = service.count(keyword);
            model.addAttribute("numberOfRecords", number);
        } 
        
        if (keyword != null) {
            long number = service.count(keyword);
            model.addAttribute("numberOfRecords", number);
        } 

        
        
        
        List<Author> listOfAuthors = service.listAll(keyword);
        model.addAttribute("listOfAuthors", listOfAuthors);
        return "crud/saleList"; //.jsp
    }
    //----------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------
    // GoTo create Form
    @GetMapping("/create")
    public String AddSales(@ModelAttribute("poliths") Author author) {
        return "crud/saleForm"; //.jsp
    }
    //----------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------
    //create save=add    
    //@PostMapping("/create2") // Ακούει σε ένα POST request: /api/authors      με POST.
    //@RequestBody Author author // Θα λάβει ο controller ένα request , αυτό θα έχει ένα κυριως μέρος, 
    // το οποίο θα είναι σε JSON μορφή. Τότε το @RequestBody θα καταλάβει αυτό το αντικείμενο 
    // θα το πάρει 
    // θα το κάνει deserialize και θα το μετατρέψει σε ένα αντικείμενο της Java τύπου Author.
    // και μετά θα αποθηκεύσουμε τον Author.
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    //@PostMapping("/create")
    public String create(@Valid @ModelAttribute("poliths") Author author,
            BindingResult result,
            RedirectAttributes attributes) { //Json->Java Object
//        System.out.println(author.toString());
//        Author savedAuthor = authorRepo.save(author); //Θα αποθηκεύσει έναν author.
//        return savedAuthor;

        if (result.hasErrors()) {
            return "crud/saleForm";
        }

        Author savedAuthor = authorRepo.save(author); //Θα αποθηκεύσει έναν author.
        String minima = "Customer " + author.getName() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/admin";//Redirect instructs client to sent a new GET request to /customer        

    }
    //----------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------
    //findById
    // Object ResponseEntity του Spring Framework, το οποίο αγκαλιάζει το Entity μας που είναι ο Author.
    // @GetMapping(value = "/{id}") // το ίδιο είναι.
    // produces = {MediaType.APPLICATION_JSON_VALUE} : για να μην επιστρέφει XML, μόνο JSON.    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") int id) {

        // Το φέρνουμε σαν authorRepo. Επιστρέφει Optional<Author>.
        Optional<Author> optionalAuthor = authorRepo.findById(id); // Είναι ένα κουτί.

        if (!optionalAuthor.isPresent()) {
            // Αν πάρει id που δεν υπάρχει θα στείλει request 404.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // optionalAuthor.get() παίρνω το αντικείμενο που είναι μέσα 
        Author author = optionalAuthor.get();
        // στο κουτάκι μας και επιστρέφει Author και το βάζω σε μια  μεταβλητή author.

        // Φτιάχνω ένα αντικείμενο ResponseEntity
        ResponseEntity responseEntity = new ResponseEntity(author, HttpStatus.OK);

        return responseEntity;
    }
    //----------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------
    @GetMapping("/update/{ccode}")
    public String showFormUpdate(@PathVariable("ccode") int ccode, Model model) {
        //Author author = service.getCustomerById(ccode);

        Author authorToUpdate = authorRepo.findById(ccode).get();
        // model.addAttribute("customerToEdit", authorToUpdate);
        model.addAttribute("poliths", authorToUpdate); // ---> GoTo saleForm.jsp poliths object
        return "crud/saleForm"; //.jsp
    }
    //----------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("poliths") Author author,
            BindingResult result,
            RedirectAttributes attributes) {
        //service.updateCustomer(customer);

        if (result.hasErrors()) {
            return "salesman/salesmanForm";
        }

        System.out.println("------------------------------");
        System.out.println("1. ->>" + author.getId() + "     " + author.getName());

        Author savedAuthor = authorRepo.save(author);

        savedAuthor.setName(author.getName());

        System.out.println("------------------------------");
        System.out.println("2. ->>" + author.getId() + "     " + author.getName());

        String minima = "Customer updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/admin";//Redirect instructs client to sent a new GET request to /customer
    }

    //----------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------
    //Delete
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int ccode, RedirectAttributes attributes) {
        Author authorToDelete = authorRepo.findById(ccode).get();
        authorRepo.delete(authorToDelete);
        String minima = "Author with id: " + ccode + " successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/admin";

    }
    //----------------------------------------------------------------------------------

    //---------------------------------------------------------------------------------------    
    // @ModelAttribute σε επίπεδο μεθόδου.
    // Για να φορτώσω το drop down menu στο Cities στο SalesmanFrom.jsp
    @ModelAttribute(name = "listOfCities")
    public List<String> getCities() {
        return service.getCities();
    }
    //--------------------------------------------------------------------------------------- 

    //---------------------------------------------------------------------------------------    
    // @ModelAttribute σε επίπεδο μεθόδου.
    // Για να φορτώσω το drop down menu στο Cities στο SalesmanFrom.jsp
    @ModelAttribute(name = "listOfEidosPolisis")
    public List<String> getEidospolisis() {
        return service.getEidospolisis();
    }
    //--------------------------------------------------------------------------------------- 

    //---------------------------------------------------------------------------------------    
    // @ModelAttribute σε επίπεδο μεθόδου.
    // Για να φορτώσω το drop down menu στο Cities στο SalesmanFrom.jsp
    @ModelAttribute(name = "listOfMyLead")
    public List<String> getMyLead() {
        return service.getMyLead();
    }
    //--------------------------------------------------------------------------------------- 

    //---------------------------------------------------------------------------------------    
    // @ExceptionHandler     
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        String minima = "Could not commit transaction!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    //---------------------------------------------------------------------------------------    

}
