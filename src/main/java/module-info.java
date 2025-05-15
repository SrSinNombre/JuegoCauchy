module org.example.juegogui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens org.example.juegogui to javafx.fxml;
    exports org.example.juegogui;
}