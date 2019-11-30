package com.crime.entity;

import java.util.List;

public class SummaryResult {

	private String name;
	private List<Crime> crimePerYear;
	private List<Crime> pspy;
	private List<Crime> pidpy;
	private List<Crime> solveRate;
	private List<Crime> cawpy;
	private List<Crime> cacpy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Crime> getCrimePerYear() {
		return crimePerYear;
	}
	public void setCrimePerYear(List<Crime> crimePerYear) {
		this.crimePerYear = crimePerYear;
	}
	public List<Crime> getPspy() {
		return pspy;
	}
	public void setPspy(List<Crime> pspy) {
		this.pspy = pspy;
	}
	public List<Crime> getPidpy() {
		return pidpy;
	}
	public void setPidpy(List<Crime> pidpy) {
		this.pidpy = pidpy;
	}
	public List<Crime> getSolveRate() {
		return solveRate;
	}
	public void setSolveRate(List<Crime> solveRate) {
		this.solveRate = solveRate;
	}
	public List<Crime> getCawpy() {
		return cawpy;
	}
	public void setCawpy(List<Crime> cawpy) {
		this.cawpy = cawpy;
	}
	public List<Crime> getCacpy() {
		return cacpy;
	}
	public void setCacpy(List<Crime> cacpy) {
		this.cacpy = cacpy;
	}
	
}
