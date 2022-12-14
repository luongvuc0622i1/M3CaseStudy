
DROP DATABASE foodhub;
CREATE DATABASE foodhub;

USE casestudy3;


CREATE TABLE	service (
                            service_id		INT				AUTO_INCREMENT PRIMARY KEY,
                            service_name	nVARCHAR(100)	NOT NULL,
                            service_price	INT				NOT NULL,
                            service_description nVARCHAR(500)
);

CREATE TABLE	shop (
                         shop_id 		INT				AUTO_INCREMENT PRIMARY KEY,
                         shop_code 		nVARCHAR(150) 	UNIQUE,
                         shop_name 		nVARCHAR(150) 	,
                         shop_email 		nVARCHAR(150) 	UNIQUE,
                         shop_phone 		nVARCHAR(150) 	UNIQUE,
                         shop_address 	nVARCHAR(150) 	,
                         shop_account 	nVARCHAR(150) 	UNIQUE,
                         shop_password 	nVARCHAR(150) 	,
                         shop_image 		NVARCHAR(150)	,
                         shop_open		TIME			,
                         shop_close		TIME			,
                         service_id		INT				,
                         shop_description nVARCHAR(500),
                         status 			bit,
                         FOREIGN KEY		(service_id)	REFERENCES	service (service_id)
);

CREATE TABLE 	admin (
                          admin_id		INT				AUTO_INCREMENT PRIMARY KEY,
                          admin_name		nVARCHAR(150)	NOT NULL,
                          admin_account 	nVARCHAR(150) 	NOT NULL UNIQUE,
                          admin_password 	nVARCHAR(150) 	NOT NULL,
                          admin_image 	nVARCHAR(150)	NOT NULL
);


CREATE TABLE	deal (
                         deal_id 		INT 			AUTO_INCREMENT PRIMARY KEY,
                         deal_code 		nVARCHAR(150) 	NOT NULL UNIQUE,
                         deal_name 		nVARCHAR(150) 	NOT NULL,
                         deal_percent	DOUBLE			NOT NULL,
                         deal_startDate 	date,
                         deal_endDate 	date,
                         deal_description nVARCHAR(150),
                         deal_image 		nVARCHAR(150),
                         status 			bit
);

CREATE TABLE	tags (
                         tags_id 		INT 			AUTO_INCREMENT PRIMARY KEY,
                         tags_code 		nVARCHAR(150) 	NOT NULL UNIQUE,
                         tags_name 		nVARCHAR(150) 	NOT NULL unique,
                         tags_description nVARCHAR(150),
                         status 			bit
);

CREATE TABLE 	food (
                         food_id 		INT 			AUTO_INCREMENT PRIMARY KEY,
                         shop_id 		INT 			NOT NULL,
                         tags_id 		INT 			NOT NULL,
                         deal_id 		INT,
                         food_name 		nVARCHAR(150) 	NOT NULL,
                         food_price 		DOUBLE			NOT NULL,
                         food_description nVARCHAR(150),
                         food_image 		nVARCHAR(150),
                         food_cooktime 	TIME			,
                         food_daycreate	date,
                         food_lastupdate	date,
                         status 			bit,
                         FOREIGN KEY (shop_id)		REFERENCES shop (shop_id),
                         FOREIGN KEY (tags_id)		REFERENCES tags (tags_id),
                         FOREIGN KEY (deal_id)		REFERENCES deal (deal_id)
);

CREATE TABLE	social (
                           food_id			INT,
                           views			INT    			DEFAULT 100,
                           ORDERR			INT				DEFAULT 200,
                           FOREIGN KEY		(food_id)		REFERENCES		food(food_id)
);

CREATE TABLE client (

                        client_id 		INT 			AUTO_INCREMENT PRIMARY KEY,
                        client_code 	nVARCHAR(150),
                        client_name 	nVARCHAR(150),
                        client_phone 	nVARCHAR(150) 	UNIQUE NOT NULL,
                        client_address 	nVARCHAR(150)	NOT NULL,
                        client_email 	nVARCHAR(150) 	UNIQUE NOT NULL,
                        client_account 	nVARCHAR(150) 	UNIQUE NOT NULL,
                        client_password nVARCHAR(150)	NOT NULL,
                        status 			bit
);

CREATE TABLE bill (
                      bill_id 		INT 			AUTO_INCREMENT PRIMARY KEY,
                      bill_code 		nVARCHAR(150) 	NOT NULL UNIQUE,
                      bill_date 		date 		NOT NULL,
                      bill_totalCost 	DOUBLE 			NOT NULL,
                      client_id 		INT 			NOT NULL,
                      shop_id 		INT 			NOT NULL,
                      status 			BIT 			NOT NULL,
                      FOREIGN KEY (client_id)	REFERENCES client (client_id),
                      FOREIGN KEY (shop_id)		REFERENCES shop (shop_id)
);

CREATE TABLE bill_detail (
                             bill_detail_id 	INT 			AUTO_INCREMENT PRIMARY KEY,
                             bill_id 		INT ,
                             food_id 		INT,
                             quantity 		INT 			NOT NULL,
                             price 			DOUBLE			NOT NULL,
                             status 			bit,
                             FOREIGN KEY (bill_id) 		REFERENCES bill(bill_id),
                             FOREIGN KEY (food_id) 		REFERENCES food(food_id)
);

-- INSERT INTO



INSERT INTO 	service	(service_name, service_price, service_description)
VALUES
    ('Ph?? D???ch V???', 4000, 'Ph?? ho??n xu, tr??? ti???n ship Xtra'),
    ('Ph?? ship Xtra', 5000, 'Ph?? th????ng v???, b???t bu???c');

INSERT INTO		shop	(shop_code, shop_name, shop_email, shop_phone, shop_address, shop_account, shop_password, shop_image, shop_open, shop_close, service_id, shop_description, status)
VALUES
    ('ST01', '??m d????ng S???p', 'phong@gmail.com', '1111', '50 Tr???n B??nh', 'lunisolar', '123456', 'https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg', '08:00:00', '21:00:00', 1, 'Qu??n Phong m???', 1),
    ('ST02', 'B???nh Bu-l??ng', 'banh@gmail.com', '2222', '69 C???u Di???n', 'banh', '123456', 'https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg', '08:00:00', '21:00:00', 1, 'Qu??n B???nh m???', 1),
    ('ST03', 'Linh th???t ch??', 'linh@gmail.com', '093333', '49 M??? ????nh', 'linh', '123456', 'https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg', '08:00:00', '21:00:00', 1, 'Qu??n Linh m???', 1),
    ('ST04', 'L????ng S??n B???c', 'luong@gmail.com', 'B??? c??u', '53 Tr???n Duy H??ng', 'luong', '123456', 'https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg', '08:00:00', '21:00:00', 1, 'Qu??n L????ng m???', 1),
    ('ST05', 'Huy Th???c ??n cho chim', 'huy@gmail.com', '095555', '63 Tr???n Duy H??ng', 'huy', '123456', 'https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg', '08:00:00', '21:00:00', 1, 'Qu??n Huy m???', 1);

INSERT INTO		admin	(admin_name, admin_account, admin_password, admin_image)
VALUES
    ('admin', 'admin', 'admin', 'https://cdn-icons-png.flaticon.com/512/892/892694.png?w=360');

INSERT INTO		deal	(deal_code, deal_name, deal_percent, deal_startDate, deal_endDate, deal_description, deal_image, status)
VALUES
    ('ALLFREE', 'Freeship 0??', 15000, '2022-10-04', '2022-11-04', 'Freeship t???i 3Km', 'https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb', 1),
    ('HUNGDS', 'Khao 50K', 50000, '2022-10-04', '2022-10-05', 'ch??o b???n m???i v???i 50K', 'https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb', 1),
    ('CUOITUAN105', 'Gi???m 105k', 105000, '2022-10-04', '2022-10-07', 'Gi???m gi?? s???n ph???m 105K', 'https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb', 1),
    ('DEALXIN', 'Gi???m 70k', 70000, '2022-10-04', '2022-12-04', 'Gi???m 70K v???i nh??n h??ng', 'https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb', 1),
    ('NULL', 'Freeship 0??', 0, '2022-10-04', '2022-11-04', 'Gi???m ti???n t???i 0??', 'https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb', 1);

INSERT INTO		tags	(tags_code, tags_name, tags_description, status)
VALUES
    ('DA01', '????? ??n', '????? ????? ??n', 1),
    ('DU01', '????? u???ng', '????? ????? u???ng', 1),
    ('DA02', '????? chay', '????? ????? ??n chay', 1),
    ('BK01', 'B??nh kem', 'B??nh sinh nh???t, B??nh ng???t Ph??p', 1),
    ('DA03', 'Tr??ng mi???ng', 'D??ng sau khi ??n', 1),
    ('OT01', 'Home made', 'Nh?? l??m', 1),
    ('OT02', 'V???a h??', 'V???a h?? l??m', 1),
    ('OT03', '????? ??n Ngo???i', 'Th???c ph???m n?????c ngo??i', 1),
    ('OT04', 'L???u', 'L???u c??c lo???i', 1),
    ('OT05', 'N?????ng', 'N?????ng c??c lo???i', 1),
    ('OT06', 'C??m h???p', 'C??m v??n ph??ng', 1),
    ('OT07', 'null', 'null', 1);

INSERT INTO		food	(shop_id, tags_id, deal_id, food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, status)
VALUES
    (1, 1, 1, 'C??m th???', 50000, 'C??m l??m t??? th???', 'https://media.foody.vn/res/g70/699961/prof/s/foody-upload-api-foody-mobile-87dc1dd7-48c8-442f-8-200903152049.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (2, 2, 2, 'R?????u ?????', 200000, 'R?????u l??m t??? ?????', 'https://dacsanhuongquynh.vn/wp-content/uploads/2021/04/Ruou-de-1.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (3, 3, 3, 'Gi?? chay', 120000, 'Gi?? ???????c l??m t??? n???m v?? rau', 'https://thucduong.org/wp-content/uploads/2019/11/cach-lam-gio-lua-chay-tai-nha.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (4, 4, 4, 'B??nh kem Ph??p', 70000, 'L??m t??? c??ng ngh??? Ph??p', 'https://blog.beemart.vn/wp-content/uploads/2016/07/tong-hop-cac-loai-banh-ngot-Phap-noi-tieng-lam-me-man-long-nguoi-5.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (5, 5, 5, 'Th??ng long', 50000, 'Li K?? teen', 'https://thaotomsmart.com/wp-content/uploads/2022/06/kiotviet_d5e2d57069d8196146923207b9b4b03b.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1);

INSERT INTO		social	(food_id)
VALUES
    (1),
    (2),
    (3),
    (4),
    (5);

INSERT INTO		client	(client_code, client_name, client_phone, client_address, client_email, client_account, client_password, status)
VALUES
    ('KH01', 'H??ng', '096666', '69 Nh?? v??? sinh', 'hung@gmail.com', 'hung', '123456', 1);

INSERT INTO		bill	(bill_code, bill_date, bill_totalCost, client_id, shop_id, status)
VALUES
    ('B111', '2022-10-05', 500000, 1, 2, 1);

INSERT INTO		bill_detail 	(bill_id, food_id, quantity, price, status)
VALUES
    (1, 1, 1, 50000, 1);

CREATE TABLE food_tags (
                           food_id			INT,
                           tags_id			INT,
                           FOREIGN KEY	(food_id)		REFERENCES		food (food_id),
                           FOREIGN KEY	(tags_id)		REFERENCES		tags (tags_id)
);

INSERT INTO food_tags (food_id, tags_id) VALUES (1,1), (1,2), (2,2);
<<<<<<< HEAD
=======
INSERT INTO		food	(shop_id, tags_id, deal_id, food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, status)
VALUES
    (2, 2, 2, 'c??m l???n', 50000, 'l??m t??? g???o v?? ???c ', 'https://media.foody.vn/res/g70/699961/prof/s/foody-upload-api-foody-mobile-87dc1dd7-48c8-442f-8-200903152049.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (3, 3, 3, 'th???t ch??', 220000, 'l??m t??? ch?? t????i ????ng l???nh', 'https://dacsanhuongquynh.vn/wp-content/uploads/2021/04/Ruou-de-1.jpg', '00:30:00', '2022-09-04', '2022-10-04', 0),
    (1, 1, 1, '???c s??o m???t ong', 200000, 'l??m t??? ??c v?? m???t ??ng', 'https://thucduong.org/wp-content/uploads/2019/11/cach-lam-gio-lua-chay-tai-nha.jpg', '00:30:00', '2022-09-04', '2022-10-04', 0),
    (1, 1, 1, 'h???t v???t l???n', 70000, 'l??m t??? tr???ng v???t c?? tr???ng', 'https://blog.beemart.vn/wp-content/uploads/2016/07/tong-hop-cac-loai-banh-ngot-Phap-noi-tieng-lam-me-man-long-nguoi-5.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (5, 5, 5, 'b???t t??m', 50000, 'giun ?????t', 'https://thaotomsmart.com/wp-content/uploads/2022/06/kiotviet_d5e2d57069d8196146923207b9b4b03b.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1);

>>>>>>> 823a845df5e5eef21f9462ead3b6c65f4cc69316


INSERT INTO		food	(shop_id, tags_id, deal_id, food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, status)
VALUES
    (2, 2, 2, 'c??m l???n', 50000, 'l??m t??? g???o v?? ???c ', 'https://media.foody.vn/res/g70/699961/prof/s/foody-upload-api-foody-mobile-87dc1dd7-48c8-442f-8-200903152049.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (3, 3, 3, 'th???t ch??', 220000, 'l??m t??? ch?? t????i ????ng l???nh', 'https://dacsanhuongquynh.vn/wp-content/uploads/2021/04/Ruou-de-1.jpg', '00:30:00', '2022-09-04', '2022-10-04', 0),
    (1, 1, 1, '???c s??o m???t ong', 200000, 'l??m t??? ??c v?? m???t ??ng', 'https://thucduong.org/wp-content/uploads/2019/11/cach-lam-gio-lua-chay-tai-nha.jpg', '00:30:00', '2022-09-04', '2022-10-04', 0),
    (1, 1, 1, 'h???t v???t l???n', 70000, 'l??m t??? tr???ng v???t c?? tr???ng', 'https://blog.beemart.vn/wp-content/uploads/2016/07/tong-hop-cac-loai-banh-ngot-Phap-noi-tieng-lam-me-man-long-nguoi-5.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1),
    (5, 5, 5, 'b???t t??m', 50000, 'giun ?????t', 'https://thaotomsmart.com/wp-content/uploads/2022/06/kiotviet_d5e2d57069d8196146923207b9b4b03b.jpg', '00:30:00', '2022-09-04', '2022-10-04', 1);


USE foodhub;