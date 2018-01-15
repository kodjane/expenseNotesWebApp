/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AIK
 */
public class Currency {
    
    private String base;

    private String date;
    
    private transient List<Rate> rates = new ArrayList<Rate>();

    
    public Currency() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public List<Rate> getRates() {
        return rates;
    }
    
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
