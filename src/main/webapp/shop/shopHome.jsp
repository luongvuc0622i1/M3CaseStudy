<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/7/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/shopHome.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <title>Now</title>
</head>
<body>
<div id="top_menu">
    <div class="content">
        <header>
            <h1><a href="#"><img src="https://www.now.vn/app/assets/img/nowvn.png?aa6bbddbf923c9dfd35ca83a7d068e6d"></a></h1>
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn">Hà Nội</button>
                <ul id="myDropdown" class="dropdown-content">
                    <li><a href="#">Hà Nội</a></li>
                    <li><a href="#">TP.HCM</a></li>
                    <li><a href="#">Đà Nẵng</a></li>
                    <li><a href="#">Hải Dương</a></li>
                    <li><a href="#">Nghệ An</a></li>
                    <li><a href="#">Vũng Tàu</a></li>
                    <li><a href="#">Bình Dương</a></li>
                    <li><a href="#">Huế</a></li>
                    <li><a href="#">Khánh Hòa</a></li>
                    <li><a href="#">Đồng Nai</a></li>
                    <li><a href="#">Nghệ An</a></li>
                    <li><a href="#">Bắc Ninh</a></li>
                    <li><a href="#">Quảng Ninh</a></li>
                    <li><a href="#">Cần Thơ</a></li>
                    <li><a href="#">Thái Nguyên</a></li>
                </ul>
            </div>
            <ul id="header_menu">
                <li><a href="#">Đồ ăn</a></li>
                <li><a href="#">Đặt bàn</a></li>
                <li><a href="#">Thực phẩm</a></li>
            </ul>
            <div id="end-top_menu">
                <a href="#"><i class="fal fa-search"></i></a>
                <a href="#">Tên shop đưa vào đây</a>
            </div>
        </header>
    </div>
</div>
<div  style="margin-top: 80px;
				/*background-image: url(images/main-banner.jpg);*/
				background-repeat: no-repeat;
				height: 840px;">
    <div class="content" id="order-food">
        <div id="left-content" >
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div id="right-content">

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
                    <span>Email: <a href="#"> info@now.vn</a></span>
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
<script>
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }
    window.onclick = function(event) {
        if (!event.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            var i;
            for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
