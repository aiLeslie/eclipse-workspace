package Store;

import java.util.Map.Entry;
import java.util.Set;

public class Biz {
	
	public static long putStorage(long id,long count) {
		if(id < 0)return -1;
		if(Commodity.map.get(id + "") == null)return -1;
		Commodity.map.get(id + "").setRepertory(Commodity.map.get(id + "").getRepertory() + count);
		return Commodity.map.get(id + "").getRepertory();
	}
	
	public static long outStorage(long id,long count) {
		if(id < 0)return -1;
		if(Commodity.map.get(id + "") == null)return -1;
		if(Commodity.map.get(id + "").getRepertory() - count < 0) {
			System.err.println("´¢Ðî¿â´æÁ¿²»¹»,³ö¿âÊ§°Ü!");
			return Commodity.map.get(id + "").getRepertory();
		}
		Commodity.map.get(id + "").setRepertory(Commodity.map.get(id + "").getRepertory() - count);
		return Commodity.map.get(id + "").getRepertory();
	}
	public static Commodity registeCommdodity(long id, String name, String category, double price, long repertory) {
		
		if(isExist(id) == -1) {
			Commodity commodity = new Commodity(id,name, category, price, repertory);
			Commodity.map.put(String.valueOf(id),commodity);
			Commodity.saveData();
			
			return commodity;
		}
		
	return null;
	}
	public static Commodity isExist(Commodity commodity) {
		Set<Entry<String, Commodity>> set = Commodity.map.entrySet();
		for (Entry<String, Commodity> entry : set) {
			if(entry.getValue().equals(commodity)) {
				return entry.getValue();
			}
		}
		return null;
		
	}
	public static long isExist(long id) {
		if (Commodity.map.containsKey(id + "")) {
			return id;
		}else {
			return -1;
		}
				
	}
	public static Commodity findInstanceById(long id) {

		return Commodity.map.get(id + "");
		
	}
	public static Commodity remove(long id) {
		
			Commodity commodity = Commodity.map.remove(id + "");
			Commodity.saveData();
			return commodity;
		
	}
	
}
