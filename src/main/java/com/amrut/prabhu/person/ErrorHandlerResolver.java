package com.amrut.prabhu.person;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ErrorHandlerResolver extends DataFetcherExceptionResolverAdapter {
    @Override
    protected List<GraphQLError> resolveToMultipleErrors(Throwable ex, DataFetchingEnvironment env) {
        GraphQLError build = GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .build();
        return Arrays.asList(build);
    }
}
