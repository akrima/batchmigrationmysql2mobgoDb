package com.akrima.batchmigrationmysql2mongo.entity.jpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class UserJpa extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        private Long userId;

        @Column
        private String username;

        @Column
        private String email;

        @Column
        private String password;

        @Column
        private String firstName;

        @Column
        private String lastName;

        public UserJpa() {
        }

        public UserJpa(Long userId, String username, String email, String password, String firstName, String lastName, Date createdAt, Date updatedAt) {
                this.userId = userId;
                this.username = username;
                this.email = email;
                this.password = password;
                this.firstName = firstName;
                this.lastName = lastName;
                this.setCreatedAt(createdAt);
                this.setUpdatedAt(updatedAt);
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
}

