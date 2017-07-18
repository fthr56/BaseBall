import java.util.Scanner;

public class BaseBall {

	static int[] myNumber = {0,0,0};

	public static void main(String[] args) {	
		// 새로운 baseballnumber를 생성하여 랜덤 숫자들을 다시 세팅하는 유무를 체크
		boolean setNewGameFlag = false;
		BaseBallNumber my;
		BaseBallNumber other = new BaseBallNumber();

//		BaseBallNumber baseballnumber = new BaseBallNumber();
		//필드: int[3] comNumber   컴퓨터가 임의로 지정한 숫자를 가지고 있을 배열
		//	   int[3] userNumber  유저가 입력한 숫자를 가지고 있을 배열
				
		Scanner scanner = new Scanner(System.in);
		while (true) {
			//처음엔 false로 초기화 되어 있어 무시하고 지나 간다음 게임을 승리한다음 사용자가 새게임을 원하면 true가 되어 들어온다
			if(setNewGameFlag){ 
				other = new BaseBallNumber();
				setNewGameFlag = false;
			}
			System.out.println("연속된 세 숫자를 입력하세요. [ex)123 , 종료:q]");

			// 길이가 3인 문자열을 입력 받아 line에 저장, 길이가 3이 아니면 처음부터 다시 수행.
			String line = scanner.nextLine();
			if(line.equals("q")){
				System.out.println("게임을 종료 합니다.");
				break;
			}
			if (line.length() != 3) {
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
			setUser( line);
			my  = new BaseBallNumber(myNumber);
			
			//baseballnumber.check()는 경기 결과를 알려 주고
			//스트라이크 갯수를 리턴하여 3스트라이크가 되면 이기면서 while문을 빠져 나간다.
			if ( my.check(my.number, other.number) == 3 ) {
				System.out.printf("승리하셨습니다!!\n게임을 종료 하실려면 'q'를 입력하세요.(아무 키나 누르면 새게임)");
				line = scanner.nextLine();
				if(line.equals("q")){
					System.out.print("Good bye!!!");
					break;
				}
				setNewGameFlag = true;
			}
		}
		scanner.close();
	}
	public static int setUser(String line){
		String[] stringNum = line.split("");
		//사용자가 입력한 문자열이 숫자가 맞는지 확인 후 userNumber 배열에다 저장
		for (int i = 0; i < stringNum.length; i++) {
			if (stringNum[i].charAt(0) >= 48 && stringNum[i].charAt(0) <= 57) {
				myNumber[i] = Integer.parseInt(stringNum[i]);
			} else{
				return -1;	//숫자가 아닌 값을 가지고 있으면 -1값을 리턴
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
		return 1;	//올바른 값이 입력 되었다면 1을 리턴
	}
}