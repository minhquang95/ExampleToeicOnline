<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="requestUrl" value="/admin-user-list.html"/>
<html>
<head>
    <title><fmt:message key="label.guideline.listen.list" bundle="${lang}"/></title>
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

        <div class="ace-settings-container" id="ace-settings-container" >
            <button class="btn btn-xs btn-danger" id = "deleteAll" data-toggle="tooltip" title = "Xóa" disabled>
                <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>
        </div>

        <br>
        <br>

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="table-responsive">
                        <fmt:bundle basename="ApplicationResources">
                            <display:table id="tableList" name="items.listResult" partialList="true" size="${items.totalItems}"
                                           pagesize="${items.maxPageItems}" sort="external" requestURI="${requestUrl}"
                                           class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                           style="margin: 3em 0 1.5em;">
                                <display:column title="<input type='checkbox' id='checkAll'/>">
                                    <fieldset>
                                        <input type="checkbox"  name = "checkList" id ="checkbox_${tableList.userId}" value="${tableList.userId}"/>
                                    </fieldset>
                                </display:column>
                                <display:column property="name" titleKey="label.guideline.listen.title" sortable="true" sortName="name"/>
                                <display:column property="fullName" titleKey="label.guideline.listen.content" sortable="true" sortName="fullName"/>
                            </display:table>
                        </fmt:bundle>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        checkBoxAll('checkAll');
        DeleteChecked();
    })

    function checkBoxAll(id) {
        $('input[type = checkbox]').change(function () {
            if($(this).attr('id')==id){
                if($(this).prop('checked')==true){
                    $('input[type=checkbox]').prop('checked', true);
                }else{
                    $('input[type=checkbox]').prop('checked', false);
                }
            }
            else{
                var totalCheckbox = $('#tableList').find('tbody input[type=checkbox]').length;
                $('#tableList').find('tbody input[type = checkbox]').each(function () {
                    var totalCheckboxChecked = $('#tableList').find('tbody input[type = checkbox]:checked').length;
                    if(totalCheckbox == totalCheckboxChecked){
                        $('#checkAll').prop('checked', true);
                    }else{
                        $('#checkAll').prop('checked', false);
                    }
                })
            }
        })
    }

    function DeleteChecked() {
        $('input[type = checkbox]').click(function () {
            if($(this).attr('id') =='checkAll' && $(this).prop('checked') == false){
                $(this).closest('table').find('input[type = checkbox]').prop('checked', false);
            }
            if($('input[type = checkbox]:checked').length >0){
                $('#deleteAll').prop('disabled', false);
            }else{
                $('#deleteAll').prop('disabled', true);
            }
        })
    }
</script>

</body>
</html>