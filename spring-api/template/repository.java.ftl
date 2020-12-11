package com.neta.spring.api.repositories.repository;

import com.neta.spring.api.repositories.dao.${model};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ${model}Repository extends JpaRepository<${model}, Long>, JpaSpecificationExecutor<${model}> {

}
