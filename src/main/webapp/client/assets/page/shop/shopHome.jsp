<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/7/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bo otstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%--    <link rel="stylesheet" type="text/css" href="css/shopHome.css">--%>
    <link rel="stylesheet" type="text/css" href="/client/assets/page/shop/css/shopHome.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="icon" href="data:image/png;base64,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" type="image/x-icon">
    <title>Now</title>
</head>
<body>
<div id="top_menu">
    <div class="content">
            <header class="p-3 mb-3 border-bottom">
                <h1><a href="#"><img src="data:image/png;base64,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" width="220" height="43"></a></h1>
                <div class="container">
                    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                        </a>

                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="#" class="nav-link px-2 link-dark">Thông tin cá nhân</a></li>
                            <li><a href="#" class="nav-link px-2 link-dark">Danh sách món ăn</a></li>
                            <li><a href="#" class="nav-link px-2 link-dark">Thông báo</a></li>
                            <li><a href="#" class="nav-link px-2 link-dark">Trợ giúp</a></li>
                        </ul>

                        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                            <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                        </form>

                        <div class="dropdown text-end">
                            <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="<c:out value = "${shop.image}" />" alt="mdo" width="32" height="32" class="rounded-circle">
                            </a>
                            <ul class="dropdown-menu text-small">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/login">Đăng xuất</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </header>
    </div>
</div>
<div  style="margin-top: 80px;
				background-repeat: no-repeat;
				height: 840px;">
    <div class="content">
        <div id="left-content" style="border: 1px solid orange">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Thêm Món Ăn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div id="right-content">
            <div class="container">
                <div class="row">
                    <c:forEach var="food" items="${foodList}">
                    <div class="col-md-4">
                        <div class="nenxanh">
                            <img src="<c:out value="${food.image}"/>" width="100" height="100">
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
<div class="clearfix"></div>
    <footer>
        <div class="content">
            <div id="bot_page">
                <div>
                    <h3 class="title-footer">Công ty</h3>
                    <a href="">Giới thiệu</a>
                    <a href="">Trung tâm trợ giúp</a>
                    <a href="">Quy chế</a>
                    <a href="">Điều khoản sử dụng</a>
                    <a href="">Bảo mật thông tin</a>
                    <a href="">Giải quyết khiếu nại</a>
                    <a href="">Liên hệ</a>
                    <a href="">Hợp tác nhân viên giao nhận</a>
                    <a href="">Đăng ký quán</a>
                    <a href="">Ứng dụng NowMerchant</a>
                    <a href="">Now Academy</a>
                </div>
                <div>
                    <h2 class="title-footer">Now App</h2>
                        <a href="#"><i class="fab fa-apple"></i>IOS</a>
                        <a href="#"><i class="fab fa-android"></i>Android</a>
                </div>
                <div>
                    <img src="https://shopeefood.vn/app/assets/img/Logo-ShopeefoodVN.png?a233b36c37415f85f46c25a6cd0963aa">
                    <p>© 2022 Now - A Foody Corporation</p>
                    <ul>
                        <li><a href="#"><i class="fab fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fab fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                    </ul>
                </div>
                <div>
                    <h3 class="title-footer">Địa chỉ công ty</h3>
                    <p>Công Ty Cổ Phần Foody, Lầu G, Tòa nhà Jabes 1,số 244 đường Cống Quỳnh, phường Phạm Ngũ Lão, Quận 1, TPHCM Giấy CN ĐKDN số: 0311828036do Sở Kế hoạch và Đầu tư TP.HCM cấp ngày 11/6/2012,sửa đổi lần thứ 23, ngày 10/12/2020 Số điện thoại: 1900 2042</p>
                    <span>Email: <a href="#"> chuckieakenzzz@gmail.com</a></span>
                    <img style="display: block;
					 				max-width:185px;
					  				max-height:70px;
  									width: auto;
  									height: auto;"	 src="https://shopeefood.vn/app/assets/img/gov_seals1.jpg?4534b28245a7aad9805fbddc90f873d8">
                </div>
            </div>
        </div>
    </footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
