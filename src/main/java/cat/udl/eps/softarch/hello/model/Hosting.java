package cat.udl.eps.softarch.hello.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Date;
import java.net.URI;

/**
 * Created by http://rhizomik.net/~roberto/
 */
@Entity
public class Hosting {

    @Id
    @NotBlank(message = "Urlname cannot be blank")
    @Size(max = 256, message = "Urlname maximum length is {max} characters long")
    private String urlname;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 256, message = "Name maximum length is {max} characters long")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "E-mail should be valid")
    private String email;

    @NotBlank(message = "type cannot be blank")
    @Size(max = 256, message = "type maximum length is {max} characters long")
    private String type;

    @NotBlank(message = "Web cannot be blank")
    @Size(max = 256, message = "Web maximum length is {max} characters long")
    private String web;

    @NotBlank(message = "Street cannot be blank")
    @Size(max = 256, message = "Street maximum length is {max} characters long")
    private String street;

    @NotBlank(message = "Postalcode cannot be blank")
    @Size(max = 256, message = "Postalcode maximum length is {max} characters long")
    private String postalcode;

    @NotBlank(message = "City cannot be blank")
    @Size(max = 256, message = "City maximum length is {max} characters long")
    private String city;

    @NotBlank(message = "Region cannot be blank")
    @Size(max = 256, message = "Region maximum length is {max} characters long")
    private String region;

    @NotBlank(message = "Province cannot be blank")
    @Size(max = 256, message = "Region maximum length is {max} characters long")
    private String province;

    @NotBlank(message = "Phonenumber cannot be blank")
    @Size(max = 256, message = "Phonenumber maximum length is {max} characters long")
    private String phonenumber;

    @NotBlank(message = "Owner cannot be blank")
    @Size(max = 256, message = "Owner maximum length is {max} characters long")
    private String owner;

    @NotBlank(message = "Latitude cannot be blank")
    @Size(max = 256, message = "Latitude maximum length is {max} characters long")
    private String latitude;

    @NotBlank(message = "Longitude cannot be blank")
    @Size(max = 256, message = "Longitude maximum length is {max} characters long")
    private String longitude;

    public Hosting() {}

    public Hosting(String name, String email, String type, String web, String street, String postalcode, String city,
                   String region, String province, String phonenumber, String owner, String latitude, String longitude) {
        this.name = name;
        this.email = email;
        this.type = type;
        this.web = web;
        this.street = street;
        this.postalcode = postalcode;
        this.city = city;
        this.region = region;
        this.province = province;
        this.phonenumber = phonenumber;
        this.owner = owner;
        this.latitude = latitude;
        this.longitude = longitude;
        this.urlname = name.replaceAll("[^A-Za-z]+", "");
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


}
