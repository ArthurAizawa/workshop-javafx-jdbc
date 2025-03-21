module workshop_javafx_jdbc {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
    opens gui to javafx.fxml; // <- Essa linha permite que o FXMLLoader acesse a classe MainViewController
    exports gui;
    opens model.entities to javafx.base, javafx.fxml;
}
