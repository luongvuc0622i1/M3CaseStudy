package service.food;

import model.Food;
import service.IService;

import java.util.List;

public interface IFoodService extends IService<Food> {

    void insert (model.Food food);
    public void save (Food f, int[] tag);
    public List<Food> selectFoodByName (String name);
    List<Food> findAllFoodByIdShop (int id);
    List<Food> findAllFoodByIdDeal (int id);
    List<Food> findAllFoodByIdTag (int id);

}
