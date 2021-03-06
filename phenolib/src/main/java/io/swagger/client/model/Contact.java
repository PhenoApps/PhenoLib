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
 * Contact
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Contact {

  @SerializedName("contactDbId")
  private String contactDbId = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("instituteName")
  private String instituteName = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("orcid")
  private String orcid = null;

  @SerializedName("type")
  private String type = null;
  public Contact contactDbId(String contactDbId) {
    this.contactDbId = contactDbId;
    return this;
  }

  

  /**
  * The ID which uniquely identifies this contact
  * @return contactDbId
  **/
  @Schema(required = true, description = "The ID which uniquely identifies this contact")
  public String getContactDbId() {
    return contactDbId;
  }
  public void setContactDbId(String contactDbId) {
    this.contactDbId = contactDbId;
  }
  public Contact email(String email) {
    this.email = email;
    return this;
  }

  

  /**
  * The contacts email address 
  * @return email
  **/
  @Schema(description = "The contacts email address ")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Contact instituteName(String instituteName) {
    this.instituteName = instituteName;
    return this;
  }

  

  /**
  * The name of the institution which this contact is part of
  * @return instituteName
  **/
  @Schema(description = "The name of the institution which this contact is part of")
  public String getInstituteName() {
    return instituteName;
  }
  public void setInstituteName(String instituteName) {
    this.instituteName = instituteName;
  }
  public Contact name(String name) {
    this.name = name;
    return this;
  }

  

  /**
  * The full name of this contact person
  * @return name
  **/
  @Schema(description = "The full name of this contact person")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Contact orcid(String orcid) {
    this.orcid = orcid;
    return this;
  }

  

  /**
  * The Open Researcher and Contributor ID for this contact person (orcid.org)
  * @return orcid
  **/
  @Schema(description = "The Open Researcher and Contributor ID for this contact person (orcid.org)")
  public String getOrcid() {
    return orcid;
  }
  public void setOrcid(String orcid) {
    this.orcid = orcid;
  }
  public Contact type(String type) {
    this.type = type;
    return this;
  }

  

  /**
  * The type of person this contact represents (ex: Coordinator, Scientist, PI, etc.)
  * @return type
  **/
  @Schema(description = "The type of person this contact represents (ex: Coordinator, Scientist, PI, etc.)")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.contactDbId, contact.contactDbId) &&
        Objects.equals(this.email, contact.email) &&
        Objects.equals(this.instituteName, contact.instituteName) &&
        Objects.equals(this.name, contact.name) &&
        Objects.equals(this.orcid, contact.orcid) &&
        Objects.equals(this.type, contact.type);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(contactDbId, email, instituteName, name, orcid, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    contactDbId: ").append(toIndentedString(contactDbId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    instituteName: ").append(toIndentedString(instituteName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orcid: ").append(toIndentedString(orcid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
