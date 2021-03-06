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

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pedigree
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Pedigree {

  @SerializedName("crossingPlan")
  private String crossingPlan = null;

  @SerializedName("crossingYear")
  private String crossingYear = null;

  @SerializedName("defaultDisplayName")
  private String defaultDisplayName = null;

  @SerializedName("familyCode")
  private String familyCode = null;

  @SerializedName("germplasmDbId")
  private String germplasmDbId = null;

  @SerializedName("parent1DbId")
  private String parent1DbId = null;

  @SerializedName("parent1Id")
  private String parent1Id = null;

  @SerializedName("parent1Name")
  private String parent1Name = null;
  /**
   * The type of parent the first parent is. ex. &#x27;MALE&#x27;, &#x27;FEMALE&#x27;, &#x27;SELF&#x27;, &#x27;POPULATION&#x27;, etc.
   */
  @JsonAdapter(Parent1TypeEnum.Adapter.class)
  public enum Parent1TypeEnum {
    MALE("MALE"),
    FEMALE("FEMALE"),
    SELF("SELF"),
    POPULATION("POPULATION");

    private String value;

    Parent1TypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static Parent1TypeEnum fromValue(String text) {
      for (Parent1TypeEnum b : Parent1TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<Parent1TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final Parent1TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public Parent1TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return Parent1TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("parent1Type")
  private Parent1TypeEnum parent1Type = null;

  @SerializedName("parent2DbId")
  private String parent2DbId = null;

  @SerializedName("parent2Id")
  private String parent2Id = null;

  @SerializedName("parent2Name")
  private String parent2Name = null;
  /**
   * The type of parent the second parent is. ex. &#x27;MALE&#x27;, &#x27;FEMALE&#x27;, &#x27;SELF&#x27;, &#x27;POPULATION&#x27;, etc.
   */
  @JsonAdapter(Parent2TypeEnum.Adapter.class)
  public enum Parent2TypeEnum {
    MALE("MALE"),
    FEMALE("FEMALE"),
    SELF("SELF"),
    POPULATION("POPULATION");

    private String value;

    Parent2TypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static Parent2TypeEnum fromValue(String text) {
      for (Parent2TypeEnum b : Parent2TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<Parent2TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final Parent2TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public Parent2TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return Parent2TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }
  @SerializedName("parent2Type")
  private Parent2TypeEnum parent2Type = null;

  @SerializedName("pedigree")
  private String pedigree = null;

  @SerializedName("siblings")
  private List<PedigreeSiblings> siblings = null;
  public Pedigree crossingPlan(String crossingPlan) {
    this.crossingPlan = crossingPlan;
    return this;
  }

  

  /**
  * The crossing strategy used to generate this germplasm
  * @return crossingPlan
  **/
  @Schema(description = "The crossing strategy used to generate this germplasm")
  public String getCrossingPlan() {
    return crossingPlan;
  }
  public void setCrossingPlan(String crossingPlan) {
    this.crossingPlan = crossingPlan;
  }
  public Pedigree crossingYear(String crossingYear) {
    this.crossingYear = crossingYear;
    return this;
  }

  

  /**
  * The year the parents were originally crossed
  * @return crossingYear
  **/
  @Schema(description = "The year the parents were originally crossed")
  public String getCrossingYear() {
    return crossingYear;
  }
  public void setCrossingYear(String crossingYear) {
    this.crossingYear = crossingYear;
  }
  public Pedigree defaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
    return this;
  }

  

  /**
  * A human readable name for a germplasm
  * @return defaultDisplayName
  **/
  @Schema(description = "A human readable name for a germplasm")
  public String getDefaultDisplayName() {
    return defaultDisplayName;
  }
  public void setDefaultDisplayName(String defaultDisplayName) {
    this.defaultDisplayName = defaultDisplayName;
  }
  public Pedigree familyCode(String familyCode) {
    this.familyCode = familyCode;
    return this;
  }

  

  /**
  * The code representing the family
  * @return familyCode
  **/
  @Schema(description = "The code representing the family")
  public String getFamilyCode() {
    return familyCode;
  }
  public void setFamilyCode(String familyCode) {
    this.familyCode = familyCode;
  }
  public Pedigree germplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
    return this;
  }

  

  /**
  *  The ID which uniquely identifies a germplasm
  * @return germplasmDbId
  **/
  @Schema(description = " The ID which uniquely identifies a germplasm")
  public String getGermplasmDbId() {
    return germplasmDbId;
  }
  public void setGermplasmDbId(String germplasmDbId) {
    this.germplasmDbId = germplasmDbId;
  }
  public Pedigree parent1DbId(String parent1DbId) {
    this.parent1DbId = parent1DbId;
    return this;
  }

  

  /**
  * The germplasm DbId of the first parent of this germplasm
  * @return parent1DbId
  **/
  @Schema(description = "The germplasm DbId of the first parent of this germplasm")
  public String getParent1DbId() {
    return parent1DbId;
  }
  public void setParent1DbId(String parent1DbId) {
    this.parent1DbId = parent1DbId;
  }
  public Pedigree parent1Id(String parent1Id) {
    this.parent1Id = parent1Id;
    return this;
  }

  

  /**
  * **Deprecated** use parent1DbId
  * @return parent1Id
  **/
  @Schema(description = "**Deprecated** use parent1DbId")
  public String getParent1Id() {
    return parent1Id;
  }
  public void setParent1Id(String parent1Id) {
    this.parent1Id = parent1Id;
  }
  public Pedigree parent1Name(String parent1Name) {
    this.parent1Name = parent1Name;
    return this;
  }

  

  /**
  * the human readable name of the first parent of this germplasm
  * @return parent1Name
  **/
  @Schema(description = "the human readable name of the first parent of this germplasm")
  public String getParent1Name() {
    return parent1Name;
  }
  public void setParent1Name(String parent1Name) {
    this.parent1Name = parent1Name;
  }
  public Pedigree parent1Type(Parent1TypeEnum parent1Type) {
    this.parent1Type = parent1Type;
    return this;
  }

  

  /**
  * The type of parent the first parent is. ex. &#x27;MALE&#x27;, &#x27;FEMALE&#x27;, &#x27;SELF&#x27;, &#x27;POPULATION&#x27;, etc.
  * @return parent1Type
  **/
  @Schema(description = "The type of parent the first parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.")
  public Parent1TypeEnum getParent1Type() {
    return parent1Type;
  }
  public void setParent1Type(Parent1TypeEnum parent1Type) {
    this.parent1Type = parent1Type;
  }
  public Pedigree parent2DbId(String parent2DbId) {
    this.parent2DbId = parent2DbId;
    return this;
  }

  

  /**
  * The germplasm DbId of the second parent of this germplasm
  * @return parent2DbId
  **/
  @Schema(description = "The germplasm DbId of the second parent of this germplasm")
  public String getParent2DbId() {
    return parent2DbId;
  }
  public void setParent2DbId(String parent2DbId) {
    this.parent2DbId = parent2DbId;
  }
  public Pedigree parent2Id(String parent2Id) {
    this.parent2Id = parent2Id;
    return this;
  }

  

  /**
  * **Deprecated** use parent2DbId
  * @return parent2Id
  **/
  @Schema(description = "**Deprecated** use parent2DbId")
  public String getParent2Id() {
    return parent2Id;
  }
  public void setParent2Id(String parent2Id) {
    this.parent2Id = parent2Id;
  }
  public Pedigree parent2Name(String parent2Name) {
    this.parent2Name = parent2Name;
    return this;
  }

  

  /**
  * The human readable name of the second parent of this germplasm
  * @return parent2Name
  **/
  @Schema(description = "The human readable name of the second parent of this germplasm")
  public String getParent2Name() {
    return parent2Name;
  }
  public void setParent2Name(String parent2Name) {
    this.parent2Name = parent2Name;
  }
  public Pedigree parent2Type(Parent2TypeEnum parent2Type) {
    this.parent2Type = parent2Type;
    return this;
  }

  

  /**
  * The type of parent the second parent is. ex. &#x27;MALE&#x27;, &#x27;FEMALE&#x27;, &#x27;SELF&#x27;, &#x27;POPULATION&#x27;, etc.
  * @return parent2Type
  **/
  @Schema(description = "The type of parent the second parent is. ex. 'MALE', 'FEMALE', 'SELF', 'POPULATION', etc.")
  public Parent2TypeEnum getParent2Type() {
    return parent2Type;
  }
  public void setParent2Type(Parent2TypeEnum parent2Type) {
    this.parent2Type = parent2Type;
  }
  public Pedigree pedigree(String pedigree) {
    this.pedigree = pedigree;
    return this;
  }

  

  /**
  * The string representation of the pedigree.
  * @return pedigree
  **/
  @Schema(description = "The string representation of the pedigree.")
  public String getPedigree() {
    return pedigree;
  }
  public void setPedigree(String pedigree) {
    this.pedigree = pedigree;
  }
  public Pedigree siblings(List<PedigreeSiblings> siblings) {
    this.siblings = siblings;
    return this;
  }

  public Pedigree addSiblingsItem(PedigreeSiblings siblingsItem) {
    if (this.siblings == null) {
      this.siblings = new ArrayList<PedigreeSiblings>();
    }
    this.siblings.add(siblingsItem);
    return this;
  }

  /**
  * List of sibling germplasm 
  * @return siblings
  **/
  @Schema(description = "List of sibling germplasm ")
  public List<PedigreeSiblings> getSiblings() {
    return siblings;
  }
  public void setSiblings(List<PedigreeSiblings> siblings) {
    this.siblings = siblings;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pedigree pedigree = (Pedigree) o;
    return Objects.equals(this.crossingPlan, pedigree.crossingPlan) &&
        Objects.equals(this.crossingYear, pedigree.crossingYear) &&
        Objects.equals(this.defaultDisplayName, pedigree.defaultDisplayName) &&
        Objects.equals(this.familyCode, pedigree.familyCode) &&
        Objects.equals(this.germplasmDbId, pedigree.germplasmDbId) &&
        Objects.equals(this.parent1DbId, pedigree.parent1DbId) &&
        Objects.equals(this.parent1Id, pedigree.parent1Id) &&
        Objects.equals(this.parent1Name, pedigree.parent1Name) &&
        Objects.equals(this.parent1Type, pedigree.parent1Type) &&
        Objects.equals(this.parent2DbId, pedigree.parent2DbId) &&
        Objects.equals(this.parent2Id, pedigree.parent2Id) &&
        Objects.equals(this.parent2Name, pedigree.parent2Name) &&
        Objects.equals(this.parent2Type, pedigree.parent2Type) &&
        Objects.equals(this.pedigree, pedigree.pedigree) &&
        Objects.equals(this.siblings, pedigree.siblings);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(crossingPlan, crossingYear, defaultDisplayName, familyCode, germplasmDbId, parent1DbId, parent1Id, parent1Name, parent1Type, parent2DbId, parent2Id, parent2Name, parent2Type, pedigree, siblings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pedigree {\n");
    
    sb.append("    crossingPlan: ").append(toIndentedString(crossingPlan)).append("\n");
    sb.append("    crossingYear: ").append(toIndentedString(crossingYear)).append("\n");
    sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
    sb.append("    familyCode: ").append(toIndentedString(familyCode)).append("\n");
    sb.append("    germplasmDbId: ").append(toIndentedString(germplasmDbId)).append("\n");
    sb.append("    parent1DbId: ").append(toIndentedString(parent1DbId)).append("\n");
    sb.append("    parent1Id: ").append(toIndentedString(parent1Id)).append("\n");
    sb.append("    parent1Name: ").append(toIndentedString(parent1Name)).append("\n");
    sb.append("    parent1Type: ").append(toIndentedString(parent1Type)).append("\n");
    sb.append("    parent2DbId: ").append(toIndentedString(parent2DbId)).append("\n");
    sb.append("    parent2Id: ").append(toIndentedString(parent2Id)).append("\n");
    sb.append("    parent2Name: ").append(toIndentedString(parent2Name)).append("\n");
    sb.append("    parent2Type: ").append(toIndentedString(parent2Type)).append("\n");
    sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
    sb.append("    siblings: ").append(toIndentedString(siblings)).append("\n");
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
