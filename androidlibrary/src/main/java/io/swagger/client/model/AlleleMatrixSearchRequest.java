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
 * AlleleMatrixSearchRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-05T16:01:47.919Z[GMT]")public class AlleleMatrixSearchRequest {

  @SerializedName("expandHomozygotes")
  private Boolean expandHomozygotes = null;

  @SerializedName("format")
  private String format = null;

  @SerializedName("markerDbId")
  private List<String> markerDbId = null;

  @SerializedName("markerProfileDbId")
  private List<String> markerProfileDbId = null;

  @SerializedName("markerprofileDbId")
  private List<String> markerprofileDbId = null;

  @SerializedName("matrixDbId")
  private List<String> matrixDbId = null;

  @SerializedName("page")
  private Integer page = null;

  @SerializedName("pageSize")
  private Integer pageSize = null;

  @SerializedName("sepPhased")
  private String sepPhased = null;

  @SerializedName("sepUnphased")
  private String sepUnphased = null;

  @SerializedName("unknownString")
  private String unknownString = null;
  public AlleleMatrixSearchRequest expandHomozygotes(Boolean expandHomozygotes) {
    this.expandHomozygotes = expandHomozygotes;
    return this;
  }

  

  /**
  * Should homozygotes be expanded (true) or collapsed into a single occurence (false)
  * @return expandHomozygotes
  **/
  @Schema(description = "Should homozygotes be expanded (true) or collapsed into a single occurence (false)")
  public Boolean isExpandHomozygotes() {
    return expandHomozygotes;
  }
  public void setExpandHomozygotes(Boolean expandHomozygotes) {
    this.expandHomozygotes = expandHomozygotes;
  }
  public AlleleMatrixSearchRequest format(String format) {
    this.format = format;
    return this;
  }

  

  /**
  * The data format of the response data. ie \&quot;json\&quot;, \&quot;tsv\&quot;, etc
  * @return format
  **/
  @Schema(description = "The data format of the response data. ie \"json\", \"tsv\", etc")
  public String getFormat() {
    return format;
  }
  public void setFormat(String format) {
    this.format = format;
  }
  public AlleleMatrixSearchRequest markerDbId(List<String> markerDbId) {
    this.markerDbId = markerDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMarkerDbIdItem(String markerDbIdItem) {
    if (this.markerDbId == null) {
      this.markerDbId = new ArrayList<String>();
    }
    this.markerDbId.add(markerDbIdItem);
    return this;
  }

  /**
  * An ID which uniquely identifies a Marker
  * @return markerDbId
  **/
  @Schema(description = "An ID which uniquely identifies a Marker")
  public List<String> getMarkerDbId() {
    return markerDbId;
  }
  public void setMarkerDbId(List<String> markerDbId) {
    this.markerDbId = markerDbId;
  }
  public AlleleMatrixSearchRequest markerProfileDbId(List<String> markerProfileDbId) {
    this.markerProfileDbId = markerProfileDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMarkerProfileDbIdItem(String markerProfileDbIdItem) {
    if (this.markerProfileDbId == null) {
      this.markerProfileDbId = new ArrayList<String>();
    }
    this.markerProfileDbId.add(markerProfileDbIdItem);
    return this;
  }

  /**
  * An ID which uniquely identifies a Marker Profile
  * @return markerProfileDbId
  **/
  @Schema(description = "An ID which uniquely identifies a Marker Profile")
  public List<String> getMarkerProfileDbId() {
    return markerProfileDbId;
  }
  public void setMarkerProfileDbId(List<String> markerProfileDbId) {
    this.markerProfileDbId = markerProfileDbId;
  }
  public AlleleMatrixSearchRequest markerprofileDbId(List<String> markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMarkerprofileDbIdItem(String markerprofileDbIdItem) {
    if (this.markerprofileDbId == null) {
      this.markerprofileDbId = new ArrayList<String>();
    }
    this.markerprofileDbId.add(markerprofileDbIdItem);
    return this;
  }

  /**
  * DEPRECATED in v1.3 - see \&quot;markerProfileDbId\&quot; (camel case)
  * @return markerprofileDbId
  **/
  @Schema(description = "DEPRECATED in v1.3 - see \"markerProfileDbId\" (camel case)")
  public List<String> getMarkerprofileDbId() {
    return markerprofileDbId;
  }
  public void setMarkerprofileDbId(List<String> markerprofileDbId) {
    this.markerprofileDbId = markerprofileDbId;
  }
  public AlleleMatrixSearchRequest matrixDbId(List<String> matrixDbId) {
    this.matrixDbId = matrixDbId;
    return this;
  }

  public AlleleMatrixSearchRequest addMatrixDbIdItem(String matrixDbIdItem) {
    if (this.matrixDbId == null) {
      this.matrixDbId = new ArrayList<String>();
    }
    this.matrixDbId.add(matrixDbIdItem);
    return this;
  }

  /**
  * An ID which uniquely identifies an Allele Matrix
  * @return matrixDbId
  **/
  @Schema(description = "An ID which uniquely identifies an Allele Matrix")
  public List<String> getMatrixDbId() {
    return matrixDbId;
  }
  public void setMatrixDbId(List<String> matrixDbId) {
    this.matrixDbId = matrixDbId;
  }
  public AlleleMatrixSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

  

  /**
  * Which page of the \&quot;data\&quot; array to return. The page indexing starts at 0 (page&#x3D;0 will return the first page). Default is 0.
  * @return page
  **/
  @Schema(description = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")
  public Integer getPage() {
    return page;
  }
  public void setPage(Integer page) {
    this.page = page;
  }
  public AlleleMatrixSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  

  /**
  * The maximum number of items to return per page of the \&quot;data\&quot; array. Default is 1000.
  * @return pageSize
  **/
  @Schema(description = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")
  public Integer getPageSize() {
    return pageSize;
  }
  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
  public AlleleMatrixSearchRequest sepPhased(String sepPhased) {
    this.sepPhased = sepPhased;
    return this;
  }

  

  /**
  * The string to use as a separator for phased allele calls.
  * @return sepPhased
  **/
  @Schema(description = "The string to use as a separator for phased allele calls.")
  public String getSepPhased() {
    return sepPhased;
  }
  public void setSepPhased(String sepPhased) {
    this.sepPhased = sepPhased;
  }
  public AlleleMatrixSearchRequest sepUnphased(String sepUnphased) {
    this.sepUnphased = sepUnphased;
    return this;
  }

  

  /**
  * The string to use as a separator for unphased allele calls.
  * @return sepUnphased
  **/
  @Schema(description = "The string to use as a separator for unphased allele calls.")
  public String getSepUnphased() {
    return sepUnphased;
  }
  public void setSepUnphased(String sepUnphased) {
    this.sepUnphased = sepUnphased;
  }
  public AlleleMatrixSearchRequest unknownString(String unknownString) {
    this.unknownString = unknownString;
    return this;
  }

  

  /**
  * The string to use as a representation for missing data.
  * @return unknownString
  **/
  @Schema(description = "The string to use as a representation for missing data.")
  public String getUnknownString() {
    return unknownString;
  }
  public void setUnknownString(String unknownString) {
    this.unknownString = unknownString;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlleleMatrixSearchRequest alleleMatrixSearchRequest = (AlleleMatrixSearchRequest) o;
    return Objects.equals(this.expandHomozygotes, alleleMatrixSearchRequest.expandHomozygotes) &&
        Objects.equals(this.format, alleleMatrixSearchRequest.format) &&
        Objects.equals(this.markerDbId, alleleMatrixSearchRequest.markerDbId) &&
        Objects.equals(this.markerProfileDbId, alleleMatrixSearchRequest.markerProfileDbId) &&
        Objects.equals(this.markerprofileDbId, alleleMatrixSearchRequest.markerprofileDbId) &&
        Objects.equals(this.matrixDbId, alleleMatrixSearchRequest.matrixDbId) &&
        Objects.equals(this.page, alleleMatrixSearchRequest.page) &&
        Objects.equals(this.pageSize, alleleMatrixSearchRequest.pageSize) &&
        Objects.equals(this.sepPhased, alleleMatrixSearchRequest.sepPhased) &&
        Objects.equals(this.sepUnphased, alleleMatrixSearchRequest.sepUnphased) &&
        Objects.equals(this.unknownString, alleleMatrixSearchRequest.unknownString);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(expandHomozygotes, format, markerDbId, markerProfileDbId, markerprofileDbId, matrixDbId, page, pageSize, sepPhased, sepUnphased, unknownString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlleleMatrixSearchRequest {\n");
    
    sb.append("    expandHomozygotes: ").append(toIndentedString(expandHomozygotes)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    markerDbId: ").append(toIndentedString(markerDbId)).append("\n");
    sb.append("    markerProfileDbId: ").append(toIndentedString(markerProfileDbId)).append("\n");
    sb.append("    markerprofileDbId: ").append(toIndentedString(markerprofileDbId)).append("\n");
    sb.append("    matrixDbId: ").append(toIndentedString(matrixDbId)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    sepPhased: ").append(toIndentedString(sepPhased)).append("\n");
    sb.append("    sepUnphased: ").append(toIndentedString(sepUnphased)).append("\n");
    sb.append("    unknownString: ").append(toIndentedString(unknownString)).append("\n");
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
