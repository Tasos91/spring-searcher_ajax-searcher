
package controller;

import ErrorsDao.UserValidator;
import dao.UserDao;
import java.util.List;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InsertUserController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserValidator uservalidator;
    
    @RequestMapping(value = "/myform.htm")
    public String ShowRegisterForm(ModelMap model){
        Users user = new Users();
        user.setFirstname("Bob");
        user.setSurname("Mastoras");
        user.setPassword("build");
        user.setUsername("Bm");
        userDao.addUser(user);
        return "home";
    }
    
    @RequestMapping(value = "/finduser")
    public String ShowExistingUser(ModelMap model){
        Users user = new Users();
        user.setFirstname("Tom");
        user.setSurname("Jerey");
        user.setPassword("YabaDabaDoo");
        
        userDao.addUser(user);
        return "home";
    }
    
    @RequestMapping(value = "/searchingform.htm")
    public String checkUser(ModelMap model, @RequestParam("text") String text){
        
        List<Users> results = userDao.findUsers(text);
        model.addAttribute("users", results);
        return "index";
    }
    
     @RequestMapping(value = "/insert.htm")
    public String addingEmptyUser(Model map){
        Users user = new Users();
        map.addAttribute("user",user);
        
        return "springForm";
    }
    
    @RequestMapping(value = "/formhandling.htm", method=RequestMethod.POST)
    public String authenticateUser(ModelMap map,  @ModelAttribute("user") Users user, BindingResult bindingResult ){
        
        uservalidator.validate(user,bindingResult);
        
        if(bindingResult.hasErrors()){
            map.addAttribute("user",user);
            Users u=(Users)map.get("user");
            String name=u.getFirstname();
            return "springForm";
        }
        map.addAttribute("user",user); 
        return "success";
    }
    
}
