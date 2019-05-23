package com.cise.cms.core.modules.${package}.models;

import com.cise.cms.core.applications.base.BaseModelSignature;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
<#list viewTableModel as cvalue>
    <#if cvalue.typeForJava == "Date">
import java.util.Date;
        <#break>
    </#if>
</#list>

@Entity
@Table(name = "${table}")
public class ${model} extends BaseModelSignature {
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
    <#else>

    public void set${cvalue.fieldJavaSetGet}(${cvalue.typeForJava} ${cvalue.field}) {
        this.${cvalue.field} = ${cvalue.field};
    }

    public ${cvalue.typeForJava} get${cvalue.fieldJavaSetGet}(){
        return ${cvalue.field};
    }
    </#if>
    </#list>

}
