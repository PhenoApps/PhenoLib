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
import io.swagger.client.model.ObservationVariable;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudyObservationVariablesResponseResult
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-05T16:01:47.919Z[GMT]")public class StudyObservationVariablesResponseResult {

  @SerializedName("data")
  private List<ObservationVariable> data = null;

  @SerializedName("studyDbId")
  private String studyDbId = null;

  @SerializedName("trialName")
  private String trialName = null;
  public StudyObservationVariablesResponseResult data(List<ObservationVariable> data) {
    this.data = data;
    return this;
  }

  public StudyObservationVariablesResponseResult addDataItem(ObservationVariable dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<ObservationVariable>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
  * Get data
  * @return data
  **/
  @Schema(description = "")
  public List<ObservationVariable> getData() {
    return data;
  }
  public void setData(List<ObservationVariable> data) {
    this.data = data;
  }
  public StudyObservationVariablesResponseResult studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  

  /**
  * Get studyDbId
  * @return studyDbId
  **/
  @Schema(description = "")
  public String getStudyDbId() {
    return studyDbId;
  }
  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }
  public StudyObservationVariablesResponseResult trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

  

  /**
  * Get trialName
  * @return trialName
  **/
  @Schema(description = "")
  public String getTrialName() {
    return trialName;
  }
  public void setTrialName(String trialName) {
    this.trialName = trialName;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudyObservationVariablesResponseResult studyObservationVariablesResponseResult = (StudyObservationVariablesResponseResult) o;
    return Objects.equals(this.data, studyObservationVariablesResponseResult.data) &&
        Objects.equals(this.studyDbId, studyObservationVariablesResponseResult.studyDbId) &&
        Objects.equals(this.trialName, studyObservationVariablesResponseResult.trialName);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(data, studyDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyObservationVariablesResponseResult {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    trialName: ").append(toIndentedString(trialName)).append("\n");
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
