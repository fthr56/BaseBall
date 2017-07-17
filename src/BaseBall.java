import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {

		BaseBallNumber baseballnumber = new BaseBallNumber();
		//필드: int[3] comNumber   컴퓨터가 임의로 지정한 숫자를 가지고 있을 배열
		//	   int[3] userNumber  유저가 입력한 숫자를 가지고 있을 배열
				
		Scanner scanner = new Scanner(System.in);
		while (true) {
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

			// 길이가 3인 line 문자열을 가지고 baseballnumber의 userNumber 값을 세팅해준다.
			// 만약 문자열에 숫자가 아닌 값을 가지고 있으면 -1을 리턴하여 while문의 시작으로 돌아가 다시 숫자를 입력
			if (baseballnumber.setUser(line) == -1) {
				System.out.println("숫자가 아닌 값이 입력 되었습니다. 다시 입력 해 주세요.");
				continue;
			}

			//baseballnumber.check()는 경기 결과를 알려 주고
			//스트라이크 갯수를 리턴하여 3스트라이크가 되면 이기면서 while문을 빠져 나간다.
			if (baseballnumber.check() == 3) {
				System.out.printf("승리하셨습니다!!\n게임을 종료 합니다.");
				break;
			}
		}
		scanner.close();
	}
}