<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        ${title} <small>Control panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> ${title}</a></li>
        <li class="active">Form</li>
    </ol>
</section>

<!-- Main content -->
<section id="content-main" class="content">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">Form ${title}</h3>
                </div>

                <form id="fm-${titleForId}" role="form" method="post">
                    <div class="box-body">
                        <#list viewFormModel as cvalue>
							<div class="form-group">
								<label for="${cvalue.field}">${cvalue.fieldNameHeader}</label>
								<input name="${cvalue.field}" class="form-control" placeholder="${cvalue.fieldNameHeader}">
							</div>
						</#list>
                    </div>

                    <div class="box-footer">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <a id="btn-cancel-form" href="javascript:void(0)" class="btn btn-warning">Cancel</a>
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>
<script src="<?php echo base_url() . '${pathFormJS}' ?>"></script>
