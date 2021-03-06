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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;

/**
 * Study
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Study {

  @SerializedName("active")
  private String active = null;

  @SerializedName("additionalInfo")
  private Map<String, String> additionalInfo = null;

  @SerializedName("commonCropName")
  private String commonCropName = null;

  @SerializedName("contacts")
  private List<Contact> contacts = null;

  @SerializedName("dataLinks")
  private List<DataLink> dataLinks = null;

  @SerializedName("documentationURL")
  private String documentationURL = null;

  @SerializedName("endDate")
  private LocalDate endDate = null;

  @SerializedName("lastUpdate")
  private StudyLastUpdate lastUpdate = null;

  @SerializedName("license")
  private String license = null;

  @SerializedName("location")
  private Location location = null;

  @SerializedName("seasons")
  private List<String> seasons = null;

  @SerializedName("startDate")
  private LocalDate startDate = null;

  @SerializedName("studyDbId")
  private String studyDbId = null;

  @SerializedName("studyDescription")
  private String studyDescription = null;

  @SerializedName("studyName")
  private String studyName = null;

  @SerializedName("studyType")
  private String studyType = null;

  @SerializedName("studyTypeDbId")
  private String studyTypeDbId = null;

  @SerializedName("studyTypeName")
  private String studyTypeName = null;

  @SerializedName("trialDbId")
  private String trialDbId = null;

  @SerializedName("trialName")
  private String trialName = null;
  public Study active(String active) {
    this.active = active;
    return this;
  }

  

  /**
  * Is this study currently active
  * @return active
  **/
  @Schema(description = "Is this study currently active")
  public String getActive() {
    return active;
  }
  public void setActive(String active) {
    this.active = active;
  }
  public Study additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  
  public Study putAdditionalInfoItem(String key, String additionalInfoItem) {
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
  public Study commonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
    return this;
  }

  

  /**
  * Common name for the crop associated with this study
  * @return commonCropName
  **/
  @Schema(description = "Common name for the crop associated with this study")
  public String getCommonCropName() {
    return commonCropName;
  }
  public void setCommonCropName(String commonCropName) {
    this.commonCropName = commonCropName;
  }
  public Study contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public Study addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<Contact>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
  * List of contact entities associated with this study
  * @return contacts
  **/
  @Schema(description = "List of contact entities associated with this study")
  public List<Contact> getContacts() {
    return contacts;
  }
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }
  public Study dataLinks(List<DataLink> dataLinks) {
    this.dataLinks = dataLinks;
    return this;
  }

  public Study addDataLinksItem(DataLink dataLinksItem) {
    if (this.dataLinks == null) {
      this.dataLinks = new ArrayList<DataLink>();
    }
    this.dataLinks.add(dataLinksItem);
    return this;
  }

  /**
  * List of links to extra data files associated with this study. Extra data could include notes, images, and reference data.
  * @return dataLinks
  **/
  @Schema(description = "List of links to extra data files associated with this study. Extra data could include notes, images, and reference data.")
  public List<DataLink> getDataLinks() {
    return dataLinks;
  }
  public void setDataLinks(List<DataLink> dataLinks) {
    this.dataLinks = dataLinks;
  }
  public Study documentationURL(String documentationURL) {
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
  public Study endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  

  /**
  * The date the study ends
  * @return endDate
  **/
  @Schema(description = "The date the study ends")
  public LocalDate getEndDate() {
    return endDate;
  }
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }
  public Study lastUpdate(StudyLastUpdate lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  

  /**
  * Get lastUpdate
  * @return lastUpdate
  **/
  @Schema(description = "")
  public StudyLastUpdate getLastUpdate() {
    return lastUpdate;
  }
  public void setLastUpdate(StudyLastUpdate lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
  public Study license(String license) {
    this.license = license;
    return this;
  }

  

  /**
  * The usage license associated with the study data
  * @return license
  **/
  @Schema(description = "The usage license associated with the study data")
  public String getLicense() {
    return license;
  }
  public void setLicense(String license) {
    this.license = license;
  }
  public Study location(Location location) {
    this.location = location;
    return this;
  }

  

  /**
  * Get location
  * @return location
  **/
  @Schema(description = "")
  public Location getLocation() {
    return location;
  }
  public void setLocation(Location location) {
    this.location = location;
  }
  public Study seasons(List<String> seasons) {
    this.seasons = seasons;
    return this;
  }

  public Study addSeasonsItem(String seasonsItem) {
    if (this.seasons == null) {
      this.seasons = new ArrayList<String>();
    }
    this.seasons.add(seasonsItem);
    return this;
  }

  /**
  * List of seasons over which this study was performed.
  * @return seasons
  **/
  @Schema(description = "List of seasons over which this study was performed.")
  public List<String> getSeasons() {
    return seasons;
  }
  public void setSeasons(List<String> seasons) {
    this.seasons = seasons;
  }
  public Study startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  

  /**
  * The date this study started
  * @return startDate
  **/
  @Schema(description = "The date this study started")
  public LocalDate getStartDate() {
    return startDate;
  }
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
  public Study studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  

  /**
  * The ID which uniquely identifies a study within the given database server
  * @return studyDbId
  **/
  @Schema(description = "The ID which uniquely identifies a study within the given database server")
  public String getStudyDbId() {
    return studyDbId;
  }
  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }
  public Study studyDescription(String studyDescription) {
    this.studyDescription = studyDescription;
    return this;
  }

  

  /**
  * The description of this study
  * @return studyDescription
  **/
  @Schema(description = "The description of this study")
  public String getStudyDescription() {
    return studyDescription;
  }
  public void setStudyDescription(String studyDescription) {
    this.studyDescription = studyDescription;
  }
  public Study studyName(String studyName) {
    this.studyName = studyName;
    return this;
  }

  

  /**
  * The human readable name for a study
  * @return studyName
  **/
  @Schema(description = "The human readable name for a study")
  public String getStudyName() {
    return studyName;
  }
  public void setStudyName(String studyName) {
    this.studyName = studyName;
  }
  public Study studyType(String studyType) {
    this.studyType = studyType;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - See \&quot;studyTypeName\&quot;
  * @return studyType
  **/
  @Schema(description = "DEPRECATED in v1.3 - See \"studyTypeName\"")
  public String getStudyType() {
    return studyType;
  }
  public void setStudyType(String studyType) {
    this.studyType = studyType;
  }
  public Study studyTypeDbId(String studyTypeDbId) {
    this.studyTypeDbId = studyTypeDbId;
    return this;
  }

  

  /**
  * The unique identifier of the type of study being performed.
  * @return studyTypeDbId
  **/
  @Schema(description = "The unique identifier of the type of study being performed.")
  public String getStudyTypeDbId() {
    return studyTypeDbId;
  }
  public void setStudyTypeDbId(String studyTypeDbId) {
    this.studyTypeDbId = studyTypeDbId;
  }
  public Study studyTypeName(String studyTypeName) {
    this.studyTypeName = studyTypeName;
    return this;
  }

  

  /**
  * The name of the type of study being performed. ex. \&quot;Yield Trial\&quot;, etc
  * @return studyTypeName
  **/
  @Schema(description = "The name of the type of study being performed. ex. \"Yield Trial\", etc")
  public String getStudyTypeName() {
    return studyTypeName;
  }
  public void setStudyTypeName(String studyTypeName) {
    this.studyTypeName = studyTypeName;
  }
  public Study trialDbId(String trialDbId) {
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
  public Study trialName(String trialName) {
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
    Study study = (Study) o;
    return Objects.equals(this.active, study.active) &&
        Objects.equals(this.additionalInfo, study.additionalInfo) &&
        Objects.equals(this.commonCropName, study.commonCropName) &&
        Objects.equals(this.contacts, study.contacts) &&
        Objects.equals(this.dataLinks, study.dataLinks) &&
        Objects.equals(this.documentationURL, study.documentationURL) &&
        Objects.equals(this.endDate, study.endDate) &&
        Objects.equals(this.lastUpdate, study.lastUpdate) &&
        Objects.equals(this.license, study.license) &&
        Objects.equals(this.location, study.location) &&
        Objects.equals(this.seasons, study.seasons) &&
        Objects.equals(this.startDate, study.startDate) &&
        Objects.equals(this.studyDbId, study.studyDbId) &&
        Objects.equals(this.studyDescription, study.studyDescription) &&
        Objects.equals(this.studyName, study.studyName) &&
        Objects.equals(this.studyType, study.studyType) &&
        Objects.equals(this.studyTypeDbId, study.studyTypeDbId) &&
        Objects.equals(this.studyTypeName, study.studyTypeName) &&
        Objects.equals(this.trialDbId, study.trialDbId) &&
        Objects.equals(this.trialName, study.trialName);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(active, additionalInfo, commonCropName, contacts, dataLinks, documentationURL, endDate, lastUpdate, license, location, seasons, startDate, studyDbId, studyDescription, studyName, studyType, studyTypeDbId, studyTypeName, trialDbId, trialName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Study {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    dataLinks: ").append(toIndentedString(dataLinks)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    license: ").append(toIndentedString(license)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    seasons: ").append(toIndentedString(seasons)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    studyDescription: ").append(toIndentedString(studyDescription)).append("\n");
    sb.append("    studyName: ").append(toIndentedString(studyName)).append("\n");
    sb.append("    studyType: ").append(toIndentedString(studyType)).append("\n");
    sb.append("    studyTypeDbId: ").append(toIndentedString(studyTypeDbId)).append("\n");
    sb.append("    studyTypeName: ").append(toIndentedString(studyTypeName)).append("\n");
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
