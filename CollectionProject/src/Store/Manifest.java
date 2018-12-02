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
					System.out.print("�̳�ϵͳ");
					for(int i = 0; i < 16;i++)
						System.out.print("~");
					System.out.println();
					
					for(int i = 0; i < 40;i++)
						System.out.print("*");
					System.out.println("");
					
					System.out.println("1.�鿴������Ʒ");
					System.out.println("2.�Ǽ���Ʒ");
					System.out.println("3.������Ʒ");
					System.out.println("4.�����Ʒ");
					System.out.println("5.�Ƴ���Ʒ��¼");
					System.out.println("6.������Ʒϵͳ");
					
					for(int i = 0; i < 40;i++)
						System.out.print("*");
						System.out.println("");
						
						for(int i = 0; i < 40;i++)
							System.out.print("-");
						System.out.println("");
						System.out.print("��ѡ����Ҫִ��ҵ��:");
						
						
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
							System.out.println("~��ӭʹ�ñ���Ʒϵͳ~");
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
			System.out.println("��Ʒ�б�û������Ŷ~");
			return;
		}
		for(int i = 0; i < 40;i++)
		System.out.print("^");
		System.out.println("");
		System.out.printf("%-8s %-8s %-8s %-8s %-8s","���" ,"����","ID","����","���");
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
		System.out.print("������Ǽ���Ʒid:");
		long id = input.nextLong();
		if(Biz.isExist(id) == -1) {
			System.out.print("������Ǽ���Ʒ����:");
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
			
			System.out.print("������Ǽ���Ʒ���:");
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
			System.out.print("������Ǽ���Ʒ����:");
			Double price = input.nextDouble();
			System.out.print("������Ǽ���Ʒ�������:");
			long repertory = input.nextLong();
			Biz.registeCommdodity(id, name.toString(), category.toString(), price, repertory);
			
			
		}else {
			System.out.println("��Ʒ�б�û�Ѵ���������� (id:"+ id +"~" + Biz.findInstanceById(id).getName() + ")����Ʒ\n");
			
		}
						
	}
	public static void putStorage() {
		System.out.print("�����������Ʒid:");
		long id = input.nextLong();
		if(Biz.isExist(id) == -1) {
			System.out.println("��Ʒ�б�û�м�¼�������id����Ʒ\n��ǰ��>2:�Ǽ���Ʒ");
		}
		
		else{
			System.out.print("��������Ʒ�������:");
			long count = input.nextLong();
			System.out.println("��ǰ" + Biz.findInstanceById(id).getName() + "����Ϊ"+ Biz.putStorage(id, count));
		}
		
	}
	public static void outStorage() {
		System.out.print("�����������Ʒid:");
		long id = input.nextLong();
		if(Biz.isExist(id) == -1) {
			System.out.println("��Ʒ�б�û�м�¼�������id����Ʒ\n��ǰ��>2:�Ǽ���Ʒ");
		}
		
		else{
			System.out.print("��������Ʒ��������:");
			long count = input.nextLong();
			System.out.println("��ǰ" + Biz.findInstanceById(id).getName() + "����Ϊ"+ Biz.outStorage(id, count));
		}
		
	}
	public static Commodity removeCommodity() {
		System.out.println("�������Ƴ���Ʒid:");
		long id = input.nextLong();
		if(Biz.isExist(id) == id) {
			System.out.println("id:"+ id +"~" + Commodity.map.get(id + "").getName() + "�Ƴ��ɹ�");
			return Biz.remove(id);
			
		}else {
			System.out.println("��Ʒ�б�û�м�¼�������id~" + id + "����Ʒ\n�Ƴ�ʧ��");
			return null;
		}
		
	}
	public static void resetSystem() {
		System.out.println("��ȷ������ϵͳ?ok/cancel");
		String contrl = input.next();
		if(contrl.equals("ok")) {
			Commodity.clear();
			System.out.println("���óɹ�");
		}
		
	}
	
}
