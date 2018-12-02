package Store;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Commodity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String filePath = "src/Store/data.txt";
	public static Map<String,Commodity> map = new TreeMap<String,Commodity>();
	@SuppressWarnings("unchecked")
	public static void loadData(){
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("商品列表没有数据哦~");
			return;
		}
		
		try(FileInputStream fin = new FileInputStream(filePath);
				ObjectInputStream in = new ObjectInputStream(fin)){
			Commodity.map = (TreeMap<String, Commodity>)in.readObject();
			System.out.println("读入成功");
//			Commodity.map.keySet().forEach(key -> System.out.println(Commodity.map.get(key).getName() + "-库存-" + Commodity.map.get(key).getRepertory()));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	

	public Commodity(long id, String name, String category, double price, long repertory) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.repertory = repertory;
	}
	public static Map<String, Commodity> getMap() {
		return map;
	}
	public static void setMap(Map<String, Commodity> map) {
		Commodity.map = map;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private long id;//商品id
	private String name;//商品名字
	private String category;//商品类别
	private double price;//商品单价
	private long repertory;//商品库存
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcategory() {
		return category;
	}
	public void setcategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getRepertory() {
		return repertory;
	}
	public void setRepertory(long repertory) {
		this.repertory = repertory;
	}
	@Override
	public boolean equals(Object arg0) {

		
		return ((Commodity)arg0).getId() == this.getId();
	}
	public static void saveData() {
		File file = new File(filePath);
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		try(FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream objOut = new ObjectOutputStream(out))
		{
			objOut.writeObject(Commodity.map);
			System.out.println("保存成功");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void clear() {
		File file = new File(filePath);
		file.delete();
		map = new TreeMap<String, Commodity>();
	}
	
	
}
