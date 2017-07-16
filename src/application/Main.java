package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {
    Player player;
    FileChooser fileChooser;

    @Override
    public void start(Stage primaryStage) throws Exception{
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        file.getItems().add(open);
        menu.getMenus().add(file);
        fileChooser = new FileChooser();

        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(primaryStage);
                if(file != null) {
                    try {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        player.setTop(menu);
                        Scene scene = new Scene(player, 720, 510, Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        Player player = new Player("file:///FILE_PATH");
        player.setTop(menu);
        Scene scene = new Scene(player, 720, 510, Color.BLACK);
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
