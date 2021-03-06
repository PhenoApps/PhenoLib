/*
 * BrAPI
 * The Breeding API (BrAPI) is a Standardized RESTful Web Service API Specification for communicating Plant Breeding Data. BrAPI allows for easy data sharing between databases and tools involved in plant breeding.  <strong>General Reference Documentation</strong>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/URL_Structure.md\">URL Structure</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Response_Structure.md\">Response Structure</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Date_Time_Encoding.md\">Date/Time Encoding</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Location_Encoding.md\">Location Encoding</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Error_Handling.md\">Error Handling</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Search_Services.md\">Search Services</a>  <a href=\"https://github.com/plantbreeding/API/blob/master/Specification/GeneralInfo/Asychronous_Processing.md\">Asynchronous Processing</a>
 *
 * OpenAPI spec version: 1.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DataLink
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class DataLink {

  @SerializedName("dataLinkName")
  private String dataLinkName = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("url")
  private String url = null;
  public DataLink dataLinkName(String dataLinkName) {
    this.dataLinkName = dataLinkName;
    return this;
  }

  

  /**
  * The name of the external data link
  * @return dataLinkName
  **/
  @Schema(description = "The name of the external data link")
  public String getDataLinkName() {
    return dataLinkName;
  }
  public void setDataLinkName(String dataLinkName) {
    this.dataLinkName = dataLinkName;
  }
  public DataLink name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - Use \&quot;dataLinkName\&quot;
  * @return name
  **/
  @Schema(description = "DEPRECATED in v1.3 - Use \"dataLinkName\"")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public DataLink type(String type) {
    this.type = type;
    return this;
  }

  

  /**
  * The type of external data link
  * @return type
  **/
  @Schema(description = "The type of external data link")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public DataLink url(String url) {
    this.url = url;
    return this;
  }

  

  /**
  * The URL which links to external data
  * @return url
  **/
  @Schema(description = "The URL which links to external data")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataLink dataLink = (DataLink) o;
    return Objects.equals(this.dataLinkName, dataLink.dataLinkName) &&
        Objects.equals(this.name, dataLink.name) &&
        Objects.equals(this.type, dataLink.type) &&
        Objects.equals(this.url, dataLink.url);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(dataLinkName, name, type, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataLink {\n");
    
    sb.append("    dataLinkName: ").append(toIndentedString(dataLinkName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
