package com.jiten.junitmockitotest.services;

        import java.util.Arrays;
        import java.util.List;

public class ExternalServiceStub implements  IExternalService {
    @Override
    public List<String> getTodos(String filter) {
        return Arrays.asList("Spring MVC STUB","Spring Core STUB", "Spring Cloud STUB","Java STUB", "Postgres STUB","JDBC STUB");
    }
}
