package kz.abcsoft.test;

import kz.abcsoft.models.DbOperations;

public class TestApp {
    
    public static void main(String[] args) {
        TestApp ME = new TestApp() ;
        DbOperations db = new DbOperations() ;
        int id1 = db.addCityOrRegion("Шымкент") ;
        int id2 = db.addCityOrRegion("Astana") ;
        System.out.println("id1 = " + id1);
        System.out.println("id2 = " + id2);
    } 
    
}
