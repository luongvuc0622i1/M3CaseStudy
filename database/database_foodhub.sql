
-- DROP DATABASE foodhub;
CREATE DATABASE foodhub;

USE foodhub;


CREATE TABLE	service (
	service_id		INT				AUTO_INCREMENT PRIMARY KEY,
    service_name	nVARCHAR(100)	NOT NULL,
    service_price	INT				NOT NULL,
    service_description nVARCHAR(500)
);

CREATE TABLE	shop (
	shop_id 		INT				AUTO_INCREMENT PRIMARY KEY,
	shop_code 		nVARCHAR(150) 	NOT NULL UNIQUE,
    shop_name 		nVARCHAR(150) 	NOT NULL,
    shop_email 		nVARCHAR(150) 	NOT NULL UNIQUE,
    shop_phone 		nVARCHAR(150) 	NOT NULL UNIQUE,
    shop_address 	nVARCHAR(150) 	NOT NULL,
    shop_account 	nVARCHAR(150) 	NOT NULL UNIQUE,
    shop_password 	nVARCHAR(150) 	NOT NULL,
    shop_image 		NVARCHAR(150)	NOT NULL,
    shop_open		TIME			NOT NULL,
    shop_close		TIME			NOT NULL,
    service_id		INT				NOT NULL,
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
    food_cooktime 	TIME			NOT NULL,
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
	client_id 	INT 			NOT NULL,
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
						("Phí Dịch Vụ", 4000, "Phí hoàn xu, trừ tiền ship Xtra"),
						("Phí ship Xtra", 5000, "Phí thương vụ, bắt buộc");

INSERT INTO		shop	(shop_code, shop_name, shop_email, shop_phone, shop_address, shop_account, shop_password, shop_image, shop_open, shop_close, service_id, shop_description, status)
VALUES
						("ST01", "Âm dương Sốp", "phong@gmail.com", "1111", "50 Trần Bình", "lunisolar", "123456", "https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg", "08:00:00", "21:00:00", 1, "Quán Phong mở", 1),
						("ST02", "Bảnh Bu-lông", "banh@gmail.com", "2222", "69 Cầu Diễn", "banh", "123456", "https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg", "08:00:00", "21:00:00", 1, "Quán Bảnh mở", 1),
						("ST03", "Linh thịt chó", "linh@gmail.com", "093333", "49 Mỹ Đình", "linh", "123456", "https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg", "08:00:00", "21:00:00", 1, "Quán Linh mở", 1),
						("ST04", "Lương Sơn Bạc", "luong@gmail.com", "Bồ câu", "53 Trần Duy Hưng", "luong", "123456", "https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg", "08:00:00", "21:00:00", 1, "Quán Lương mở", 1),
						("ST05", "Huy Thức ăn cho chim", "huy@gmail.com", "095555", "63 Trần Duy Hưng", "huy", "123456", "https://haycafe.vn/wp-content/uploads/2022/02/Hinh-avatar-facebook-doc-ngon-giua.jpg", "08:00:00", "21:00:00", 1, "Quán Huy mở", 1);

INSERT INTO		admin	(admin_name, admin_account, admin_password, admin_image)
VALUES
						("admin", "admin", "admin", "https://cdn-icons-png.flaticon.com/512/892/892694.png?w=360");

INSERT INTO		deal	(deal_code, deal_name, deal_percent, deal_startDate, deal_endDate, deal_description, deal_image, status)
VALUES					
						("ALLFREE", "Freeship 0đ", 15000, "2022-10-04", "2022-11-04", "Freeship tới 3Km", "https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb", 1),
						("HUNGDS", "Khao 50K", 50000, "2022-10-04", "2022-10-05", "chào bạn mới với 50K", "https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb", 1),
						("CUOITUAN105", "Giảm 105k", 105000, "2022-10-04", "2022-10-07", "Giảm giá sản phẩm 105K", "https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb", 1),
						("DEALXIN", "Giảm 70k", 70000, "2022-10-04", "2022-12-04", "Giảm 70K với nhãn hàng", "https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb", 1),
						("NULL", "Freeship 0đ", 0, "2022-10-04", "2022-11-04", "Giảm tiền tới 0đ", "https://cf.shopee.vn/file/faef5c8b89f60eebdd161e08707ecbbb", 1);

INSERT INTO		tags	(tags_code, tags_name, tags_description, status)
VALUES
						("DA01", "Đồ ăn", "Đồ để ăn", 1),
						("DU01", "Đồ uống", "Đồ để uống", 1),
						("DA02", "Đồ chay", "Đồ để ăn chay", 1),
						("BK01", "Bánh kem", "Bánh sinh nhật, Bánh ngọt Pháp", 1),
						("DA03", "Tráng miệng", "Dùng sau khi ăn", 1),
						("OT01", "Home made", "Nhà làm", 1),
						("OT02", "Vỉa hè", "Vỉa hè làm", 1),
						("OT03", "Đồ ăn Ngoại", "Thực phẩm nước ngoài", 1),
						("OT04", "Lẩu", "Lẩu các loại", 1),
						("OT05", "Nướng", "Nướng các loại", 1),
						("OT06", "Cơm hộp", "Cơm văn phòng", 1),
						("OT07", "null", "null", 1);

INSERT INTO		food	(shop_id, tags_id, deal_id, food_name, food_price, food_description, food_image, food_cooktime, food_daycreate, food_lastupdate, status)
VALUES
						(1, 1, 1, "Cơm thố", 50000, "Cơm làm từ thố", "https://media.foody.vn/res/g70/699961/prof/s/foody-upload-api-foody-mobile-87dc1dd7-48c8-442f-8-200903152049.jpg", "00:30:00", "2022-09-04", "2022-10-04", 1),
						(2, 2, 2, "Rượu đế", 200000, "Rượu làm từ đế", "https://dacsanhuongquynh.vn/wp-content/uploads/2021/04/Ruou-de-1.jpg", "00:30:00", "2022-09-04", "2022-10-04", 1),
						(3, 3, 3, "Giò chay", 120000, "Giò được làm từ nấm và rau", "https://thucduong.org/wp-content/uploads/2019/11/cach-lam-gio-lua-chay-tai-nha.jpg", "00:30:00", "2022-09-04", "2022-10-04", 1),
						(4, 4, 4, "Bánh kem Pháp", 70000, "Làm từ công nghệ Pháp", "https://blog.beemart.vn/wp-content/uploads/2016/07/tong-hop-cac-loai-banh-ngot-Phap-noi-tieng-lam-me-man-long-nguoi-5.jpg", "00:30:00", "2022-09-04", "2022-10-04", 1),
						(5, 5, 5, "Thăng long", 50000, "Li Kô teen", "https://thaotomsmart.com/wp-content/uploads/2022/06/kiotviet_d5e2d57069d8196146923207b9b4b03b.jpg", "00:30:00", "2022-09-04", "2022-10-04", 1);
					
INSERT INTO		social	(food_id)
VALUES
						(1),
						(2),
						(3),
						(4),
						(5);
                        
INSERT INTO		client	(client_code, client_name, client_phone, client_address, client_email, client_account, client_password, status)
VALUES
						("KH01", "Hùng", "096666", "69 Nhà vệ sinh", "hung@gmail.com", "hung", "123456", 1);
                        
INSERT INTO		bill	(bill_code, bill_date, bill_totalCost, client_id, shop_id, status)
VALUES
						("B111", "2022-10-05", 500000, 1, 2, 1);

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
											

-- USE foodhub;