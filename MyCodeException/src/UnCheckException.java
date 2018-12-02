/**
 * √‚ºÏ“Ï≥£   - RunTimeException/Error
 * @author Administrator
 *
 */
public class UnCheckException {

	public UnCheckException() {
		
	}
	
	@SuppressWarnings("null")
	public static void main(String []args) {
		String str = null;
		try {System.out.println(str.toString());
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
