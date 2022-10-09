package service.shop;

import model.Shop;
import service.IService;

public interface IShopService extends IService<Shop> {

    Shop selectShopByName (String name);

    void insertDefaul(Shop shop);

    Shop blockShopById(int id);
    Shop unblockShopById(int id);

}
