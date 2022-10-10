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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <%--    <link rel="stylesheet" type="text/css" href="css/shopHome.css">--%>
  <link rel="stylesheet" type="text/css" href="/client/assets/page/shop/css/shopInfo.css">
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
  <link rel="icon" href="data:image/png;base64,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" type="image/x-icon">
  <title>Xin Chào ${shop.name}</title>
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
            <li><a href="shop?action=info" class="nav-link px-2 link-dark">Thông tin cá nhân</a></li>
            <li><a href="shop?action=listFood" class="nav-link px-2 link-dark">Món ăn sẵn có</a></li>
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
    <div id="left-content" style="border: 1px orange;">
      <ul class="nav flex-column">
        <li class="nav-item">
          <a href="shop?action=create">
            <img src="/client/assets/page/shop/other/Untitled.png" width="200" height="300">
          </a>
        </li>
      </ul>
    </div>
  </div>
  <div class="content">
    <div id="right-content" style="margin-top: 30px">
      <div class="container">
        <div class="row">
          <div class="container">
            <div class="main-body ">
              <div class="row gutters-sm">
                <div class="col-md-4 mb-3" >
                  <div class="card" style="position: static">
                      <div class="d-flex flex-column align-items-center text-center">
                        <img src="${shop.image}" alt="Admin" class="rounded-circle" width="150">
                        <div class="mt-3">
                          <h4>${shop.name}</h4>
                          <p class="text-secondary mb-1">Loại: ${shop.code}</p>
                          <p class="text-muted font-size-sm">SDT: ${shop.phone}</p>
                          <button class="btn btn-primary">Nạp lần đầu</button>
                          <button class="btn btn-outline-primary">Từ bỏ</button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-8">
                  <div class="card mb-3" style="position: static">
                    <div class="card-body">
                      <div class="row">
                        <div class="col-sm-3">
                          <h6 class="mb-0">Full Name</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                          Kenneth Valdez
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <h6 class="mb-0">Email</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                          fip@akeda
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <h6 class="mb-0">Phone</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                          113
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <h6 class="mb-0">Mobile</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                          911
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-3">
                          <h6 class="mb-0">Address</h6>
                        </div>
                        <div class="col-sm-9 text-secondary">
                          da lat
                        </div>
                      </div>
                      <hr>
                      <div class="row">
                        <div class="col-sm-12">
                          <a class="btn btn-info " target="__blank" href="https://www.bootdey.com/snippets/view/profile-edit-data-and-skills">Edit</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
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
<script>

</script>
</body>
</html>
