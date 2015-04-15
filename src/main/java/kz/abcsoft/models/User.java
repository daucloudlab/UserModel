package kz.abcsoft.models;

public class User {
    private int id ;
    private String firstName ;
    private String lastName ;
    private String middleName ;
    private String password ;
    private String email ;
    private String phone ;
    private String Iin_Bin ;
    private boolean isActive ;
    
//    private int cityOrRegion_id ;
    private CityOrRegion cityOrRegion ;
    
    public User(){}
    public User(String firstName, String lastName, String password, String email){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.password = password ;
        this.email = email ;
        
        this.isActive = false ;
    }
    public User(String firstName, String lastName, String password, String email, 
            CityOrRegion cityOrRegion){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.password = password ;
        this.email = email ;
        this.cityOrRegion = cityOrRegion ;
        
        this.isActive = false ;
    }
    public User(String firstName, String lastName, String middleName, String password, 
            String email, CityOrRegion cityOrRegion){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.middleName = middleName ;
        this.password = password ;
        this.email = email ;
        this.cityOrRegion = cityOrRegion ;
        
        this.isActive = false ;
    }
    
    public User(String firstName, String lastName, String middleName, String password, 
            String email, CityOrRegion cityOrRegion, String phone, String Iin_Bin){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.middleName = middleName ;
        this.password = password ;
        this.email = email ;
        this.cityOrRegion = cityOrRegion ;
        this.phone = phone ;
        this.Iin_Bin = Iin_Bin ;
        
        this.isActive = false ;
    }
}
