package service.client;

import model.Client;
import model.Service;
import model.Shop;
import service.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public interface IClientService extends IService<Client> {

    Client blockClientById(int id);
    Client unblockClientById(int id);

    List<Client> fillAllForAdmin();
}
