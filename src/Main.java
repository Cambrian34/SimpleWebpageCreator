import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    String head;
    String bodyy;
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField header = new TextField();
        TextField body = new TextField();
        Text headertxt = new Text(" Webpage Title");
        Text bodytxt = new Text("Body");

        Button comp = new Button("Compile");
        comp.setOnAction(e ->{
            head = header.getText();
            bodyy = body.getText();
            create();
        });
        VBox pane = new VBox(headertxt,header,bodytxt, body, comp);

        Group root = new Group(pane);
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Website Creator");
        primaryStage.show();
    }
    public void create(){

        try {
            FileWriter obj = new FileWriter("page.html");
            obj.write("<html> \n <head> \n <title> \n"+ head + "\n </title> \n </head> \n" +"<body> \n "+bodyy +" \n </body>" +" \n </hmtl>");
            obj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Main(String[] args){
        launch(args);
    }
}
