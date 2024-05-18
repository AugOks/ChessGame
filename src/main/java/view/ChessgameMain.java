package view;

import Model.logic.BoardObserver;
import Model.logic.ChessBoard;
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessgameMain extends Application implements BoardObserver {
 private ChessBoard board;
 private int[] selected;
 private  Scene scene;
  public static void mainApp(String[] args) {
  launch(args);
}
  @Override
  public void start(Stage stage) throws Exception {
    try{
      selected = null;
      board = new ChessBoard(this);
      GridPane root = drawBoard();
      root.setHgap(40);
      root.setVgap(20);
      root.setAlignment(Pos.CENTER);
      BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
          false, false, true, false);
      Image bgrImage = new Image(Objects.requireNonNull(getClass().getClassLoader()
          .getResource("chess.png")).toExternalForm());
      root.setBackground(new Background( new BackgroundImage(bgrImage, BackgroundRepeat.NO_REPEAT,
          BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,bSize )));


      //Get the screen size


      this.scene = new Scene(root, 1000, 1000);
      //stage.setMaximized(true);
      stage.setScene(scene);
      stage.show();
    }catch (Exception e){
      e.printStackTrace();
    }

  }

  /**
   * This method draws the board on the console.
   */
  private GridPane drawBoard(){
    Image placeholder = new Image(getClass().getClassLoader()
        .getResource("pieces\\transparent.png").toExternalForm());
    GridPane canvas = new GridPane();
    String color;
    for (int i = 0; i < 8; i++) {
      System.out.println();
      for (int j = 0; j < 8; j++) {
        if (board.getPiece(i, j) != null) {
          String imageLink = "pieces\\" +  board.getPiece(i,j).imageLink() + ".png";
          Image pieceImg = new Image(getClass().getClassLoader()
              .getResource(imageLink).toExternalForm());
          ImageView image = new ImageView(pieceImg);
          image.setOnMouseClicked(mouseEvent -> {
            image.setStyle("-fx-border-color: black");
           int row = GridPane.getRowIndex(image);
           int col = GridPane.getColumnIndex(image);
           if (selected == null){
             selected = new int[2];
             selected[0] = row;
             selected[1] = col;
           }else {
             board.movePiece(selected[0], selected[1], row, col);
             selected = null;
           }
          });
          canvas.add(image, j,i);


        } else {
         ImageView placeholderImage = new ImageView(placeholder);
         placeholderImage.setOnMouseClicked(mouseEvent ->{
           placeholderImage.setStyle("-fx-border-color: black");
           int row = GridPane.getRowIndex(placeholderImage);
           int col = GridPane.getColumnIndex(placeholderImage);
           if (selected == null){
             selected = new int[2];
             selected[0] = row;
             selected[1] = col;
           }else {
             board.movePiece(selected[0], selected[1], row, col);
             selected = null;
           }
         });
         canvas.add(placeholderImage, i, j);
        }

      }
    }
   return  canvas;
  }

  @Override
  public void update() {
    drawBoard();
  }
}
