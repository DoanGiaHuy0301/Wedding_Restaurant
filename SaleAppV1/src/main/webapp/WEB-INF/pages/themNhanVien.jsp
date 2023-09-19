<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themNhanVien" var="action" />
<form:form modelAttribute="themNhanVien" action="${action}" method="post">
    <form:hidden path="id" />
    <h2>Thông tin nhân viên</h2>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="tenNhanVien" id="name" placeholder="Tên nhân viên" name="name" />
        <label for="name">Tên nhân viên</label>
        <form:errors path="tenNhanVien" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" class="form-control" path="ngaySinh" id="birthday" placeholder="Ngày sinh" name="birthday" />
        <label for="birthday">Ngày sinh</label>
    </div>
    <div class="radio-group" style="display: flex; margin: 10px 0; ">
        <form:radiobutton path="gioiTinh" id="nam" value="1" style="margin: 0 10px;" />
        <label for="nam">Nam</label>

        <form:radiobutton path="gioiTinh" id="nu" value="0" style="margin: 0 10px;" />
        <label for="nu">Nữ</label>
    </div>


    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" path="email" id="name" placeholder="Email" name="email" />
        <label for="email">Email</label>
        <form:errors path="email" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="soDienThoai" id="soDienThoai" placeholder="Số điện thoại" name="soDienThoai" />
        <label for="soDienThoai">Số điện thoại</label>
        <form:errors path="soDienThoai" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" class="form-control" path="ngayVaoLam" id="ngayVaoLam" placeholder="Ngày sinh" name="ngayVaoLam" />
        <label for="ngayVaoLam">Ngày vào làm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="diaChi" id="diaChi" placeholder="Địa chỉ" name="diaChi" />
        <label for="diaChi">Địa chỉ</label>
        <form:errors path="diaChi" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <div class="form-floating">
            <form:select class="form-select" id="chiNhanh" name="chiNhanh" path="chiNhanhId">
                <c:forEach items="${chiNhanh}" var="cn">
                    <option value="${cn.id}">${cn.tenChiNhanh}</option>
                </c:forEach>
            </form:select>
            <label for="chiNhanh" class="form-label">Chi nhánh</label>
        </div> 
    </div>
    <div class="form-floating mb-3 mt-3">
        <div class="form-floating">
            <form:select class="form-select" id="chucVu" name="chucVu" path="chucVuId">
                <c:forEach items="${chucVu}" var="cv">
                    <c:choose>
                        <c:when test="${cv.id == themNhanVien.chucVuId.id}"><option value="${cv.id}" selected>${cv.chucVu}</option></c:when>
                        <c:otherwise><option value="${cv.id}">${cv.chucVu}</option></c:otherwise>
                    </c:choose>

                </c:forEach>
            </form:select>
            <label for="chucVu" class="form-label">Chức vụ</label>
        </div> 
    </div>

    <h2>Tài khoản</h2>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="taiKhoanId.tenDangNhap" id="taiKhoan" placeholder="Tên đăng nhập" name="taiKhoan" onblur="checkUsernameAvailability()"/>
        <label for="taiKhoan">Tên đăng nhập</label>
        <span id="tenDangNhapMessage" class="text-danger"></span>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="taiKhoanId.matKhau" id="matKhau" 
                    placeholder="Mật khẩu" name="matKhau"/>
        <label for="matKhau">Mật khẩu</label>
    </div>
    <div class="form-group" style="margin: 10px 0;">
        <form:radiobutton path="taiKhoanId.vaiTro" id="AD" value="ROLE_ADMIN" style="margin: 0 10px;" />
        <label for="ROLE_ADMIN">Admin</label>

        <form:radiobutton path="taiKhoanId.vaiTro" id="NV" value="ROLE_STAFF" style="margin: 0 10px;" />
        <label for="ROLE_STAFF">Nhân viên</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            Thêm nhân viên
        </button>
    </div>
</form:form>

<script src="<c:url value="/js/main.js" />"></script>