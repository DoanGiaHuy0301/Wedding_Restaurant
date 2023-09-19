<%-- 
    Document   : thucDon
    Created on : Jul 30, 2023, 8:46:34 PM
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Thực đơn</h1>
    <a href="<c:url value="/themThucDon"/>" class="btn btn-info">Thêm thưc đơn</a>

    <table class="table table-hover text-center">
        <thead>
            <tr>
                <th>Id</th>
                <th>Mã thực đơn</th>
                <th>Món khai vị</th>
                <th>Món chính 1</th>
                <th>Món chính 2</th>
                <th>Món chính 3</th>
                <th>Món chính 4</th>
                <th>Món tráng miệng</th>
                <th>Bia</th>
                <th>Nước ngọt</th>
                <th>Giá gói thực đơn</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${thucDon}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.maThucDon}</td>
                    <td>${p.monKhaiVi}</td>
                    <td>${p.monChinh1}</td>
                    <td>${p.monChinh2}</td>
                    <td>${p.monChinh3}</td>
                    <td>${p.monChinh4}</td>
                    <td>${p.monTrangMieng}</td>
                    <td>${p.bia}</td>
                    <td>${p.nuocNgot}</td>
                    <td>${p.giaGoi}</td>
                    <td>
                        <c:url value="/api/thucDon/${p.id}" var="apiDel" />
                        <a href="<c:url value="/themThucDon/${p.id}"/>" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" onclick="delThucDon('${apiDel}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js" />"></script>