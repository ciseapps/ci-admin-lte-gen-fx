<div th:fragment="content" xmlns:th="http://www.w3.org/1999/xhtml" class="content-wrapper">
    <script th:inline="javascript">
        window.history.forward(0);
    </script>
    <div class="row">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${module} Form</h4>
                    <form class="form-sample" th:action="@{~/${path}/save}" th:object="${r"${"}${path}}" method="post">
                        <#list viewTableModel as cvalue>
                        <#if cvalue.key == 'PRI'>
                        <input th:if="*{${cvalue.field} > 0}" type="hidden" th:field="*{${cvalue.field}}"/>
                        <#elseif cvalue.field == 'status'>
                        <#elseif cvalue.field == 'createdBy'>
                        <#elseif cvalue.field == 'createdDate'>
                        <#elseif cvalue.field == 'modifiedBy'>
                        <#elseif cvalue.field == 'modifiedDate'>
                        <#else>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">${cvalue.fieldJavaSetGet}</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" th:field="*{${cvalue.field}}">
                                    </div>
                                    <span class="col-sm-3 col-form-label" th:if="${r"${#fields.hasErrors('"}${cvalue.field}')}"></span>
                                    <span class="col-sm-9 error error-field text-danger" th:if="${r"${#fields.hasErrors('"}${cvalue.field}')}" th:errors="*{${cvalue.field}}"></span>
                                </div>
                            </div>
                        </div>
                        </#if>
                        </#list>
                        <button type="submit" class="btn btn-success mr-2">Submit</button>
                        <button type="button" onclick="cancel()" class="btn btn-light">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script th:inline="javascript">

        function cancel() {
            window.location.replace(/*[[@{~/${path}}]]*/);
        }

    </script>
</div>
