module com.example.projeto_final {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
            
    opens com.example.projeto_final to javafx.fxml;
    exports com.example.projeto_final;
    exports com.example.projeto_final.controller;
    exports com.example.projeto_final.model;
    opens com.example.projeto_final.model to javafx.fxml;
    opens com.example.projeto_final.controller to javafx.fxml;
}