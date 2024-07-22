package gui.abdullah;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class BaseController {

    protected void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    protected void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    protected boolean isInputValid(TextField... fields) {
        String errorMessage = "";
        for (TextField field : fields) {
            if (field.getText() == null || field.getText().isEmpty()) {
                errorMessage += "No valid input in field: " + field.getId() + "\n";
            }
        }
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showAlert("Invalid Fields", errorMessage, Alert.AlertType.ERROR);
            return false;
        }
    }
}
