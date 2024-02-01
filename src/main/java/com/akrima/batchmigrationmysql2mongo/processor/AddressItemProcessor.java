package com.akrima.batchmigrationmysql2mongo.processor;


import com.akrima.batchmigrationmysql2mongo.entity.mongo.AddressMongo;
import com.akrima.batchmigrationmysql2mongo.entity.jpa.AddressJpa;
import org.springframework.batch.item.ItemProcessor;

public class AddressItemProcessor implements ItemProcessor<AddressJpa, AddressMongo> {

    @Override
    public AddressMongo process(AddressJpa addressJpa) {
        // We can apply here any kind of transformation before insertion to cassandra DB
        System.out.println("");
        return new AddressMongo(
                addressJpa.getAddressId().toString(),
                addressJpa.getUser().getUserId().toString(),
                addressJpa.getStreet(),
                addressJpa.getCity(),
                addressJpa.getState(),
                addressJpa.getZipCode(),
                addressJpa.getCountry(),
                addressJpa.getCreatedAt(),
                addressJpa.getUpdatedAt());
    }
}
