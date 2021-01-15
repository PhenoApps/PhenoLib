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

/**
 * NewObservationsTableRequest
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class NewObservationsTableRequest {

  @SerializedName("data")
  private List<List<String>> data = null;

  @SerializedName("headerRow")
  private List<String> headerRow = null;

  @SerializedName("metadata")
  private Object metadata = null;

  @SerializedName("observationVariableDbIds")
  private List<String> observationVariableDbIds = null;

  @SerializedName("result")
  private NewObservationsTableRequestResult result = null;
  public NewObservationsTableRequest data(List<List<String>> data) {
    this.data = data;
    return this;
  }

  public NewObservationsTableRequest addDataItem(List<String> dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<List<String>>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
  * Matrix of observation data recorded for different observation variables across different observation units
  * @return data
  **/
  @Schema(description = "Matrix of observation data recorded for different observation variables across different observation units")
  public List<List<String>> getData() {
    return data;
  }
  public void setData(List<List<String>> data) {
    this.data = data;
  }
  public NewObservationsTableRequest headerRow(List<String> headerRow) {
    this.headerRow = headerRow;
    return this;
  }

  public NewObservationsTableRequest addHeaderRowItem(String headerRowItem) {
    if (this.headerRow == null) {
      this.headerRow = new ArrayList<String>();
    }
    this.headerRow.add(headerRowItem);
    return this;
  }

  /**
  * The header row describing the data matrix. Append &#x27;observationVariableDbIds&#x27; for complete header row.
  * @return headerRow
  **/
  @Schema(description = "The header row describing the data matrix. Append 'observationVariableDbIds' for complete header row.")
  public List<String> getHeaderRow() {
    return headerRow;
  }
  public void setHeaderRow(List<String> headerRow) {
    this.headerRow = headerRow;
  }
  public NewObservationsTableRequest metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  

  /**
  * DEPRECATED
  * @return metadata
  **/
  @Schema(description = "DEPRECATED")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }
  public NewObservationsTableRequest observationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
    return this;
  }

  public NewObservationsTableRequest addObservationVariableDbIdsItem(String observationVariableDbIdsItem) {
    if (this.observationVariableDbIds == null) {
      this.observationVariableDbIds = new ArrayList<String>();
    }
    this.observationVariableDbIds.add(observationVariableDbIdsItem);
    return this;
  }

  /**
  * The list of observation variables which have values recorded for them in the data matrix. Append to the &#x27;headerRow&#x27; for comlete header row.
  * @return observationVariableDbIds
  **/
  @Schema(description = "The list of observation variables which have values recorded for them in the data matrix. Append to the 'headerRow' for comlete header row.")
  public List<String> getObservationVariableDbIds() {
    return observationVariableDbIds;
  }
  public void setObservationVariableDbIds(List<String> observationVariableDbIds) {
    this.observationVariableDbIds = observationVariableDbIds;
  }
  public NewObservationsTableRequest result(NewObservationsTableRequestResult result) {
    this.result = result;
    return this;
  }

  

  /**
  * Get result
  * @return result
  **/
  @Schema(description = "")
  public NewObservationsTableRequestResult getResult() {
    return result;
  }
  public void setResult(NewObservationsTableRequestResult result) {
    this.result = result;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewObservationsTableRequest newObservationsTableRequest = (NewObservationsTableRequest) o;
    return Objects.equals(this.data, newObservationsTableRequest.data) &&
        Objects.equals(this.headerRow, newObservationsTableRequest.headerRow) &&
        Objects.equals(this.metadata, newObservationsTableRequest.metadata) &&
        Objects.equals(this.observationVariableDbIds, newObservationsTableRequest.observationVariableDbIds) &&
        Objects.equals(this.result, newObservationsTableRequest.result);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(data, headerRow, metadata, observationVariableDbIds, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationsTableRequest {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    headerRow: ").append(toIndentedString(headerRow)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    observationVariableDbIds: ").append(toIndentedString(observationVariableDbIds)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
