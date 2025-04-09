package gui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import db.DBLogin;
import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginViewController {

    @FXML
    private TextField usuarioField;

    @FXML
    private TextField senhaField;

    @FXML
    private Label mensagemLabel;

    @FXML
    private Button btnLogin;

    @FXML
    public void OnActionBtnLogin(ActionEvent event) {
        if (autenticar()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
                ScrollPane scrollPane = loader.load();

                scrollPane.setFitToHeight(true);
                scrollPane.setFitToWidth(true);

                // Atualiza apenas o conteúdo da cena atual (sem criar nova Scene)
                Main.getMainScene().setRoot(scrollPane);

            } catch (IOException e) {
                Alerts.showAlert("Erro", "Erro ao carregar MainView", e.getMessage(), AlertType.ERROR);
            }
        } else {
            Alerts.showAlert("Login inválido", null, "Usuário ou senha incorretos", AlertType.ERROR);
        }
    }

    private boolean autenticar() {
        String usuario = usuarioField.getText();
        String senha = senhaField.getText();

        try (Connection conn = DBLogin.conectar()) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Se encontrou usuário, autenticação OK

        } catch (SQLException e) {
            mensagemLabel.setTextFill(Color.RED);
            mensagemLabel.setText("Erro ao acessar o sistema.");
            e.printStackTrace();
            return false;
        }
    }
}
