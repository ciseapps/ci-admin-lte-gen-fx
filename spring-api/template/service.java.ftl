package com.neta.spring.api.services;

import com.neta.spring.api.repositories.dao.${model};
import com.neta.spring.api.applications.base.ServiceResolver;
import com.neta.spring.api.repositories.payload.request.FilterRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ${model}Service {

    ServiceResolver<Boolean> save(${model} request);

    ServiceResolver<Boolean> delete(${model} request);

    ServiceResolver<List<${model}>> list(FilterRequest request);

    ServiceResolver<Page<${model}>> page(FilterRequest request);

}
