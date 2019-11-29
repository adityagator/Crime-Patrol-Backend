package com.crime.entity;

import java.util.List;

public class SummaryResult {

	private String name;
	private List<Crime> crimePerYear;
	private List<Police> pspy;
	private List<Police> pidpy;
	private List<SolveRatePerYear> solveRate;
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
	public List<Police> getPspy() {
		return pspy;
	}
	public void setPspy(List<Police> pspy) {
		this.pspy = pspy;
	}
	public List<Police> getPidpy() {
		return pidpy;
	}
	public void setPidpy(List<Police> pidpy) {
		this.pidpy = pidpy;
	}
	public List<SolveRatePerYear> getSolveRate() {
		return solveRate;
	}
	public void setSolveRate(List<SolveRatePerYear> solveRate) {
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
