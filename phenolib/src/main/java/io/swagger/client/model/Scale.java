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
 * Scale metadata
 */
@Schema(description = "Scale metadata")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Scale {

  @SerializedName("dataType")
  private TraitDataType dataType = null;

  @SerializedName("decimalPlaces")
  private Integer decimalPlaces = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("ontologyRefernce")
  private OntologyRefernce ontologyRefernce = null;

  @SerializedName("scaleDbId")
  private String scaleDbId = null;

  @SerializedName("scaleName")
  private String scaleName = null;

  @SerializedName("validValues")
  private ValidValues validValues = null;

  @SerializedName("xref")
  private String xref = null;
  public Scale dataType(TraitDataType dataType) {
    this.dataType = dataType;
    return this;
  }

  

  /**
  * Get dataType
  * @return dataType
  **/
  @Schema(description = "")
  public TraitDataType getDataType() {
    return dataType;
  }
  public void setDataType(TraitDataType dataType) {
    this.dataType = dataType;
  }
  public Scale decimalPlaces(Integer decimalPlaces) {
    this.decimalPlaces = decimalPlaces;
    return this;
  }

  

  /**
  * For numerical, number of decimal places to be reported
  * @return decimalPlaces
  **/
  @Schema(description = "For numerical, number of decimal places to be reported")
  public Integer getDecimalPlaces() {
    return decimalPlaces;
  }
  public void setDecimalPlaces(Integer decimalPlaces) {
    this.decimalPlaces = decimalPlaces;
  }
  public Scale name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - Use \&quot;scaleName\&quot;
  * @return name
  **/
  @Schema(description = "DEPRECATED in v1.3 - Use \"scaleName\"")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Scale ontologyRefernce(OntologyRefernce ontologyRefernce) {
    this.ontologyRefernce = ontologyRefernce;
    return this;
  }

  

  /**
  * Get ontologyRefernce
  * @return ontologyRefernce
  **/
  @Schema(description = "")
  public OntologyRefernce getOntologyRefernce() {
    return ontologyRefernce;
  }
  public void setOntologyRefernce(OntologyRefernce ontologyRefernce) {
    this.ontologyRefernce = ontologyRefernce;
  }
  public Scale scaleDbId(String scaleDbId) {
    this.scaleDbId = scaleDbId;
    return this;
  }

  

  /**
  * Unique identifier of the scale. If left blank, the upload system will automatically generate a scale ID.
  * @return scaleDbId
  **/
  @Schema(description = "Unique identifier of the scale. If left blank, the upload system will automatically generate a scale ID.")
  public String getScaleDbId() {
    return scaleDbId;
  }
  public void setScaleDbId(String scaleDbId) {
    this.scaleDbId = scaleDbId;
  }
  public Scale scaleName(String scaleName) {
    this.scaleName = scaleName;
    return this;
  }

  

  /**
  * Name of the scale
  * @return scaleName
  **/
  @Schema(description = "Name of the scale")
  public String getScaleName() {
    return scaleName;
  }
  public void setScaleName(String scaleName) {
    this.scaleName = scaleName;
  }
  public Scale validValues(ValidValues validValues) {
    this.validValues = validValues;
    return this;
  }

  

  /**
  * Get validValues
  * @return validValues
  **/
  @Schema(description = "")
  public ValidValues getValidValues() {
    return validValues;
  }
  public void setValidValues(ValidValues validValues) {
    this.validValues = validValues;
  }
  public Scale xref(String xref) {
    this.xref = xref;
    return this;
  }

  

  /**
  * Cross reference to the scale, for example to a unit ontology such as UO or to a unit of an external major database
  * @return xref
  **/
  @Schema(description = "Cross reference to the scale, for example to a unit ontology such as UO or to a unit of an external major database")
  public String getXref() {
    return xref;
  }
  public void setXref(String xref) {
    this.xref = xref;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scale scale = (Scale) o;
    return Objects.equals(this.dataType, scale.dataType) &&
        Objects.equals(this.decimalPlaces, scale.decimalPlaces) &&
        Objects.equals(this.name, scale.name) &&
        Objects.equals(this.ontologyRefernce, scale.ontologyRefernce) &&
        Objects.equals(this.scaleDbId, scale.scaleDbId) &&
        Objects.equals(this.scaleName, scale.scaleName) &&
        Objects.equals(this.validValues, scale.validValues) &&
        Objects.equals(this.xref, scale.xref);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(dataType, decimalPlaces, name, ontologyRefernce, scaleDbId, scaleName, validValues, xref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scale {\n");
    
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    decimalPlaces: ").append(toIndentedString(decimalPlaces)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ontologyRefernce: ").append(toIndentedString(ontologyRefernce)).append("\n");
    sb.append("    scaleDbId: ").append(toIndentedString(scaleDbId)).append("\n");
    sb.append("    scaleName: ").append(toIndentedString(scaleName)).append("\n");
    sb.append("    validValues: ").append(toIndentedString(validValues)).append("\n");
    sb.append("    xref: ").append(toIndentedString(xref)).append("\n");
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
