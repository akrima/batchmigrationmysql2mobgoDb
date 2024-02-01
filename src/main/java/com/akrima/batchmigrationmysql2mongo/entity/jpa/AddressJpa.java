package com.akrima.batchmigrationmysql2mongo.entity.jpa;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class AddressJpa extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long addressId;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserJpa user;

        private String street;
        private String city;
        private String state;

        @Column(name = "zip_code")
        private String zipCode;

        private String country;
        

        public AddressJpa() {
        }

        public AddressJpa(Long addressId, UserJpa user, String street, String city, String state,
                          String zipCode, String country, Date createdAt, Date updatedAt) {
                this.addressId = addressId;
                this.user = user;
                this.street = street;
                this.city = city;
                this.state = state;
                this.zipCode = zipCode;
                this.country = country;
                this.setCreatedAt(createdAt);
                this.setUpdatedAt(updatedAt);
        }

        public Long getAddressId() {
                return addressId;
        }

        public void setAddressId(Long addressId) {
                this.addressId = addressId;
        }

        public UserJpa getUser() {
                return user;
        }

        public void setUser(UserJpa user) {
                this.user = user;
        }

        public String getStreet() {
                return street;
        }

        public void setStreet(String street) {
                this.street = street;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getZipCode() {
                return zipCode;
        }

        public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
        }

        public String getCountry() {
                return country;
        }

        public void setCountry(String country) {
                this.country = country;
        }

        @Override
        public int hashCode() {
                return Objects.hash(addressId, user, street, city, state, zipCode, country, getCreatedAt(), getUpdatedAt());
        }

        @Override
        public String toString() {
                return "Address{" +
                        "addressId=" + addressId +
                        ", user=" + user +
                        ", street='" + street + '\'' +
                        ", city='" + city + '\'' +
                        ", state='" + state + '\'' +
                        ", zipCode='" + zipCode + '\'' +
                        ", country='" + country + '\'' +
                        ", createdAt=" + getCreatedAt() +
                        ", updatedAt=" + getUpdatedAt() +
                        '}';
        }
}
