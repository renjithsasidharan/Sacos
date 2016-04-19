
package com.sacos.sacosandorid.models.skyscanner.browsedates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class OutboundDate {

    private String PartialDate;
    private List<Integer> QuoteIds = new ArrayList<Integer>();
    private int Price;
    private String QuoteDateTime;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PartialDate
     */
    public String getPartialDate() {
        return PartialDate;
    }

    /**
     * 
     * @param PartialDate
     *     The PartialDate
     */
    public void setPartialDate(String PartialDate) {
        this.PartialDate = PartialDate;
    }

    /**
     * 
     * @return
     *     The QuoteIds
     */
    public List<Integer> getQuoteIds() {
        return QuoteIds;
    }

    /**
     * 
     * @param QuoteIds
     *     The QuoteIds
     */
    public void setQuoteIds(List<Integer> QuoteIds) {
        this.QuoteIds = QuoteIds;
    }

    /**
     * 
     * @return
     *     The Price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * 
     * @param Price
     *     The Price
     */
    public void setPrice(int Price) {
        this.Price = Price;
    }

    /**
     * 
     * @return
     *     The QuoteDateTime
     */
    public String getQuoteDateTime() {
        return QuoteDateTime;
    }

    /**
     * 
     * @param QuoteDateTime
     *     The QuoteDateTime
     */
    public void setQuoteDateTime(String QuoteDateTime) {
        this.QuoteDateTime = QuoteDateTime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
