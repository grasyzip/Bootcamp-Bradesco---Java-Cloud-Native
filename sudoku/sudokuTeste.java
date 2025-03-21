import java.util.Scanner;

public class Sudoku {
    private static final int SIZE = 9; // Tamanho do tabuleiro
    private int[][] board;

    public Sudoku() {
        board = new int[SIZE][SIZE];
    }

    // Método para imprimir o tabuleiro
    public void printBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar se um número pode ser colocado na posição (row, col)
    public boolean isSafe(int row, int col, int num) {
        // Verifica a linha
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Verifica a coluna
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Verifica a caixa 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int r = 0; r < 3; r++) {
            for (int d = 0; d < 3; d++) {
                if (board[r + startRow][d + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para resolver o Sudoku
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Encontra uma célula vazia
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(row, col, num)) {
                            board[row][col] = num; // Coloca o número

                            if (solve()) { // Recursão
                                return true;
                            }

                            board[row][col] = 0; // Desfaz a ação
                        }
                    }
                    return false; // Se nenhum número é válido
                }
            }
        }
        return true; // Se não há células vazias
    }

    // Método para definir o tabuleiro (exemplo)
    public void setBoard(int[][] newBoard) {
        this.board = newBoard;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        
        // Exemplo de tabuleiro (0 representa células vazias)
        int[][] exampleBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        sudoku.setBoard(exampleBoard);
        System.out.println("Tabuleiro inicial:");
        sudoku.printBoard();

        if (sudoku.solve()) {
            System.out.println("Tabuleiro resolvido:");
            sudoku.printBoard();
        } else {
            System.out.println("Não foi possível resolver o Sudoku.");
        }
    }
}