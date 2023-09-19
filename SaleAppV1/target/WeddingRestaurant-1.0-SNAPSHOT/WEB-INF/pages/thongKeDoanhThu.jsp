<%-- 
    Document   : thongKeDoanhThu
    Created on : Aug 24, 2023, 11:35:31 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/thongKeDoanhThu" var="action" />
<h1 class="text-center text-info mt-4 mb-3">Thống kê doanh thu</h1>
<div class="row">
    <div class="col-sm-2 " style="height: 100%;">
        <div class="mt-3 mb-3">
            <span style="font-weight: 700;">Danh mục thống kê & báo cáo</span>
        </div>
        <div class="list-group  list-group-flush">
            <a href="<c:url value="/thongKeSanh"/>" class="list-group-item ">Thống kê mật độ sảnh</a>
            <a href="<c:url value="/thongKeTiecCuoi"/>" class="list-group-item ">Thống kê mật độ tiệc cưới</a>
            <a href="<c:url value="/thongKeDoanhThu"/>" class="list-group-item ">Thống kê doanh thu</a>
        </div>
    </div>
    <div class="col-md-6">
        <form method="get" action="${action}">
            <div class="mt-3 mb-3 row">
                <div class="col-xl-2 col-md-2 col-sm-2">
                    <select id="selectMonth" name="month">
                        <script>
                            function generateMonth() {
                                var options = '';
                                options += '<option value="" selected >Tháng</option>'
                                for (let i = 1; i <= 12; i++) {
                                    options += '<option value="' + i + '">' + "Tháng " + i + ' </option>';
                                }
                                return options;
                            }

                            var selectMonthElement = document.getElementById("selectMonth");
                            var monthOptions = generateMonth();
                            selectMonthElement.innerHTML = monthOptions;
                        </script>
                    </select>
                </div>
                <div class="col-xl-2 col-md-2 col-sm-2">
                    <select id="selectYear" name="year">
                        <script>
                            function getCurrentYear() {
                                return new Date().getFullYear();
                            }

                            function generateYearOptions(startYear, endYear) {
                                var options = '';
                                options += '<option value="" selected >Năm</option>'
                                for (var year = startYear; year <= endYear; year++) {
                                    options += '<option value="' + year + '">' + year + '</option>';
                                }
                                return options;
                            }

                            var currentYear = getCurrentYear();
                            var selectYearElement = document.getElementById("selectYear");
                            var yearOptions = generateYearOptions(2010, currentYear);
                            selectYearElement.innerHTML = yearOptions;
                        </script>
                    </select>
                </div>
                <div class="col-xl-2 col-md-2 col-sm-2">
                    <select id="selectQuarter" name="quarter">
                        <option value="" selected>Quý</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>
                <div class="col-xl-2 col-md-2 col-sm-2">
                    <input type="submit" class="btn btn-primary" value="Thống kê">
                </div>
            </div>
        </form>
        <div class="">
            <div id="chartContainer" style="height: 300px; width: 100%;"></div>
        </div>
    </div>
    <div class="col-md-4">
        <table class="table">
            <thead>
                <tr>
                    <th>Tháng</th>
                    <th>Tổng doanh thu</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${thongKeDoanhThu}" var="dataPoint">
                    <tr>
                        <td>${dataPoint.time}</td>
                         <td><fmt:formatNumber value="${dataPoint.data}" type="number" pattern="#,###.##" /> VNĐ</td> 
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>

</div>

<script type="text/javascript">
    window.onload = function () {
        var dps3 = [[]];
        var currentURL = window.location.href;

        var urlParams = new URLSearchParams(new URL(currentURL).search);

        var month = urlParams.get("month");
        var year = urlParams.get("year");
        var quarter = urlParams.get("quarter");

        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2", // "light1", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Thống kê doanh thu"
            },
            data: [{
                    type: "pie",
                    showInLegend: "true",
                    legendText: "{x}",
                    yValueFormatString: "#,###",
                    indexLabelFontSize: 16,
                    indexLabel: "Tháng {x}",
                    dataPoints: dps3[0]
                }]
        });
    <c:forEach items="${thongKeDoanhThu}" var="dataPoint">
        xValue = "${dataPoint.time}";
        yValue = "${dataPoint.data}";
        dps3[0].push({
            x: xValue,
            y: yValue
        });
    </c:forEach>
        console.log(dps3);
        chart.render();

    }
</script>
