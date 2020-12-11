package com.neta.spring.api.modules.${package}.controllers;

import com.neta.spring.api.applications.base.BaseRestController;
import com.neta.spring.api.services.${model}Service;
import com.neta.spring.api.applications.base.ServiceResolver;
import com.neta.spring.api.repositories.dao.${model};
import com.neta.spring.api.repositories.payload.request.FilterRequest;
import com.neta.spring.api.repositories.payload.response.PageResponse;
import com.neta.spring.api.repositories.payload.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/${path}")
@SuppressWarnings({"unchecked", "rawtypes"})
public class ${controllerFileName} extends BaseRestController {

    @Autowired
    ${model}Service ${path}Service;

    @PostMapping("/save")
    public ResponseEntity<Response> save(@RequestBody ${model} request) {
         ServiceResolver<Boolean> resolver = ${path}Service.save(request);
         return response(resolver);
    }

    @PostMapping("/delete")
    public ResponseEntity<Response> delete(@RequestBody ${model} request) {
        ServiceResolver<Boolean> resolver = ${path}Service.delete(request);
        return response(resolver);
    }

    @PostMapping("/list")
    public ResponseEntity<Response<List<${model}>>> list(@RequestBody FilterRequest request) {
         ServiceResolver<List<${model}>> resolver = ${path}Service.list(request);
         return response(resolver);
    }

    @PostMapping("/page")
    public ResponseEntity<PageResponse> delete(@RequestBody FilterRequest o) {
        ServiceResolver<Page<${model}>> resolver = ${path}Service.page(o);
        return responsePage(resolver);
    }
}
