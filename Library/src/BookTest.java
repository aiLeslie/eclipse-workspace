
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book("��Խ����","520-1314",999.9,1);
				BookAction bookaction = new BookAction();
				System.out.println(book.toString());
		if(bookaction.sellBook(book)){
			System.out.println("��ϲ���������Խһ��!!Ҫ�Ҹ�Ŷ");
		}
		else{
			System.out.println("�����Խһ��Ե�ֶ�û��,�ټ������ĺ���~~");
		}
				
	}

}
