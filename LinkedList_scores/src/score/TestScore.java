package score;

import java.util.Scanner;

public class TestScore {
	static Scanner scanner = new Scanner(System.in);
	static int count = 0;
	static LinkedList list = new LinkedList();

	public static void main(String[] args) {
		
		int input, status = 0;
		while (true) {
			if (status == 0) {
				System.out.print("Option: 1) Add. 2) Output. 3)Delete. -1) Quit:");
				input = scanner.nextInt();
				if (input == -1)
					break;
				if (input == 1)
					status = 1;
				else if (input == 2)
					status = 2;
				else if (input == 3)
					status = 3;
				else
					System.out.println("Input error!");
			}
			if (status == 1)
				status = add();
			if (status == 2) {
				output();
				status = 0;
			}
			if (status == 3)
				status = delete();
		}
		System.out.println("Bye!");
	}
	
	public static int add() {
		System.out.print("Insert new data (SN/ENGLISH/MATH): ");
		int sn, eng, math;
		sn = scanner.nextInt();
		eng = scanner.nextInt();
		math = scanner.nextInt();
		if (sn == -1 && eng == -1 && math == -1)
			return 0;
		if (eng > 100 || eng < -1 || math > 100 || math < -1)
			System.out.println("成績輸入錯誤，請重新輸入！");
		else if (list.search(sn) != null)
			System.out.println("學號重複輸入，請重新輸入！");
		else {
			list.inserInOrdered(sn, eng, math);
			count++;
		}
		return 1;
	}
	
	public static int delete() {
		System.out.print("Delete student number:");
		int input = scanner.nextInt();
		
		if (list.delete(input)) {
			System.out.println("Delete successed!");
			count--;
		}
		else
			System.out.println("Input not found!");
		return 0;
	}
	
	public static void output() {
		if (count > 0) {
			System.out.println("SN\tENG.\tMATH\tAVG.");
			System.out.println("----------------------------");
			for (int i = 0; i < count; i++)
				System.out.println(list.getData(i));
		}
	}

}
