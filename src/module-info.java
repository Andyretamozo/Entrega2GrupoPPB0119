module Entrega2GrupoPPB0119 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens Controlador to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
