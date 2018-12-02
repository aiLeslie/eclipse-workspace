
public class BookAction {
	/**book 是销售书籍对象
	 * 如果销售成功,返回true,否则返回false */
	public boolean sellBook(Book book){
		/**判定对象书的库存是否大于零
		 * 图书库存-1
		 * 返回是否成功
		 */
		boolean isSell =false; 
		if(book.getCount() ==0){
			System.out.println("该书已卖完,请买其他的书吧!");
			return isSell;
		}
		book.setCount(book.getCount() - 1);
		return isSell = true;
	}
}
