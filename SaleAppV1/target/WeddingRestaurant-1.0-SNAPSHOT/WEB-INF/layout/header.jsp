<%-- 
    Document   : header
    Created on : Jul 22, 2023, 9:42:44 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<c:url value="/" var="action" />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">GH - WEDDING RESTAURANT</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <se:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="${action}">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/loaiTiec"/>">Loại tiệc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/chiNhanh"/>">Chi nhánh</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/nhanVien"/>">Nhân viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/dichVu"/>">Dịch vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/thongTinSanh"/>">Sảnh tiệc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/thucDon"/>">Thực đơn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/anhSanh"/>">Ảnh sảnh</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/thongKeSanh"/>">Thống kê & Báo cáo</a>
                    </li>
                </se:authorize>
            </ul>
            <form class="d-flex" action="${action}">

                <c:choose>

                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <se:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/" />">${pageContext.request.userPrincipal.name}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/logout" />">Đăng xuất</a>
                            </li>
                        </se:authorize>
                    </c:when>

                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </div>
</nav>