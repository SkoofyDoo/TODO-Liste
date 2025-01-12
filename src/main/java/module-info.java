module org.example.materialfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.materialfx to javafx.fxml;
    exports org.example.materialfx;
}