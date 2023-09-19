<%-- 
    Document   : loaiTiec
    Created on : Jul 23, 2023, 8:42:09 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/loaiTiec" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý loại tiệc</h1>
   
    <form class="d-flex justify-content-between" action="${action}">
        <a href="<c:url value="/themLoaiTiec"/>" class="btn btn-info">Thêm loại tiệc</a>
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
                <th>Tên loại tiệc</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${loaiTiec}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.tenLoaiTiec}</td>
                    <td>
                        <c:url value="/api/loaiTiec/${p.id}" var="apiDel" />
                        <a href="<c:url value="/themLoaiTiec/${p.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delPro('${apiDel}', ${p.id})">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>