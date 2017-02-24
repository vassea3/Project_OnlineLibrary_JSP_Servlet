package com.biblioteca.entitati;

public class MyContactPage {

    private int id;
    private String city;
    private String Street;
    private String phone;
    private String email;
    private String graphic;

    public MyContactPage(int id, String city, String Street, String phone, String email, String graphic) {
        this.id = id;
        this.city = city;
        this.Street = Street;
        this.phone = phone;
        this.email = email;
        this.graphic = graphic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    @Override
    public String toString() {
        return "MyContactPage{" + "id=" + id + ", city=" + city + ", Street=" + Street + ", phone=" + phone + ", email=" + email + ", graphic=" + graphic + '}';
    }

}
