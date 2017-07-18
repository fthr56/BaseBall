import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallNumber {
			//만약 반복적으로 게임을 하게 할려면 변경 요망
			int[] number = new int[3];	//사용자가 반복적으로 입력하는 변수를 담을 배열

			BaseBallNumber() {
				//컴퓨터가 가지고 있을 랜덤한 숫자 생성
				number = setCom();
			}
			BaseBallNumber(int[] userChoice){
				setUser(userChoice);
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
			private void setUser(int[] userChoice){
				int index =0;
				for(int i : userChoice){
					number[index++] = i;
				}
			}
			public int check(int[] user1, int[] user2) {
				int strike = 0, ball = 0;
				int trash; // 삼항 연산자를 수행할려고 만든 쓰레기 값;

				//for문을 안쓸려면 아래를 주석 해제
				// user[0]과 com[0]이 같으면 strike 같에 1을 더한다. 아니라면 user[0]과 com[1], com[2]을
				// 비교하여 같으면 ball의 값에 1을 더한다.
				// 아니라면 쓰레기 값에 0을 대입하면서 삼항연산자를 마친다. 같은 방법으로 user[1],user[2]를 수행
//				trash = (userNumber[0] == comNumber[0]) ? strike++ : (userNumber[0] == comNumber[1]) ? ball++ : (userNumber[0] == comNumber[2]) ? ball++ : 0;
//				trash = (userNumber[1] == comNumber[1]) ? strike++ : (userNumber[1] == comNumber[0]) ? ball++ : (userNumber[1] == comNumber[2]) ? ball++ : 0;
//				trash = (userNumber[2] == comNumber[2]) ? strike++ : (userNumber[2] == comNumber[1]) ? ball++ : (userNumber[2] == comNumber[0]) ? ball++ : 0;

				//for문과 비트 연산을 통해 같은 위치를 제외한 배열의 인덱스의 위치를 찾아 값이 같으면 ball++를 연산하게 한다.
				//첫번째에선 같은 같은 인덱스 끼리 비교, 두번째엔 i==1이면 0 아니면 1인 인덱스와 비교, 세번째엔 i==2이면 1 아니면 2인 인덱스와 비교
				//for문 작동 시 위에 직접 입력한 값이랑 똑같은 인덱스로 돌아간다.
				for(int i = 3; i-- != 0;){
					int j = i;	//비트 연산으로 인해 i 값이 변할수 있으니 임시 변수를 사용 하여 비트연산
					trash = (user1[i] == user2[i]) ? strike++ : (user1[i] == user2[(1&(j+1))]) ? ball++ : (user1[i] == user2[(2&(j+2))]) ? ball++ : 0;
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