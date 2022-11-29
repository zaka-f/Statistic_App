package error_message;

public class OldBoundsBuilder implements BoundsBuilder {
	private ErrorBounds errorBounds;
	public OldBoundsBuilder() {
		this.errorBounds = new ErrorBounds();
	}

	@Override
	public void buildX() {
		errorBounds.setX(45);
		
	}

	@Override
	public void buildY() {
		errorBounds.setY(50);
		
	}

	@Override
	public void buildWidth() {
		errorBounds.setWidth(400);
		
	}

	@Override
	public void buildHeight() {
		errorBounds.setHeight(25);
		
	}
	public ErrorBounds getBounds() {
		return this.errorBounds;
	}
	
}
