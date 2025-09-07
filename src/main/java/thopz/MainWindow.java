package thopz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Thopz thopz;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/Messi.png"));
    private Image thopzImage = new Image(this.getClass().getResourceAsStream("/images/Thopz.png"));

    /**
     * Intialise thopz.
     */

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Injects the thopz instance
     * Include greetings
     *
     * @param
     * d
     */
    public void setThopz(Thopz d) {
        thopz = d;
        dialogContainer.getChildren().add(
                DialogBox.getThopzDialog(
                        "Wassup wassup! Life ok? Vibes ok? Family ok? " +
                                "I am Thopz your virtual chatbot. How may I help you?",
                        thopzImage
                )
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Thopz's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = thopz.getResponse(input);

        dialogContainer.getChildren().add(
                DialogBox.getUserDialog(input, userImage)
        );

        if (!response.isEmpty()) {
            dialogContainer.getChildren().add(
                    DialogBox.getThopzDialog(response, thopzImage)
            );
        }

        userInput.clear();

        if ("Chaoz. See you!".equals(response)) {
            javafx.application.Platform.exit();
        }
    }


}
