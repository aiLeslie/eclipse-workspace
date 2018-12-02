package Store;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Manifest {
	private static Scanner input = new  Scanner(System.in);
	public static void main(String[] args)
	{
		Commodity.loadData();

			while(true) {
				for(int i = 0; i < 40;i++)
					System.out.print("*");
					System.out.println("");
					
					for(int i = 0; i < 17;i++)
						System.out.print("~");
					System.out.print("商城系统");
					for(int i = 0; i < 16;i++)
						System.out.print("~");
					System.out.println();
					
					for(int i = 0; i < 40;i++)
						System.out.print("*");
					System.out.println("");
					
					System.out.println("1.查看所有商品");
					System.out.println("2.登记商品");
					System.out.println("3.出库商品");
					System.out.println("4.入库商品");
					System.out.println("5.移除商品记录");
					System.out.println("6.重置商品系统");
					
					for(int i = 0; i < 40;i++)
						System.out.print("*");
						System.out.println("");
						
						for(int i = 0; i < 40;i++)
							System.out.print("-");
						System.out.println("");
						System.out.print("请选择您要执行业务:");
						
						
					try {
						switch(input.next()) {
							case "1":showAllComodity();
								break;
							case "2":sign();
								break;
							case "3":outStorage();
								break;
							case "4":putStorage();
								break;
							case "5":removeCommodity();
								break;
							case "6":resetSystem();
							break;
							case "exit":Commodity.saveData();
							System.out.println("~欢迎使用本商品系统~");
							System.exit(0);
								break;
						}
						for(int i = 0; i < 40;i++)
							System.out.print("-");
						System.out.println("");
						
						System.out.println("");
					}catch (Exception e) {
						e.printStackTrace();
					}
					
			}
		
	}
	public static void showAllComodity() {
		if(Commodity.map == null || Commodity.map.isEmpty()) {
			System.out.println("商品列表没有数据哦~");
			return;
		}
		for(int i = 0; i < 40;i++)
		System.out.print("^");
		System.out.println("");
		System.out.printf("%-8s %-8s %-8s %-8s %-8s","类别" ,"名称","ID","单价","库存");
		System.out.println();
		
		for(int i = 0; i < 40;i++)
			System.out.print("-");
		System.out.println();
		
		Set<Entry<String, Commodity>> set = Commodity.map.entrySet();
		Iterator<Entry<String, Commodity>> it = set.iterator();
		Entry<String, Commodity> temp = null;
		Commodity commodity = null;
		while(it.hasNext()) {
			
				
				temp = (Entry<String, Commodity>) it.next();
				commodity = temp.getValue();
				System.out.printf("%-7s %-7s %-7s %-7s %-7s",commodity.getcategory() ,commodity.getName(),commodity.getId()+"",commodity.getPrice()+"",commodity.getRepertory()+"");
				System.out.println();
				
				for(int i = 0; i < 40;i++)
					System.out.print("~");
				System.out.println();
				if(!it.hasNext()) {
					for(int i = 0; i < 40;i++)
						System.out.print("^");
						System.out.println();
						
						
				}
		}
		
	}
	
	public static void sign() {
		for(int i = 0; i < 40;i++)
			System.out.print("^");
		System.out.println();
		System.out.print("请输入登记商品id:");
		long id = input.nextLong();
		if(Biz.isExist(id) == -1) {
			System.out.print("请输入登记商品名称:");
			StringBuffer name = new StringBuffer();
			name.append(input.next());
			int i = 0;
			for (i = 0; i < name.length() ; i++) {
				if(name.charAt(i) > 'a' && name.charAt(i) < 'z' || name.charAt(i) > 'A' && name.charAt(i) < 'A') {
					break;
				}; 
			}
			if(i != name.length()){
				for (i = 0; i < name.length() ; i++) {
					if(name.charAt(i) > 'a' && name.charAt(i) < 'z' || name.charAt(i) > 'A' && name.charAt(i) < 'A') {
						name.deleteCharAt(i);
					}; 
				}
			}
			
			System.out.print("请输入登记商品类别:");
			StringBuffer category = new StringBuffer();
			category.append(input.next());
			
			for (i = 0; i < category.length() ; i++) {
				if(category.charAt(i) > 'a' && category.charAt(i) < 'z' || category.charAt(i) > 'A' && category.charAt(i) < 'A') {
					break;
				}; 
			}
			if(i != category.length()){
				for (i = 0; i < category.length() ; i++) {
					if(category.charAt(i) > 'a' && category.charAt(i) < 'z' || category.charAt(i) > 'A' && category.charAt(i) < 'A') {
						category.deleteCharAt(i);
					}; 
				}
			}
			System.out.print("请输入登记商品单价:");
			Double price = input.nextDouble();
			System.out.print("请输入登记商品入库数量:");
			long repertory = input.nextLong();
			Biz.registeCommdodity(id, name.toString(), category.toString(), price, repertory);
			
			
		}else {
			System.out.println("商品列表没已存在您输入的 (id:"+ id +"~" + Biz.findInstanceById(id).getName() + ")的商品\n");
			
		}
						
	}
	public static void putStorage() {
		System.out.print("请输入入库商品id:");
		long id = input.nextLong();
		if(Biz.isExist(id) == -1) {
			System.out.println("商品列表没有记录您输入的id的商品\n请前往>2:登记商品");
		}
		
		else{
			System.out.print("请输入商品入库数量:");
			long count = input.nextLong();
			System.out.println("当前" + Biz.findInstanceById(id).getName() + "总数为"+ Biz.putStorage(id, count));
		}
		
	}
	public static void outStorage() {
		System.out.print("请输入出库商品id:");
		long id = input.nextLong();
		if(Biz.isExist(id) == -1) {
			System.out.println("商品列表没有记录您输入的id的商品\n请前往>2:登记商品");
		}
		
		else{
			System.out.print("请输入商品出库数量:");
			long count = input.nextLong();
			System.out.println("当前" + Biz.findInstanceById(id).getName() + "总数为"+ Biz.outStorage(id, count));
		}
		
	}
	public static Commodity removeCommodity() {
		System.out.println("请输入移除商品id:");
		long id = input.nextLong();
		if(Biz.isExist(id) == id) {
			System.out.println("id:"+ id +"~" + Commodity.map.get(id + "").getName() + "移除成功");
			return Biz.remove(id);
			
		}else {
			System.out.println("商品列表没有记录您输入的id~" + id + "的商品\n移除失败");
			return null;
		}
		
	}
	public static void resetSystem() {
		System.out.println("你确定重置系统?ok/cancel");
		String contrl = input.next();
		if(contrl.equals("ok")) {
			Commodity.clear();
			System.out.println("重置成功");
		}
		
	}
	
}
