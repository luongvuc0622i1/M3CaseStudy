-- STORE PROCEDURE

USE foodhub;

DELIMITER $$
CREATE PROCEDURE blockShopById(IN shop_id INT)

BEGIN

    UPDATE foodhub.shop
    SET status = 0
    WHERE shop.shop_id = shop_id;

    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE unblockShopById(IN shop_id INT)

BEGIN

    UPDATE foodhub.shop
    SET status = 1
    WHERE shop.shop_id = shop_id;

    END$$
DELIMITER ;

CALL unblockShopById(3);

DELIMITER $$
CREATE PROCEDURE blockClientById(IN client_id INT)

BEGIN

    UPDATE foodhub.client
    SET status = 0
    WHERE client.client_id = client_id;

    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE unblockClientById(IN client_id INT)

BEGIN

    UPDATE foodhub.client
    SET status = 1
    WHERE client.client_id = client_id;

    END$$
DELIMITER ;

CALL blockShopById(3);