package com.amrut.prabhu.person;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @QueryMapping(value = "person")
    public Optional<Person> getPerson(@Argument(name = "id") Integer id, DataFetchingEnvironment dataFetchingEnvironment) {
        System.out.println("Querying Person");
        return personRepository.findById(id);
    }

    @SchemaMapping
    public List<Address> address(Person person) {
        System.out.println("Fetching address");
        return addressRepository.findByPersonId(person.getId());
    }

    @SchemaMapping
    public String phone(Person person) {
        System.out.println("Fetching phone");
        throw new RuntimeException("Did not find phone data");
    }



    @MutationMapping(name = "createPerson")
    public Person createPerson(@Argument(name = "person") Person person) {
        personRepository.save(person);
        return person;
    }

    @MutationMapping(name = "createAddress")
    public Address createAddress(@Argument(name = "address") Address address) {
        return addressRepository.save(address);
    }
}

