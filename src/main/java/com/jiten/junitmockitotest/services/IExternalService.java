package com.jiten.junitmockitotest.services;

import java.util.List;

public interface IExternalService {

    List<String> getTodos(String filter);
}
