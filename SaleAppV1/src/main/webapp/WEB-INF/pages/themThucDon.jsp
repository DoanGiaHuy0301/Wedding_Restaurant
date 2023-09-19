<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/themThucDon" var="action" />
<form:form modelAttribute="themThucDon" action="${action}" method="post" >
    <form:hidden path="id" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="maThucDon" id="name" placeholder="Mã thực đơn" name="maThucDon" />
        <label for="name">Mã thực đơn</label>
        <form:errors path="maThucDon" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="monKhaiVi" id="monKhaiVi" placeholder="Món khai vị" name="monKhaiVi" />
        <label for="monKhaiVi">Món khai vị</label>
        <form:errors path="monKhaiVi" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="monChinh1" id="monChinh1" placeholder="Món chính 1" name="monChinh1" />
        <label for="name">Món chính 1</label>
        <form:errors path="monChinh1" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="monChinh2" id="monChinh2" placeholder="Món chính 2" name="monChinh2" />
        <label for="monChinh2">Món chính 2</label>
        <form:errors path="monChinh2" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="monChinh3" id="monChinh3" placeholder="Món chính 3" name="monChinh3" />
        <label for="monChinh3">Món chính 3</label>
        <form:errors path="monChinh3" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="monChinh4" id="monChinh4" placeholder="Món chính 4" name="monChinh4" />
        <label for="monChinh4">Món chính 4</label>
        <form:errors path="monChinh4" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="monTrangMieng" id="monTrangMieng" placeholder="Món tráng miệng" name="monTrangMieng" />
        <label for="monTrangMieng">Món tráng miệng</label>
        <form:errors path="monTrangMieng" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="bia" id="bia" placeholder="Bia" name="bia" />
        <label for="name">Bia</label>
        <form:errors path="bia" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="nuocNgot" id="nuocNgot" placeholder="Nước ngọt" name="nuocNgot" />
        <label for="nuocNgot">Nước ngọt</label>
        <form:errors path="nuocNgot" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="giaGoi" id="giaGoi" placeholder="Giá gói thực đơn" name="giaGoi" />
        <label for="giaGoi">Giá gói thực đơn</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${themThucDon.id == null}">Thêm thực đơn</c:when>
                <c:otherwise>Cập nhật thực đơn</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>