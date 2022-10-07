package service.billDetail;

import model.BillDetail;
import service.IService;

public interface IBillDetail extends IService<BillDetail> {
    void add(BillDetail billDetail , int[] billDetails);
}
