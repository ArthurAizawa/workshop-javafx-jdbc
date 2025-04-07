package gui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginViewController {
	@FXML
    private TextField usuarioField;
	
	@FXML
    private TextField senhaField;
	
	@FXML
    private Label mensagemLabel;
	
	@FXML
	private Button btnLogin;

	public void OnActionBtnLogin() {
		btnLogin.setOnAction(x -> autenticar());
	}
    

    private void autenticar() {
        String usuario = usuarioField.getText();
        String senha = senhaField.getText();

        if (usuario.equals("admin") && senha.equals("1234")) {
            mensagemLabel.setTextFill(Color.GREEN);
            mensagemLabel.setText("Login bem-sucedido!");
        } else {
            mensagemLabel.setTextFill(Color.RED);
            mensagemLabel.setText("Usuário ou senha incorretos.");
        }
    }
}
