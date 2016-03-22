package logic;

/**
 *
 * @author Евгений
 */
public class Structure {

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Structure with size = ");
        builder.append(SIZE);
        builder.append('\n');
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builder.append(field[i][j]).append(' ');
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    private final int SIZE;
    private final int MAX_POINTS;
    private int[][] field;
    private int points = 0;

    int getCell(int i, int j) {
        return field[i][j];
    }
    
    void setValue(int i, int j, int value) {
        field[i][j] = value;
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
        for (int i = 0; i < SIZE - 1; i++) {
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

    public void pushLeft() {

    }

    public void pushDown() {

    }

    public void pushUp() {

    }

}
