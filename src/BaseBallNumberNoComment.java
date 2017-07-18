import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallNumberNoComment {
	int[] number = new int[3];

	BaseBallNumberNoComment() {
		number = setCom();
	}

	BaseBallNumberNoComment(int[] userChoice) {
		setUser(userChoice);
	}

	private int[] setCom() {

		int[] com = new int[3];
		Integer[] random = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> rnd = Arrays.asList(random);
		Collections.shuffle(rnd);
		System.out.print("컴퓨터 번호: ");// 처음 게임 이후는 사용자가 값을 입력한 다음 출력, 컴의 번호 안볼려면 주석 처리
		for (int i = 0; i < com.length; i++) {
			com[i] = rnd.get(i);
			System.out.print(com[i]); // 컴의 번호 안볼려면 주석 처리
		}
		System.out.println();// 컴의 번호 안볼려면 주석 처리
		return com;
	}

	private void setUser(int[] userChoice) {
		int index = 0;
		for (int i : userChoice) {
			number[index++] = i;
		}
	}
 
	public int check(int[] user1, int[] user2) {
		int strike = 0, ball = 0;
		int trash;
		for (int i = 3; i-- != 0;) {
			int j = i;
			trash = (user1[i] == user2[i]) ? strike++
					: (user1[i] == user2[(1 & (j + 1))]) ? ball++ : (user1[i] == user2[(2 & (j + 2))]) ? ball++ : 0;
		}

		if (strike > 0 || ball > 0) {
			System.out.printf("스트라이크: %d, 볼: %d\n", strike, ball);
		} else {
			System.out.println("낫싱");
		}
		return strike;
	}

	public void showNumber() {
		System.out.println("상대 번호: ");
		for (int num : number) {
			System.out.print(num);
		}
		System.out.println();
	}
}