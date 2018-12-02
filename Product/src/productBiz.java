import javax.swing.JOptionPane;

public  class productBiz {
	public static void main(String[] args) {
		
		double total = 0;//总价钱
		int count = 0;//商品数量
		Product product = new Product();//对象实例化
		
		
		while(true){/**分别输入商品名称,价钱和个数
                     *打印商品名称,价钱和个数	
                     *打印总价钱	
 		             */
		
			
			product.setName(JOptionPane.showInputDialog("请输入商品的名称"));
			/*但输入字符串为0时,停止累加价钱(跳出循环)*/
			if("0".equals(product.getName()))break;
			product.setPrice(Double.parseDouble(JOptionPane.showInputDialog("请输入商品的单价")));
			count = Integer.parseInt(JOptionPane.showInputDialog("请输入商品的数目"));
			
			
			total += count * product.getPrice();
			
			System.out.print("商品名称\t商品单价\t商品数目\n");
			System.out.printf("%-4s\t%-4s\t%-4s\n",product.getName(),product.getPrice(),count);
			System.out.println("现在价钱为" + total);
			System.out.println("按0退出计算金额");
			System.out.println();
			System.out.println();
		}
		System.out.println("现在价钱为 " + total);
		System.out.println(" leslie".equals("leslie"));
		
				
	}
	
	
}


