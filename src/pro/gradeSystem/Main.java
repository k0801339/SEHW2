package pro.gradeSystem;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try{
			UI ui = new UI();
		} catch (NoSuchIDExceptions e){
			System.out.println("���s�b��ID!");
		} catch (NoSuchCommandExceptions e) {
			System.out.println("���O��J���~!");
		} catch (NumberFormatException e) {
			System.out.println("�榡���~!");
		} catch (IOException e) {
			System.out.println("project�ڥؿ������s�bgradeinput.txt!");
		}
	}
	
}

class NoSuchIDExceptions extends Exception{
	public NoSuchIDExceptions(int ID){
		super("ERROR:"+ID);
	}
}

class NoSuchCommandExceptions extends Exception{
	public NoSuchCommandExceptions(String cmd){
		super("ERROR:"+cmd);
	}	
}