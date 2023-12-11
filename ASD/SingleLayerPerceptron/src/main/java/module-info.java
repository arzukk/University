module com.example.singlelayerperceptron {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.singlelayerperceptron to javafx.fxml;
    exports com.example.singlelayerperceptron;
}