<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        ${title} <small>Control panel</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> ${title}</a></li>
        <li class="active">Content</li>
    </ol>
</section>

<!-- Main content -->
<section id="content-main" class="content">
    <div class="row">
        <div class="col-xs-12">
            <div id="tbl-content" class="box-table box-primary">
                <div class="box-body">
                    <table id="tbl-${titleForId}">
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- JS content -->
<script src="<?php echo base_url() . '${pathContentJS}' ?>"></script>