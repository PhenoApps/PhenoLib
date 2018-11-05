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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MarkerProfile
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-05T16:01:47.919Z[GMT]")public class MarkerProfile {

  @SerializedName("analysisMethod")
  private String analysisMethod = null;

  @SerializedName("data")
  private List<Map<String, String>> data = new ArrayList<Map<String, String>>();

  @SerializedName("extractDbId")
  private String extractDbId = null;

  @SerializedName("germplasmDbId")
  private String germplasmDbId = null;

  @SerializedName("markerProfileDbId")
  private String markerProfileDbId = null;

  @SerializedName("markerprofileDbId")
  private String markerprofileDbId = null;

  @SerializedName("uniqueDisplayName")
  private String uniqueDisplayName = null;
  public MarkerProfile analysisMethod(String analysisMethod) {
    this.analysisMethod = analysisMethod;
    return this;
  }

  

  /**
  * The type of analysis performed to determine a set of marker data
  * @return analysisMethod
  **/
  @Schema(description = "The type of analysis performed to determine a set of marker data")
  public String getAnalysisMethod() {
    return analysisMethod;
  }
  public void setAnalysisMethod(String analysisMethod) {
    this.analysisMethod = analysisMethod;
  }
  public MarkerProfile data(List<Map<String, String>> data) {
    this.data = data;
    return this;
  }

  public MarkerProfile addDataItem(Map<String, String> dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
  * array of marker-name/score pairs
  * @return data
  **/
  @Schema(required = true, description = "array of marker-name/score pairs")
  public List<Map<String, String>> getData() {
    return data;
  }
  public void setData(List<Map<String, String>> data) {
    this.data = data;
  }
  public MarkerProfile extractDbId(String extractDbId) {
    this.extractDbId = extractDbId;
    return this;
  }

  

  /**
  * Required
  * @return extractDbId
  **/
  @Schema(required = true, description = "Required")
  public String getExtractDbId() {
    return extractDbId;
  }
  public void setExtractDbId(String extractDbId) {
    this.extractDbId = extractDbId;
  }
  public MarkerProfile germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  

  /**
  * Required
  * @return germplasmDbId
  **/
  @Schema(required = true, description = "Required")
  public String getGermplasmDbId() {
    return germplasmDbId;
  }
  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }
  public MarkerProfile markerProfileDbId(String markerProfileDbId) {
    this.markerProfileDbId = markerProfileDbId;
    return this;
  }

  

  /**
  * Unique in the database. Can be a catenation of unique IDs for germplasm and extract. Required
  * @return markerProfileDbId
  **/
  @Schema(required = true, description = "Unique in the database. Can be a catenation of unique IDs for germplasm and extract. Required")
  public String getMarkerProfileDbId() {
    return markerProfileDbId;
  }
  public void setMarkerProfileDbId(String markerProfileDbId) {
    this.markerProfileDbId = markerProfileDbId;
  }
  public MarkerProfile markerprofileDbId(String markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - see \&quot;markerProfileDbId\&quot; (camel case)
  * @return markerprofileDbId
  **/
  @Schema(description = "DEPRECATED in v1.3 - see \"markerProfileDbId\" (camel case)")
  public String getMarkerprofileDbId() {
    return markerprofileDbId;
  }
  public void setMarkerprofileDbId(String markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
  }
  public MarkerProfile uniqueDisplayName(String uniqueDisplayName) {
    this.uniqueDisplayName = uniqueDisplayName;
    return this;
  }

  

  /**
  * Human readable display name for this marker profile
  * @return uniqueDisplayName
  **/
  @Schema(description = "Human readable display name for this marker profile")
  public String getUniqueDisplayName() {
    return uniqueDisplayName;
  }
  public void setUniqueDisplayName(String uniqueDisplayName) {
    this.uniqueDisplayName = uniqueDisplayName;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarkerProfile markerProfile = (MarkerProfile) o;
    return Objects.equals(this.analysisMethod, markerProfile.analysisMethod) &&
        Objects.equals(this.data, markerProfile.data) &&
        Objects.equals(this.extractDbId, markerProfile.extractDbId) &&
        Objects.equals(this.germplasmDbId, markerProfile.germplasmDbId) &&
        Objects.equals(this.markerProfileDbId, markerProfile.markerProfileDbId) &&
        Objects.equals(this.markerprofileDbId, markerProfile.markerprofileDbId) &&
        Objects.equals(this.uniqueDisplayName, markerProfile.uniqueDisplayName);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(analysisMethod, data, extractDbId, germplasmDbId, markerProfileDbId, markerprofileDbId, uniqueDisplayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkerProfile {\n");
    
    sb.append("    analysisMethod: ").append(toIndentedString(analysisMethod)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    extractDbId: ").append(toIndentedString(extractDbId)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    markerProfileDbId: ").append(toIndentedString(markerProfileDbId)).append("\n");
    sb.append("    markerprofileDbId: ").append(toIndentedString(markerprofileDbId)).append("\n");
    sb.append("    uniqueDisplayName: ").append(toIndentedString(uniqueDisplayName)).append("\n");
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
