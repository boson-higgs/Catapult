import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball
{
	
	public double x;
	public double y;
	public double xVelocity;
	public double yVelocity;
	
	private final int radius;
	
	public Ball(int x, int y, int radius)
	{
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void accelerate(double xAcc, double yAcc, double difTime)
	{
		xVelocity +=  xAcc * difTime;
		yVelocity +=  yAcc * difTime;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void move(double time)
	{
		x += xVelocity * time;
		y += yVelocity * time;
	}

	public void paint(GraphicsContext gc)
	{
		gc.setFill(Color.BLUEVIOLET);
		gc.setStroke(Color.BLUEVIOLET);
		gc.fillOval(x - radius, y - radius, radius * 2., radius * 2.);
	}

	public void fixXCoordinate(int canvasWidth) {
		x = (x + canvasWidth) % canvasWidth;
	}


	public void stopAndMoveTo(int newX, int newY)
	{
		xVelocity = 0;
		yVelocity = 0;
		this.x = newX;
		this.y = newY;
	}

}