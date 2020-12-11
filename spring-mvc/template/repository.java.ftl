package com.cise.cms.core.modules.${package}.repo;

import com.cise.cms.core.modules.${package}.models.${model};
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ${model}Repository extends CrudRepository<${model}, Long> {

    Page<${model}> findAll(Pageable pageable);

}
