
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXApplication extends Application
{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Catapult simulation application");
		CatapultSimulationController controller = CatapultSimulationController.create();
		Scene scene = controller.createScene();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(x -> System.exit(0));
	}

	public static void doLaunch(String[] args) {
		Application.launch(args);
	}

}
