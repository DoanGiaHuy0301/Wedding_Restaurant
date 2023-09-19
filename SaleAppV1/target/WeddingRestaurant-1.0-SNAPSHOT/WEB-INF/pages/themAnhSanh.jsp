 
<!--    Document   : thongTinSanh
    Created on : Jul 28, 2023, 8:32:32 PM
    Author     : DELL-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themAnhSanh" var="action" />

<form:form modelAttribute="themAnhSanh" action="${action}" method="post" enctype="multipart/form-data">
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file" placeholder="Upload image" name="file" />
        <label for="file">Upload image</label>
         <c:if test="${themAnhSanh.anhSanh != null}">
            <img src="${themAnhSanh.anhSanh}" width="120" />
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <div class="form-floating">
            <form:select class="form-select" id="loaiSanh" name="loaiSanh" path="sanhId">
                <c:forEach items="${thongTinSanh}" var="s">
                    <option value="${s.id}">${s.tenSanh}</option>
                </c:forEach>
            </form:select>
            <label for="chiNhanh" class="form-label">Loại sảnh</label>
        </div> 
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class="btn btn-info" type="submit">
            <c:choose>
                <c:when test="${themAnhSanh.id == null}">Thêm ảnh sảnh</c:when>
                <c:otherwise>Cập nhật ảnh sảnh</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>