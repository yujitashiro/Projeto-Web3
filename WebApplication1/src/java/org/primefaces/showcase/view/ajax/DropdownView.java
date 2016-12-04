//package org.primefaces.showcase.view.ajax;
// 
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.context.FacesContext;
// 
//@ManagedBean
//@ViewScoped
//public class DropdownView implements Serializable {
//     
//    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
//    private String country; 
//    private String city;  
//    private Map<String,String> countries;
//    private Map<String,String> cities;
//     
//    @PostConstruct
//    public void init() {
//        countries  = new HashMap<String, String>();
//        countries.put("A", "A");
//        countries.put("B", "B");
//        countries.put("C", "C");
//        countries.put("D", "D");
//        countries.put("E", "E");
//         
//        Map<String,String> map = new HashMap<String, String>();
//        map.put("1", "1");
//        map.put("2", "2");
//        map.put("3", "3");
//        data.put("A", map);
//         
//        map = new HashMap<String, String>();
//        map.put("1", "1");
//        map.put("2", "2");
//        map.put("3", "3");
//        data.put("B", map);
//         
//        map = new HashMap<String, String>();
//        map.put("1", "1");
//        map.put("2", "2");
//        map.put("3", "3");
//        data.put("C", map);
//    }
// 
//    public Map<String, Map<String, String>> getData() {
//        return data;
//    }
// 
//    public String getCountry() {
//        return country;
//    }
// 
//    public void setCountry(String country) {
//        this.country = country;
//    }
// 
//    public String getCity() {
//        return city;
//    }
// 
//    public void setCity(String city) {
//        this.city = city;
//    }
// 
//    public Map<String, String> getCountries() {
//        return countries;
//    }
// 
//    public Map<String, String> getCities() {
//        return cities;
//    }
// 
//    public void onCountryChange() {
//        if(country !=null && !country.equals(""))
//            cities = data.get(country);
//        else
//            cities = new HashMap<String, String>();
//    }
//     
//    public void displayLocation() {
//        FacesMessage msg;
//        if(city != null && country != null)
//            msg = new FacesMessage("Selected", city + " of " + country);
//        else
//            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
//             
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
//    }
//}