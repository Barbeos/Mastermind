package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Main extends Application implements EventHandler<ActionEvent> {
	int state = 0;

	Button[][] checks;
	Button[][] guesses;

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Button check = new Button("check");
			check.setOnAction(this);

			// root.setGridLinesVisible(true);

			root.setHgap(10);
			root.setVgap(10);
			root.setPadding(new Insets(10, 10, 10, 10));
			root.add(check, 3, 12);

			guesses = new Button[10][4];
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 4; x++) {
					guesses[y][x] = new Button();
					root.add(guesses[y][x], x, y);
					guesses[y][x].setStyle("-fx-background-color: blue;");
					guesses[y][x].setPrefSize(40, 40);
					guesses[y][x].setOnAction(this);
				}
			}

			checks = new Button[10][4];
			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 4; x++) {
					checks[y][x] = new Button();
					root.add(checks[y][x], x + 4, y);
					checks[y][x].setStyle("-fx-background-color: purple;");
					checks[y][x].setPrefSize(20, 20);
				}
			}

			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Controller.getInstance().compChosesColor();
		launch(args);

	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		boolean[] isSet = new boolean[4];
		System.out.println("event" + isSet[1]);
		
		//the first if and three else if change the colors on guesses buttons

		if (b.getStyle().equals("-fx-background-color: green;")) {
			b.setStyle("-fx-background-color: white;");
		} else if (b.getStyle().equals("-fx-background-color: white;")) {
			b.setStyle("-fx-background-color: blue;");
		} else if (b.getStyle().equals("-fx-background-color: blue;")) {
			b.setStyle("-fx-background-color: red;");
		} else if (b.getStyle().equals("-fx-background-color: red;")) {
			b.setStyle("-fx-background-color: green;");
			
			
		// inside this else if a check between the guess colors and the computer choises are made
		} else if (b.getText().equals("check")) {
			String[] color = Controller.getInstance().getColor();
			
			int black = 0;
			int white = 0;
			// for loop checks if guess is equal to computer color choice on same index
			for (int x = 0; x < 4; x++) {
				System.out.println(color[x] + "computer choice");
				if (color[x].equals(guesses[state][x].getStyle())) {
					black++;
					isSet[x] = true;
				} else if (color[x].equals(guesses[state][x].getStyle())) {
					black++;
					isSet[x] = true;
				} else if (color[x].equals(guesses[state][x].getStyle())) {
					black++;
					isSet[x] = true;
				} else if (color[x].equals(guesses[state][x].getStyle())) {
					black++;
					isSet[x] = true;
				}
			}
			// here we check if a color occures in the computer choises but not in same index
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					if (!isSet[x] && !isSet[y]) {
						if (color[x].equals(guesses[state][y].getStyle())) {
							white++;
							isSet[x] = true;
						} else if (color[x].equals(guesses[state][y].getStyle())) {
							white++;
							isSet[x] = true;
						} else if (color[x].equals(guesses[state][y].getStyle())) {
							white++;
							isSet[x] = true;
						} else if (color[x].equals(guesses[state][y].getStyle())) {
							white++;
							isSet[x] = true;
						}
					}
				}
			}
			// here we set how many of the colors where right and set on the right index
			for (int x = 0; x < black; x++) {
				checks[state][x].setStyle("-fx-background-color: black;");
			}
			// here we set how many colors where right but in wrong index
			for (int x = 0 + black; x < white + black; x++) {
				checks[state][x].setStyle("-fx-background-color: white;");
			}

			state++;

			// for (int x = 0; x < 4; x++) {
			// System.out.println(color[x] + "computer choice");
			// if (color[x].equals(guesses[state][x].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: black;");
			// isSet[x] = true;
			// System.out.println(x + checks[state][x].getStyle());
			// } else if (color[x].equals(guesses[state][x].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: black;");
			// isSet[x] = true;
			// System.out.println(x + checks[state][x].getStyle());
			// } else if (color[x].equals(guesses[state][x].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: black;");
			// isSet[x] = true;
			// System.out.println(x + checks[state][x].getStyle());
			// } else if (color[x].equals(guesses[state][x].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: black;");
			// isSet[x] = true;
			// }
			// }
			//
			// for (int x = 0; x < 4; x++) {
			// for (int y = 0; y < 4; y++) {
			// if (!isSet[x] && !isSet[y]) {
			// if (color[x].equals(guesses[state][y].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: white;");
			// isSet[x] = true;
			// } else if (color[x].equals(guesses[state][y].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: white;");
			// isSet[x] = true;
			// } else if (color[x].equals(guesses[state][y].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: white;");
			// isSet[x] = true;
			// } else if (color[x].equals(guesses[state][y].getStyle())) {
			// checks[state][x].setStyle("-fx-background-color: white;");
			// isSet[x] = true;
			// }
			// }
			// }
			// }

		}

	}

}
