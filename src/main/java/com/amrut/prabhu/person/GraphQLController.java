package com.amrut.prabhu.person;

import com.amrut.prabhu.person.domain.Address;
import com.amrut.prabhu.person.domain.AddressRepository;
import com.amrut.prabhu.person.domain.Person;
import com.amrut.prabhu.person.domain.PersonRepository;
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
    public Optional<Person> getPerson(@Argument(name = "id") Integer id) {
        System.out.println("Querying Person");
        return personRepository.findById(id);
    }

    @SchemaMapping(value = "address")
    public List<Address> getAddress(Person person) {
        System.out.println("Fetching address");
        return addressRepository.findByPersonId(person.getId());
    }

    @SchemaMapping(value = "phone")
    public String getPhone(Person person) {
        System.out.println("Fetching phone");
        throw new RuntimeException("Did not find phone data");
    }


    @MutationMapping(name = "createPerson")
    public Person addPerson(@Argument(name = "person") Person person) {
        return personRepository.save(person);
    }

    @MutationMapping(name = "createAddress")
    public Address addAddress(@Argument(name = "address") Address address) {
        return addressRepository.save(address);
    }
}

