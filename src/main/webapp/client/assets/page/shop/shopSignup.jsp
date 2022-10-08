<%--
  Created by IntelliJ IDEA.
  User: LINH
  Date: 10/7/2022
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="../img/favicon.png">
    <title>Shop Sign Up</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .card-registration .select-input.form-control[readonly]:not([disabled]) {
            font-size: 1rem;
            line-height: 2.15;
            padding-left: .75em;
            padding-right: .75em;
        }

        .card-registration .select-arrow {
            top: 13px;
        }

        body {
            background: rgb(250, 110, 34);
        }

        input, label {
            margin: 5px 5px;
        }

        .form-group {
            margin: 30px auto;
            width: 450px;
        }

        .form-control {
            float: left;
        }
    </style>
</head>
<body>
<section class="h-100">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">

                            <img src="<c:url value='/img/restaurant.jpg'/>"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"/>
                            <br>
                        </div>
                        <div class="col-xl-6"><img src="<c:url value='/img/favicon.png'/>" alt="logo"
                                                   class="rounded float-left" width="70px"
                                                   height="70px" style="margin-top: 20px;margin-left: 10px">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase text-center">Đăng ký cửa hàng mới</h3>
                                <form method="post" action="/createShop?action=submit">
                                    <fieldset>
                                        <legend>Thông tin tài khoản</legend>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="account">Tên tài khoản</label>
                                            <input type="text" placeholder="Nhập tên tài khoản" id="account"
                                                   name="account"
                                                   class="form-control form-control-md"/>
                                        </div>
                                        <div class="form-outline mb-4 form-group">
                                            <label class="form-label" for="password">Mật khẩu</label>
                                            <input type="password" placeholder="Nhập mật khẩu" id="password"
                                                   name="password"
                                                   class="form-control form-control-md"/>
                                        </div>
                                    </fieldset>
                                    <br>
                                    <fieldset>
                                        <legend>Thông tin cửa hàng</legend>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="name">Tên cửa hàng</label>
                                            <input type="text" placeholder="Nhập tên cửa hàng" id="name" name="name"
                                                   class="form-control form-control-md"/>

                                        </div>

                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="phone">Số điện thoại</label>
                                            <input type="text" placeholder="Nhập số điện thoại" id="phone" name="phone"
                                                   class="form-control form-control-md"/>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="email">Email</label>
                                            <input type="text" placeholder="VD: 'abc123@gmail.com'" id="email"
                                                   name="email"
                                                   class="form-control form-control-md"/>

                                        </div>

                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="address">Địa chỉ</label>
                                            <input type="text" placeholder="Nhập địa chỉ" id="address" name="address"
                                                   class="form-control form-control-md"/>
                                        </div>

                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="openTime">Thời gian mở cửa:</label>
                                            <input type="time" id="openTime" name="openTime"
                                                   class="form-control form-control-md"/>
                                        </div>


                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="closeTime">Thời gian đóng cửa:</label>
                                            <input type="time" id="closeTime" name="closeTime"
                                                   class="form-control form-control-md"/>
                                        </div>
                                        <br>
                                        <br>
                                        <div class="form-outline mb-4">
                                            <label class="form-label"><h6>Các loại phí khác:</h6></label>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox"
                                                       id="serviceFee"
                                                       value="1"/>
                                                <label class="form-check-label" for="serviceFee">Phí dịch vụ</label>
                                            </div>

                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox" id="shippingFee"
                                                       value="2"/>
                                                <label class="form-check-label" for="shippingFee">Phí ship extra</label>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="shopImage">Hình ảnh cửa hàng</label>
                                                <input type="text" placeholder="Nhập link ảnh cửa hàng" id="shopImage"
                                                       name="shopImage"
                                                       class="form-control form-control-md"/>
                                            </div>
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="description">Mô tả</label>
                                                <textarea class="form-control" id="description" name="description"
                                                          placeholder="Nhập mô tả về cửa hàng"></textarea>
                                            </div>

                                        </div>
                                    </fieldset>
                                    <br>
                                    <div class="d-flex justify-content-end pt-3">
                                        <button type="reset" class="btn btn-light btn-lg ">Reset all</button>
                                        <button type="submit" class="btn btn-lg ms-2 "
                                                style="background:rgb(255,87,36);color: white">
                                            Submit form
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
