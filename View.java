import java.util.Scanner;

public class View {
    int user;

    // 보드 프린트 0값을 만나면 공백으로 처리하여 출력한다.
    public void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0)
                    System.out.printf("%2d\t", board[i][j]);
                else
                    System.out.printf(" \t");
            }
            System.out.println("");
        }
    }

    //메뉴 선택 함수 (야구게임에서 그냥 끌어왔어요)
    public int selectMenu() {
        Scanner scanner = new Scanner(System.in); // Scanner 정의
        int num = 0;
        while (true) {
            num = scanner.nextInt();
            if (num < 1 || num > 3)
                scanner.nextLine();
            else
                break;
        }
        return num;
    }

    public int selectUserInput() {
        Scanner scanner = new Scanner(System.in); // Scanner 정의
        user = scanner.nextInt();
        return user;
    }


    //게임 시작 멘트를 출력하는 함수
    public void startPrintgame() {
        System.out.println("\n ▶ Puzzle Game ◀");
        System.out.println("게임이 시작 됩니다. 퍼즐을 풀어보세요!\n");
    }

    // 숫자를 이동할 때 입력받는 멘트를 출력하는 함수
    public void writeNumber() {
        System.out.printf("이동시킬 숫자는 무엇입니까? : ");
    }

    // user가 입력하는 함수로 올바른 index를 입력하라고 협박(?)하는 함수
    public void writeCorrectnumber() { System.out.printf("그곳으로는 이동시킬 수 없습니다! 다시 입력하세요. : ");
    }

    // 게임 종료 멘트를 출력하는 함수
    public void endGame() {
        System.out.println("퍼즐을 완성시켰습니다!\n ☆ 축하합니다 ☆ ");
    }

    //게임 종료 멘트를 출력하는 함수
    public void systemOut() {
        System.out.println("▶ 게임을 종료합니다. \n");
    }

    //리셋을 알려주는 함수
    public void setRegame() {
        System.out.println("Reset을 입력했습니다. 새 퍼즐이 주어집니다.");
    }

    // 더이상 reset 불가
    public void resetCheck() {
        System.out.println("더이상 리셋이 불가능합니다. \n");
    }
}