package ErrorsDao;

import model.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return Users.class.equals(type);
    }

    
    @Override
    public void validate(Object o, Errors errors) {
        boolean f=true;
        Users u = (Users)o;
        String checkFL=u.getFirstname();
        char[] array = checkFL.toCharArray();
        char ch = checkFL.charAt(0);
        if(ch=='T'){
            f=false;
        }
        
        else{
            
            errors.rejectValue("firstname","fletter.notT");
        }
        
        
    }
    
    
    
}
