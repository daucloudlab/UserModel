package kz.abcsoft.models;

public class CityOrRegion {
    private int id ;
    private String city_or_region_name ;
    
    public CityOrRegion(){}
    public CityOrRegion(String city_or_region_name){
        this.city_or_region_name = city_or_region_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_or_region_name() {
        return city_or_region_name;
    }

    public void setCity_or_region_name(String city_or_region_name) {
        this.city_or_region_name = city_or_region_name;
    }
    
    
    
}
