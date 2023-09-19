<%-- 
    Document   : thongTinSanh
    Created on : Jul 28, 2023, 8:32:32 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/thongTinSanh" var="action" />
<section class="container">
    
    <h1 class="text-center text-info mt-4">Quản lý sảnh</h1>
    <form class="d-flex justify-content-between" action="${action}">
        <a href="<c:url value="/themSanh"/>" class="btn btn-info">Thêm sảnh</a>
        <div class="col-md-6">
            <div class="input-group">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </div>
        </div>
    </form>
    <table class="table table-hover text-center">
        <thead>
            <tr>
                <th>Id</th>
                <th>Loại sảnh</th>
                <th>Tên sảnh</th>
                <th>Số lượng bàn</th>
                <th>Đơn giá</th>
                <th>Loại tiệc</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${thongTinSanh}" var="s" varStatus="loop">
                <c:if test="${loop.index < 4}">
                    <tr>
                        <td>${s.id}</td>
                        <td>${s.loaiSanh}</td>
                        <td>${s.tenSanh}</td>
                        <td>${s.soLuongBan}</td>
                        <td><fmt:formatNumber value="${s.donGiaToiThieu}" type="number" pattern="#,###.##" /> VNĐ</td>
                        <td>${s.loaiTiecId.tenLoaiTiec}</td>
                        <td>
                            <c:url value="/api/thongTinSanh/${s.id}" var="apiDel" />
                            <a href="<c:url value="/themSanh/${s.id}"/>" class="btn btn-info">Cập nhật</a>
                            <button class="btn btn-danger" onclick="delSanh('${apiDel}')">Xóa</button>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-center">
        <c:if test="${counter > 1}">
            <ul class="pagination mt-1">
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/thongTinSanh" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>

</section>

<script src="<c:url value="/js/main.js" />"></script>