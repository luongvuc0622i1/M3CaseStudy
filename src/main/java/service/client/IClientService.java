package service.client;

import model.Client;
import model.Shop;
import service.IService;

public interface IClientService extends IService<Client> {

    Shop blockClientById(int id);
    Shop unblockClientById(int id);

}
