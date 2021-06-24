package com.jiten.junitmockitotest.services;

import java.util.List;

public interface ITodoService {
    List<String> getTodos(String filterBy);
}
