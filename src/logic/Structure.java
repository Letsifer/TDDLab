package logic;

/**
 *
 * @author Евгений
 */
public class Structure {
    private final int SIZE;
    private final int MAX_POINTS;
    private int[][] field;

    int getCell(int i, int j) {
        return field[i][j];
    }
    
    public Structure(int size, int max_points) {
        this.SIZE = size;
        this.MAX_POINTS = max_points;
        field = new int[size][size];
    }
    
    public void pushRight() {
        
    }
    public void pushLeft() {
        
    }
    public void pushDown() {
        
    }
    public void pushUp() {
        
    }
    
}
