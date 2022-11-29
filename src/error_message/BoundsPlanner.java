package error_message;

public class BoundsPlanner {
	private BoundsBuilder boundsBuilder;
	public BoundsPlanner(BoundsBuilder boundsBuilder) {
		this.boundsBuilder = boundsBuilder;
	}
	public ErrorBounds getErrorBounds() {
		return this.boundsBuilder.getBounds();
	}
	public void makeBounds() {
		this.boundsBuilder.buildX();
		this.boundsBuilder.buildY();
		this.boundsBuilder.buildWidth();
		this.boundsBuilder.buildHeight();
	}
}