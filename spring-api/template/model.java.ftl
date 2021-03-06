package com.neta.spring.api.repositories.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.neta.spring.api.applications.base.BaseEntity;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

<#list viewTableModel as cvalue>
    <#if cvalue.typeForJava == "Date">
import java.util.Date;
        <#break>
    </#if>
</#list>

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "${table}")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ${model} extends BaseEntity {
    <#list viewTableModel as cvalue>
    <#if cvalue.key == 'PRI'>

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ${cvalue.typeForJava} ${cvalue.field};
    <#elseif cvalue.field == 'status'>
    <#elseif cvalue.field == 'createdBy'>
    <#elseif cvalue.field == 'createdDate'>
    <#elseif cvalue.field == 'modifiedBy'>
    <#elseif cvalue.field == 'modifiedDate'>
    <#else>

    private ${cvalue.typeForJava} ${cvalue.field};
    </#if>
    </#list>
    <#list viewTableModel as cvalue>
    <#if cvalue.field == 'status'>
    <#elseif cvalue.field == 'createdBy'>
    <#elseif cvalue.field == 'createdDate'>
    <#elseif cvalue.field == 'modifiedBy'>
    <#elseif cvalue.field == 'modifiedDate'>
    </#if>
    </#list>

}
