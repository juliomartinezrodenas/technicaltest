package com.paradigmadigital.technicaltest.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Price
 */
@Validated
public class Price {
    @JsonProperty("priceId")
    private Integer priceId = null;

    @JsonProperty("brandId")
    private Integer brandId = null;

    @JsonProperty("productId")
    private Integer productId = null;

    @JsonProperty("startDate")
    private OffsetDateTime startDate = null;

    @JsonProperty("endDate")
    private OffsetDateTime endDate = null;

    @JsonProperty("priority")
    private BigDecimal priority = null;

    @JsonProperty("price")
    private Double price = null;

    @JsonProperty("currency")
    private String currency = null;

    public Price priceId(Integer priceId) {
        this.priceId = priceId;
        return this;
    }

    /**
     * Identifier of the Price object. Must be unique
     *
     * @return priceId
     **/
    @Schema(required = true, description = "Identifier of the Price object. Must be unique")
    @NotNull

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Price brandId(Integer brandId) {
        this.brandId = brandId;
        return this;
    }

    /**
     * Identifier of the price's brand
     *
     * @return brandId
     **/
    @Schema(required = true, description = "Identifier of the price's brand")
    @NotNull

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Price productId(Integer productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Identifier of the price's product
     *
     * @return productId
     **/
    @Schema(required = true, description = "Identifier of the price's product")
    @NotNull

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Price startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The price's application start date
     *
     * @return startDate
     **/
    @Schema(required = true, description = "The price's application start date")
    @NotNull

    @Valid
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public Price endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The price's application end date
     *
     * @return endDate
     **/
    @Schema(required = true, description = "The price's application end date")
    @NotNull

    @Valid
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public Price priority(BigDecimal priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Priority value of the Price. Higher value prices will be shown first in the response
     *
     * @return priority
     **/
    @Schema(required = true, description = "Priority value of the Price. Higher value prices will be shown first in the response")
    @NotNull

    @Valid
    public BigDecimal getPriority() {
        return priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    public Price price(Double price) {
        this.price = price;
        return this;
    }

    /**
     * Amount value of the price
     *
     * @return price
     **/
    @Schema(required = true, description = "Amount value of the price")
    @NotNull

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Price currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * ISO-4217 currency code of the price's amount
     *
     * @return currency
     **/
    @Schema(required = true, description = "ISO-4217 currency code of the price's amount")
    @NotNull

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return Objects.equals(this.priceId, price.priceId) &&
                Objects.equals(this.brandId, price.brandId) &&
                Objects.equals(this.productId, price.productId) &&
                Objects.equals(this.startDate, price.startDate) &&
                Objects.equals(this.endDate, price.endDate) &&
                Objects.equals(this.priority, price.priority) &&
                Objects.equals(this.price, price.price) &&
                Objects.equals(this.currency, price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceId, brandId, productId, startDate, endDate, priority, price, currency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Price {\n");

        sb.append("    priceId: ").append(toIndentedString(priceId)).append("\n");
        sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
