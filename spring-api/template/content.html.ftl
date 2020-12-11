<div th:fragment="content" xmlns:th="http://www.w3.org/1999/xhtml" class="content-wrapper">
    <div class="row">
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${module} Table</h4>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8">
                                <a th:href="@{~/${path}/form}" class="btn btn-success mr-2">Add</a>
                            </div>
                            <div class="col-md-4">
                                <input th:value="${r"${search}"}" id="search-key" type="text" class="form-control pull-right" placeholder="Search">
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="action">Action</th>
                                <#list viewTableModel as cvalue>
                                <#if cvalue.key == 'PRI'>
                                <#elseif cvalue.field == 'status'>
                                <#else>
                                <th>${cvalue.fieldJavaSetGet}</th>
                                </#if>
                                </#list>
                            </tr>
                            </thead>
                            <tbody>
                            <tr th:if="${r"${page.content.empty}"}">
                                <td colspan="5"> No Data Available</td>
                            </tr>
                            <tr th:each="row : ${r"${page.content}"}">
                                <td class="action">
                                    <div>
                                        <a th:href="@{~/${path}/form?id=} + ${r"${row."}${pk}}" class="btn btn-warning mr-2"><i class="fa fa-edit"></i></a>
                                        <a href="javascript:void(0)" th:data-id="${r"${row."}${pk}}" th:data-user="${r"${row."}${pk}}" onclick="deleteConfirm(this.getAttribute('data-id'), this.getAttribute('data-user'));" class="btn btn-danger"><i class="fa fa-window-close"></i></a>
                                    </div>
                                </td>
                                <#list viewTableModel as cvalue>
                                <#if cvalue.key == 'PRI'>
                                <#elseif cvalue.field == 'status'>
                                <#else>
                                <td th:text="${r"${row."}${cvalue.field}}"></td>
                                </#if>
                                </#list>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="pageable pull-right"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script th:inline="javascript">

        function deleteConfirm(id, user, product){
            swal({
                title: "Are you sure delete " + id + "?",
                text: "Once deleted, you will not be able to recover this data!",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            }).then((willDelete) => {
                if (willDelete) {
                    $.ajax({
                        url: /*[[@{~/${path}/delete}]]*/,
                        type: "POST",
                        data: JSON.stringify({${pk}: id}),
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        success: function(){
                            document.location.reload(true);
                        }
                    });
                } else {
                    swal("Your row is safe!");
                }
            });
        };

        const keySearch = $('#search-key').val();
        const totalPage = /*[[${r"${page.totalPages}"}]]*/;
        var startPage = /*[[(${r"${page.number}"} + 1)]]*/;

        if ((totalPage + 1) > 1 && totalPage < startPage) {
            window.location.replace(/*[+[[@{~/${path}}]] + '?page=' + (totalPage)+]*/);
        } else {
            $('.pageable').twbsPagination({
                totalPages: (totalPage == 0 ? totalPage + 1 : totalPage),
                startPage:  startPage,
                initiateStartPageClick: false,
                onPageClick: function (evt, page) {
                    if (keySearch == "") {
                        window.location.replace(/*[+[[@{~/${path}}]] + '?page=' + (page)+]*/);
                    } else {
                        window.location.replace(/*[+[[@{~/${path}}]] + '?page=' + (page)+'&search='+keySearch+]*/);
                    }
                }
            });
        }

        $('#search-key').keydown(function(e) {
            var key = e.which;
            if (key == 13) {
                var keySearch = $(this).val();
                if (keySearch !== "") {
                    window.location.replace(/*[+[[@{~/${path}}]] + '?search=' + keySearch+]*/);
                } else {
                    window.location.replace(/*[+[[@{~/${path}}]] +]*/);
                }
            }
        });

    </script>
</div>