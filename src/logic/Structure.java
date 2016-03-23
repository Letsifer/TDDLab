package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Евгений
 */
public class Structure {

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Structure with size = ").append(SIZE).append('\n');
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builder.append(field[i][j]).append(' ');
            }
            builder.append('\n');
        }
        builder.append("Текущее количество очков: ").append(Integer.toString(points)).append('\n');
        return builder.toString();
    }

    private final int SIZE;
    private final int MAX_POINTS;
    private final static int GENERATED_CELLS = 2;
    
    private final int[][] field;
    
    int getCheckSum() {
        return Arrays.stream(field)
                .flatMapToInt(line -> Arrays.stream(line))
                .sum();
    }
    
    int getCell(int i, int j) {
        return field[i][j];
    }
    
    void setValue(int i, int j, int value) {
        field[i][j] = value;
    }
    
    private int points = 0;

    public int getPoints() {
        return points;
    }

    /**
     * Создает экземпляр структуры произольного размера и количество очков =
     * 256.
     *
     * @param size размер поля
     */
    public Structure(int size) {
        this.SIZE = size;
        this.MAX_POINTS = 512;
        field = new int[size][size];
    }

    /**
     * Создает экземпляр структуры произольного размера и произвольным
     * количеством очков
     *
     * @param size размер поля
     * @param maxPoints максимальное количество очков до победы
     */
    public Structure(int size, int maxPoints) {
        this.SIZE = size;
        this.MAX_POINTS = maxPoints;
        field = new int[size][size];
    }

    /**
     * Сдвигает все цифры вправо на 1 клетку, склеивая их при равенстве.
     */
    public void pushRight() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = SIZE - 2; j >= 0; j--) {
                if (field[i][j + 1] == 0) {
                    field[i][j + 1] = field[i][j];
                    field[i][j] = 0;
                } else if (field[i][j] == field[i][j + 1]) {
                    field[i][j + 1] *= 2;
                    field[i][j] = 0;
                    points += field[i][j + 1];
                }
            }
        }
    }

    /**
     * Сдвигает все цифры влево на 1 клетку, склеивая их при равенстве.
     */
    public void pushLeft() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (field[i][j - 1] == 0) {
                    field[i][j - 1] = field[i][j];
                    field[i][j] = 0;
                } else if (field[i][j] == field[i][j - 1]) {
                    field[i][j - 1] *= 2;
                    field[i][j] = 0;
                    points += field[i][j - 1];
                }
            }
        }
    }

    /**
     * Сдвигает все цифры вниз на 1 клетку, склеивая их при равенстве.
     */
    public void pushDown() {
        for (int i = SIZE - 2; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i + 1][j] == 0) {
                    field[i + 1][j] = field[i][j];
                    field[i][j] = 0;
                } else if (field[i][j] == field[i + 1][j]) {
                    field[i + 1][j] *= 2;
                    field[i][j] = 0;
                    points += field[i + 1][j];
                }
            }
        }
    }

    public void pushUp() {
        for (int i = 1; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i - 1][j] == 0) {
                    field[i - 1][j] = field[i][j];
                    field[i][j] = 0;
                } else if (field[i][j] == field[i - 1][j]) {
                    field[i - 1][j] *= 2;
                    field[i][j] = 0;
                    points += field[i - 1][j];
                }
            }
        }
    }
    
    public MoveResults checkForFinish() {
        if (checkForWin()) {
            return MoveResults.WIN;
        }
        if (checkForLose()) {
            return MoveResults.LOSE;
        }
        return MoveResults.CONTINUE;
    }

    private boolean checkForLose() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == 0 || 
                    i < SIZE - 1 && field[i][j] == field[i + 1][j] || 
                    j < SIZE - 1 && field[i][j] == field[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkForWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == MAX_POINTS) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private final List<Integer> freeCellsIndexes = new ArrayList<>();
    public void generateNewNumbers() {
        freeCellsIndexes.clear();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == 0) {
                    freeCellsIndexes.add(i * SIZE + j);
                }
            }
        }
        Collections.shuffle(freeCellsIndexes);
        Random random = new Random();
        
        for (int i = 0; i < GENERATED_CELLS; i++) {
            if (freeCellsIndexes.isEmpty()) {
                break;
            }
            int indexInList = random.nextInt(freeCellsIndexes.size());
            int indexField = freeCellsIndexes.get(indexInList);
            freeCellsIndexes.remove(indexInList);
            setValueToCell(indexField);            
        }        
    }
    
    private void setValueToCell(int index) {
        int row = index / SIZE, column = index % SIZE;
        field[row][column] = 2;
    }
}
