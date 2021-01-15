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
 * GermplasmAttributeCategory
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class GermplasmAttributeCategory {

  @SerializedName("attributeCategoryDbId")
  private String attributeCategoryDbId = null;

  @SerializedName("attributeCategoryName")
  private String attributeCategoryName = null;

  @SerializedName("name")
  private String name = null;
  public GermplasmAttributeCategory attributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
    return this;
  }

  

  /**
  * The ID which uniquely identifies this attribute category within the given database server
  * @return attributeCategoryDbId
  **/
  @Schema(description = "The ID which uniquely identifies this attribute category within the given database server")
  public String getAttributeCategoryDbId() {
    return attributeCategoryDbId;
  }
  public void setAttributeCategoryDbId(String attributeCategoryDbId) {
    this.attributeCategoryDbId = attributeCategoryDbId;
  }
  public GermplasmAttributeCategory attributeCategoryName(String attributeCategoryName) {
    this.attributeCategoryName = attributeCategoryName;
    return this;
  }

  

  /**
  * A human readable name for this attribute category. Very similar to Trait class. (examples: \&quot;morphologic\&quot;, \&quot;phenologic\&quot;, \&quot;agronomic\&quot;, \&quot;physiologic\&quot;, \&quot;abiotic stress\&quot;, \&quot;biotic stress\&quot;, \&quot;biochemic\&quot;, \&quot;quality traits\&quot;, \&quot;fertility\&quot;, etc.)
  * @return attributeCategoryName
  **/
  @Schema(description = "A human readable name for this attribute category. Very similar to Trait class. (examples: \"morphologic\", \"phenologic\", \"agronomic\", \"physiologic\", \"abiotic stress\", \"biotic stress\", \"biochemic\", \"quality traits\", \"fertility\", etc.)")
  public String getAttributeCategoryName() {
    return attributeCategoryName;
  }
  public void setAttributeCategoryName(String attributeCategoryName) {
    this.attributeCategoryName = attributeCategoryName;
  }
  public GermplasmAttributeCategory name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - Use \&quot;attributeCategoryName\&quot;
  * @return name
  **/
  @Schema(description = "DEPRECATED in v1.3 - Use \"attributeCategoryName\"")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GermplasmAttributeCategory germplasmAttributeCategory = (GermplasmAttributeCategory) o;
    return Objects.equals(this.attributeCategoryDbId, germplasmAttributeCategory.attributeCategoryDbId) &&
        Objects.equals(this.attributeCategoryName, germplasmAttributeCategory.attributeCategoryName) &&
        Objects.equals(this.name, germplasmAttributeCategory.name);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(attributeCategoryDbId, attributeCategoryName, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GermplasmAttributeCategory {\n");
    
    sb.append("    attributeCategoryDbId: ").append(toIndentedString(attributeCategoryDbId)).append("\n");
    sb.append("    attributeCategoryName: ").append(toIndentedString(attributeCategoryName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
