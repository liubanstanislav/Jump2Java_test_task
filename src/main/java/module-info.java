module com.jump2java_test_task.home {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
            
    opens com.jump2java_test_task.home to javafx.fxml;
    exports com.jump2java_test_task.home;
}