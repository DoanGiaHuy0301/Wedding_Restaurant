<%-- 
    Document   : themDichVu
    Created on : Jul 31, 2023, 8:33:25 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themDichVu" var="action" />
<form:form modelAttribute="themDichVu" action="${action}" method="post" >
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="loaiDichVu" id="name" placeholder="Loại dịch vụ" name="name" />
        <label for="name">Loại dịch vụ</label>
        <form:errors path="loaiDichVu" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="giaDichVu" id="price" placeholder="Giá dịch vu" name="price" />
        <label for="name">Giá dịch vụ</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
             <c:choose>
                <c:when test="${themDichVu.id == null}">Thêm dịch vụ</c:when>
                <c:otherwise>Cập nhật dịch vụ</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
