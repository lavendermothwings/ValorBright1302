module edu.westga.cs1302.Project1ValorBright2025 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens edu.westga.cs1302.Project1ValorBright2025.views to javafx.fxml;
    exports edu.westga.cs1302.Project1ValorBright2025;
}
