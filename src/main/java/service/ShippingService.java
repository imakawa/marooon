package service;

import java.util.ArrayList;
import java.util.List;

import model.Shipping;
import dao.ShippingDao;;

public class ShippingService {

	public ShippingService() {
		// TODO Auto-generated constructor stub
	}

    private ShippingDao shippingDao;
	
	public ShippingDao getShippingDao() {
		return shippingDao;
	}

	public void setShippingDao(ShippingDao shippingDao) {
		this.shippingDao = shippingDao;
	}

	public Integer Create(Shipping shipping){
		return shippingDao.Create(shipping);
	}
	
	public Integer Update(Shipping shipping){
		return shippingDao.Update(shipping);
	}
	
	public List<Shipping> Read(){
		List<Shipping> products = new ArrayList<Shipping>();
		try{
			products = shippingDao.Read();
		}catch(Exception e){
		}
		return products;
	}
	
	public Shipping Read(String id){
		return shippingDao.Read(id);
	}
	
	public Integer Delete(Shipping shipping){
		return shippingDao.Delete(shipping);
	}
}
