import javax.swing.JOptionPane;

public  class productBiz {
	public static void main(String[] args) {
		
		double total = 0;//�ܼ�Ǯ
		int count = 0;//��Ʒ����
		Product product = new Product();//����ʵ����
		
		
		while(true){/**�ֱ�������Ʒ����,��Ǯ�͸���
                     *��ӡ��Ʒ����,��Ǯ�͸���	
                     *��ӡ�ܼ�Ǯ	
 		             */
		
			
			product.setName(JOptionPane.showInputDialog("��������Ʒ������"));
			/*�������ַ���Ϊ0ʱ,ֹͣ�ۼӼ�Ǯ(����ѭ��)*/
			if("0".equals(product.getName()))break;
			product.setPrice(Double.parseDouble(JOptionPane.showInputDialog("��������Ʒ�ĵ���")));
			count = Integer.parseInt(JOptionPane.showInputDialog("��������Ʒ����Ŀ"));
			
			
			total += count * product.getPrice();
			
			System.out.print("��Ʒ����\t��Ʒ����\t��Ʒ��Ŀ\n");
			System.out.printf("%-4s\t%-4s\t%-4s\n",product.getName(),product.getPrice(),count);
			System.out.println("���ڼ�ǮΪ" + total);
			System.out.println("��0�˳�������");
			System.out.println();
			System.out.println();
		}
		System.out.println("���ڼ�ǮΪ " + total);
		System.out.println(" leslie".equals("leslie"));
		
				
	}
	
	
}


