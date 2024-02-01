package com.akrima.batchmigrationmysql2mongo.entity.jpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductJpa extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private Long productId;

        private String name;
        private String description;
        private Double price;
        private Integer stockQuantity;

        public ProductJpa() {
        }

        public ProductJpa(Long productId, String name, String description, Double price,
                          Integer stockQuantity, Date createdAt, Date updatedAt) {
                this.productId = productId;
                this.name = name;
                this.description = description;
                this.price = price;
                this.stockQuantity = stockQuantity;
                setCreatedAt(createdAt);
                setUpdatedAt(updatedAt);
        }

        public Long getProductId() {
                return productId;
        }

        public void setProductId(Long productId) {
                this.productId = productId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }

        public Integer getStockQuantity() {
                return stockQuantity;
        }

        public void setStockQuantity(Integer stockQuantity) {
                this.stockQuantity = stockQuantity;
        }

        @Override
        public int hashCode() {
                return Objects.hash(productId, name, description, price, stockQuantity, this.getCreatedAt(), this.getUpdatedAt());
        }

        @Override
        public String toString() {
                return "ProductJpa{" +
                        "productId=" + productId +
                        ", name='" + name + '\'' +
                        ", description='" + description + '\'' +
                        ", price=" + price +
                        ", stockQuantity=" + stockQuantity +
                        ", createdAt=" + this.getCreatedAt() +
                        ", updatedAt=" + this.getUpdatedAt() +
                        '}';
        }
}
