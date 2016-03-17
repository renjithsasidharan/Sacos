package com.sacos.sacosandorid.models;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

/**
 * Created by renjith on 14/03/16.
 */

@Generated("org.jsonschema2pojo")
public class ExploreModel {

  private int price;
  private String priceString;
  private int DestinationId;
  private String destination;
  private String days;
  private String OutboundPictureUrl;
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  /**
   *
   * @return
   * The price
   */
  public int getPrice() {
    return price;
  }

  /**
   *
   * @param price
   * The price
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   *
   * @return
   * The price string
   */
  public String getPriceString() {
    return priceString;
  }

  /**
   *
   * @param price
   * The price string
   */
  public void setPriceString(String price) {
    this.priceString = price;
  }

  /**
   *
   * @return
   *     The DestinationId
   */
  public int getDestinationId() {
    return DestinationId;
  }

  /**
   *
   * @param DestinationId
   *     The DestinationId
   */
  public void setDestinationId(int DestinationId) {
    this.DestinationId = DestinationId;
  }

  /**
   *
   * @return
   *     The DepartureDate
   */

  /**
   *
   * @return
   * The destination
   */
  public String getDestination() {
    return destination;
  }

  /**
   *
   * @param destination
   * The destination
   */
  public void setDestination(String destination) {
    this.destination = destination;
  }

  /**
   *
   * @return
   * The days
   */
  public String getDays() {
    return days;
  }

  /**
   *
   * @param days
   * The days
   */
  public void setDays(String days) {
    this.days = days;
  }

  /**
   *
   * @return
   *     The OutboundPictureUrl
   */
  public String getOutboundPictureUrl() {
    return OutboundPictureUrl;
  }

  /**
   *
   * @param OutboundPictureUrl
   *     The OutboundPictureUrl
   */
  public void setOutboundPictureUrl(String OutboundPictureUrl) {
    this.OutboundPictureUrl = OutboundPictureUrl;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
