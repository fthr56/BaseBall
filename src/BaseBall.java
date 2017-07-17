import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {

		int[] user = new int[3]; // 사용자가 입력한 값이 저장될 배열
		int[] com = setCom();// 컴퓨터가 랜덤으로 배정한 값이 들어갈 배열에 setCom() 메소드를 사용하여 랜덤값 배정

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("연속된 세 숫자를 입력하세요. (123 or 456)");

			String line = scanner.nextLine();
			if (line.length() < 3 || line.length() > 3) {
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
			String[] userNum = line.split("");

			user = setUser(userNum);
			if (check(user, com) == 3) {
				System.out.println("승리하셨습니다.");
				break;
			}
		}
		scanner.close();
	}
	
	public static int[] setCom() {

		int[] com = new int[3];
		Integer[] random = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> rnd = Arrays.asList(random);
		Collections.shuffle(rnd);
		for (int i = 0; i < com.length; i++) {
			com[i] = rnd.get(i);
			System.out.print(com[i]); // 컴퓨터가 배정한 임의의 수 출력, 제대로된 게임을 할려면 주석 처리
										// 할것
		}
		System.out.println();

		return com;
	}

	public static int[] setUser(String[] userNum) {

		int[] user = new int[3];
		// 반복이 3번이라 for문을 안쓰고 직접 작성 하겠다면 아래를 풀면 된다
		// if (userNum[0].charAt(0) >= 48 && userNum[0].charAt(0) <= 57) {
		// user[0] = Integer.parseInt(userNum[0]);
		// }
		// if (userNum[1].charAt(0) >= 48 && userNum[1].charAt(0) <= 57) {
		// user[1] = Integer.parseInt(userNum[1]);
		// }
		// if (userNum[2].charAt(0) >= 48 && userNum[2].charAt(0) <= 57) {
		// user[2] = Integer.parseInt(userNum[2]);
		// }

		// for문을 안쓸려면 아래를 주석 처리 후 위에 코드들을 풀면 된다.
		// for문을 이용하여 사용자가 입력 한 숫자들을 int[] user 배열에다가 저장
		for (int i = 0; i < 3; i++) {
			if (userNum[i].charAt(0) >= 48 && userNum[i].charAt(0) <= 57) {
				user[i] = Integer.parseInt(userNum[i]);
			} else {
				System.out.println("숫자가 아닙니다.");
				break;
			}
		}
		return user;
	}

	public static int check(int[] user, int[] com) {
		int strike = 0, ball = 0;
		int trash; // 삼항 연산자를 수향할려고 만든 쓰레기 값;

		// user[0]과 com[0]이 같으면 strike 같에 1을 더한다. 아니라면 user[0]과 com[1], com[2]을
		// 비교하여 같으면 ball의 값에 1을 더한다.
		// 아니라면 쓰레기 값에 0을 대입하면서 삼항연산자를 마친다. 같은 방법으로 user[1],user[2]를 수행
		trash = (user[0] == com[0]) ? strike++ : (user[0] == com[1]) ? ball++ : (user[0] == com[2]) ? ball++ : 0;
		trash = (user[1] == com[1]) ? strike++ : (user[1] == com[0]) ? ball++ : (user[1] == com[2]) ? ball++ : 0;
		trash = (user[2] == com[2]) ? strike++ : (user[2] == com[1]) ? ball++ : (user[2] == com[0]) ? ball++ : 0;

		if (strike > 0 || ball > 0) {
			System.out.printf("스트라이크: %d, 볼: %d\n", strike, ball);
		} else {
			System.out.println("낫싱");
		}
		// strike 값만 넘겨 줘서 3이라면 게임을 종료 시킨다.
		return strike;
	}
}