package comcave;

public class Program {

	public static void main(String[] args) {
		textDateiSchreiben();

	}
	
	private static void textDateiSchreiben() {
		
		
		try {
			int[] arrayTest = {1,2,3};
			arrayTest[3] = 100;
			
			System.out.println("try ende");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("exception");
			
			
		}
//		catch(ArrayIndexOutOfBoundsException e1) {
//			System.out.println("Fehler");
//		}
//		catch(IOException e3) {
//
//		}
//		catch(FileNotFoudException e2) {
//		}
	}
	
	

}
