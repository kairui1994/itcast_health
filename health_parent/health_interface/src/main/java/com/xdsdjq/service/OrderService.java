package com.xdsdjq.service;

import com.xdsdjq.entity.Result;
import java.util.Map;

public interface OrderService {

    Result order(Map map) throws Exception;

    Map findById(Integer id);
}
