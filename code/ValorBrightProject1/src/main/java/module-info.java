module edu.westga.cs1302.ValorBrightProject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;

    opens edu.westga.cs1302.ValorBrightProject1.views to javafx.fxml;
    exports edu.westga.cs1302.ValorBrightProject1;
}
