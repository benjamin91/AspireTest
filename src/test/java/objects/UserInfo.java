package objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class UserInfo {
    private String name;
    private String email;
    private String country;
    private String phoneNumber;
    private String role;
    private String hear;
    private String referral;
    private String cardNumber;
    private String dob;
    private String nationality;
    private String gender;
    private List<String> interestedProducts = new ArrayList<>();
    private Business business;

    public UserInfo(String name,
                    String country,
                    String role,
                    String hear,
                    String referral,
                    String cardNumber,
                    String dob,
                    String gender,
                    String products) {
        this.name = name + System.currentTimeMillis();
        this.email = this.name + "@corp.com";
        this.country = country;
        Random random = new Random();
        this.phoneNumber = String.valueOf(100000000 + random.nextInt(900000000));
        this.role = role;
        this.hear = hear;
        this.referral = referral;
        this.cardNumber = cardNumber;
        this.dob = dob;
        this.nationality = country;
        this.gender = gender;
        for(String product:products.split(","))
            this.interestedProducts.add(product);
    }

    public UserInfo(String dob, String products) {
        this.dob = dob;
        for(String product:products.split(",")) {
            this.interestedProducts.add(product);
        }
    }

    public UserInfo(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHear() {
        return hear;
    }

    public void setHear(String hear) {
        this.hear = hear;
    }

    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getInterestedProducts() {
        return interestedProducts;
    }

    public void setInterestedProducts(List<String> interestedProducts) {
        this.interestedProducts = interestedProducts;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
