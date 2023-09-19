<%-- 
    Document   : themSanh
    Created on : Aug 13, 2023, 10:50:24 PM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themSanh" var="action" />
<form:form modelAttribute="themSanh" action="${action}" method="post">
     <form:hidden path="id" />
    <h2>Thông tin sảnh</h2>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="loaiSanh" id="name" placeholder="Loại sảnh" name="loaiSanh" />
        <label for="name">Loại sảnh</label>
        <form:errors path="loaiSanh" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="tenSanh" id="tenSanh" placeholder="Tên sảnh" name="tenSanh" />
        <label for="tenSanh">Tên sảnh</label>
        <form:errors path="tenSanh" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="soLuongBan" id="soLuongBan" placeholder="Số lượng bàn" name="soLuongBan" />
        <label for="soLuongBan">Số lượng bàn</label>
        <form:errors path="soLuongBan" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="donGiaToiThieu" id="donGiaToiThieu" placeholder="Đơn giá sảnh" name="donGiaToiThieu" />
        <label for="soDienThoai">Đơn giá</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <div class="form-floating">
            <form:select class="form-select" id="loaiTiec" name="loaiTiec" path="loaiTiecId">
                <c:forEach items="${loaiTiec}" var="l">
                    <c:choose>
                        <c:when test="${l.id == themSanh.loaiTiecId.id}"><option value="${l.id}" selected>${l.tenLoaiTiec}</option></c:when>
                        <c:otherwise><option value="${l.id}">${l.tenLoaiTiec}</option></c:otherwise>
                    </c:choose>
                    
                </c:forEach>
            </form:select>
            <label for="chucVu" class="form-label">Loại tiệc</label>
        </div> 
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${themSanh.id == null}">Thêm sảnh</c:when>
                <c:otherwise>Cập nhật sảnh</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>