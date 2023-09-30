package debugger.collisions;

public final class Interval {
  public double min;
  public double max;

  public Interval(double min, double max) {
    this.min = min;
    this.max = max;
  }

  public boolean overlap (Interval other) {
    return this.min <= other.max && other.min <= this.max;
  }
}

