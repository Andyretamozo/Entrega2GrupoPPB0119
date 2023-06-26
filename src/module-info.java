module Entrega2GrupoPPB0119 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.desktop;
	
	opens Controlador to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
