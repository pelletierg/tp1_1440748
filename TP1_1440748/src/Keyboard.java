import java.util.Scanner;

public class Keyboard{

	private Scanner sc;
		
		
	public Keyboard(){
		this.sc = new Scanner(System.in);	
	}
	
	public String read() {
		String input = this.sc.nextLine();
	    return input;
	}
}
