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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;

/**
 * TaxonID
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-05T16:01:47.919Z[GMT]")public class TaxonID {

  @SerializedName("sourceName")
  private String sourceName = null;

  @SerializedName("taxonId")
  private String taxonId = null;
  public TaxonID sourceName(String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  

  /**
  * The human readable name of the taxonomy provider
  * @return sourceName
  **/
  @Schema(required = true, description = "The human readable name of the taxonomy provider")
  public String getSourceName() {
    return sourceName;
  }
  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }
  public TaxonID taxonId(String taxonId) {
    this.taxonId = taxonId;
    return this;
  }

  

  /**
  * The identifier (name, ID, URI) of a particular taxonomy within the source provider
  * @return taxonId
  **/
  @Schema(required = true, description = "The identifier (name, ID, URI) of a particular taxonomy within the source provider")
  public String getTaxonId() {
    return taxonId;
  }
  public void setTaxonId(String taxonId) {
    this.taxonId = taxonId;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxonID taxonID = (TaxonID) o;
    return Objects.equals(this.sourceName, taxonID.sourceName) &&
        Objects.equals(this.taxonId, taxonID.taxonId);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(sourceName, taxonId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxonID {\n");
    
    sb.append("    sourceName: ").append(toIndentedString(sourceName)).append("\n");
    sb.append("    taxonId: ").append(toIndentedString(taxonId)).append("\n");
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
