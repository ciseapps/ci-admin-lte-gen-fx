package com.cise.cms.core.modules.${package}.service;

import com.cise.cms.core.modules.${package}.models.${model};
import com.cise.cms.core.modules.${package}.repo.${model}Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ${model}ServiceImpl implements ${model}Service {

    private int rowSize = 10;

    @Autowired
    protected ${model}Repository repository;

    @Override
    public ${model} createOrUpdate(${model} o) {
        return repository.save(o);
    }

    @Override
    public void delete(${model} o) {
        repository.delete(o);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public ${model} findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<${model}> findAll() {
        List<${model}> target = new ArrayList<>();
        repository.findAll().forEach(target::add);
        return target;
    }

    @Override
    public Page<${model}> page(int page) {
        return repository.findAll(PageRequest.of(page, rowSize));
    }

    @Override
    public Page<${model}> page(String search, int page) {
        // return repository.findAll("%"+search+"%", PageRequest.of(page, rowSize));
        return repository.findAll(PageRequest.of(page, rowSize));
    }
}
