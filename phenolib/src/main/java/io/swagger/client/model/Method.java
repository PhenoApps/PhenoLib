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
 * Method metadata
 */
@Schema(description = "Method metadata")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Method {

  @SerializedName("class")
  private String propertyClass = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("formula")
  private String formula = null;

  @SerializedName("methodDbId")
  private String methodDbId = null;

  @SerializedName("methodName")
  private String methodName = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("ontologyRefernce")
  private OntologyRefernce ontologyRefernce = null;

  @SerializedName("reference")
  private String reference = null;
  public Method propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

  

  /**
  * Method class (examples: \&quot;Measurement\&quot;, \&quot;Counting\&quot;, \&quot;Estimation\&quot;, \&quot;Computation\&quot;, etc.
  * @return propertyClass
  **/
  @Schema(description = "Method class (examples: \"Measurement\", \"Counting\", \"Estimation\", \"Computation\", etc.")
  public String getPropertyClass() {
    return propertyClass;
  }
  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }
  public Method description(String description) {
    this.description = description;
    return this;
  }

  

  /**
  * Method description.
  * @return description
  **/
  @Schema(description = "Method description.")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Method formula(String formula) {
    this.formula = formula;
    return this;
  }

  

  /**
  * For computational methods i.e., when the method consists in assessing the trait by computing measurements, write the generic formula used for the calculation
  * @return formula
  **/
  @Schema(description = "For computational methods i.e., when the method consists in assessing the trait by computing measurements, write the generic formula used for the calculation")
  public String getFormula() {
    return formula;
  }
  public void setFormula(String formula) {
    this.formula = formula;
  }
  public Method methodDbId(String methodDbId) {
    this.methodDbId = methodDbId;
    return this;
  }

  

  /**
  * Method unique identifier
  * @return methodDbId
  **/
  @Schema(description = "Method unique identifier")
  public String getMethodDbId() {
    return methodDbId;
  }
  public void setMethodDbId(String methodDbId) {
    this.methodDbId = methodDbId;
  }
  public Method methodName(String methodName) {
    this.methodName = methodName;
    return this;
  }

  

  /**
  * Human readable name for the method
  * @return methodName
  **/
  @Schema(description = "Human readable name for the method")
  public String getMethodName() {
    return methodName;
  }
  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }
  public Method name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - Use \&quot;methodName\&quot;
  * @return name
  **/
  @Schema(description = "DEPRECATED in v1.3 - Use \"methodName\"")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Method ontologyRefernce(OntologyRefernce ontologyRefernce) {
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
  public Method reference(String reference) {
    this.reference = reference;
    return this;
  }

  

  /**
  * Bibliographical reference describing the method.
  * @return reference
  **/
  @Schema(description = "Bibliographical reference describing the method.")
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Method method = (Method) o;
    return Objects.equals(this.propertyClass, method.propertyClass) &&
        Objects.equals(this.description, method.description) &&
        Objects.equals(this.formula, method.formula) &&
        Objects.equals(this.methodDbId, method.methodDbId) &&
        Objects.equals(this.methodName, method.methodName) &&
        Objects.equals(this.name, method.name) &&
        Objects.equals(this.ontologyRefernce, method.ontologyRefernce) &&
        Objects.equals(this.reference, method.reference);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(propertyClass, description, formula, methodDbId, methodName, name, ontologyRefernce, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Method {\n");
    
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
    sb.append("    methodDbId: ").append(toIndentedString(methodDbId)).append("\n");
    sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ontologyRefernce: ").append(toIndentedString(ontologyRefernce)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
