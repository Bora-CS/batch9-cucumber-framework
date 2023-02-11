package utilities;

public enum StatusCodes {

	OK(200), BAD_REQUEST(400), UNAUTHORIZED(401), NOT_FOUND(404);

	private int value;

	StatusCodes(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}

}
