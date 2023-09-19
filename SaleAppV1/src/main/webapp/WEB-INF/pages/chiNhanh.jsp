<%-- 
    Document   : chiNhanh
    Created on : Jul 23, 2023, 8:42:54 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/chiNhanh" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý chi nhánh</h1>
    <form class="d-flex justify-content-between" action="${action}">
        <a href="<c:url value="/themChiNhanh"/>" class="btn btn-info">Thêm chi nhánh</a>
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
                <th>Tên chi nhánh</th>
                <th>Địa chỉ</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${chiNhanh}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.tenChiNhanh}</td>
                    <td>${p.diaChi}</td>
                    <td>
                        <c:url value="/api/chiNhanh/${p.id}" var="apiDel" />
                        <a href="<c:url value="/themChiNhanh/${p.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delChiNhanh('${apiDel}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>