package ch.dellensekte.domain;

public class Duration {
	TimeUnit unit;
	long value;

	public TimeUnit getUnit() {
		return unit;
	}

	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}


	public Duration(TimeUnit unit, long value) {
		super();
		this.unit = unit;
		this.value = value;
	}

}
