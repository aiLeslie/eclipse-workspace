
public class Book {
	private String name;
	private String isbn;
	private double price;
	private int count;
	private boolean borrow;
	
	public boolean isBorrow() {
		return borrow;
	}

	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}

	public Book(){
		
	}
	
    public Book(String name){
		this.name = name;
	}
	
    public Book(String name,String isbn,double price,int count){
    	setName(name);
    	setIsbn(isbn);
    	setPrice(price);
    	setCount(count);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if(count < 0){
			count = 0;
		}
		this.count = count;
	}
}
