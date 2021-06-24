package com.jiten.junitmockitotest.services;

import java.util.Arrays;
import java.util.List;

public class ExternalService implements  IExternalService {
    @Override
    public List<String> getTodos(String filter) {
        return Arrays.asList("Spring MVC","Spring Core", "Spring Cloud","Java", "Postgres","JDBC");
    }
}
