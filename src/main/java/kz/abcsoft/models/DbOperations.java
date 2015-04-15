package kz.abcsoft.models;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import kz.abcsoft.utils.HibernateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DbOperations {
    
    public DbOperations(){}
    
    public int addCityOrRegion(CityOrRegion newCityOrRegion){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer cityID = null ;
        try{
            tx = session.beginTransaction() ;
            cityID = (Integer) session.save(newCityOrRegion) ;
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
        return cityID ;
    }
    
    public CityOrRegion addCityOrRegion(String newCityName){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer cityID = null ;
        CityOrRegion cityName = new CityOrRegion(newCityName) ;
        try{
            tx = session.beginTransaction() ;
            cityID = (Integer) session.save(cityName) ;
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
        return cityName ;
    }
    
    public int addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer userID = null ;
        String md5Password = DigestUtils.md5Hex(user.getPassword()) ;
        user.setPassword(md5Password);
        try{
            tx = session.beginTransaction() ;
            userID = (Integer)session.save(user) ;
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return userID ;
    }


    
    public int addUser(String firstName, String lastName, String email, String password){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer userID = null ;
        String md5Password  = DigestUtils.md5Hex(password) ;
        User user = new User(firstName, lastName, email, md5Password  );
        try{
            tx = session.beginTransaction() ;
            userID = (Integer)session.save(user) ;
            tx.commit() ;
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return userID ;
    }
    
    public int addUser(String firstName, String lastName, String email, String password, 
            CityOrRegion newCity){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer userID = null ;
        String md5Password  = DigestUtils.md5Hex(password) ;
        User user = new User(firstName, lastName, email, md5Password, newCity  );
        try{
            tx = session.beginTransaction() ;
            userID = (Integer)session.save(user) ;
            tx.commit() ;
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return userID ;
    }
    
    public int addUser(String firstName, String lastName, String middleName, String email,
            String password, CityOrRegion newCity){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer userID = null ;
        String md5Password  = DigestUtils.md5Hex(password) ;
        User user = new User(firstName, lastName, middleName, email, md5Password, newCity  );
        try{
            tx = session.beginTransaction() ;
            userID = (Integer)session.save(user) ;
            tx.commit() ;
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return userID ;
    }
    
    public int addUser(String firstName, String lastName, String middleName, String email,
            String password, CityOrRegion newCity, String phone, String IIN_BIN){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        Integer userID = null ;
        String md5Password  = DigestUtils.md5Hex(password) ;
        User user = new User(firstName, lastName, middleName, email, md5Password, newCity,
        phone, IIN_BIN);
        try{
            tx = session.beginTransaction() ;
            userID = (Integer)session.save(user) ;
            tx.commit() ;
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return userID ;
    }
    
    public void deleteCityOrRegion(CityOrRegion city){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        try{
            tx = session.beginTransaction() ;
            session.delete(city);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }
    
    public void deleteCityOrRegion(int cityID){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        try{
            tx = session.beginTransaction() ;
            CityOrRegion city = (CityOrRegion)session.get(CityOrRegion.class, cityID) ;
            session.delete(city);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }
    
    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        try{
            tx = session.beginTransaction() ;
            session.delete(user);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }
    
    public void deleteUser(int userID){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        try{
            tx = session.beginTransaction() ;
            User user = (User)session.get(User.class, userID) ;
            session.delete(user);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }
    
    public int getCityOrRegionID(String cityName){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        List result = null ;
        try{
            tx = session.beginTransaction() ;
            String hql = "Select id From CityOrRegion where city_or_region_name = :city" ;
            Query query = session.createQuery(hql) ;
            query.setParameter("city", cityName) ;
            result = query.list() ;
        }catch (HibernateException e){
            if( tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return  (int)result.get(0) ;
    }
    
    public int getUserID(String email){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        List result = null ;
        try{
            tx = session.beginTransaction() ;
            String hql = "Select id From User where email = :userEmail" ;
            Query query = session.createQuery(hql) ;
            query.setParameter("userEmail", email) ;
            result = query.list() ;
        }catch (HibernateException e){
            if( tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return  (int)result.get(0) ;
    }
    
    public List getCityOrRegionList(){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        List result = null ;
        try{
            tx = session.beginTransaction() ;
            String hql = "From CityOrRegion" ;
            Query query = session.createQuery(hql) ;
            result = query.list() ;
        }catch (HibernateException e){
            if( tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return  result ;
    }
    
    public List getUserList(){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        List result = null ;
        try{
            tx = session.beginTransaction() ;
            String hql = "From User" ;
            Query query = session.createQuery(hql) ;
            result = query.list() ;
            tx.commit();
        }catch (HibernateException e){
            if( tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return  result ;
    }
    
    public boolean isAuthenticate(String mail, String password){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        String userHashPassword = null ;
        List<User> result = null ;
        boolean is_auth = false ;
        try{
            tx = session.beginTransaction() ;
            
            userHashPassword = DigestUtils.md5Hex(password) ;
            
            String hql = "From User where email = :em" ;
            Query query = session.createQuery(hql );
            query.setParameter("em", mail) ;
            result = query.list() ;
            
            for (User u : result){
                if ( (mail.equalsIgnoreCase( u.getEmail() ) && 
                    userHashPassword.equals( u.getPassword()))){
                is_auth = true ;
                return is_auth ;
            }
            else{
                is_auth = false ;
                return is_auth ;
            }
            }
            
            tx.commit();
            for (Iterator it = result.iterator(); it.hasNext();) {
                String o = (String)it.next();
                System.out.println(o + "---");
            }
               return true ;
        }catch (HibernateException e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
        return is_auth ;
        
    }
    
    public void updateCityOrRegion(int cityID, String newCityName){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        try{
            tx = session.beginTransaction() ;
            CityOrRegion city = (CityOrRegion)session.get(CityOrRegion.class, cityID) ;
            city.setCity_or_region_name(newCityName);
            session.update(city);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }
    
    public void updateUserNames(int userID, String fName, String lName, String mName){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        try{
            tx = session.beginTransaction() ;
            User user = (User)session.get(User.class, userID) ;
            user.setFirstName(fName);
            user.setLastName(lName);
            user.setMiddleName(mName);
            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }
        
        public void updateUser(int userID, String fName, String lName, String mName,
                String mail, String passwd){
        Session session = HibernateUtil.getSessionFactory().openSession() ;
        Transaction tx = null ;
        String hashPasswd = null ;
        try{
            tx = session.beginTransaction() ;
            User user = (User)session.get(User.class, userID) ;
            user.setFirstName(fName);
            user.setLastName(lName);
            user.setMiddleName(mName);
            user.setEmail(mail);
            hashPasswd = DigestUtils.md5Hex(passwd) ;
            user.setPassword(hashPasswd);
            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            session.close() ;
        }
    }

}
