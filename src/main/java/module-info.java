module org.example.materialfx {
    requires java.sql;
    requires MaterialFX;


    opens org.example.materialfx to javafx.fxml;
    exports org.example.materialfx;
    exports org.example.materialfx.controller;
    opens org.example.materialfx.controller to javafx.fxml;
}