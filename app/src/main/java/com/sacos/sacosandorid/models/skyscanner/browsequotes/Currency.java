
package com.sacos.sacosandorid.models.skyscanner.browsequotes;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Currency {

    private String Code;
    private String Symbol;
    private String ThousandsSeparator;
    private String DecimalSeparator;
    private boolean SymbolOnLeft;
    private boolean SpaceBetweenAmountAndSymbol;
    private int RoundingCoefficient;
    private int DecimalDigits;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * 
     * @param Code
     *     The Code
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * 
     * @return
     *     The Symbol
     */
    public String getSymbol() {
        return Symbol;
    }

    /**
     * 
     * @param Symbol
     *     The Symbol
     */
    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    /**
     * 
     * @return
     *     The ThousandsSeparator
     */
    public String getThousandsSeparator() {
        return ThousandsSeparator;
    }

    /**
     * 
     * @param ThousandsSeparator
     *     The ThousandsSeparator
     */
    public void setThousandsSeparator(String ThousandsSeparator) {
        this.ThousandsSeparator = ThousandsSeparator;
    }

    /**
     * 
     * @return
     *     The DecimalSeparator
     */
    public String getDecimalSeparator() {
        return DecimalSeparator;
    }

    /**
     * 
     * @param DecimalSeparator
     *     The DecimalSeparator
     */
    public void setDecimalSeparator(String DecimalSeparator) {
        this.DecimalSeparator = DecimalSeparator;
    }

    /**
     * 
     * @return
     *     The SymbolOnLeft
     */
    public boolean isSymbolOnLeft() {
        return SymbolOnLeft;
    }

    /**
     * 
     * @param SymbolOnLeft
     *     The SymbolOnLeft
     */
    public void setSymbolOnLeft(boolean SymbolOnLeft) {
        this.SymbolOnLeft = SymbolOnLeft;
    }

    /**
     * 
     * @return
     *     The SpaceBetweenAmountAndSymbol
     */
    public boolean isSpaceBetweenAmountAndSymbol() {
        return SpaceBetweenAmountAndSymbol;
    }

    /**
     * 
     * @param SpaceBetweenAmountAndSymbol
     *     The SpaceBetweenAmountAndSymbol
     */
    public void setSpaceBetweenAmountAndSymbol(boolean SpaceBetweenAmountAndSymbol) {
        this.SpaceBetweenAmountAndSymbol = SpaceBetweenAmountAndSymbol;
    }

    /**
     * 
     * @return
     *     The RoundingCoefficient
     */
    public int getRoundingCoefficient() {
        return RoundingCoefficient;
    }

    /**
     * 
     * @param RoundingCoefficient
     *     The RoundingCoefficient
     */
    public void setRoundingCoefficient(int RoundingCoefficient) {
        this.RoundingCoefficient = RoundingCoefficient;
    }

    /**
     * 
     * @return
     *     The DecimalDigits
     */
    public int getDecimalDigits() {
        return DecimalDigits;
    }

    /**
     * 
     * @param DecimalDigits
     *     The DecimalDigits
     */
    public void setDecimalDigits(int DecimalDigits) {
        this.DecimalDigits = DecimalDigits;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
