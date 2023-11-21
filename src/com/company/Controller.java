package com.company;

public class Controller {
    View view;
    int turn = 1;
    int[][] supportArray = new int[8][3];
    boolean isGameOver;

    public void setView(View view) {
        this.view = view;
    }

    public void handleKeyDown(int x, int y) {
        if (!isGameOver) {
            int fieldX = x / 100;
            int fieldY = y / 100;
            if (supportArray[fieldY][fieldX] == 0) {
                addElement(x, y);
                drawElement(fieldX, fieldY);
            }
            view.drawWinText(winCheck());
        }
    }

    public String winCheck() {
        String winner = null;
        if (nobodyWins()) {
            isGameOver = true;
            return "Никто не сражался лучше другого";
        }
        for (int x = 0; x < supportArray.length; x++) {
            if (supportArray[x][0] == supportArray[x][1] && supportArray[x][1] == supportArray[x][2] && supportArray[x][0] != 0) {
                drawWinLine(x);
                isGameOver = true;
                if (supportArray[x][0] == 1) {
                    return "Выиграл храбрец, сражавшийся крестиками.";
                } else return "Выиграл храбрец, сражавшийся ноликами.";
            }
        }
        return winner;
    }

    public boolean nobodyWins() {
        boolean nobody = false;
        for (int x = 0; x < supportArray.length; x++) {
            boolean cross = false;
            boolean zero = false;
            for (int y = 0; y < supportArray[x].length; y++) {
                if (!cross) {
                    if (supportArray[x][y] == 1) {
                        cross = true;
                    }
                }
                if (!zero) {
                    if (supportArray[x][y] == 2) {
                        zero = true;
                    }
                }
            }
            if (cross && zero) {
                nobody = true;
            } else return false;
        }
        return nobody;
    }

    public void drawWinLine(int index) {
        switch (index) {
            case 0: {
                view.drawWinLine(0, 50, 300, 50);
                break;
            }
            case 1: {
                view.drawWinLine(0, 150, 300, 150);
                break;
            }
            case 2: {
                view.drawWinLine(0, 250, 300, 250);
                break;
            }
            case 3: {
                view.drawWinLine(50, 0, 50, 300);
                break;
            }
            case 4: {
                view.drawWinLine(150, 0, 150, 300);
                break;
            }
            case 5: {
                view.drawWinLine(250, 0, 250, 300);
                break;
            }
            case 6: {
                view.drawWinLine(0, 0, 300, 300);
                break;
            }
            case 7: {
                view.drawWinLine(0, 300, 300, 0);
                break;
            }
        }
    }

    public void drawElement(int x, int y) {
        if (turn == 2) {
            view.drawZero(x * 100, y * 100);
            turn = 1;
        } else {
            view.drawCross(x * 100, y * 100);
            turn = 2;
        }
    }

    public void addElement(int x, int y) {
        if (x < 100 && y < 100) {
            supportArray[0][0] = turn;
            supportArray[3][0] = turn;
            supportArray[6][0] = turn;
        }
        if (x > 100 && x < 200 && y < 100) {
            supportArray[0][1] = turn;
            supportArray[4][0] = turn;
        }
        if (x > 200 && x < 300 && y < 100) {
            supportArray[0][2] = turn;
            supportArray[5][0] = turn;
            supportArray[7][0] = turn;
        }
        if (x < 100 && y > 100 && y < 200) {
            supportArray[1][0] = turn;
            supportArray[3][1] = turn;
        }
        if (x > 100 && x < 200 && y > 100 && y < 200) {
            supportArray[1][1] = turn;
            supportArray[4][1] = turn;
            supportArray[6][1] = turn;
            supportArray[7][1] = turn;
        }
        if (x > 200 && x < 300 && y > 100 && y < 200) {
            supportArray[1][2] = turn;
            supportArray[5][1] = turn;
        }
        if (x < 100 && y > 200) {
            supportArray[2][0] = turn;
            supportArray[3][2] = turn;
            supportArray[7][2] = turn;
        }
        if (x > 100 && x < 200 && y > 200) {
            supportArray[2][1] = turn;
            supportArray[4][2] = turn;
        }
        if (x > 200 && x < 300 && y > 200) {
            supportArray[2][2] = turn;
            supportArray[5][2] = turn;
            supportArray[6][2] = turn;
        }
    }
}
