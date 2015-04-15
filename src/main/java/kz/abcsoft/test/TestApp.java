package kz.abcsoft.test;

import kz.abcsoft.models.CityOrRegion;
import kz.abcsoft.models.DbOperations;

public class TestApp {
    
    public static void main(String[] args) {
        TestApp ME = new TestApp() ;
        DbOperations db = new DbOperations() ;
//        int id1 = db.addCityOrRegion("Шымкент") ;
//        int id2 = db.addCityOrRegion("Astana") ;
//        System.out.println("id1 = " + id1);
//        System.out.println("id2 = " + id2);
        
//        int id3 = db.addUser("Daulet", "Baimbetov", "dau@gmail.com", "12345") ;
        CityOrRegion city = db.addCityOrRegion("Karaganda") ;
        int id4 = db.addUser("Kairat", "Almakhanov", "kairo@yahoo.com", "456", city);
        System.out.println("id3 = " + id4);
    } 
    
}
