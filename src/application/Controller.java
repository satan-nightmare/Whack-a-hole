package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Controller {

    int level;
    Button bt[][];
    @FXML
    TextField nameField;
    @FXML
    AnchorPane newPane;

    @FXML
    AnchorPane namePane;
    @FXML
    Label nameLabel;

    @FXML
    GridPane grid1;
    @FXML
    GridPane grid2;
    @FXML
    GridPane grid3;

    @FXML
    Label scoreLabel;
    int score;
    boolean a[][];
    @FXML
    public void initialize(){
        score=0;

    }

    public void click(int r,int c){
        a[r][c]=false;
    }

    @FXML
    public void Start(ActionEvent e){
        newPane.setVisible(true);
        nameLabel.setText(nameField.getText());
        Button b = (Button)e.getSource();
        namePane.setVisible(false);
        if(b.getText().equals("Easy")){
            level=1;
        }
        if(b.getText().equals("Medium")){
            level=2;
        }
        if(b.getText().equals("Hard")){
            level=3;
        }
        makeGrid();
        Thread t = new Thread(new Blink(this));
        t.start();
    }

    private void makeGrid(){
        GridPane grid;
        grid=grid1;
        if(level==1)
            grid=grid1;
        if(level==2)
            grid=grid2;
        if(level==3)
            grid=grid3;

        bt=new Button[2+level][2+level];
        a=new boolean[2+level][2+level];
        for(int i=0;i<2+level;i++)
            for(int j=0;j<2+level;j++) {
                a[i][j]=false;
                bt[i][j] = new Button();
                bt[i][j].setMaxSize(1000, 1000);
                bt[i][j].setStyle("-fx-padding: 10%");
                bt[i][j].setStyle("-fx-background-color: red;");
                final int r=i;
                final int c=j;
                bt[i][j].setOnMouseClicked(mouseEvent -> {click(r,c);});
                grid.add(bt[i][j], i, j);
            }
        grid.setVisible(true);
    }

}
