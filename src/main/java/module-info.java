module org.example.juegogui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;


    opens org.example.juegogui to javafx.fxml;
    exports org.example.juegogui;
}