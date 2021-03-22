package objects;

import libraries.Utils;

public class Business {
    private String name;
    private String parentType;
    private String type;
    private String numberUEN;
    private String website;
    private String model;
    private String industry;

    public Business(String name, String type, String model, String industry) {
        this.name = name + " Corporation";
        this.type = type;
        this.numberUEN = Utils.generateEUN("^([0-9]{8,9}[a-zA-Z]{1})$");
        this.website = "www." + name + ".com";
        this.industry = industry;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberUEN() {
        return numberUEN;
    }

    public void setNumberUEN(String numberUEN) {
        this.numberUEN = numberUEN;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
