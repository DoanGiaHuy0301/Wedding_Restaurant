<%-- 
    Document   : nhanVien
    Created on : Jul 24, 2023, 9:19:43 PM
    Author     : DELL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/nhanVien" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-4">Quản lý nhân viên</h1>


    <form class="d-flex justify-content-between" action="${action}">
        <a href="<c:url value="/themNhanVien"/>" class="btn btn-info">Thêm nhân viên</a>
        <div class="col-md-6">
            <div class="input-group">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </div>
        </div>
    </form>

    <!-- Button to Open the Modal -->

    <table class="table table-hover text-center">
        <thead>
            <tr>
                <th>Id</th>
                <th>Tên nhân viên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Ngày vào làm</th>
                <th>Địa chỉ</th>
                <th>Chức vụ</th>
                <th>Chi nhánh</th>
                <th>Tên đăng nhập</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${nhanVien}" var="p" varStatus="loop">
                <c:if test="${loop.index < 4}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.tenNhanVien}</td>
                        <td>${p.ngaySinh}</td>
                        <c:if test="${p.gioiTinh == 1}">
                            <td>Nam</td>
                        </c:if>
                        <c:if test="${p.gioiTinh == 0}">
                            <td>Nữ</td>
                        </c:if>
                        <td>${p.soDienThoai}</td>
                        <td>${p.email}</td>
                        <td>${p.ngayVaoLam}</td>
                        <td>${p.diaChi}</td>
                        <td>${p.chucVu}</td>
                        <td>${p.chiNhanh}</td>
                        <td>${p.taiKhoan}</td>
                        <td>

                            <c:url value="/api/nhanVien/${p.id}" var="apiDel" />
                            <button class="btn btn-danger" onclick="delNhanVien('${apiDel}')">Xóa</button>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-center">
        <c:if test="${counterNV > 1}">
            <ul class="pagination mt-1">
                <c:forEach begin="1" end="${counterNV}" var="i">
                    <c:url value="/nhanVien" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>
</section>

<script src="<c:url value="/js/main.js" />"></script>
