package view;

import Model.logic.BoardObserver;
import Model.logic.ChessBoard;
import java.util.Objects;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChessgameMain extends Application implements BoardObserver {
 private ChessBoard board;
 private int[] selected;
 private  Scene scene;

 private FlowPane root;
  public static void mainApp(String[] args) {
  launch(args);
}
  @Override
  public void start(Stage stage) throws Exception {
    try{
      root = new FlowPane();
      selected = null;
      board = new ChessBoard(this);
       this.root.getChildren().add( drawBoard());
     /* root.setHgap(40);
      root.setVgap(20);
      root.setAlignment(Pos.CENTER);
      BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO,
          false, false, true, false);
      Image bgrImage = new Image(Objects.requireNonNull(getClass().getClassLoader()
          .getResource("chess.png")).toExternalForm());
      root.setBackground(new Background( new BackgroundImage(bgrImage, BackgroundRepeat.NO_REPEAT,
          BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,bSize )));

      */

      //Get the screen size


      this.scene = new Scene(this.root, 1000, 1000);
      //stage.setMaximized(true);
      stage.setScene(scene);
      stage.show();
    }catch (Exception e){
      e.printStackTrace();
    }

  }

  private void imageListener( Node node){
    node.setOnMouseClicked(mouseEvent -> {
      node.setStyle("-fx-border-color: blue");
      int row = GridPane.getRowIndex(node);
      int col = GridPane.getColumnIndex(node);
      if (selected == null) {
        selected = new int[2];
        selected[0] = row;
        selected[1] = col;
      } else {
        if(board.movePiece(selected[0], selected[1], row, col)){
        }
        selected = null;
      }
    });
  }
  private String tileChooser(int j, int i){
    String tile;
    if ((i + j) % 2 == 0) {
      tile = getClass().getClassLoader().getResource("whiteTile.png").toExternalForm();
    } else {
      tile = getClass().getClassLoader().getResource("blackTile.png").toExternalForm();
    }
    return tile;

  }
  /**
   * This method draws the board on the console.
   */
  private GridPane drawBoard() {
    GridPane canvas = new GridPane();
    for (int i = 0; i < 8; i++) {
      System.out.println();
      for (int j = 0; j < 8; j++) {
        String tile= tileChooser(j, i);
        Image tileImg = new Image(tile);
        ImageView tileView = new ImageView(tileImg);
        StackPane stack = new StackPane();

        if (board.getPiece(i, j) != null) {
          String imageLink = "pieces\\" + board.getPiece(i, j).imageLink() + ".png";
          Image pieceImg = new Image(getClass().getClassLoader()
              .getResource(imageLink).toExternalForm());
          ImageView image = new ImageView(pieceImg);
          image.setFitWidth(80);
          image.setFitHeight(80);
          stack.getChildren().addAll(tileView, image);
          this.imageListener(stack);
          canvas.add(stack, j, i);

        } else {
          stack.getChildren().add(tileView);
          this.imageListener(stack);
            canvas.add(stack, j, i);
        }
      }

    }
    return canvas;
  }
  @Override
  public void update() {
    root.getChildren().clear();
    root.getChildren().add(drawBoard());

  }
}
