<%-- 
    Document   : themChiNhanh
    Created on : Jul 31, 2023, 8:11:32 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themChiNhanh" var="action" />
<form:form modelAttribute="themChiNhanh" action="${action}" method="post" >
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="tenChiNhanh" id="name" placeholder="Tên chi nhánh" name="name" />
        <label for="name">Tên chi nhánh</label>
        <form:errors path="tenChiNhanh" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="diaChi" id="name" placeholder="Địa chỉ" name="name" />
        <label for="name">Địa chỉ</label>
        <form:errors path="diaChi" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
           <c:choose>
                <c:when test="${themChiNhanh.id == null}">Thêm chi nhánh</c:when>
                <c:otherwise>Cập nhật chi nhánh</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
