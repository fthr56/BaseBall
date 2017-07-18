import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallNumber {
	//작은 게임이라 문제는 없겠지만 진행되면서 변경되면  안되니 final로 선언 
	//만약 반복적으로 게임을 하게 할려면 변경 요망
	final int[] comNumber;			//컴퓨터가 3개의 임의의 변수를 담을 배열
	int[] userNumber = new int[3];	//사용자가 반복적으로 입력하는 변수를 담을 배열

	BaseBallNumber() {
		//컴퓨터가 가지고 있을 랜덤한 숫자 생성
		comNumber = setCom();
	}
	//1~9까지의 랜덤 숫자를 가진 int[3] 배열을 리턴하여 생성자에서 사용
	private int[] setCom() {

		int[] com = new int[3];
		Integer[] random = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> rnd = Arrays.asList(random);
		Collections.shuffle(rnd);
		for (int i = 0; i < com.length; i++) {
			com[i] = rnd.get(i);
			System.out.print(com[i]); // 컴퓨터가 배정한 임의의 수 출력, 제대로된 게임을 할려면 주석 처리
		}
		System.out.println();
		return com;
	}

	public int setUser(String line){
		String[] stringNum = line.split("");
		//사용자가 입력한 문자열이 숫자가 맞는지 확인 후 userNumber 배열에다 저장
		for (int i = 0; i < stringNum.length; i++) {
			if (stringNum[i].charAt(0) >= 48 && stringNum[i].charAt(0) <= 57) {
				userNumber[i] = Integer.parseInt(stringNum[i]);
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
	
	public int check() {
		int strike = 0, ball = 0;
		int trash; // 삼항 연산자를 수행할려고 만든 쓰레기 값;

		//for문을 안쓸려면 아래를 주석 해제
		// user[0]과 com[0]이 같으면 strike 같에 1을 더한다. 아니라면 user[0]과 com[1], com[2]을
		// 비교하여 같으면 ball의 값에 1을 더한다.
		// 아니라면 쓰레기 값에 0을 대입하면서 삼항연산자를 마친다. 같은 방법으로 user[1],user[2]를 수행
//		trash = (userNumber[0] == comNumber[0]) ? strike++ : (userNumber[0] == comNumber[1]) ? ball++ : (userNumber[0] == comNumber[2]) ? ball++ : 0;
//		trash = (userNumber[1] == comNumber[1]) ? strike++ : (userNumber[1] == comNumber[0]) ? ball++ : (userNumber[1] == comNumber[2]) ? ball++ : 0;
//		trash = (userNumber[2] == comNumber[2]) ? strike++ : (userNumber[2] == comNumber[1]) ? ball++ : (userNumber[2] == comNumber[0]) ? ball++ : 0;

		//for문과 비트 연산을 통해 같은 위치를 제외한 배열의 인덱스의 위치를 찾아 값이 같으면 ball++를 연산하게 한다.
		//첫번째에선 같은 같은 인덱스 끼리 비교, 두번째엔 i==1이면 0 아니면 1인 인덱스와 비교, 세번째엔 i==2이면 1 아니면 2인 인덱스와 비교
		//for문 작동 시 위에 직접 입력한 값이랑 똑같은 인덱스로 돌아간다.
		for(int i = 3; i-- != 0;){
			int j = i;	//비트 연산으로 인해 i 값이 변할수 있으니 임시 변수를 사용 하여 비트연산
			trash = (userNumber[i] == comNumber[i]) ? strike++ : (userNumber[i] == comNumber[(1&(j+1))]) ? ball++ : (userNumber[i] == comNumber[(2&(j+2))]) ? ball++ : 0;
		}

		if (strike > 0 || ball > 0) {
			System.out.printf("스트라이크: %d, 볼: %d\n", strike, ball);
		} else {
			System.out.println("낫싱");
		}
		// strike 값만 넘겨 줘서 3이라면 게임을 종료 시킨다.
		return strike;
	}
}