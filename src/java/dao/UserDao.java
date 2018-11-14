
package dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;
import model.Users;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    
    public UserDao() {
    }
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional 
    public void addUser(Users user){
        //em.getTransaction().begin();
        em.persist(user);
        //em.flush();
        //em.getTransaction().commit();
    }
    
     @Transactional 
     public User findUser(int id){
         User user = em.find(User.class, id);
         return user;
     }
     
     @Transactional 
     public List findUsers(String text){
         
         Query query =em.createQuery("Select u from Users u where u.firstname like :firstname");
         query.setParameter("firstname", text + "%");
         List<Users> myusers = query.getResultList();
         return myusers;
     }
     
}
