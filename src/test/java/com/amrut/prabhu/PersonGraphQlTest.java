package com.amrut.prabhu;

import com.amrut.prabhu.person.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

@SpringBootTest
@AutoConfigureGraphQlTester
public class PersonGraphQlTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldAddPersonAndQueryBack() {
        this.graphQlTester.documentName("person-mutation")
                .execute()
                .path("createPerson.name")
                .entity(String.class).isEqualTo("amrut");

        this.graphQlTester.documentName("person-query")
                .variable("id", 1)
                .execute()
                .path("person.name")
                .entity(String.class).isEqualTo("amrut");
    }


    @Test
    void shouldAddPersonAndQueryReturnsErrors() {
        this.graphQlTester.documentName("person-mutation")
                .execute()
                .path("createPerson.name")
                .entity(String.class).isEqualTo("amrut");

        this.graphQlTester.documentName("person-with-errors-query")
                .variable("id", 1)
                .execute()
                .errors()
                    .expect( error -> error.getMessage().equals("Did not find phone data"))
                .verify()
                .path("person.name")
                    .entity(String.class)
                    .isEqualTo("amrut")
                .path("person.address")
                    .entity(new ParameterizedTypeReference<List<Address>>(){})
                    .satisfies(addresses -> addresses.isEmpty());
    }

}
