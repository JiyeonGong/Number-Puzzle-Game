public class View_gamemenu extends View {
    public void gameMenu(){
        System.out.println(" --◈ Number Puzzle Game ◈--");
        System.out.println("1.게 임 시 작");
        System.out.println("2.게 임 방 법");
        System.out.println("3.게 임 종 료");
    }
    public void gameRule(){
        System.out.println("\n ▼ Puzzel Game Rule ▼");
        System.out.println("이 게임은 그림 맞추기 퍼즐을 Text mode로 구현한 게임입니다.");
        System.out.println("게임이 시작되면 랜덤으로 한 칸이 비어진 4X4크기의 숫자 퍼즐이 만들어집니다.");
        System.out.println("그림 대신 주어진 숫자를 순서대로 알맞게 정렬하면 게임이 종료됩니다.");
        System.out.println("< 퍼즐게임의 룰은 다음과 같습니다. >");
        System.out.println("1. 주어진 퍼즐의 빈 칸을 기준으로 움직일 숫자를 입력합니다.");
        System.out.println("2. 주어진 빈 칸을 기준으로 상,하,좌,우의 방향으로만 숫자를 옮길 수 있습니다.");
        System.out.println("3. 대각선 방향 혹은 전혀 옮길 수 없는 숫자는 입력할 수 없습니다.");
        System.out.println("4. 주어진 퍼즐을 완성하면 게임은 종료됩니다.");
        System.out.println("5. 'R'을 입력하면 퍼즐을 처음부터 다시 풀 수 있습니다.\n    그러나, 새로운 퍼즐이 주어진다는 점을 명심하세요.\n");

    }
}
