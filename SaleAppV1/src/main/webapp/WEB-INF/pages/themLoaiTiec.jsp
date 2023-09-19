<%-- 
    Document   : thongTinSanh
    Created on : Jul 28, 2023, 8:32:32 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themLoaiTiec" var="action" />
<form:form modelAttribute="themLoaiTiec" action="${action}" method="post" >
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="tenLoaiTiec" id="name" placeholder="Tên loại tiệc" name="name" />
        <label for="name">Tên loại tiệc</label>
        <form:errors path="tenLoaiTiec" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${themLoaiTiec.id == null}">Thêm loại tiệc</c:when>
                <c:otherwise>Cập nhật loại tiệc</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>