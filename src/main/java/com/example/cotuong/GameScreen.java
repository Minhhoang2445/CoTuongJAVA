package com.example.cotuong;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

import java.io.InputStream;

public class GameScreen extends BorderPane {

    // UI Components
    private GridPane boardGrid;
    private GridPane cellGrid;
    private GridPane pieceGrid;
    private GridPane posMovedGrid;
    private GridPane highlightGrid;
    private Text turnTextBlock;
    private Text blackInfo;
    private Text blackClock;
    private Text redInfo;
    private Text redClock;
    private Text warningTextBlock;
    private GridPane blackCapturedGrid;
    private GridPane redCapturedGrid;
    private Button undoButton;
    private Button doButton;

    private double xOffset = 0;
    private double yOffset = 0;

    public GameScreen() {
        initializeUI();
    }

    private void initializeUI() {
        // Set background image
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(getClass().getResourceAsStream("/com/example/cotuong/images/background.png")),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        setBackground(new Background(backgroundImage));

        // Create main grid
        GridPane mainGrid = createMainGrid();
        setCenter(mainGrid);
    }

    private GridPane createMainGrid() {
        GridPane mainGrid = new GridPane();

        // Set row constraints equivalent to WPF's RowDefinitions
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(8);  // 0.2 of total
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(16); // 0.4 of total
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(40); // 1 of total
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(8);  // 0.2 of total
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(40); // 1 of total
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(16); // 0.4 of total

        mainGrid.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);

        // Set column constraints equivalent to WPF's ColumnDefinitions
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(31); // 3.3 of total
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(57); // 6 of total
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(12); // 1.2 of total

        mainGrid.getColumnConstraints().addAll(col1, col2, col3);

        // Add the chess board
        StackPane boardContainer = createChessBoard();
        mainGrid.add(boardContainer, 1, 1, 1, 5);

        // Add the right side panel with controls
        VBox rightPanel = createRightPanel();
        mainGrid.add(rightPanel, 2, 1, 1, 5);

        // Add player 2 (black) panel
        BorderPane player2Panel = createPlayerPanel("Người chơi 2", "blackInfo", "blackClock");
        mainGrid.add(player2Panel, 0, 1);

        // Add black captured pieces grid
        blackCapturedGrid = createCapturedPiecesGrid();
        BorderPane blackCapturedContainer = new BorderPane();
        blackCapturedContainer.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-background-radius: 10;");
        blackCapturedContainer.setCenter(blackCapturedGrid);
        blackCapturedContainer.setPadding(new Insets(10));
        mainGrid.add(blackCapturedContainer, 0, 2);

        // Add warning text block
        warningTextBlock = new Text();
        warningTextBlock.setFont(Font.font("Arial", 30));
        warningTextBlock.setFill(Color.RED);
        StackPane warningContainer = new StackPane(warningTextBlock);
        mainGrid.add(warningContainer, 0, 3);

        // Add red captured pieces grid
        redCapturedGrid = createCapturedPiecesGrid();
        BorderPane redCapturedContainer = new BorderPane();
        redCapturedContainer.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-background-radius: 10;");
        redCapturedContainer.setCenter(redCapturedGrid);
        redCapturedContainer.setPadding(new Insets(10));
        mainGrid.add(redCapturedContainer, 0, 4);

        // Add player 1 (red) panel
        BorderPane player1Panel = createPlayerPanel("Người chơi 1", "redInfo", "redClock");
        mainGrid.add(player1Panel, 0, 5);

        // Add title bar
        HBox titleBar = createTitleBar();
        mainGrid.add(titleBar, 0, 0, 3, 1);

        return mainGrid;
    }

    private GridPane createCapturedPiecesGrid() {
        GridPane grid = createUniformGrid(3, 5);
        grid.setGridLinesVisible(false);
        grid.setPrefSize(300, 200);
        return grid;
    }

    private HBox createTitleBar() {
        HBox titleBar = new HBox();
        titleBar.setPadding(new Insets(10));
        titleBar.setStyle("-fx-background-color: white; -fx-background-radius: 10 10 0 0;");

        // Left side with icon and title
        HBox leftSide = new HBox(15);
        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/com/example/cotuong/images/icon.png")));
        icon.setFitHeight(25);
        icon.setFitWidth(25);

        Text title = new Text("Cờ tướng");
        title.setFont(Font.font("Arial", 20));

        leftSide.getChildren().addAll(icon, title);

        // Right side with window controls
        HBox rightSide = new HBox(10);
        rightSide.setPadding(new Insets(0, 30, 0, 0));

        Button minimizeButton = createWindowControlButton(MaterialDesign.MDI_WINDOW_MINIMIZE, Color.BLACK);
        Button maximizeButton = createWindowControlButton(MaterialDesign.MDI_WINDOW_MAXIMIZE, Color.BLACK);
        Button closeButton = createWindowControlButton(MaterialDesign.MDI_CLOSE, Color.BLACK);

        minimizeButton.setOnAction(e -> {
            Stage stage = (Stage) getScene().getWindow();
            stage.setIconified(true);
        });

        maximizeButton.setOnAction(e -> {
            Stage stage = (Stage) getScene().getWindow();
            stage.setMaximized(!stage.isMaximized());
        });

        closeButton.setOnAction(e -> {
            Stage stage = (Stage) getScene().getWindow();
            stage.close();
        });

        rightSide.getChildren().addAll(minimizeButton, maximizeButton, closeButton);
        rightSide.setAlignment(Pos.CENTER_RIGHT);

        // Add both sides to the title bar
        titleBar.getChildren().addAll(leftSide, rightSide);
        HBox.setHgrow(rightSide, Priority.ALWAYS);

        // Make the stage draggable
        titleBar.setOnMousePressed(event -> {
            Stage stage = (Stage) getScene().getWindow();
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });

        titleBar.setOnMouseDragged(event -> {
            Stage stage = (Stage) getScene().getWindow();
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });

        return titleBar;
    }

    private Button createWindowControlButton (MaterialDesign iconCode, Color color){
        Button button = new Button();
        button.setPrefSize(30, 30);
        button.setStyle("-fx-background-color: transparent;");

        FontIcon icon = new FontIcon(iconCode);
        icon.setIconSize(20);
        icon.setIconColor(color);

        button.setGraphic(icon);
        return button;
    }


    private BorderPane createPlayerPanel(String playerID, String infoID, String clockID) {

        BorderPane playerPanel = new BorderPane();
        playerPanel.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-background-radius: 10;");
        playerPanel.setPrefSize(300, 200);

        Text playerName = new Text(playerID);
        playerName.setFont(Font.font("Arial", 20));
        playerName.setFill(Color.BLACK);

        Text infoText = new Text(infoID);
        infoText.setFont(Font.font("Arial", 20));
        infoText.setFill(Color.BLACK);

        Text clockText = new Text(clockID);
        clockText.setFont(Font.font("Arial", 20));
        clockText.setFill(Color.BLACK);

        VBox playerInfo = new VBox(5);
        playerInfo.getChildren().addAll(playerName, infoText, clockText);
        playerInfo.setAlignment(Pos.CENTER);

        playerPanel.setCenter(playerInfo);
        return playerPanel;

    }

    private StackPane createChessBoard() {
        StackPane container = new StackPane();

        // Create board background
        boardGrid = new GridPane();
        boardGrid.setPrefSize(720, 720);
        BackgroundImage boardImage = new BackgroundImage(
                new Image(getClass().getResourceAsStream("/com/example/cotuong/images/board.jpg")),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        boardGrid.setBackground(new Background(boardImage));

        // Create cell grid for handling mouse events
        cellGrid = new GridPane();
        cellGrid.setPrefSize(710, 720);
        cellGrid.setOnMouseClicked(this::handleBoardClick);

        // Create uniform grids for pieces, moves, and highlights
        pieceGrid = createUniformGrid(10, 9);
        posMovedGrid = createUniformGrid(10, 9);
        highlightGrid = createUniformGrid(10, 9);

        cellGrid.add(pieceGrid, 0, 0);
        cellGrid.add(posMovedGrid, 0, 0);
        cellGrid.add(highlightGrid, 0, 0);

        container.getChildren().addAll(boardGrid, cellGrid);
        return container;
    }

    private void handleBoardClick (MouseEvent event){
        // Implement board click logic here
        System.out.println("Board clicked at: " + event.getX() + ", " + event.getY());
        // Add your implementation for handling chess moves
    }


    private GridPane createUniformGrid(int rows, int cols) {
        GridPane grid = new GridPane();

        // Set equal row constraints
        for (int i = 0; i < rows; i++) {
            RowConstraints rowConstraint = new RowConstraints();
            rowConstraint.setPercentHeight(100.0 / rows);
            grid.getRowConstraints().add(rowConstraint);
        }

        // Set equal column constraints
        for (int i = 0; i < cols; i++) {
            ColumnConstraints colConstraint = new ColumnConstraints();
            colConstraint.setPercentWidth(100.0 / cols);
            grid.getColumnConstraints().add(colConstraint);
        }

        return grid;
    }

    private VBox createRightPanel() {
        VBox panel = new VBox(10);
        panel.setAlignment(Pos.CENTER);

        // Turn indicator
        BorderPane turnIndicator = new BorderPane();
        turnIndicator.setPrefSize(130, 80);
        turnIndicator.setStyle("-fx-background-color: rgba(255, 255, 255, 0.9); -fx-background-radius: 10; -fx-border-color: black; -fx-border-radius: 10;");

        VBox turnTextContainer = new VBox(5);
        turnTextContainer.setAlignment(Pos.CENTER);

        Text turnLabel = new Text("Lượt của:");
        turnLabel.setFont(Font.font("Arial", 20));

        turnTextBlock = new Text();
        turnTextBlock.setFont(Font.font("Arial", 22));
        turnTextBlock.setFill(Color.RED);

        turnTextContainer.getChildren().addAll(turnLabel, turnTextBlock);
        turnIndicator.setCenter(turnTextContainer);

        // Create action buttons
        Button saveButton = createGameButton(MaterialDesign.MDI_CONTENT_SAVE, "Save");
        Button pauseButton = createGameButton(FontAwesomeSolid.PAUSE, "Pause");
        undoButton = createGameButton(MaterialDesign.MDI_UNDO, "Undo");

        // Create redo button with flipped undo icon
        doButton = createGameButton(MaterialDesign.MDI_UNDO, "Redo");
        FontIcon redoIcon = (FontIcon) doButton.getGraphic();
        doButton.setVisible(false);

        // Add all components to panel
        panel.getChildren().addAll(turnIndicator, saveButton, pauseButton, undoButton, doButton);

        return panel;
    }

    private Button createGameButton(Object iconCode, String purpose) {
        Button button = new Button();
        button.setPrefSize(80, 80);
        button.setStyle("-fx-background-color: #333333; -fx-background-radius: 40; -fx-border-radius: 40;");

        FontIcon icon = new FontIcon();
        if (iconCode instanceof MaterialDesign) {
            icon.setIconCode((MaterialDesign) iconCode);
        } else if (iconCode instanceof FontAwesomeSolid) {
            icon.setIconCode((FontAwesomeSolid) iconCode);
            icon.setIconSize(40);
            icon.setIconColor(Color.WHITE);

            button.setGraphic(icon);

            // Set action handlers based on purpose
//        switch (purpose) {
//            case "Save":
//                button.setOnAction(e -> handleSaveGame());
//                break;
//            case "Pause":
//                button.setOnAction(e -> handlePauseGame());
//                break;
//            case "Undo":
//                button.setOnAction(e -> handleUndoMove());
//                break;
//            case "Redo":
//                button.setOnAction(e -> handleRedoMove());
//                break;
//
        }
            return button;
        }




        // Event
}