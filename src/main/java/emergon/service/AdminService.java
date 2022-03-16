package emergon.service;

import emergon.entity.Author;
import emergon.repo.AuthorRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AdminService {

    @Autowired
    private AuthorRepo repo;

    public List<Author> listAll(String keyword) {
        if (keyword != null) {
            return repo.findAll(keyword);
        }
        return repo.findAll(Sort.by("id").descending());
    }

    public long count(String keyword) {
        //return repo.count();
        if (keyword == null) {
            return repo.count();
        }

        return repo.findAll(keyword).size();
    }
    

    public List<String> getCities() {
        List<String> cities = new ArrayList();
        cities.add("Καβάλα");
        cities.add("Χρυσούπολη");
        cities.add("Ελευθερούπολη");
        cities.add("Θάσος");
        cities.add("Παλιό");
        cities.add("Ν. Πέραμος");
        cities.add("Ν. Ηρακλείτσα");
        cities.add("Αμυγδαλεώνας");
        return cities;
    }

    
    public List<String> getEidospolisis() {
        List<String> cities = new ArrayList();
        cities.add("FTTH");
        cities.add("Νέα Σύνδεση");
        cities.add("24 to 50");
        cities.add("50 to 100");
        cities.add("move to OTE");
        cities.add("Booster");
        cities.add("Internet BackUp");
        cities.add("Booster");
        cities.add("Cosmote DP");
        cities.add("TP LINK POWERLINE 4226");
        return cities;
    }

    public List<String> getMyLead() {
        List<String> cities = new ArrayList();
        cities.add("ΕΝΑΡΞΗ ΠΩΛΗΣΗΣ");
        cities.add("ΚΑΤΑΧΩΡΗΣΗ");
        cities.add("ΚΑΤΑΧΩΡΗΣΗ - BUSINESS");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΑΔΥΝΑΜΙΑ ΕΠΙΚΟΙΝΩΝΙΑΣ");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΕΛΙΠΠΗΣ ΕΠΙΚΟΙΝΩΝΙΑΣ");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΚΑΤΑΣΤΗΜΑ");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΔΕΝ ΕΝΔΙΑΦΕΡΕΤΑΙ");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΚΟΚΚΙΝΟ ΦΑΝΑΡΙ");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΠΟΛΛΑΠΛΑ SR");
        cities.add("ΜΗ ΠΩΛΗΣΗ - ΔΕΝ ΕΠΙΘΥΜΕΙ ΕΝΗΜΕΡΩΣΗ");
        cities.add("ΜΗ ΠΩΛΗΣΗ - 13888");
        cities.add("ΜΗ ΠΩΛΗΣΗ - BUSINESS");
        cities.add("ΠΩΛΗΣΗ");
        cities.add("---- ----");
        return cities;
    }

}
