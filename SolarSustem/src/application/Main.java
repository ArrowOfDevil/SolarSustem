package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage S) {
		
		S.setTitle("Animation example");
		
		Group root = new Group();
		Scene myScene = new Scene(root);
		S.setScene(myScene);
		
		Canvas canvas = new Canvas (512, 512);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image space = new Image("space.png");
		Image sun = new Image("soln.png");
		Image earth = new Image("elon.png");
		Image mars = new Image("mars.png");
		
		final long startTime = System.nanoTime();
		
		 new AnimationTimer() { 
			double r = 100; 
			double n = 140; 
			double s = -1; 
			@Override 
			public void handle(long t) { 
			double diff = (t-startTime)/ 700000000.0; 
			double x = 230 + 128*Math.cos(diff); 
			double y = 230 + 128*Math.sin(diff); 
			double x1 = (230 + 200*Math.cos(diff)); 


			s+= 0.02; 
			if(s%4<1) { 
			r+=4; 

			} 
			if((s%4<2)&&(s%4>=1)) { 
			n+=4; 

			} 
			if((s%4<3)&&(s%4>=2)) { 
			r-=4; 

			} 
			if((s%4<4)&&(s%4>=3)) { 
			n-=4; 

			} 


				

				gc.drawImage(space, 0, 0);
				gc.drawImage(sun, 196, 196);
				gc.drawImage(earth, x, y);
				gc.drawImage(mars,r,n); 
				
				
				
				
			}
		}.start();

		
		
		
		
		S.show();
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}



