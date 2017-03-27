package pro.gradeSystem;
import java.io.IOException;

/*
 * method Main
 * �{���i�J�I�A�ΨӳЫ�UI�A�óz�LUI�i�椧�᪺�ާ@�A�P�ɳB�z�ӦۤU�h�ߥX���ҥ~
 * ��Ʀ���: ui
 * ----------------------
 * Pseudo code:
 * public static void main(String[] args){
 * 		try{
 * 			call UI constructor �غcui
 * 		}end try
 * 		catch(NoSuchIDEExceptions){ print "���s�b��ID!" }	�B�z��J���~ID
 * 		catch(NoSuchCommandExceptions){ print "���O��J���~!" }	�B�z��J���~���O
 * 		catch(NumberFormatException){print "�榡��J���~" } �B�z�榡���~���D
 * 		catch(IOException){ print "project�ڥؿ������s�bgradeinput.txt!" } �B�zŪ�ɿ��~
 * }
 */
public class Main {

	public static void main(String[] args) {
		try{
			UI ui = new UI();
		} catch (NoSuchIDExceptions e){
			System.out.println("���s�b��ID!");
		} catch (NoSuchCommandExceptions e) {
			System.out.println("���O��J���~!");
		}catch(NumberFormatException e){ 
			System.out.println("�榡��J���~!");
		}catch (IOException e) {
			System.out.println("project�ڥؿ������s�bgradeinput.txt!");
		}
	}
	
}
/*
 * method NoSuchIDExceptions
 * �ҥ~�B�z �w ���J���s�b��ID
 */
class NoSuchIDExceptions extends Exception{
	public NoSuchIDExceptions(int ID){
		super("ERROR:"+ID);
	}
}
/*
 * methos NoSuchCommandExceptions
 * �ҥ~�B�z �w ���J���s�b�����O��
 */

class NoSuchCommandExceptions extends Exception{
	public NoSuchCommandExceptions(String cmd){
		super("ERROR:"+cmd);
	}	
}