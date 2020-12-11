package com.neta.spring.api.services;

import com.neta.spring.api.repositories.dao.${model};
import com.neta.spring.api.repositories.repository.${model}Repository;
import com.neta.spring.api.applications.base.BaseService;
import com.neta.spring.api.applications.base.ServiceResolver;
import com.neta.spring.api.repositories.payload.request.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ${model}ServiceImpl extends BaseService implements ${model}Service {

    @Autowired
    protected ${model}Repository repository;

    public ServiceResolver<Boolean> save(${model} param) {
        ${model} o = repository.save(param);
        return success(true);
    }

    public ServiceResolver<Boolean> delete(${model} o) {
        repository.delete(o);
        return success(true);
    }

    public ServiceResolver<List<${model}>> list(FilterRequest request) {
        List<${model}> list = repository.findAll();
        return success(list);
    }

    public ServiceResolver<Page<${model}>> page(FilterRequest request) {
        Page<${model}> pages = repository.findAll(request.pageRequest());
        return success(pages);
    }
}
