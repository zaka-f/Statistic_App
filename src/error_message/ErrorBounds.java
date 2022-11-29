package error_message;

public class ErrorBounds implements ErrorBoundsPlan {
	private int boundsX;
	private int boundsY;
	private int boundsWidth;
	private int boundsHeight;
	@Override
	public void setX(int x) {
		this.boundsX = x;
		
	}
	public int getX() {
		return boundsX;
	}

	@Override
	public void setY(int y) {
		this.boundsY = y;
		
	}
	public int getY() {
		return boundsY;
	}
	
	@Override
	public void setWidth(int width) {
		this.boundsWidth = width;
		
	}
	public int getWidth() {
		return boundsWidth;
	}

	@Override
	public void setHeight(int height) {
		this.boundsHeight = height;
		
	}
	public int getHeight() {
		return boundsHeight;
	}

}
