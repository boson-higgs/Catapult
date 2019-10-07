import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

public class Catapult
{

	private static final int ARR_SIZE = 5;
	private final int x;
	private final int y;
	private final int len; //delka

	private int angle;

	private int power;

	public Catapult(int x, int y, int len)
	{
		super();
		this.x = x;
		this.y = y;
		this.len = len;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void shootBall(Ball ball, CatapultSimulationController controllerForRedraw)
	{

		double xAcc = Math.cos(Math.toRadians(angle)) * power;
		double yAcc = -Math.sin(Math.toRadians(angle)) * power;

		int xEnd = x + (int) (Math.cos(Math.toRadians(angle)) * len);
		int yEnd = y - (int) (Math.sin(Math.toRadians(angle)) * len);

		long initTime = System.currentTimeMillis();

		while(ball.getX() < xEnd && ball.getY() > yEnd)
		{
			ProcessRoutines.sleep( 1);
			long newTime = System.currentTimeMillis();
			double difTime = (newTime - initTime) / 1000.;
			ball.move(difTime);
			ball.accelerate(xAcc, yAcc, difTime);
			initTime = newTime;
			controllerForRedraw.needsRedraw();
		}

	}

	public void paint(GraphicsContext gc)
	{
		Affine oldTransform = gc.getTransform();
		Transform transform = Transform.translate(x, y);
		transform = transform.createConcatenation(Transform.rotate(-angle, 0, 0));
		gc.setTransform(new Affine(transform));
		gc.setFill(Color.LIGHTBLUE);
		gc.setStroke(Color.LIGHTBLUE);
		gc.strokeLine(0, 0, len, 0);
		gc.fillPolygon(new double[] { len, len - ARR_SIZE, len - ARR_SIZE, len },
				new double[] { 0, -ARR_SIZE, ARR_SIZE, 0 }, 4);
		gc.setTransform(oldTransform);
	}

}
