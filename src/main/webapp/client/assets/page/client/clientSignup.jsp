<%--
  Created by IntelliJ IDEA.
  User: LINH
  Date: 10/6/2022
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
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
        }</style>

</head>
<body>
<section class="h-100" style="background: rgb(253,118,45)">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                             <img src="<c:url value='/img/login1.jpg'/>"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"/>
                        </div>
                        <div class="col-xl-6"><img src="<c:url value='/img/favicon.png'/>" alt="logo" class="rounded float-left" width="70px"
                                                   height="70px" style="margin-top: 20px;margin-left: 10px">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase text-center">Đăng ký người dùng mới</h3>

                                <div class="form-outline mb-4">
                                    <input type="text" placeholder="Nhập tên tài khoản" id="account" class="form-control form-control-md"/>
                                    <label class="form-label" for="account">Tên tài khoản</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" placeholder="Nhập họ và tên" id="name" class="form-control form-control-md"/>
                                    <label class="form-label" for="name">Họ và tên</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="text" placeholder="Nhập số điện thoại" id="phone" class="form-control form-control-md"/>
                                    <label class="form-label" for="phone">Số điện thoại</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="text" placeholder="Nhập địa chỉ" id="address" class="form-control form-control-md"/>
                                    <label class="form-label" for="address">Địa chỉ</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="text" placeholder="VD: 'abc123@gmail.com'" id="email" class="form-control form-control-md"/>
                                    <label class="form-label" for="email">Email</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" placeholder="Nhập mật khẩu" id="password" class="form-control form-control-md"/>
                                    <label class="form-label" for="password">Mật khẩu</label>
                                </div>

                                <div class="d-flex justify-content-end pt-3">
                                    <button type="reset" class="btn btn-light btn-lg ">Reset all</button>
                                    <button type="submit" class="btn btn-lg ms-2 "
                                            style="background:rgb(255,87,36);color: white">
                                        Submit form
                                    </button>
                                </div>

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
