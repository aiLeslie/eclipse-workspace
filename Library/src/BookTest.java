
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book("村越爱情","520-1314",999.9,1);
				BookAction bookaction = new BookAction();
				System.out.println(book.toString());
		if(bookaction.sellBook(book)){
			System.out.println("恭喜获得限量村越一个!!要幸福哦");
		}
		else{
			System.out.println("你跟村越一点缘分都没有,再见可怜的孩子~~");
		}
				
	}

}
