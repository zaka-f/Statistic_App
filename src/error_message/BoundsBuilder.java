package error_message;

public interface BoundsBuilder {
	
	public void buildX();
	public void buildY();
	public void buildWidth();
	public void buildHeight();
	public ErrorBounds getBounds();
}
