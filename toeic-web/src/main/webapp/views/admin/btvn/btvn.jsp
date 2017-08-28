<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="requestUrl" value="/admin-btvn.html"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#"><fmt:message key="label.home" bundle="${lang}"/></a>
                </li>
                <li class="active"><fmt:message key="label.guideline.listen.list" bundle="${lang}"/></li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <br class="col-xs-12">
                    <div class="ace-settings-container" id="ace-settings-container">
                        <div id = "div">
                        <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                        </div>
                         </div>
                    </div>
                </br>
                </br>
                    <div class="table-responsive">
                        <form>
                        <fmt:bundle basename="ApplicationResources">
                            <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                           pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column title="<input type='checkbox' id='checkAll'/>">
                                    <input type="checkbox"/>
                                </display:column>
                                <display:column property="name" titleKey="label.guideline.listen.title" sortable="true" sortName="name" />
                                <display:column property="fullName" titleKey="label.guideline.listen.content" sortable="true" sortName="fullName" />
                            </display:table>
                        </fmt:bundle>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script>
    $(document).ready(function () {
        checkAllCheckBox('checkAll');
    });
    function checkAllCheckBox(id) {
        $('input[type=checkbox]').change(function () {
            if ($(this).attr('id') == id) {
                if ($(this).prop('checked') == true) {
                    $('input[type=checkbox]').prop('checked', true);
                    $('#div').show();
                } else {
                    $('input[type=checkbox]').prop('checked', false);
                    $('#div').hide();
                }
            } else {
                var totalCheckbox = $('#tableList').find('tbody input[type=checkbox]').length;
                $('#tableList').find('tbody input[type=checkbox]').each(function () {
                    var totalCheckboxChecked = $('#tableList').find('tbody input[type=checkbox]:checked').length;

                    if(totalCheckboxChecked != 0){
                        $('#div').show();
                    }else{
                        $('#div').hide();
                    }
                    if (totalCheckboxChecked == totalCheckbox) {
                        $('#' +id).prop('checked', true);
                    } else {
                        $('#' +id).prop('checked', false);
                    }
                });
            }
         });
    }
</script>
</body>
</html>
