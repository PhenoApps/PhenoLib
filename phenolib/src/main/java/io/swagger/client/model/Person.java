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
 * Person
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Person {

  @SerializedName("description")
  private String description = null;

  @SerializedName("emailAddress")
  private String emailAddress = null;

  @SerializedName("firstName")
  private String firstName = null;

  @SerializedName("lastName")
  private String lastName = null;

  @SerializedName("mailingAddress")
  private String mailingAddress = null;

  @SerializedName("middleName")
  private String middleName = null;

  @SerializedName("personDbId")
  private String personDbId = null;

  @SerializedName("phoneNumber")
  private String phoneNumber = null;

  @SerializedName("userID")
  private String userID = null;
  public Person description(String description) {
    this.description = description;
    return this;
  }

  

  /**
  * description of this person
  * @return description
  **/
  @Schema(description = "description of this person")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Person emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  

  /**
  * email address for this person
  * @return emailAddress
  **/
  @Schema(description = "email address for this person")
  public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  public Person firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  

  /**
  * Persons first name
  * @return firstName
  **/
  @Schema(description = "Persons first name")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public Person lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  

  /**
  * Persons last name
  * @return lastName
  **/
  @Schema(description = "Persons last name")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public Person mailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
    return this;
  }

  

  /**
  * physical address of this person
  * @return mailingAddress
  **/
  @Schema(description = "physical address of this person")
  public String getMailingAddress() {
    return mailingAddress;
  }
  public void setMailingAddress(String mailingAddress) {
    this.mailingAddress = mailingAddress;
  }
  public Person middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  

  /**
  * Persons middle name
  * @return middleName
  **/
  @Schema(description = "Persons middle name")
  public String getMiddleName() {
    return middleName;
  }
  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }
  public Person personDbId(String personDbId) {
    this.personDbId = personDbId;
    return this;
  }

  

  /**
  * Unique ID for this person
  * @return personDbId
  **/
  @Schema(required = true, description = "Unique ID for this person")
  public String getPersonDbId() {
    return personDbId;
  }
  public void setPersonDbId(String personDbId) {
    this.personDbId = personDbId;
  }
  public Person phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  

  /**
  * phone number of this person
  * @return phoneNumber
  **/
  @Schema(description = "phone number of this person")
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  public Person userID(String userID) {
    this.userID = userID;
    return this;
  }

  

  /**
  * A systems user ID ascociated with this person. Different from personDbId because you could have a person who is not a user of the system.
  * @return userID
  **/
  @Schema(description = "A systems user ID ascociated with this person. Different from personDbId because you could have a person who is not a user of the system.")
  public String getUserID() {
    return userID;
  }
  public void setUserID(String userID) {
    this.userID = userID;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.description, person.description) &&
        Objects.equals(this.emailAddress, person.emailAddress) &&
        Objects.equals(this.firstName, person.firstName) &&
        Objects.equals(this.lastName, person.lastName) &&
        Objects.equals(this.mailingAddress, person.mailingAddress) &&
        Objects.equals(this.middleName, person.middleName) &&
        Objects.equals(this.personDbId, person.personDbId) &&
        Objects.equals(this.phoneNumber, person.phoneNumber) &&
        Objects.equals(this.userID, person.userID);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(description, emailAddress, firstName, lastName, mailingAddress, middleName, personDbId, phoneNumber, userID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    mailingAddress: ").append(toIndentedString(mailingAddress)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    personDbId: ").append(toIndentedString(personDbId)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
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