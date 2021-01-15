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
 * StudyType
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class StudyType {

  @SerializedName("description")
  private String description = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("studyTypeDbId")
  private String studyTypeDbId = null;

  @SerializedName("studyTypeName")
  private String studyTypeName = null;
  public StudyType description(String description) {
    this.description = description;
    return this;
  }

  

  /**
  * The description of this study type
  * @return description
  **/
  @Schema(description = "The description of this study type")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public StudyType name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - Use \&quot;studyTypeName\&quot;
  * @return name
  **/
  @Schema(description = "DEPRECATED in v1.3 - Use \"studyTypeName\"")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public StudyType studyTypeDbId(String studyTypeDbId) {
    this.studyTypeDbId = studyTypeDbId;
    return this;
  }

  

  /**
  * The unique identifier of a study type
  * @return studyTypeDbId
  **/
  @Schema(description = "The unique identifier of a study type")
  public String getStudyTypeDbId() {
    return studyTypeDbId;
  }
  public void setStudyTypeDbId(String studyTypeDbId) {
    this.studyTypeDbId = studyTypeDbId;
  }
  public StudyType studyTypeName(String studyTypeName) {
    this.studyTypeName = studyTypeName;
    return this;
  }

  

  /**
  * The human readable name of a study type
  * @return studyTypeName
  **/
  @Schema(description = "The human readable name of a study type")
  public String getStudyTypeName() {
    return studyTypeName;
  }
  public void setStudyTypeName(String studyTypeName) {
    this.studyTypeName = studyTypeName;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudyType studyType = (StudyType) o;
    return Objects.equals(this.description, studyType.description) &&
        Objects.equals(this.name, studyType.name) &&
        Objects.equals(this.studyTypeDbId, studyType.studyTypeDbId) &&
        Objects.equals(this.studyTypeName, studyType.studyTypeName);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(description, name, studyTypeDbId, studyTypeName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudyType {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    studyTypeDbId: ").append(toIndentedString(studyTypeDbId)).append("\n");
    sb.append("    studyTypeName: ").append(toIndentedString(studyTypeName)).append("\n");
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
