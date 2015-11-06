package components;

public class ThreeCimGroup {

	public Cim c1;
	public Cim c2;
	public Cim c3;
	
	public ThreeCimGroup(int m1Chn, int m2Chn, int m3Chn) {
		c1 = new Cim(m1Chn);
		c2 = new Cim(m2Chn);
		c3 = new Cim(m3Chn);
	}
	
	public void set(double speed) {
		c1.set(speed);
		c2.set(speed);
		c3.set(speed);
	}
}
