
package com.sacos.sacosandorid.models.skyscanner;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Place {

    private int PlaceId;
    private String IataCode;
    private String Name;
    private String Type;
    private String CityName;
    private String CityId;
    private String CountryName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PlaceId
     */
    public int getPlaceId() {
        return PlaceId;
    }

    /**
     * 
     * @param PlaceId
     *     The PlaceId
     */
    public void setPlaceId(int PlaceId) {
        this.PlaceId = PlaceId;
    }

    /**
     * 
     * @return
     *     The IataCode
     */
    public String getIataCode() {
        return IataCode;
    }

    /**
     * 
     * @param IataCode
     *     The IataCode
     */
    public void setIataCode(String IataCode) {
        this.IataCode = IataCode;
    }

    /**
     * 
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * 
     * @return
     *     The CityName
     */
    public String getCityName() {
        return CityName;
    }

    /**
     * 
     * @param CityName
     *     The CityName
     */
    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    /**
     * 
     * @return
     *     The CityId
     */
    public String getCityId() {
        return CityId;
    }

    /**
     * 
     * @param CityId
     *     The CityId
     */
    public void setCityId(String CityId) {
        this.CityId = CityId;
    }

    /**
     * 
     * @return
     *     The CountryName
     */
    public String getCountryName() {
        return CountryName;
    }

    /**
     * 
     * @param CountryName
     *     The CountryName
     */
    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
