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
 * StudyObservationVariablesResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class StudyObservationVariablesResponse {

  @SerializedName("metadata")
  private Metadata metadata = null;

  @SerializedName("result")
  private StudyObservationVariablesResponseResult result = null;
  public StudyObservationVariablesResponse metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

  

  /**
  * Get metadata
  * @return metadata
  **/
  @Schema(description = "")
  public Metadata getMetadata() {
    return metadata;
  }
  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }
  public StudyObservationVariablesResponse result(StudyObservationVariablesResponseResult result) {
    this.result = result;
    return this;
  }

  

  /**
  * Get result
  * @return result
  **/
  @Schema(description = "")
  public StudyObservationVariablesResponseResult getResult() {
    return result;
  }
  public void setResult(StudyObservationVariablesResponseResult result) {
    this.result = result;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudyObservationVariablesResponse studyObservationVariablesResponse = (StudyObservationVariablesResponse) o;
    return Objects.equals(this.metadata, studyObservationVariablesResponse.metadata) &&
        Objects.equals(this.result, studyObservationVariablesResponse.result);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(metadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyObservationVariablesResponse {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
