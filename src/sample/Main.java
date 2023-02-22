package sample;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void stop() {
        System.out.println("In stop");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parser parser = new Parser();
        String json = ReadFile.read();
        List<Movie> movieList = parser.parse(json);


        TableView tableView = new TableView();

        TableColumn<Movie, String> column1 = new TableColumn<>("Title");

        column1.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Movie, String> column2 = new TableColumn<>("Author");

        column2.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Movie, String> column3 = new TableColumn<>("Year");

        column3.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Movie, String> column4 = new TableColumn<>("Type");

        column4.setCellValueFactory(new PropertyValueFactory<>("type"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);


        for (Movie movie : movieList) {
            tableView.getItems().add(movie);
        }


        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
