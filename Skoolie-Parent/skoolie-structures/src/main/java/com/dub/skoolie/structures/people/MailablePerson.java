/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dub.skoolie.structures.people;

/**
 *
 * @author Kevin W
 */
public abstract class MailablePerson extends Person {
    
    protected String addressOne;
    
    private String addressTwo;
    
    protected String city;
    
    protected String postal;
    
    protected String state;

    /**
     * @return the address
     */
    public String getAddressOne() {
        return addressOne;
    }

    /**
     * @param address the address to set
     */
    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postal
     */
    public String getPostal() {
        return postal;
    }

    /**
     * @param postal the postal to set
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the addressTwo
     */
    public String getAddressTwo() {
        return addressTwo;
    }

    /**
     * @param addressTwo the addressTwo to set
     */
    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }
    
}
