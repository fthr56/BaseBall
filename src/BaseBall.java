import java.util.Scanner;

public class BaseBall {

	static int[] myNumber = {0,0,0};

	public static void main(String[] args) {	
		// 새로운 baseballnumber를 생성하여 랜덤 숫자들을 다시 세팅하는 유무를 체크
		boolean setNewGameFlag = false;
		BaseBallNumber my;
		BaseBallNumber other = new BaseBallNumber();
		//BaseBallNumber()로 성생시 컴퓨터가 랜덤 값을 입력하여 유저vs컴퓨터로 게임 플래이
		//BaseBallNumber(int[3] number)로 생성시 number에 들어간 데이터로 값 생성
		//이러한 방식으로 추후 유저vs유저 게임이 가능하게 확장성을 열어둠.
		
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while (flag) {
			// 처음엔 false로 초기화 되어 있어 무시하고 지나 간다음 게임을 승리한다음 사용자가 새게임을 원하면 true가 되어
			// 들어온다
			if (setNewGameFlag) {
				other = new BaseBallNumber();
				setNewGameFlag = false;
			}
			//종료키를 누르면 false를 리턴하여 while문을 빠져나감, true라면 게임 진행
			flag = inputNumber(scanner);
			
			if (flag) {
				my = new BaseBallNumber(myNumber); //넘겨준 배열 값으로 my클래스 내부 배열을 초기화
				// my.check()는 경기 결과를 알려 주고
				// 스트라이크 갯수를 리턴하여 3스트라이크가 되면 이기면서 while문을 빠져 나간다.
				if (my.check(my.number, other.number) == 3) {
					System.out.printf("승리하셨습니다!!\n게임을 종료 하실려면 'q'를 입력하세요.(아무 키나 누르면 새게임)");
					String line = scanner.nextLine();
					if (line.equals("q")) {
						System.out.print("Good bye!!!");
						flag= false;
						break;
					}
					setNewGameFlag = true;//새 게임을 수행하게하는 플래그
				}
			}
		}
		scanner.close();
	}
	
	//해당 메소드를 만듬으로 이중 while문 및 setUser의 for문까지 고려하면 3중 반복문이 발생하는 부분이 있어
	//여차하면 메소드로 만들지 말고 main문으로 넣는 방식을 하면 반복의 중첩을 한단계 낮출수는 있다.....
	public static boolean inputNumber(Scanner scanner){

		boolean rightLineFlag = true;
		while (rightLineFlag) {
			System.out.println("연속된 세 숫자를 입력하세요. [ex)123 , 종료:q]");

			// 길이가 3인 문자열을 입력 받아 line에 저장, 길이가 3이 아니면 처음부터 다시 수행.
			String line = scanner.nextLine();
			if (line.equals("q")) {
				System.out.println("게임을 종료 합니다.");
				return false;
			}
			if (line.length() != 3) {
				System.out.println("세글자만 입력하세요.");
				continue;	//세글자가 아닌 문장을 입력하면 while문을 지속적으로 반복
			}
			rightLineFlag = setUser(line); 
			//잘못된 값을 입력하면 true, 옳바르면 false를 리턴하여 while문을 벗어나거나 계속 돌게한다.
		}
		return true;
	}
	
	private static boolean setUser(String line){
		String[] stringNum = line.split("");
		//사용자가 입력한 문자열이 숫자가 맞는지 확인 후 userNumber 배열에다 저장
		for (int i = 0; i < stringNum.length; i++) {
			if (stringNum[i].charAt(0) >= 48 && stringNum[i].charAt(0) <= 57) {
				myNumber[i] = Integer.parseInt(stringNum[i]);
			} else{
				System.out.println("문자를 입력 하셨습니다.");
				return true;	//숫자가 아닌 값을 가지고 있으면 true를 리턴하여 while문을 계속 돔
			}
		}
		// 반복이 적은 3번이라 for문을 안쓰고 직접 대입 할려면 아래를 주석 해제 후 위의 for문을 주석처리 하면 된다.
		// if (userNum[0].charAt(0) >= 48 && userNum[0].charAt(0) <= 57) {
		// user[0] = Integer.parseInt(userNum[0]);
		// }
		// if (userNum[1].charAt(0) >= 48 && userNum[1].charAt(0) <= 57) {
		// user[1] = Integer.parseInt(userNum[1]);
		// }
		// if (userNum[2].charAt(0) >= 48 && userNum[2].charAt(0) <= 57) {
		// user[2] = Integer.parseInt(userNum[2]);
		// }
		return false;	//올바른 값이 입력 되었다면 false를 리턴 하여 해당 메소드를 부른 while문 내부를 벗어남
	}
}