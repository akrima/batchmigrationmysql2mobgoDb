package com.akrima.batchmigrationmysql2mongo.entity.jpa;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class CommentJpa extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long commentId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserJpa user;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private ProductJpa product;

        @Column(name = "comment_text")
        private String commentText;
        
        public CommentJpa() {
        }
        
        public CommentJpa(Long commentId, UserJpa user, ProductJpa product, String commentText,
                          Date createdAt, Date updatedAt) {
                this.commentId = commentId;
                this.user = user;
                this.product = product;
                this.commentText = commentText;
                this.setCreatedAt(createdAt);
                this.setUpdatedAt(updatedAt);
        }

        public Long getCommentId() {
                return commentId;
        }

        public void setCommentId(Long commentId) {
                this.commentId = commentId;
        }

        public UserJpa getUser() {
                return user;
        }

        public void setUser(UserJpa user) {
                this.user = user;
        }

        public ProductJpa getProduct() {
                return product;
        }

        public void setProduct(ProductJpa product) {
                this.product = product;
        }

        public String getCommentText() {
                return commentText;
        }

        public void setCommentText(String commentText) {
                this.commentText = commentText;
        }

        @Override
        public int hashCode() {
                return Objects.hash(commentId, user, product, commentText, getCreatedAt(), getUpdatedAt());
        }

        @Override
        public String toString() {
                return "CommentJpa{" +
                        "commentId=" + commentId +
                        ", user=" + user +
                        ", product=" + product +
                        ", commentText='" + commentText + '\'' +
                        ", createdAt=" + getCreatedAt() +
                        ", updatedAt=" + getUpdatedAt() +
                        '}';
        }
}
