
package com.sacos.sacosandorid.models.skyscanner;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Quote {

    private int QuoteId;
    private int MinPrice;
    private boolean Direct;
    private com.sacos.sacosandorid.models.skyscanner.OutboundLeg OutboundLeg;
    private com.sacos.sacosandorid.models.skyscanner.InboundLeg InboundLeg;
    private String QuoteDateTime;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The QuoteId
     */
    public int getQuoteId() {
        return QuoteId;
    }

    /**
     * 
     * @param QuoteId
     *     The QuoteId
     */
    public void setQuoteId(int QuoteId) {
        this.QuoteId = QuoteId;
    }

    /**
     * 
     * @return
     *     The MinPrice
     */
    public int getMinPrice() {
        return MinPrice;
    }

    /**
     * 
     * @param MinPrice
     *     The MinPrice
     */
    public void setMinPrice(int MinPrice) {
        this.MinPrice = MinPrice;
    }

    /**
     * 
     * @return
     *     The Direct
     */
    public boolean isDirect() {
        return Direct;
    }

    /**
     * 
     * @param Direct
     *     The Direct
     */
    public void setDirect(boolean Direct) {
        this.Direct = Direct;
    }

    /**
     * 
     * @return
     *     The OutboundLeg
     */
    public com.sacos.sacosandorid.models.skyscanner.OutboundLeg getOutboundLeg() {
        return OutboundLeg;
    }

    /**
     * 
     * @param OutboundLeg
     *     The OutboundLeg
     */
    public void setOutboundLeg(com.sacos.sacosandorid.models.skyscanner.OutboundLeg OutboundLeg) {
        this.OutboundLeg = OutboundLeg;
    }

    /**
     * 
     * @return
     *     The InboundLeg
     */
    public com.sacos.sacosandorid.models.skyscanner.InboundLeg getInboundLeg() {
        return InboundLeg;
    }

    /**
     * 
     * @param InboundLeg
     *     The InboundLeg
     */
    public void setInboundLeg(com.sacos.sacosandorid.models.skyscanner.InboundLeg InboundLeg) {
        this.InboundLeg = InboundLeg;
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
