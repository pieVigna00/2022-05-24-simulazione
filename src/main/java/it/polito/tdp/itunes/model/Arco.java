package it.polito.tdp.itunes.model;

public class Arco {
	private Track track1;
	private Track track2;
	private double preso;
	public Arco(Track track1, Track track2, double preso) {
		super();
		this.track1 = track1;
		this.track2 = track2;
		this.preso = preso;
	}
	public Track getTrack1() {
		return track1;
	}
	public void setTrack1(Track track1) {
		this.track1 = track1;
	}
	public Track getTrack2() {
		return track2;
	}
	public void setTrack2(Track track2) {
		this.track2 = track2;
	}
	public double getPreso() {
		return preso;
	}
	public void setPreso(double preso) {
		this.preso = preso;
	}
	

}
