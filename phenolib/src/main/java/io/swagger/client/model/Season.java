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
 * Season
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2018-11-15T17:05:32.234Z[GMT]")public class Season {

  @SerializedName("season")
  private String season = null;

  @SerializedName("seasonDbId")
  private String seasonDbId = null;

  @SerializedName("year")
  private String year = null;
  public Season season(String season) {
    this.season = season;
    return this;
  }

  

  /**
  * Name of the season. ex. &#x27;Spring&#x27;, &#x27;Q2&#x27;, &#x27;Season A&#x27;, etc.
  * @return season
  **/
  @Schema(description = "Name of the season. ex. 'Spring', 'Q2', 'Season A', etc.")
  public String getSeason() {
    return season;
  }
  public void setSeason(String season) {
    this.season = season;
  }
  public Season seasonDbId(String seasonDbId) {
    this.seasonDbId = seasonDbId;
    return this;
  }

  

  /**
  * The ID which uniquely identifies a season
  * @return seasonDbId
  **/
  @Schema(description = "The ID which uniquely identifies a season")
  public String getSeasonDbId() {
    return seasonDbId;
  }
  public void setSeasonDbId(String seasonDbId) {
    this.seasonDbId = seasonDbId;
  }
  public Season year(String year) {
    this.year = year;
    return this;
  }

  

  /**
  * The 4 digit year of the season.
  * @return year
  **/
  @Schema(description = "The 4 digit year of the season.")
  public String getYear() {
    return year;
  }
  public void setYear(String year) {
    this.year = year;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Season season = (Season) o;
    return Objects.equals(this.season, season.season) &&
        Objects.equals(this.seasonDbId, season.seasonDbId) &&
        Objects.equals(this.year, season.year);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(season, seasonDbId, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Season {\n");
    
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    seasonDbId: ").append(toIndentedString(seasonDbId)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
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