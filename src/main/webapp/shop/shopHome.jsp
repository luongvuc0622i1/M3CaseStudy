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
            <header class="p-3 mb-3 border-bottom">
                <h1><a href="#"><img src="https://shopeefood.vn/app/assets/img/shopeefoodvn.png?4aa1a38e8da801f4029b80734905f3f7"></a></h1>
                <div class="container">
                    <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                        </a>

                        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <li><a href="#" class="nav-link px-2 link-secondary">Overview</a></li>
                            <li><a href="#" class="nav-link px-2 link-dark">Inventory</a></li>
                            <li><a href="#" class="nav-link px-2 link-dark">Customers</a></li>
                            <li><a href="#" class="nav-link px-2 link-dark">Products</a></li>
                        </ul>

                        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                            <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
                        </form>

                        <div class="dropdown text-end">
                            <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBUWFRgWFRYYGBgYGBgYGBgYHBgYGBgYGBgaGRgYGBgcIS4lHB4rIRgYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QGhISGjQhISE0NDQ0NDQ0NDQxNDQ0NDQ0NDQ0NDQ0NDQ0NDQ0PzQ0NDQ0NDQ0NDQ0NDQ0PzU0NDE0Mf/AABEIAOEA4QMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAFAAECAwQGBwj/xAA7EAACAQIDBAcHAwQBBQEAAAABAgADEQQhMQUSQVEGExRSYXGBIjKRkqHB0RVCsWJy4fAHFiMzgrJD/8QAGAEAAwEBAAAAAAAAAAAAAAAAAAECAwT/xAAfEQEBAAICAwEBAQAAAAAAAAAAAQIREiEDEzFRQWH/2gAMAwEAAhEDEQA/APXeyp3F+VfxF2VO4vyr+JdFJ2SnsqdxflX8RdlTuL8q/iXRQ2FPZU7i/Kv4i7KncX5V/EuijNV2ZO4nyj8Ruyp3F+VfxLozGAVHDJ3E+VfxMNdU7i/Ks2VWyvMVWoBnkSOZtbxhLo9Kezm/uoBy3U/nWWBLfsQ87KpmeviyLjd1/dqPjBz4gk3BGXInL0iuSpjRwU04hb/2L+JXVor3EbyC3/iDaGLbiZoXFmLnD4VCqiHLcW40O6v1yzmjCsl/cS39q/iZMRUGvGRpVRr538+Y8I5ltNx06JMOhF9xflX8SXZU7i/Kv4mTZmJDDzhEwsSp7KncX5V/EXZU7i/Kv4l0UkKDhU7i/Kv4jHCJ3E+VfxNEVpNmww1NnUz+xPlEHYnYdM6IvyiH7RiJNxVMrHE4rYC8EX4CBsTsfd/aPgJ6W1IHhMtfAq3CRZlGuOceYPhLftHwEzmmvdHwE9CxWxgdBAeM2KRwhyrWZRzPVr3V+Ajwt+ktyij5K5R6H1xi61oMFZ+Ufr35THll+seME+vMbrzBvXvyjde/KHPL9HHH8E+0mSTEMTa0Fdc/KFNng7tyLGaePLK5a2nKYyfGomVu4j1XAmZ2BnTbpGOO0a75esFYlibkm0Iu0yPSveZ21rjjAtmJ+Eqp4dicoUXCE52m2jh1Ggk91fUDKeCYSfZDDHViMUEWi5Az4Y2lJwphx6YmepTj7h9VmwbFPHwh2hX3luIIGU2YeoOGXOa45bmmOeGu2k4oRu1CYcXU3DpkdJQcWOU58vJlLpUwxsFO1iLtggk4ocou1DlJ9uQ4Yi/axF2sQSMWIjixD25DhiKnFiN2oQV2oR+1iL25DhiJNiBKKjAzGcUIhihFytVMZFnViKQ7UsUWzG9wRdUJZFOrjHNuquqHKLqhLYocIOVVdSOUttYRXkKrWEvHGQW2sOJXjw5cZRTfPLT65x61YZ38uRz4mNTOnrc8LcIVrj8WKl8+Ui7AR6j8s7a/75yFTO3M/STVRbTcHPhJIw4ShXC2z1v/AIlK1rG0VsEjazyG+fKZ3cjMmVPXOg1kXJcxbWe0g5vMD4i2tjEuIvpe0XI+LQxjJUsZkfEHllICvHMtHcehxAHsD6SZwC8oNw1ciHabXAPOVcZl25st41j7AvKROz15QhaK0nhC50OOzl5Rv01eUJ2jWj9cHOhh2csidnCFrRrReqDnQo7OWVvs4DOGbSLIDFfHD50B7MOUUNdnXlFJ9f8Ah86s3hH3hOaXpEnOTHSCnzh7aPW6LeEW8IAG3qfOS/XafOHupeujtxKMbU3Vgobbp85sfEB0VlIIJP04TbxZ8rossdMLjW/HIxK9xbyufHP/ABNFVlvYjhp/vlMbPYG1tfSPJpj8TWqQCfH6amWNUtckzC9biDlunLhrmZXiMUCMuIP8fkmTtWtr8RXz9fjlcW+EZavEzDvE68or5TPLJpji29ovrH35hXWa0sczpI3tprRlPG8g7MToY71kGhA846YoD9wPrGSlg3KQVGPCWvilJkO1hTHoNOGVgeU6DZ1S625Gcx24DM2tNOy9uUmcqrf5tNMctRh5cdupvHvBnbl7wi7cvek+2MeFE7xXgzti85IYwcxD3QcKI3ivB3ax3hH7YO9D3QcKIXivB/bB3o3ax3hD2jhRC8UH9rHeEUPdB668svHEe0e0wdBrmPvHnHtH3YA28ec67ojUL0nQ5BWBv5j/ABOSCw/0TxQSoysbBkPlcZj7zTxZayRljuDu0agsTmDw8oLOKuMjwv8AWNjdv0AxXcZ87E6j08JiSvSc3S6kcGzE0y8kt6aY+LKTtveqCoBIG8Da3K+cgnLgB/MwUSA1yeZ56wpSTIngdPExW7hzHVW7sprCWDPnJdTbxvxmdaRBVCgb2pHGYcbis7A5W0EnjnztxtPH8Z0zxgyIVCf6M/Mb95eGFy+IyzmP13+Ndz7t/POCw9YN7x+s4R+lmNP/AO7D+0Iv/wAqJdU697I9ar1re1ZnO5u8785rPFf7WN80/Ho+H2iwHtH4/wCZbW21QVTvVqanUAugOXheec9HtnUq9cgpUNPdIu2974I1KnkTleX9M+jD4dusp0itDdQb17gObi2Z3uAi9eO9Wq9uXHcjotodJsO2RrqB/SGb/wCQZThOlGEpG6O7kA5KjX0/qInmkO0Ka0/Y31RyLs97qydzPQ6fCaTx4yMb5cq66t/yCoG8KdUg6FrKD5G5h/Zu13rUkqAkBhe172zIIvx0nBbE2W2KYNuslBc1As674IupB5gk6TvqdFVAVVCqNAoAAub5ATn80wx6n1eHK91qGNfvGLtz94yndjbswa6XHHv3jIttF+8ZSyyDLENNSbRc/uMl+oP3jMaGTvGTT+ov3jGmTeEUNBs/Tn7pjdhfumejGivISith1schLuMiJlt52aZGsbchXHUfbNpn6mTYqMe7NOEU3a2RKkCWClLKFOzAwXjdWB+zMNvsxP7R9ZRiSiOGL2Om75wqq7iVbd/+Rf7zlMUpZyToDCOq9unwNJnY2Fwup5eELI4AAPDnL9mMqU1AADFFZrcSwuSeZzmbEZN58ZXxl9q5cSBNdKpcZa84FsRnkT4zTQrBRYDKPY01ts7eN3sfP7TnukXQ2hiEa4CVDuhagBYooYMQFLAG4uPWdB26w/EpqYy+ovHjlq7ibjy6ryKj0IxaVSVWmVVmCl2WzLchWKqSRcWNpP8A6TxRDU2qUrM28Qu8xBy4kCwFhPS6mDDm4JXylg2eiDLU8TmTNfbWfoxB+j2wkoKFUWuQWzJBawBOZ8J1b4RKiFGUHLiLjzzmbZ9EMdROhoYayyJbbtV1jNPHKnRTDI7CojG5JzZgNfAiHtlbBwPu9npm+V2G+fP2rzq9rYBM2IBH7gfheDURVyUAW5SuWX9pcMbOoFpgVpXRUVACclUKL87DyktyEMWl3J52P0lHVzny+pZtyNuzV1cXVxBkKytkm405E0oHtgKROuU2dTGr0soQqGxSzdilDb1Kxj1V9kyy0qxD+yfKFZ725XEpdzIChNSrdjLuqjOMHURCjCApR+qi0ewTEputnmjix8GHun7ekx1OjLsAyEMrZ20I8DznR1sPcZjLiPCQXCGqLhmQcCMr+kWnRjnvFhwmHNOyk5gc72HC8udbzViUp0UCXuSy5nUm/GQIhVS7YnSUsCJuqJMbrnAKy8YPIsMyZBzlDYbKNcCZ8VibnM5TI1SwmnB4LfBZjYHQSpR0P7Ow9PcDEi31k8btJQLK3wnH7RXEIu4rezoGB9q0B03rocyzj+o3l7uukWd7ruxj94lScmG6fXKDUqZ29JRsqizn28jbIA8fGa9mYYtUsf23J9P8wu/6OUbjRjdTCJpxdVM7GNob1EXUQj1UXVQ0NhpoRuohI043VRaGwwUM5HF0fZhXqpTjafswkJznVxTVuxRh6JaUvTuJpAlVbIEwyjOVh7MsdKAJgg46oXIC5Ca6Fepyi2003vRAjpQExtVqHhHWpU5GPkWmtqAmTE4Zx/4yP7Wy+BEdq1TuyPWvy/EXLasdztyW06LlkLtc7+g0FoYRspXjQG9oEEbxsfWVCpG6ZdrarTFht472+OORlzVJJXgGWrTtMtYGbqhF5QbGIMSUyzBeevkITNcL7PlbL+IPZ91ydLJl5kzC+Kq1D7HxJt9ZWMK0YxNdF99wvhqfhBr4uiTYb1udrfSD6mzqxzut/U/WVfp2I5L57wlyEPYbaKIwAU203uXjadPszDjedhxtb1FzODobNqoCz1A3G2trnmJ3Oy8WEprca5/b7R5XU7ZZT8Flw15Lskwjb6DWTTb9M8ZMsZdtTYSVnDGQfbtMcYqe2qZ4w3B2l2cxDDGXHadMamQ/VqfOHQ7Q7KZXicEWFpqXaSc5MYxDxi3iOwL9IaKHO1pFFyxPYiJCqMjJyNTSXfjKfQ/D4cXJtNiURIUFmkTOYryy7R6sRwgjxwJpMYz2iaYmHaotTcLqVMIMYNxj6xzGHK4vo7U38Gh4jeB81dgRI1qtpuWktFiiiyOzOvIMxu49TczJjqY4cZnl9d2F3FKYkGXo8FssnTqESVN1WpKOutK3rypKgveMzOpc3I9mW7oVcsparBjmZZVcDK2UE0NrYk8DaULi3JteG6eETU2Jkd1AwG6LyoKWyqDVSEP7iAfLj9BO5qbPTdsFFgLD0gTYABqrYaAk/C33nVNHl25fJlZk5XH7HU6CPgthIBmJ0b0xJJTkaHKOXx2w14CW4DYqjUTpHpxU6do9Fy6B8XshSuQmbD7HUDMTpCJBqd4riJm59Nmg3tLaOz+EOJSAkgghwpXKUG/To8M7sUPWnl/h5F9JKRfQzSkqoS6VUJoixnQy+mEeNeV1KwEuQjYhrLAlaobzfia98uf2g6sM47NCMuKoK6lTx+nIjxnPVarIxSoc/wBp7y8/OdNBm2NnCqltGGatyP4kWN/HnxoA7i8rLzJ1jKSjizDUfceEsVrzLTq3ta7gyph4xnSVFTGFtKrutzloxQ4t9/SY90xCmJU0kSbFgcZUuOBIFwCTqcoJ2nXKJcC5JsL8MjnB+Dqlxc5tz/3hLxx2yyz109r6OYNEp7yNvlrXb7CF7Tzbopt1ksjE5ZWPEcvPkZ6Ph6yuoZdDHcXNlbvaVo4Ee0lFotoGNaSIihoyjSVo8NEjFGJExYrF2yENi3TdvRQF2lucUNp5QdkKmknIuLiJX9V0JaTKSwUQdiMfn7JLeCgt/GUrHHU7Fu6JVKsxVHzgnE16jgtv9Wq5kWufU8PSUpjHNrbr38SDbna0rY01Y+tuujcN6x8m9n7y6qswPg1cEVN52OhawCnUboGQ89Zs6y6jK5tn58ZNuzim8a8dhItAwrbWzRUW4ycDI/acupKkq+TDIid9bnAe2tk9ZdlsHGh5+DeH8SbjtthnrquWqVze0iapEhVBU7rqVYZZiUljfmOcl0b23rWEg1WZQCTNOGpgG7Z8pUhUP6SMQif3Z+oyg/ZlTMwztWlvo3OAtlEKxDTXH45s52P7OYk34jTx/wAT0Lo3tcqLNmp1HEHnPP8ABOtzadFs+pbMDL935hWdenIwIuDcHlJzkqVUgeyX0uu6xB8RyMuobVfvEj+oAn1GRk6J0xjCCqO1r67p8sv5hCjiFbT4RWUl8g7Wk5EiKhgxFUnITMaJMK7gjhBMtUalCOyGKGN0RpWqNT8OSBmcpkqYu+S6c/xzmJsaHOZsOC/c+McVVm01DWVhvDmf6tPhpMdWlV0BW3hlNLVhAvSDpPSwy3clnI9lBqfFjwEew0vs93UoW97ll9ZjfZtRLGpVpIq/uFwSONwbC9uN/ScRiP8AkPFOT1aqg4WFz9bwQ9bE4lizuxPmYB6djtuYZFt1qsxI3QpDEm+WnCbqFQEZHWx+M856PbGUMSwueZnc4YkWXLTj4ZyKbRWflFRa8hib5DLPlLqKWEAm4mZ0M2Mkx1iNM/DnAMW0NnI4s9vBhqv5HhOWx+yWpGx0OhHun/PhCPSTpMmGuiEPWI01VPE828JX0c2qMVRam43qq62ObLwdQcrjQxXFphnZ9A0pm820qdoXrbGdRvBSR5EMPNZmCcLRadEsvxielcWnNYnCMj6azteovpMe0sFvADRs7HxAylys88egrZgz9Idw7lc9LGC9mgX3T7LZXU6+h4+U6TC0haxFwdRBjT4vaNWinWIgcA3ZQSTu8SADnb+PKQw3SzCshqurg3G+osQCcgQTa00krQXNgb5KGIvflczzqvidyu4ZAisSHp8LHW3hxEcQ9EodL8BqSw8x+CYTwXSvAubJUVT/AFXX6nKeQVtnFWIFyNVPNTpM1fCMhGouMjpKD6Mw2MBAzuDoRmPjNt58/dH+lNfCuPaLJxQ3seeXDzGfnPcdibRTEUlqJoR8OYMnKBvMYmIxGZ0GvFIxRbGnP16YAy/31mbrCDbOWdcDE26eXlLPTFtfbCUKbO2ZGSr3n4DynmWJD4gmq5LM5ufDwnVY5Ria5p2tT3H3DzdWUb0qwuzSqMCM1Mc6JzNDAlGBIy4zrNn7OVc10IkUwoYWhHZSlRunhC0aTw9HdN5vZrEHxH4lZWzSWIF0MRiNPDC+8b38fxNFo2GTeRW0uoPxAmTaG2MPRB36qgjgPab4CAa6gy/34mcD0m6WW3qWGNzmHq/ZPzKekPSh8QNykClM6k+8/nbQeE5pcNHIA5qdyScycyeJk8NUem4dGKMpyZciIQOFkezytlqjSdNMVkd8HIXuBnz8Zf8A9Wu5AqItuJW+95gk/Sc22GIjqhi1FS2O+wFdKi7yG448CPMSrHN7a2/aGJ+Fh9TOV2Zi3pOGU5X9ocCON51tEB2Njfj6cJLW57xB6+HJfehJscaVPfB3rWG6Rncm178pOtRlTYbeVgdCpvF/WTj9s4upWfecmw90cB5S7FuMRS3iP+7TGveTj68fjCr7MBlP6Q4N094fXwmiWvo3R67D55sht6f7/Mvxuy+sQrb219pfTUfCWdGFNJArAg3O8D55Q7iEsQwk2jTzytsdipsLm07z/iXH/wDbekx0YEA8D7pH0lbYUB8hk2Y+8zbJpDDYpmOVOrax4K7WIvyG8p+Me9h6nFKcJXDrfiMiORlszoK0UeKIOPxbKTmLHvLkfwYN2klRUsntlyE3gLbiH3ieRtNmJ4GNRxOdpZgu2KgodTURfZT2SB3WGf8AEMqisN5dGF/QjKZdt4XeRh+wj5TwPleZOj2JJohT71MlD/66fS0Atw62axhDqeIg+pkbwnRqXS8AjV0BiJupjtmJXQHCAc1tNnY7pZrDIC5sB5QA+zjfOdxi8Fdr2lDYEcoQ3MYbB5TQMJ4Q6mFtwifDR7ASmDvINs+GEp2kqtHjEARcIAbEZS07KU5jSbXTwk8O9sjDYYDsdSOUI7FQoShN7Ll5XNvvL6oyuJRsQlncnhuqPgT94bLbe9OV1ksh8YRWjeZMcB7vEawG2CmmUtSjHpLNFMZ2jJTiKNhcTdhzvJaMqXBErwhsSIjPu5eIz/MpxuF62k6AgMVO6ToG1Un1Am5hmDwMyA7rMPA/4jKiWwNoPTVBVHtFgj53GQChr+gnXzz+s5st9Tmf99Z3WCq76I3NR8bZyaKuijxRaDyd9Jl4xRTYNb+63kf4gXYutb+/7RRRlGupNeH9yKKI000jU9Y0UCSqyoxoozQkGjxQCEk8eKIVmaUmKKOG0p7pkdifv/v+wiigQ1Tgyt77+f2jxQCK6y1NYoowtSMnvRRQCfCZq/vHy+0UUCKvwnWbN/8AEnl94oohWiKKKIP/2Q==" alt="mdo" width="32" height="32" class="rounded-circle">
                            </a>
                            <ul class="dropdown-menu text-small">
                                <li><a class="dropdown-item" href="#">New project...</a></li>
                                <li><a class="dropdown-item" href="#">Settings</a></li>
                                <li><a class="dropdown-item" href="#">Profile</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Sign out</a></li>
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
        <div id="left-content" >
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
            abc
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
