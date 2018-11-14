package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
import java.util.List;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    
    @Autowired 
    private UserDao userDao;
    
    @RequestMapping(value = "/ajaxsearch.htm",method=RequestMethod.GET,headers="Accept=*/*",produces="application/json")
    @ResponseBody
    public  String getAllUsers(@RequestParam("text2") String text) throws JsonProcessingException{
        
        List<Users> results = userDao.findUsers(text);
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.writeValueAsString(results);
    }
    
}
