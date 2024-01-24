import java.util.Random;

public class Model{
    View _view;
    public Model() {
        _view = new View();
    }

    int[][] board = new int[4][4];

    int find_zero;
    int find_user;
    int user_col=-1, user_row=-1;
    int zero_col, zero_row;
    int reset_count = 3;
    boolean reset_flag = false;

    // 보드판에 넣을 값을 return하는 함수.
    // 4x4배열이기 때문에 0-15의 값 즉 총 16개의 1차원 배열이 return 된다.
    public int[] setNumber(int size) {
        int[] number = new int[size];
        for (int i = 0; i < size; i++)
            number[i] = i;
        return number;
    }

    // return한 1차원 배열을 board판에 랜덤하게 값을 넣는 함수
    // setNumber로 1차원 배열을 retrun한 number배열을 board 값에 넣는다. 이 때 number배열의 index를 무작위로 주면서 랜덤하게 배치
    public void setBoard(int[] number) {
        Random r = new Random();
        int use_index = 0;
        int check_index = 0;

        if (reset_flag)
            reset_flag = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                use_index = r.nextInt(number.length);
                while (check_index < board.length*board.length && number[use_index] == -1) {
                    use_index = r.nextInt(number.length);
                }
                board[i][j] = number[use_index];
                number[use_index] = -1;
                check_index = check_index + 1;
            }
        }
    }

    // board의 zero index를 찾는다. 행*10+열의 값을 return
    public void findZeroIndex()
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] == 0) {
                    find_zero = i*10 + j;
                    break;
                }
            }
        }
    }

    // user가 입력한 값의 index를 행*10+열의 값으로 return
    public void findUserIndex()
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] == _view.user) {
                    find_user = i*10 + j;
                    break;
                }
            }
        }
    }

    // 행*10 + 열로 합쳐놨던 값을 행, 열로 분할 저장
    public void indexList()
    {
        findUserIndex();
        findZeroIndex();
        user_row = find_user / 10;
        user_col = find_user % 10;
        zero_row = find_zero / 10;
        zero_col = find_zero % 10;
    }

    // 대각선, 양옆, 위아래 두칸 이상의 접근 예외처리
    public boolean checkIndex()
    {
        if ((zero_col - user_col == 1 || zero_col - user_col == -1)
                && (zero_row - user_row == 1 || zero_row - user_row == -1))
            return false;
        else if ((zero_col - user_col < -1 || zero_col - user_col > 1))
            return false;
        else if ((zero_row - user_row < -1 || zero_row - user_row > 1))
            return false;
        else
            return true;
    }

    // user가 입력하는 함수로 올바른 index를 입력할 때까지 반복
    public void selectNumber() {
        _view.writeNumber();

        try {
            _view.user = _view.selectUserInput();
            indexList();
            reset_flag = false;
        }
        catch (Exception e){
            reset_count--;
            reset_flag = true;
            return;
        }

        while(!checkIndex())
        {
            _view.writeCorrectnumber();
            try{
                _view.user = _view.selectUserInput();
                indexList();
                reset_flag = false;
            }
            catch (Exception e)
            {
                reset_count--;
                reset_flag = true;
            }
        }
    }

    // board판에서 유저가 입력한 값의 index와 공백 index(zero index)를 스왑
    public void swapValue()
    {
        int tmp;
        tmp = board[user_row][user_col];
        board[user_row][user_col] = 0;
        board[zero_row][zero_col] = tmp;
    }

    // 게임이 정상적으로 순차 배열을 가지면 개임 종료
    public boolean checkGame() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == count++)
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public boolean resetGame()
    {
        if (reset_count < 0 ) {
            _view.resetCheck();
            return false;
        }
        else
            return true;
    }
}
