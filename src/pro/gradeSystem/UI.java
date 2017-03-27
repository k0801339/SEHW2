package pro.gradeSystem;
import java.io.*;
import java.util.Scanner;

/*
 * method UI
 * �t�d�����ϥΪ̿�J���d�ߪ�ID�A����d�߹�H�������O�ʧ@�A�N���O�ǵ��U�h��GradeSystems����
 * ��Ʀ���: aGradeSystem
 * -------------------
 * Pseudo code
 * 1.�إ�aGradeSystem
 * 2.�z�LpromptID�o��ID input�A�P�_�O�_��Q or q ->if so, �{������
 * 3.�NpromptID�ରInteger�A�z�LcheckID�P�_aGradeSystem�����S���o�����
 * 4.�p�G���G��true -> ���� showWelcomeMsg �M promptCommand
 * 5.�����{�� -> ����showFinishMsg
 * public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions, NumberFormatException, IOException{
 * 		try{
 * 			call GradeSystem constructor //�غcaGradeSystem
 * 			while(true){
 * 				get cmdID from method promptID //�o��command input
 * 				if(cmdID is equal to Q or q) break	//�����{��
 * 				else{
 * 					convert cmdID(String type) to Integer type
 * 					if(method checkID is true){
 * 						call method showWelcomeMsg, promptCommand
 * 					}
 * 				}print '\n'
 * 			}
 * 		}end try
 * 		finally {call method showFinishMsg}
 * }end of UI
 */
public class UI {
	private GradeSystems aGradeSystem;
	
	public UI() throws NoSuchIDExceptions, NoSuchCommandExceptions, NumberFormatException, IOException {	
		try{
			aGradeSystem = new GradeSystems();
			while(true){
				String cmdID = promptID().toLowerCase();
				if(cmdID.equals("q")){
					break;
				}else{
					int ID = Integer.parseInt(cmdID);
					if(checkID(ID)){
						showWelcomeMsg(ID);
						promptCommand(ID);
					}
				}
				System.out.println();
			}
		}catch(NumberFormatException e){
			System.out.println("�п�J9�X�ƦrID�άOQ!");
		}finally{
			showFinishMsg();
		}
	}
/*
 * 
 */
	public boolean checkID(int ID) throws NoSuchIDExceptions{
		if(aGradeSystem.containsID(ID)){
			return true;
		}else{
			throw new NoSuchIDExceptions(ID);
		}
	}
/*
 * 
 */
	public void promptCommand(int ID) throws NoSuchCommandExceptions{
		Scanner console = new Scanner(System.in);
first:	while(true){
			System.out.println("�ϥΪ̿�J: ");
			String cmd = console.nextLine().toUpperCase();
			switch(cmd){
				case "G": aGradeSystem.showGrade(ID); 	break;
				case "R": aGradeSystem.showRank(ID);	break;
				case "A": aGradeSystem.showAverage();	break;
				case "W": aGradeSystem.updateWeights();	break;
				case "E": break first;
				default: throw new NoSuchCommandExceptions(cmd);
			}
		}
	}
	public String promptID(){
		System.out.println("��J ID ��    Q(�����ϥ�)");
		Scanner console = new Scanner(System.in);
		return console.nextLine();
	}
	public void showFinishMsg(){
		System.out.println("�t�Τw����");
	}
	public void showWelcomeMsg(int ID){
		System.out.printf("Welcome %s\n", aGradeSystem.getThisIDName(ID));
		System.out.println("��J���O  1) G ��ܦ��Z (Grade)");
		System.out.println("      2) R ��ܱƦW (Rank)");
		System.out.println("      3) A ��ܥ��� (Average)");
		System.out.println("      4) W ��s�t�� (Weight)");
		System.out.println("      5) E ���}��� (Exit))");
	}
}
