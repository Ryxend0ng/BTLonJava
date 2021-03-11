package BEAN;

import java.text.ParseException;
import java.util.Date;

public class MonHoc {
	private int maMH;
	private String tenMH;
	private float heSoMH;
	public int getMaMH() {
		return maMH;
	}
	public MonHoc(int maMH, String tenMH, float heSoMH) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.heSoMH = heSoMH;
	}
	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public float getHeSoMH() {
		return heSoMH;
	}
	public void setHeSoMH(float heSoMH) {
		this.heSoMH = heSoMH;
	}
	
}
