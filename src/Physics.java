public class Physics
{

	private final int gravity;
	
	
	public Physics(int gravity)
	{
		super();
		this.gravity = gravity;
	}

	public void manageBallMovement(Ball ball, CatapultSimulationController controllerForRedraw, int canvasWidth, int canvasHeight)
	{


		long initTime = System.currentTimeMillis();

		while(ball.getY() < canvasHeight)
		{
			ProcessRoutines.sleep( 1);
			long newTime = System.currentTimeMillis();
			double difTime = (newTime - initTime) / 1000.;
			ball.move(difTime);
			if(ball.getX() > canvasWidth)
			{
				ball.xVelocity = - ball.xVelocity;
			}
			ball.fixXCoordinate(canvasWidth);
			ball.accelerate( 0, gravity, difTime);
			initTime = newTime;
			controllerForRedraw.needsRedraw();
		}

	}
}
