<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title><fmt:message key="label.manager.user" bundle="${lang}"/></title>
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
                <div class="col-xs-12">
                    <a href="${listenGuidelineEditUrl}" type="button">Thêm bài hd</a>
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>

                    <div class="row">
                        <div class="col-xs-12">
                            <c:url var="listenGuidelineAddUrl" value="/admin-user-edit.html">
                                <c:param name="typeUrl" value="url_edit"/>
                            </c:url>
                            <a href="${listenGuidelineAddUrl}" class="btn btn-white btn-warning btn-bold"><fmt:message key="label.user.add" bundle="${lang}"/></a>
                        </div>
                    </div>

                    <button type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold">
                                    <span>
                                        <i class="fa fa-trash-o bigger-110 pink"></i>
                                    </span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
