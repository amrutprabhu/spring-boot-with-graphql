

GraphQL schema : https://github.com/graphql/graphql-spec


````graphql
query get_person{
    person(id : 2){
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