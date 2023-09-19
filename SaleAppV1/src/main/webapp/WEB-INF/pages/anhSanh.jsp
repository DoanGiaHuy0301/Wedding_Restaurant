<%-- 
    Document   : loaiTiec
    Created on : Jul 23, 2023, 8:42:09 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/anhSanh" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý ảnh sảnh</h1>
    <div>
        <a href="<c:url value="/themAnhSanh"/>" class="btn btn-info">Thêm ảnh</a>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Ảnh</th>
                <th>Loại sảnh</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${anhSanh}" var="a">
                <tr>
                    <td>${a.id}</td>
                    <td>
                        <img src="${a.anhSanh}" width="100" />
                    </td>
                    <td>${a.sanhId.loaiSanh}</td>
                    <td>
                    <td>
                        <c:url value="/api/anhSanh/${a.id}" var="apiAnhSanh" />
                        <a href="<c:url value="/themAnhSanh/${a.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delAnhSanh('${apiAnhSanh}', ${a.id})">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js" />"></script>