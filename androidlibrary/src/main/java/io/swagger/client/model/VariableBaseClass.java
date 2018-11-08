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
import io.swagger.client.model.Method;
import io.swagger.client.model.OntologyRefernce;
import io.swagger.client.model.Scale;
import io.swagger.client.model.Trait;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * VariableBaseClass
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-05T16:01:47.919Z[GMT]")public class VariableBaseClass {

  @SerializedName("contextOfUse")
  private List<String> contextOfUse = null;

  @SerializedName("crop")
  private String crop = null;

  @SerializedName("defaultValue")
  private String defaultValue = null;

  @SerializedName("documentationURL")
  private String documentationURL = null;

  @SerializedName("growthStage")
  private String growthStage = null;

  @SerializedName("institution")
  private String institution = null;

  @SerializedName("language")
  private String language = null;

  @SerializedName("method")
  private Method method = null;

  @SerializedName("ontologyDbId")
  private String ontologyDbId = null;

  @SerializedName("ontologyName")
  private String ontologyName = null;

  @SerializedName("ontologyRefernce")
  private OntologyRefernce ontologyRefernce = null;

  @SerializedName("scale")
  private Scale scale = null;

  @SerializedName("scientist")
  private String scientist = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("submissionTimestamp")
  private OffsetDateTime submissionTimestamp = null;

  @SerializedName("synonyms")
  private List<String> synonyms = null;

  @SerializedName("trait")
  private Trait trait = null;

  @SerializedName("xref")
  private String xref = null;
  public VariableBaseClass contextOfUse(List<String> contextOfUse) {
    this.contextOfUse = contextOfUse;
    return this;
  }

  public VariableBaseClass addContextOfUseItem(String contextOfUseItem) {
    if (this.contextOfUse == null) {
      this.contextOfUse = new ArrayList<String>();
    }
    this.contextOfUse.add(contextOfUseItem);
    return this;
  }

  /**
  * Indication of how trait is routinely used. (examples: [\&quot;Trial evaluation\&quot;, \&quot;Nursery evaluation\&quot;])
  * @return contextOfUse
  **/
  @Schema(description = "Indication of how trait is routinely used. (examples: [\"Trial evaluation\", \"Nursery evaluation\"])")
  public List<String> getContextOfUse() {
    return contextOfUse;
  }
  public void setContextOfUse(List<String> contextOfUse) {
    this.contextOfUse = contextOfUse;
  }
  public VariableBaseClass crop(String crop) {
    this.crop = crop;
    return this;
  }

  

  /**
  * Crop name (examples: \&quot;Maize\&quot;, \&quot;Wheat\&quot;)
  * @return crop
  **/
  @Schema(description = "Crop name (examples: \"Maize\", \"Wheat\")")
  public String getCrop() {
    return crop;
  }
  public void setCrop(String crop) {
    this.crop = crop;
  }
  public VariableBaseClass defaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  

  /**
  * Variable default value. (examples: \&quot;red\&quot;, \&quot;2.3\&quot;, etc.)
  * @return defaultValue
  **/
  @Schema(description = "Variable default value. (examples: \"red\", \"2.3\", etc.)")
  public String getDefaultValue() {
    return defaultValue;
  }
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
  public VariableBaseClass documentationURL(String documentationURL) {
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
  public VariableBaseClass growthStage(String growthStage) {
    this.growthStage = growthStage;
    return this;
  }

  

  /**
  * Growth stage at which measurement is made (examples: \&quot;flowering\&quot;)
  * @return growthStage
  **/
  @Schema(description = "Growth stage at which measurement is made (examples: \"flowering\")")
  public String getGrowthStage() {
    return growthStage;
  }
  public void setGrowthStage(String growthStage) {
    this.growthStage = growthStage;
  }
  public VariableBaseClass institution(String institution) {
    this.institution = institution;
    return this;
  }

  

  /**
  * Name of institution submitting the variable
  * @return institution
  **/
  @Schema(description = "Name of institution submitting the variable")
  public String getInstitution() {
    return institution;
  }
  public void setInstitution(String institution) {
    this.institution = institution;
  }
  public VariableBaseClass language(String language) {
    this.language = language;
    return this;
  }

  

  /**
  * 2 letter ISO code for the language of submission of the variable.
  * @return language
  **/
  @Schema(description = "2 letter ISO code for the language of submission of the variable.")
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public VariableBaseClass method(Method method) {
    this.method = method;
    return this;
  }

  

  /**
  * Get method
  * @return method
  **/
  @Schema(required = true, description = "")
  public Method getMethod() {
    return method;
  }
  public void setMethod(Method method) {
    this.method = method;
  }
  public VariableBaseClass ontologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - see \&quot;this.ontologyRefernce.ontologyDbId\&quot;
  * @return ontologyDbId
  **/
  @Schema(description = "DEPRECATED in v1.3 - see \"this.ontologyRefernce.ontologyDbId\"")
  public String getOntologyDbId() {
    return ontologyDbId;
  }
  public void setOntologyDbId(String ontologyDbId) {
    this.ontologyDbId = ontologyDbId;
  }
  public VariableBaseClass ontologyName(String ontologyName) {
    this.ontologyName = ontologyName;
    return this;
  }

  

  /**
  * DEPRECATED in v1.3 - see \&quot;this.ontologyRefernce.ontologyName\&quot;
  * @return ontologyName
  **/
  @Schema(description = "DEPRECATED in v1.3 - see \"this.ontologyRefernce.ontologyName\"")
  public String getOntologyName() {
    return ontologyName;
  }
  public void setOntologyName(String ontologyName) {
    this.ontologyName = ontologyName;
  }
  public VariableBaseClass ontologyRefernce(OntologyRefernce ontologyRefernce) {
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
  public VariableBaseClass scale(Scale scale) {
    this.scale = scale;
    return this;
  }

  

  /**
  * Get scale
  * @return scale
  **/
  @Schema(required = true, description = "")
  public Scale getScale() {
    return scale;
  }
  public void setScale(Scale scale) {
    this.scale = scale;
  }
  public VariableBaseClass scientist(String scientist) {
    this.scientist = scientist;
    return this;
  }

  

  /**
  * Name of scientist submitting the variable.
  * @return scientist
  **/
  @Schema(description = "Name of scientist submitting the variable.")
  public String getScientist() {
    return scientist;
  }
  public void setScientist(String scientist) {
    this.scientist = scientist;
  }
  public VariableBaseClass status(String status) {
    this.status = status;
    return this;
  }

  

  /**
  * Variable status. (examples: \&quot;recommended\&quot;, \&quot;obsolete\&quot;, \&quot;legacy\&quot;, etc.)
  * @return status
  **/
  @Schema(description = "Variable status. (examples: \"recommended\", \"obsolete\", \"legacy\", etc.)")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public VariableBaseClass submissionTimestamp(OffsetDateTime submissionTimestamp) {
    this.submissionTimestamp = submissionTimestamp;
    return this;
  }

  

  /**
  * Timestamp when the Variable was added (ISO 8601)
  * @return submissionTimestamp
  **/
  @Schema(description = "Timestamp when the Variable was added (ISO 8601)")
  public OffsetDateTime getSubmissionTimestamp() {
    return submissionTimestamp;
  }
  public void setSubmissionTimestamp(OffsetDateTime submissionTimestamp) {
    this.submissionTimestamp = submissionTimestamp;
  }
  public VariableBaseClass synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public VariableBaseClass addSynonymsItem(String synonymsItem) {
    if (this.synonyms == null) {
      this.synonyms = new ArrayList<String>();
    }
    this.synonyms.add(synonymsItem);
    return this;
  }

  /**
  * Other variable names
  * @return synonyms
  **/
  @Schema(description = "Other variable names")
  public List<String> getSynonyms() {
    return synonyms;
  }
  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }
  public VariableBaseClass trait(Trait trait) {
    this.trait = trait;
    return this;
  }

  

  /**
  * Get trait
  * @return trait
  **/
  @Schema(required = true, description = "")
  public Trait getTrait() {
    return trait;
  }
  public void setTrait(Trait trait) {
    this.trait = trait;
  }
  public VariableBaseClass xref(String xref) {
    this.xref = xref;
    return this;
  }

  

  /**
  * Cross reference of the variable term to a term from an external ontology or to a database of a major system.
  * @return xref
  **/
  @Schema(description = "Cross reference of the variable term to a term from an external ontology or to a database of a major system.")
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
    VariableBaseClass variableBaseClass = (VariableBaseClass) o;
    return Objects.equals(this.contextOfUse, variableBaseClass.contextOfUse) &&
        Objects.equals(this.crop, variableBaseClass.crop) &&
        Objects.equals(this.defaultValue, variableBaseClass.defaultValue) &&
        Objects.equals(this.documentationURL, variableBaseClass.documentationURL) &&
        Objects.equals(this.growthStage, variableBaseClass.growthStage) &&
        Objects.equals(this.institution, variableBaseClass.institution) &&
        Objects.equals(this.language, variableBaseClass.language) &&
        Objects.equals(this.method, variableBaseClass.method) &&
        Objects.equals(this.ontologyDbId, variableBaseClass.ontologyDbId) &&
        Objects.equals(this.ontologyName, variableBaseClass.ontologyName) &&
        Objects.equals(this.ontologyRefernce, variableBaseClass.ontologyRefernce) &&
        Objects.equals(this.scale, variableBaseClass.scale) &&
        Objects.equals(this.scientist, variableBaseClass.scientist) &&
        Objects.equals(this.status, variableBaseClass.status) &&
        Objects.equals(this.submissionTimestamp, variableBaseClass.submissionTimestamp) &&
        Objects.equals(this.synonyms, variableBaseClass.synonyms) &&
        Objects.equals(this.trait, variableBaseClass.trait) &&
        Objects.equals(this.xref, variableBaseClass.xref);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(contextOfUse, crop, defaultValue, documentationURL, growthStage, institution, language, method, ontologyDbId, ontologyName, ontologyRefernce, scale, scientist, status, submissionTimestamp, synonyms, trait, xref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariableBaseClass {\n");
    
    sb.append("    contextOfUse: ").append(toIndentedString(contextOfUse)).append("\n");
    sb.append("    crop: ").append(toIndentedString(crop)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    growthStage: ").append(toIndentedString(growthStage)).append("\n");
    sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    ontologyDbId: ").append(toIndentedString(ontologyDbId)).append("\n");
    sb.append("    ontologyName: ").append(toIndentedString(ontologyName)).append("\n");
    sb.append("    ontologyRefernce: ").append(toIndentedString(ontologyRefernce)).append("\n");
    sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
    sb.append("    scientist: ").append(toIndentedString(scientist)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    submissionTimestamp: ").append(toIndentedString(submissionTimestamp)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    trait: ").append(toIndentedString(trait)).append("\n");
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