import java.util.Scanner;

public class BaseBallNoComment {

	static int[] myNumber = {0,0,0};

	public static void main(String[] args) {	
		boolean setNewGameFlag = false;
		BaseBallNumberNoComment my;
		BaseBallNumberNoComment other = new BaseBallNumberNoComment();
		
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while (flag) {
			if (setNewGameFlag) {
				other = new BaseBallNumberNoComment();
				setNewGameFlag = false;
			}
			flag = inputNumber(scanner);
			
			if (flag) {
				my = new BaseBallNumberNoComment(myNumber); 
				if (my.check(my.number, other.number) == 3) {
					System.out.printf("승리하셨습니다!!\n게임을 종료 하실려면 'q'를 입력하세요.(아무 키나 누르면 새게임)");
					String line = scanner.nextLine();
					if (line.equals("q")) {
						System.out.print("Good bye!!!");
						flag= false;
						break;
					}
					setNewGameFlag = true;
				}
			}
		}
		scanner.close();
	}
	
	public static boolean inputNumber(Scanner scanner){

		boolean rightLineFlag = true;
		while (rightLineFlag) {
			System.out.println("연속된 세 숫자를 입력하세요. [ex)123 , 종료:q]");

			String line = scanner.nextLine();
			if (line.equals("q")) {
				System.out.println("게임을 종료 합니다.");
				return false;
			}
			if (line.length() != 3) {
				System.out.println("세글자만 입력하세요.");
				continue;	
			}
			rightLineFlag = setUser(line); 
		}
		return true;
	}
	
	private static boolean setUser(String line){
		String[] stringNum = line.split("");
		for (int i = 0; i < stringNum.length; i++) {
			if (stringNum[i].charAt(0) >= 48 && stringNum[i].charAt(0) <= 57) {
				myNumber[i] = Integer.parseInt(stringNum[i]);
			} else{
				System.out.println("문자를 입력 하셨습니다.");
				return true;	
			}
		}
		return false;
	}
}