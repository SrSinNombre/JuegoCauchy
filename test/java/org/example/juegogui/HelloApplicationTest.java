package org.example.juegogui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {

    @Test
    void start() {
        HelloApplication app = new HelloApplication();
        try {
            // El método start normalmente recibe un Stage, que es de JavaFX.
            // Sin Stage real podemos pasar null o mock si tienes librerías.
            app.start(null);
        } catch (Exception e) {
            fail("El método start lanzó una excepción: " + e.getMessage());
        }
    }

    @Test
    void main() {
        try {
            HelloApplication.main(new String[]{});
        } catch (Exception e) {
            fail("El método main lanzó una excepción: " + e.getMessage());
        }
    }
}