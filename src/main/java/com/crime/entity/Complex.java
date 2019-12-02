package com.crime.entity;

import java.util.List;

public class Complex {
	private List<HighestCrimeGroup> cgList;
	private List<JuviePercent> jp;
	private List<DecreaseCrime> dc;
	private List<PresentSublists> ps;
	private List<String> tpp10;
	
	public List<HighestCrimeGroup> getCgList() {
		return cgList;
	}
	public void setCgList(List<HighestCrimeGroup> cgList) {
		this.cgList = cgList;
	}
	public List<JuviePercent> getJp() {
		return jp;
	}
	public void setJp(List<JuviePercent> jp) {
		this.jp = jp;
	}
	public List<DecreaseCrime> getDc() {
		return dc;
	}
	public void setDc(List<DecreaseCrime> dc) {
		this.dc = dc;
	}
	public List<PresentSublists> getPs() {
		return ps;
	}
	public void setPs(List<PresentSublists> ps) {
		this.ps = ps;
	}
	public List<String> getTpp10() {
		return tpp10;
	}
	public void setTpp10(List<String> tpp10) {
		this.tpp10 = tpp10;
	}
}
