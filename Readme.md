# Implementing GraphQL APIs in a Spring Boot Application

In this repo, we have implemented graphql and provided APIs to query using query operations and modify data using mutations.

This implementation makes use of Spring Boot GraphQL. 


You can read about this on my website [https://refactorfirst.com](https://refactorfirst.com)

GraphQL Specifications: https://github.com/graphql/graphql-spec

Sample GraphQL queries  used in the example.
````graphql
query get_person{
    person(id : 1){
        id
        name
        phone
        address {
            type
            street
        }
    }
}
mutation create_person{
    createPerson(person : {
        id : 1
        name: "amrut"
    }){
        id
        name
    }
}


mutation create_Address{
    createAddress(address: {
        id: 1
        personId : 1
        type : SECONDARY
        street : "some street"
    }){
        type
        street

    }
}


query getbooks{
    getBook(id:"1"){
        id
        name
    }
}

mutation BookQueryDsl{
    BookQueryDsl(book:{
        id: "2"
        name: "prabhu"
    }){
        id
        name
    }
}
````