module org.example.materialfx {
    requires MaterialFX;
    requires java.sql;


    opens org.example.materialfx to javafx.fxml;
    exports org.example.materialfx;
    exports org.example.materialfx.controller;
    opens org.example.materialfx.controller to javafx.fxml;
}