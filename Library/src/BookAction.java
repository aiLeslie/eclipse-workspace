
public class BookAction {
	/**book �������鼮����
	 * ������۳ɹ�,����true,���򷵻�false */
	public boolean sellBook(Book book){
		/**�ж�������Ŀ���Ƿ������
		 * ͼ����-1
		 * �����Ƿ�ɹ�
		 */
		boolean isSell =false; 
		if(book.getCount() ==0){
			System.out.println("����������,�������������!");
			return isSell;
		}
		book.setCount(book.getCount() - 1);
		return isSell = true;
	}
}
