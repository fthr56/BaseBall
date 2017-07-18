import java.util.Scanner;

public class BaseBallNoComment {

	static int[] myNumber = { 0, 0, 0 };

	public static void main(String[] args) {
		BaseBallNumberNoComment my;
		BaseBallNumberNoComment other = new BaseBallNumberNoComment();
		boolean setNewGameFlag = false;
		 
		Scanner scanner = new Scanner(System.in);
		while (inputNumber(scanner)) {
			if (setNewGameFlag) {
				other = new BaseBallNumberNoComment();
				setNewGameFlag = false;
			}
			
			my = new BaseBallNumberNoComment(myNumber);
			
			if (my.check(my.number, other.number) == 3) {
				System.out.println("승리하셨습니다!! 새 게임을 시작합니다.\n");
				setNewGameFlag = true;
			}
		}
		scanner.close();
		System.out.print("Good bye!!!");
	}

	public static boolean inputNumber(Scanner scanner) {
		
		boolean rightLineFlag = true;
		while (rightLineFlag) {

			System.out.println("연속된 세 숫자를 입력하세요. [ex)123 , 종료:q]");
			String line = scanner.nextLine();

			if (line.equals("q")) {
				System.out.println("게임을 종료 합니다.");
				return false;
			} else if (line.length() != 3) {
				System.out.println("세글자만 입력하세요.");
				continue;
			}
			rightLineFlag = setUser(line);
		}
		return true;
	}

	private static boolean setUser(String line) {
		String[] stringNum = line.split("");
		for (int i = 0; i < stringNum.length; i++) {
			if (stringNum[i].charAt(0) >= 48 && stringNum[i].charAt(0) <= 57) {
				myNumber[i] = Integer.parseInt(stringNum[i]);
			} else {
				System.out.println("문자를 입력 하셨습니다.");
				return true;
			}
		}
		return false;
	}
}