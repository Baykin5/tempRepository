package com.example.webpos.rest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A product.
 */

@Schema(name = "Product", description = "A product.")
@JsonTypeName("Product")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-27T22:23:35.437517400+08:00[Asia/Shanghai]")
public class ProductDto {

  @JsonProperty("id")
  private String id;

  @JsonProperty("tid")
  private String tid;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("category")
  private String category;

  @JsonProperty("quantity")
  private Integer quantity;

  @JsonProperty("name")
  private String name;

  @JsonProperty("stock")
  private Integer stock;

  @JsonProperty("img")
  private String img;

  public ProductDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the product.
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "The ID of the product.", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductDto tid(String tid) {
    this.tid = tid;
    return this;
  }

  /**
   * Get tid
   * @return tid
  */
  @NotNull 
  @Schema(name = "tid", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTid() {
    return tid;
  }

  public void setTid(String tid) {
    this.tid = tid;
  }

  public ProductDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * The price of the product.
   * @return price
  */
  @NotNull 
  @Schema(name = "price", description = "The price of the product.", requiredMode = Schema.RequiredMode.REQUIRED)
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public ProductDto category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @NotNull 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public ProductDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @NotNull 
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the product.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "The name of the product.", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDto stock(Integer stock) {
    this.stock = stock;
    return this;
  }

  /**
   * Get stock
   * @return stock
  */
  @NotNull 
  @Schema(name = "stock", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public ProductDto img(String img) {
    this.img = img;
    return this;
  }

  /**
   * The image of the product.
   * @return img
  */
  @NotNull 
  @Schema(name = "img", description = "The image of the product.", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto product = (ProductDto) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.tid, product.tid) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.category, product.category) &&
        Objects.equals(this.quantity, product.quantity) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.stock, product.stock) &&
        Objects.equals(this.img, product.img);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tid, price, category, quantity, name, stock, img);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tid: ").append(toIndentedString(tid)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    stock: ").append(toIndentedString(stock)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
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

