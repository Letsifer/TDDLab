package game;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import logic.MoveResults;
import logic.Structure;

/**
 *
 * @author Евгений
 */
public class GameController {

    private Stage stage;
    private int size;
    private Structure field;
    @FXML
    private GridPane playingField;
    @FXML
    private Button buttonUp;
    @FXML
    private Button buttonDown;
    @FXML
    private Button buttonLeft;
    @FXML
    private Button buttonRight;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonExit;

    private Label[][] numbers;

    @FXML
    public void startClick() {
        field = new Structure(4, 512);
        drawNumbers();
        buttonLeft.setDisable(false);
        buttonRight.setDisable(false);
        buttonDown.setDisable(false);
        buttonUp.setDisable(false);
    }

    @FXML
    public void exit() {
        stage.close();
    }

    public void initStructure(int size, int maxPoints, Stage stage) {
        this.stage = stage;
        field = new Structure(size, maxPoints);
        this.size = size;
        double percentage = 100.0 / size;
        playingField.getColumnConstraints().get(0).setHalignment(HPos.CENTER);
        for (int i = 1; i < size; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(percentage);
            playingField.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(percentage);
            column.setHalignment(HPos.CENTER);
            playingField.getColumnConstraints().add(column);
        }
        numbers = new Label[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                numbers[i][j] = new Label(Integer.toString(field.getCell(i, j)));
                playingField.add(numbers[i][j], j, i, 1, 1);
            }
        }
    }

    private void afterStep(MoveResults result) {
        drawNumbers();
        if (result == MoveResults.CONTINUE) {
            return;
        }
        buttonLeft.setDisable(true);
        buttonRight.setDisable(true);
        buttonDown.setDisable(true);
        buttonUp.setDisable(true);
        Alert alert;
        if (result == MoveResults.WIN) {
            alert = new Alert(Alert.AlertType.INFORMATION, "Победа!!", ButtonType.OK);
            alert.setTitle("Победа");
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION, "Вы проиграли :С", ButtonType.OK);
            alert.setTitle("Поражеие");
        }
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void drawNumbers() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                numbers[i][j].setText(Integer.toString(field.getCell(i, j)));
            }
        }
    }

    public void setToField(int i, int j, int value) {
        field.setValue(i, j, value);
    }

    public String getField() {
        return field.toString();
    }

    @FXML
    public void moveRight() {
        MoveResults result = field.pushRight(false);
        afterStep(result);
    }

    @FXML
    public void moveLeft() {
        MoveResults result = field.pushLeft(false);
        afterStep(result);
    }

    @FXML
    public void moveDown() {
        MoveResults result = field.pushDown(false);
        afterStep(result);
    }

    @FXML
    public void moveUp() {
        MoveResults result = field.pushUp(false);
        afterStep(result);
    }

}
