package pl1.simulation;
import pl1.commons.ProcessRoutines;

public class Physics {

	private final int gravity;
	
	
	public Physics(int gravity) {
		super();
		this.gravity = gravity;
	}

	public void manageBallMovement(Ball ball, SimulationManager manager, int canvasWidth, int canvasHeight) {
		long time = System.currentTimeMillis();
		while(ball.getY() < canvasHeight) {
			ProcessRoutines.sleep(1);
			long newTime = System.currentTimeMillis();
			double difTime = (newTime - time)/1000.;
			ball.move(difTime);
			if(ball.getX() > canvasWidth)
			{
				ball.xVelocity = - ball.xVelocity;
			}
			ball.fixXCoordinate(canvasWidth);
			ball.accelerate(0, gravity, difTime);
			time = newTime;
			if(!manager.stepOfSimulation()) {
				break;
			}
		
		}
	}
}
