package byjc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by student on 6/20/17.
 */
@Controller
public class HomeController {
    @Autowired
    private ATMRepository atmRepository;
    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/add")
    public String newATM(Model model){
        model.addAttribute(new ATMAction());
        return "ATMForm";
    }

    @PostMapping("/add")
    public @ResponseBody String processATM(@ModelAttribute ATMAction atmAction){
    atmRepository.save(atmAction);
        return atmAction.getAction() +" "+String.valueOf(atmAction.getAmount());
    }
@RequestMapping("/all")
    public @ResponseBody String getAction(){
        return atmRepository.findAll().toString();
}

}
