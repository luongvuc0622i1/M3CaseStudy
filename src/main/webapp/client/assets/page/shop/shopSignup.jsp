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
            background: rgb(250, 103, 22);
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
                <div class="col-xl-12">
                    <div class="card card-registration my-4">
                        <img src="<c:url value='/img/restaurant.jpg'/>"
                             alt="Sample photo">
                        <div class="row">
                            <img
                                    src="<c:url value='/img/favicon.png'/>"
                                    alt="logo"
                                    class="rounded float-left" width="80px"
                                    height="80px" style="margin-left: 25%;margin-top: 25px;margin-right: 20px">

                            <h1 class="text-uppercase text-center float-left " style="margin-top: 40px">????ng k?? c???a h??ng
                                m???i</h1>
                        </div>
                        <div class="card-body p-md-5 text-black">
                            <form method="post" action="/createShop?action=submit">
                                <fieldset>
                                    <legend>Th??ng tin t??i kho???n</legend>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="account">T??n t??i kho???n</label>
                                                <input type="text" placeholder="Nh???p t??n t??i kho???n" id="account"
                                                       name="account"
                                                       class="form-control form-control-md"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="password">M???t kh???u</label>
                                                <input type="password" placeholder="Nh???p m???t kh???u" id="password"
                                                       name="password"
                                                       class="form-control form-control-md"/>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                <br>
                                <fieldset>
                                    <legend>Th??ng tin c???a h??ng</legend>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="name">T??n c???a h??ng</label>
                                                <input type="text" placeholder="Nh???p t??n c???a h??ng" id="name" name="name"
                                                       class="form-control form-control-md"/>

                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="address">?????a ch???</label>
                                                <input type="text" placeholder="Nh???p ?????a ch???" id="address"
                                                       name="address"
                                                       class="form-control form-control-md"/>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="phone">S??? ??i???n tho???i</label>
                                                <input type="text" placeholder="Nh???p s??? ??i???n tho???i" id="phone"
                                                       name="phone"
                                                       class="form-control form-control-md"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="email">Email</label>
                                                <input type="text" placeholder="VD: 'abc123@gmail.com'" id="email"
                                                       name="email"
                                                       class="form-control form-control-md"/>

                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="openTime">Th???i gian m??? c???a:</label>
                                                <input type="time" step="1" id="openTime" name="openTime"
                                                       class="form-control form-control-md"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <label class="form-label" for="closeTime">Th???i gian ????ng c???a:</label>
                                                <input type="time" step="1" id="closeTime" name="closeTime"
                                                       class="form-control form-control-md"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label"><h6>C??c lo???i ph?? kh??c:</h6></label>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox"
                                                   id="serviceFee"
                                                   value="1"/>
                                            <label class="form-check-label" for="serviceFee">Ph?? d???ch v???</label>
                                        </div>

                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="shippingFee"
                                                   value="2"/>
                                            <label class="form-check-label" for="shippingFee">Ph?? ship extra</label>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="shopImage">H??nh ???nh c???a h??ng</label>
                                            <input type="text" placeholder="Nh???p link ???nh c???a h??ng" id="shopImage"
                                                   name="shopImage"
                                                   class="form-control form-control-md"/>
                                        </div>
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="description">M?? t???</label>
                                            <textarea class="form-control" id="description" name="description"
                                                      placeholder="Nh???p m?? t??? v??? c???a h??ng"></textarea>
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