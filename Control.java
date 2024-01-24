public class Control {
    Model _model;
    View_gamemenu _view;

    public Control() {
        _model = new Model();
        _view = new View_gamemenu();
    }

    public void startGame() {
        boolean check = true;

        while (check) {
            _view.gameMenu();

            switch (_view.selectMenu()) {

                //게임 진행
                case 1: {
                    _view.startPrintgame();
                    _model.setBoard(_model.setNumber(16)); // board판 셋팅
                    _view.printBoard(_model.board);        // board판 출력
                    while (!_model.checkGame())            // board가 순차적 배열일때까지 반복
                    {
                        _model.selectNumber();             // 유저 입력을 받음
                        if (_model.reset_flag && _model.resetGame()) {
                            _model.setBoard(_model.setNumber(16));
                            _view.setRegame();
                        }
                        else {
                            if (!_model.reset_flag)
                                _model.swapValue();                // board판 값 스왑
                        }
                        _view.printBoard(_model.board);
                    }
                    _view.endGame();
                }

                // 게임 방법 출력
                case 2 : {
                    _view.gameRule();
                    break;
                }

                // 게임 종료
                case 3:{
                    _view.systemOut();
                    check = false;  // 게임 종료를 위해 while반복문의 계수 check를 false로 변경
                    break;
                }
            }
        }
    }
}


