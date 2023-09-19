<%-- 
    Document   : dichVu
    Created on : Jul 23, 2023, 8:43:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/dichVu" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý dich vụ</h1>

    <form class="d-flex justify-content-between" action="${action}">
        <a href="<c:url value="/themDichVu"/>" class="btn btn-info">Thêm dịch vụ</a>
        <div class="col-md-6">
            <div class="input-group">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </div>
        </div>
    </form>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Loại dịch vụ</th>
                <th>Giá dịch vụ</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dichVu}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.loaiDichVu}</td>
                    <td><fmt:formatNumber value="${p.giaDichVu}" type="number" pattern="#,###.##" /> VNĐ</td>
                    <td>
                        <c:url value="/api/dichVu/${p.id}" var="apiDel" />
                        <a href="<c:url value="/themDichVu/${p.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delDichVu('${apiDel}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>