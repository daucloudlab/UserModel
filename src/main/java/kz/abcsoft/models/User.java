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
    public User(String firstName, String lastName,  String email, String password){
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.email = email ;
        this.password = password ;
        
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIin_Bin() {
        return Iin_Bin;
    }

    public void setIin_Bin(String Iin_Bin) {
        this.Iin_Bin = Iin_Bin;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public CityOrRegion getCityOrRegion() {
        return cityOrRegion;
    }

    public void setCityOrRegion(CityOrRegion cityOrRegion) {
        this.cityOrRegion = cityOrRegion;
    }
}
