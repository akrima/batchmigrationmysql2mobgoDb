package com.akrima.batchmigrationmysql2mongo.entity.jpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "order_items")
public class OrderItemJpa extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long orderItemId;

        @ManyToOne
        @JoinColumn(name = "order_id")
        private OrderJpa order;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private ProductJpa product;

        private Integer quantity;
        private Double subtotal;
        public OrderItemJpa() {
        }

        public OrderItemJpa(Long orderItemId, OrderJpa order, ProductJpa product, Integer quantity,
                            Double subtotal, Date createdAt, Date updatedAt) {
                this.orderItemId = orderItemId;
                this.order = order;
                this.product = product;
                this.quantity = quantity;
                this.subtotal = subtotal;
                this.setCreatedAt(createdAt);
                this.setUpdatedAt(updatedAt);
        }

        public Long getOrderItemId() {
                return orderItemId;
        }

        public void setOrderItemId(Long orderItemId) {
                this.orderItemId = orderItemId;
        }

        public OrderJpa getOrder() {
                return order;
        }

        public void setOrder(OrderJpa order) {
                this.order = order;
        }

        public ProductJpa getProduct() {
                return product;
        }

        public void setProduct(ProductJpa product) {
                this.product = product;
        }

        public Integer getQuantity() {
                return quantity;
        }

        public void setQuantity(Integer quantity) {
                this.quantity = quantity;
        }

        public Double getSubtotal() {
                return subtotal;
        }

        public void setSubtotal(Double subtotal) {
                this.subtotal = subtotal;
        }

        @Override
        public int hashCode() {
                return Objects.hash(orderItemId, order, product, quantity, subtotal, getCreatedAt(), getUpdatedAt());
        }

        @Override
        public String toString() {
                return "OrderItemJpa{" +
                        "orderItemId=" + orderItemId +
                        ", order=" + order +
                        ", product=" + product +
                        ", quantity=" + quantity +
                        ", subtotal=" + subtotal +
                        ", createdAt=" + getCreatedAt() +
                        ", updatedAt=" + getUpdatedAt() +
                        '}';
        }
}
