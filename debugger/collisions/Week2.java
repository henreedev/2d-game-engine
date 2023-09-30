package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.interfaces.Week2Reqs;

/**
 * Fill this class in during Week 2.
 */
public final class Week2 extends Week2Reqs {

	// AXIS-ALIGNED BOXES
	
	@Override
	public boolean isColliding(AABShape s1, AABShape s2) {
		Vec2d xAxis = new Vec2d(1,0);
		Vec2d yAxis = new Vec2d(0,1);

		Interval xInt1 = new Interval(s1.topLeft.projectOnto(xAxis).mag(), s1.topLeft.plus(s1.size).projectOnto(xAxis).mag());
		Interval yInt1 = new Interval(s1.topLeft.projectOnto(yAxis).mag(), s1.topLeft.plus(s1.size).projectOnto(yAxis).mag());
		Interval xInt2 = new Interval(s2.topLeft.projectOnto(xAxis).mag(), s2.topLeft.plus(s2.size).projectOnto(xAxis).mag());
		Interval yInt2 = new Interval(s2.topLeft.projectOnto(yAxis).mag(), s2.topLeft.plus(s2.size).projectOnto(yAxis).mag());

		return xInt1.overlap(xInt2) && yInt1.overlap(yInt2);
	}

	public double clamp(Interval interval, double val) {
		return Math.max(interval.min, Math.min(interval.max, val));
	}

	@Override
	public boolean isColliding(AABShape s1, CircleShape s2) {
		Vec2d xAxis = new Vec2d(1,0);
		Vec2d yAxis = new Vec2d(0,1);

		Interval xInt = new Interval(s1.topLeft.projectOnto(xAxis).mag(), s1.topLeft.plus(s1.size).projectOnto(xAxis).mag());
		Interval yInt = new Interval(s1.topLeft.projectOnto(yAxis).mag(), s1.topLeft.plus(s1.size).projectOnto(yAxis).mag());

		Vec2d closestPoint = new Vec2d(clamp(xInt, s2.getCenter().x), clamp(yInt, s2.getCenter().y));

		return isColliding(s2, closestPoint);
	}

	@Override
	public boolean isColliding(AABShape s1, Vec2d s2) {
		double left = s1.topLeft.x;
		double right = s1.topLeft.x + s1.size.x;
		double top = s1.topLeft.y;
		double bot = s1.topLeft.y + s1.size.y;
		return s2.x > left && s2.x < right && s2.y > top && s2.y < bot;
	}

	// CIRCLES
	
	@Override
	public boolean isColliding(CircleShape s1, AABShape s2) {
		return isColliding(s2, s1);
	}

	@Override
	public boolean isColliding(CircleShape s1, CircleShape s2) {
		Vec2d pos1 = s1.getCenter();
		double r1 = s1.getRadius();
		Vec2d pos2 = s2.getCenter();
		double r2 = s2.getRadius();
		return pos1.dist2(pos2) <= (r1 + r2) * (r1 + r2);
	}

	@Override
	public boolean isColliding(CircleShape s1, Vec2d s2) {
		Vec2d pos = s1.getCenter();
		double r = s1.getRadius();
		return pos.dist2(s2) <= r * r;
	}

	
}
