
package com.sacos.sacosandorid.models.skyscanner.browsedates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class BrowseDates {

    private com.sacos.sacosandorid.models.skyscanner.browsedates.Dates Dates;
    private List<Quote> Quotes = new ArrayList<Quote>();
    private List<Place> Places = new ArrayList<Place>();
    private List<Carrier> Carriers = new ArrayList<Carrier>();
    private List<Currency> Currencies = new ArrayList<Currency>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Dates
     */
    public com.sacos.sacosandorid.models.skyscanner.browsedates.Dates getDates() {
        return Dates;
    }

    /**
     * 
     * @param Dates
     *     The Dates
     */
    public void setDates(com.sacos.sacosandorid.models.skyscanner.browsedates.Dates Dates) {
        this.Dates = Dates;
    }

    /**
     * 
     * @return
     *     The Quotes
     */
    public List<Quote> getQuotes() {
        return Quotes;
    }

    /**
     * 
     * @param Quotes
     *     The Quotes
     */
    public void setQuotes(List<Quote> Quotes) {
        this.Quotes = Quotes;
    }

    /**
     * 
     * @return
     *     The Places
     */
    public List<Place> getPlaces() {
        return Places;
    }

    /**
     * 
     * @param Places
     *     The Places
     */
    public void setPlaces(List<Place> Places) {
        this.Places = Places;
    }

    /**
     * 
     * @return
     *     The Carriers
     */
    public List<Carrier> getCarriers() {
        return Carriers;
    }

    /**
     * 
     * @param Carriers
     *     The Carriers
     */
    public void setCarriers(List<Carrier> Carriers) {
        this.Carriers = Carriers;
    }

    /**
     * 
     * @return
     *     The Currencies
     */
    public List<Currency> getCurrencies() {
        return Currencies;
    }

    /**
     * 
     * @param Currencies
     *     The Currencies
     */
    public void setCurrencies(List<Currency> Currencies) {
        this.Currencies = Currencies;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
