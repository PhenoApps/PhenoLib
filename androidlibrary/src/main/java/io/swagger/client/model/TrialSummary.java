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
import io.swagger.client.model.TrialStudies;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;

/**
 * TrialSummary
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-05T16:01:47.919Z[GMT]")public class TrialSummary {

  @SerializedName("active")
  private Boolean active = null;

  @SerializedName("additionalInfo")
  private Map<String, String> additionalInfo = null;

  @SerializedName("commonCropName")
  private String commonCropName = null;

  @SerializedName("documentationURL")
  private String documentationURL = null;

  @SerializedName("endDate")
  private LocalDate endDate = null;

  @SerializedName("programDbId")
  private String programDbId = null;

  @SerializedName("programName")
  private String programName = null;

  @SerializedName("startDate")
  private LocalDate startDate = null;

  @SerializedName("studies")
  private List<TrialStudies> studies = null;

  @SerializedName("trialDbId")
  private String trialDbId = null;

  @SerializedName("trialName")
  private String trialName = null;
  public TrialSummary active(Boolean active) {
    this.active = active;
    return this;
  }

  

  /**
  * Is this trail currently active
  * @return active
  **/
  @Schema(description = "Is this trail currently active")
  public Boolean isActive() {
    return active;
  }
  public void setActive(Boolean active) {
    this.active = active;
  }
  public TrialSummary additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  
  public TrialSummary putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = null;
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }
  /**
  * Additional arbitrary info
  * @return additionalInfo
  **/
  @Schema(description = "Additional arbitrary info")
  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }
  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }
  public TrialSummary commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  

  /**
  * Common name for the crop associated with this trial
  * @return commonCropName
  **/
  @Schema(description = "Common name for the crop associated with this trial")
  public String getCommonCropName() {
    return commonCropName;
  }
  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }
  public TrialSummary documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  

  /**
  * A URL to the human readable documentation of this object
  * @return documentationURL
  **/
  @Schema(description = "A URL to the human readable documentation of this object")
  public String getDocumentationURL() {
    return documentationURL;
  }
  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }
  public TrialSummary endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  

  /**
  * The date this trial ends
  * @return endDate
  **/
  @Schema(description = "The date this trial ends")
  public LocalDate getEndDate() {
    return endDate;
  }
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
  public TrialSummary programDbId(String programDbId) {
    this.programDbId = programDbId;
    return this;
  }

  

  /**
  * The ID which uniquely identifies a program
  * @return programDbId
  **/
  @Schema(description = "The ID which uniquely identifies a program")
  public String getProgramDbId() {
    return programDbId;
  }
  public void setProgramDbId(String programDbId) {
    this.programDbId = programDbId;
  }
  public TrialSummary programName(String programName) {
    this.programName = programName;
    return this;
  }

  

  /**
  * The human readable name of a program
  * @return programName
  **/
  @Schema(description = "The human readable name of a program")
  public String getProgramName() {
    return programName;
  }
  public void setProgramName(String programName) {
    this.programName = programName;
  }
  public TrialSummary startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  

  /**
  * The date this trial started
  * @return startDate
  **/
  @Schema(description = "The date this trial started")
  public LocalDate getStartDate() {
    return startDate;
  }
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
  public TrialSummary studies(List<TrialStudies> studies) {
    this.studies = studies;
    return this;
  }

  public TrialSummary addStudiesItem(TrialStudies studiesItem) {
    if (this.studies == null) {
      this.studies = new ArrayList<TrialStudies>();
    }
    this.studies.add(studiesItem);
    return this;
  }

  /**
  * List of studies inside this trial
  * @return studies
  **/
  @Schema(description = "List of studies inside this trial")
  public List<TrialStudies> getStudies() {
    return studies;
  }
  public void setStudies(List<TrialStudies> studies) {
    this.studies = studies;
  }
  public TrialSummary trialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
    return this;
  }

  

  /**
  * The ID which uniquely identifies a trial
  * @return trialDbId
  **/
  @Schema(description = "The ID which uniquely identifies a trial")
  public String getTrialDbId() {
    return trialDbId;
  }
  public void setTrialDbId(String trialDbId) {
    this.trialDbId = trialDbId;
  }
  public TrialSummary trialName(String trialName) {
    this.trialName = trialName;
    return this;
  }

  

  /**
  * The human readable name of a trial
  * @return trialName
  **/
  @Schema(description = "The human readable name of a trial")
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
    TrialSummary trialSummary = (TrialSummary) o;
    return Objects.equals(this.active, trialSummary.active) &&
        Objects.equals(this.additionalInfo, trialSummary.additionalInfo) &&
        Objects.equals(this.commonCropName, trialSummary.commonCropName) &&
        Objects.equals(this.documentationURL, trialSummary.documentationURL) &&
        Objects.equals(this.endDate, trialSummary.endDate) &&
        Objects.equals(this.programDbId, trialSummary.programDbId) &&
        Objects.equals(this.programName, trialSummary.programName) &&
        Objects.equals(this.startDate, trialSummary.startDate) &&
        Objects.equals(this.studies, trialSummary.studies) &&
        Objects.equals(this.trialDbId, trialSummary.trialDbId) &&
        Objects.equals(this.trialName, trialSummary.trialName);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(active, additionalInfo, commonCropName, documentationURL, endDate, programDbId, programName, startDate, studies, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialSummary {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    programDbId: ").append(toIndentedString(programDbId)).append("\n");
    sb.append("    programName: ").append(toIndentedString(programName)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studies: ").append(toIndentedString(studies)).append("\n");
    sb.append("    trialDbId: ").append(toIndentedString(trialDbId)).append("\n");
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
