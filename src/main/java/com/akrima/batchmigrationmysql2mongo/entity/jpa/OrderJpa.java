package com.akrima.batchmigrationmysql2mongo.entity.jpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrderJpa extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "order_id")
        private Long orderId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserJpa user;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "order_date")
        private Date orderDate;

        private Double totalAmount;
        private String status;
        public OrderJpa() {
        }

        public OrderJpa(Long orderId, UserJpa user, Date orderDate, Double totalAmount,
                        String status, Date createdAt, Date updatedAt) {
                this.orderId = orderId;
                this.user = user;
                this.orderDate = orderDate;
                this.totalAmount = totalAmount;
                this.status = status;
                this.setCreatedAt(createdAt);
                this.setUpdatedAt(updatedAt);
        }

        public Long getOrderId() {
                return orderId;
        }

        public void setOrderId(Long orderId) {
                this.orderId = orderId;
        }

        public UserJpa getUser() {
                return user;
        }

        public void setUser(UserJpa user) {
                this.user = user;
        }

        public Date getOrderDate() {
                return orderDate;
        }

        public void setOrderDate(Date orderDate) {
                this.orderDate = orderDate;
        }

        public Double getTotalAmount() {
                return totalAmount;
        }

        public void setTotalAmount(Double totalAmount) {
                this.totalAmount = totalAmount;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        @Override
        public int hashCode() {
                return Objects.hash(orderId, user, orderDate, totalAmount, status, getCreatedAt(), getUpdatedAt());
        }

        @Override
        public String toString() {
                return "OrderJpa{" +
                        "orderId=" + orderId +
                        ", user=" + user +
                        ", orderDate=" + orderDate +
                        ", totalAmount=" + totalAmount +
                        ", status='" + status + '\'' +
                        ", createdAt=" + getCreatedAt() +
                        ", updatedAt=" + getUpdatedAt() +
                        '}';
        }
}
