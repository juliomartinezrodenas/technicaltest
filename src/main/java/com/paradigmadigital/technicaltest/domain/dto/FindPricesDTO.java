package com.paradigmadigital.technicaltest.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * FindPricesDTO
 */
@Validated
public class FindPricesDTO {

  @JsonProperty("productId")
  private Integer productId = null;

  @JsonProperty("brandId")
  private Integer brandId = null;

  @JsonProperty("date")
  private OffsetDateTime date = null;

  public FindPricesDTO productId(Integer productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Product Id that the prices returned must match
   *
   * @return productId
   **/
  @Schema(description = "Product Id that the prices returned must match")

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public FindPricesDTO brandId(Integer brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Brand Id that the prices returned must match
   *
   * @return brandId
   **/
  @Schema(description = "Brand Id that the prices returned must match")

  public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  public FindPricesDTO date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Date in which the price is applicable. If the date is later or equal to the price's start date
   * and previous or equal to the end date then it will be matched
   *
   * @return date
   **/
  @Schema(description = "Date in which the price is applicable. If the date is later or equal to the price's start date and previous or equal to the end date then it will be matched")

  @Valid
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FindPricesDTO findPricesDTO = (FindPricesDTO) o;
    return Objects.equals(this.productId, findPricesDTO.productId) &&
        Objects.equals(this.brandId, findPricesDTO.brandId) &&
        Objects.equals(this.date, findPricesDTO.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FindPricesDTO {\n");

    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first
   * line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
