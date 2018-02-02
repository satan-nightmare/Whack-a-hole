package application;

import javafx.application.Platform;

import java.util.Random;

public class Blink implements Runnable{

    private Controller controller;
    public Blink(Controller controller){
        this.controller=controller;
    }

    @Override
    public void run() {
        int r,c;
        Random ro = new Random();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true) {
            System.out.println("Sumit");
            r=ro.nextInt(3+controller.level-1);
            c=ro.nextInt(3+controller.level-1);
            System.out.println(""+r+" "+c);
            controller.bt[r][c].setStyle("-fx-background-color: blue;");
            controller.a[r][c]=true;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(controller.a[r][c]){
                Platform.runLater(()->{controller.nameLabel.setText("Game Over");});
                Thread.currentThread().stop();
            }
            controller.score++;
            Platform.runLater(()->{controller.scoreLabel.setText(Integer.toString(controller.score));});
            controller.bt[r][c].setStyle("-fx-background-color: red;");
        }
    }
}
