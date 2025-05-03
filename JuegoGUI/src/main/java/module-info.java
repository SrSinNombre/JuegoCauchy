module org.example.juegogui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.juegogui to javafx.fxml;
    exports org.example.juegogui;
}