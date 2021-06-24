package com.jiten.junitmockitotest.services;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TodoService implements ITodoService {

    private IExternalService externalService;

    public TodoService(IExternalService externalService) {
        this.externalService = externalService;
    }

    @Override
    public List<String> getTodos(String filterBy) {

        List<String> todos = externalService.getTodos(filterBy);

        String filterByLowerCase = filterBy.toLowerCase();

        return todos.stream()
                .filter(it ->  {
                    return it.toLowerCase().contains(filterByLowerCase);
                })
                .collect(Collectors.toList());
    }
}
