package com.learnshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
       GridPane root = loader.load();
       //get the reference to first Pane inside GridPane
        Pane menuPane =  (Pane) root.getChildren().get(0);
        MenuBar menuBar = createMenu();
        //set MenuBar width same as stage
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        menuPane.getChildren().add(menuBar);

       controller = loader.getController();
       controller.createPlayGround();

       Scene scene = new Scene(root);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Connect Four");
       primaryStage.setResizable(false);
       primaryStage.show();
    }

    private MenuBar createMenu() {
        //file menu
        Menu fileMenu = new Menu("File");
        //file menu items
        MenuItem newGame = new MenuItem("New Game");

        newGame.setOnAction(event -> resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");

        resetGame.setOnAction(event -> resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");

        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
        //Help menu
        Menu helpMenu = new Menu("Help");
        //file menu items
        MenuItem aboutGame = new MenuItem("About Game");
        
        aboutGame.setOnAction(event -> aboutConnect4());
        
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");

        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);
        //MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Ashutosh Singh");
        alert.setContentText("I love coding and playing games. and this game is one of my childhood favourite");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect 4");
        alert.setHeaderText("How to Play ?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
       controller.resetGame();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
