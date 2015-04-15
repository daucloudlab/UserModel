package kz.abcsoft.models;

import kz.abcsoft.utils.HibernateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.HibernateException;
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
    
    public int addCityOrRegion(String newCityName){
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
        return cityID ;
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
}
