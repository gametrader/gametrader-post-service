/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.gametrader.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gametrader.api.model.PostDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * InlineObject1
 */
@JsonPropertyOrder({
  InlineObject1.JSON_PROPERTY_DTO,
  InlineObject1.JSON_PROPERTY_FILES
})
@JsonTypeName("inline_object_1")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-24T17:48:16.859401900+02:00[Europe/Belgrade]")
public class InlineObject1 {
  public static final String JSON_PROPERTY_DTO = "dto";
  private PostDto dto;

  public static final String JSON_PROPERTY_FILES = "files";
  private Set<File> files = new LinkedHashSet<>();


  public InlineObject1 dto(PostDto dto) {
    
    this.dto = dto;
    return this;
  }

   /**
   * Get dto
   * @return dto
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DTO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PostDto getDto() {
    return dto;
  }


  @JsonProperty(JSON_PROPERTY_DTO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDto(PostDto dto) {
    this.dto = dto;
  }


  public InlineObject1 files(Set<File> files) {
    
    this.files = files;
    return this;
  }

  public InlineObject1 addFilesItem(File filesItem) {
    this.files.add(filesItem);
    return this;
  }

   /**
   * Get files
   * @return files
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_FILES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Set<File> getFiles() {
    return files;
  }


  @JsonProperty(JSON_PROPERTY_FILES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFiles(Set<File> files) {
    this.files = files;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject1 inlineObject1 = (InlineObject1) o;
    return Objects.equals(this.dto, inlineObject1.dto) &&
        Objects.equals(this.files, inlineObject1.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dto, files);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject1 {\n");
    sb.append("    dto: ").append(toIndentedString(dto)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

