package com.crime.entity;

import java.util.List;

public class SummaryResult {

	private String name;
	private List<TotalCrimePerYear> crimePerYear;
	private List<PoliceStrengthPerYear> pspy;
	private List<PoliceInjDeathsPerYear> pidpy;
	private List<SolveRatePerYear> solveRate;
	private List<CrimeAgainstWandCPerYear> cawpy;
	private List<CrimeAgainstWandCPerYear> cacpy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TotalCrimePerYear> getCrimePerYear() {
		return crimePerYear;
	}
	public void setCrimePerYear(List<TotalCrimePerYear> crimePerYear) {
		this.crimePerYear = crimePerYear;
	}
	public List<PoliceStrengthPerYear> getPspy() {
		return pspy;
	}
	public void setPspy(List<PoliceStrengthPerYear> pspy) {
		this.pspy = pspy;
	}
	public List<PoliceInjDeathsPerYear> getPidpy() {
		return pidpy;
	}
	public void setPidpy(List<PoliceInjDeathsPerYear> pidpy) {
		this.pidpy = pidpy;
	}
	public List<SolveRatePerYear> getSolveRate() {
		return solveRate;
	}
	public void setSolveRate(List<SolveRatePerYear> solveRate) {
		this.solveRate = solveRate;
	}
	public List<CrimeAgainstWandCPerYear> getCawpy() {
		return cawpy;
	}
	public void setCawpy(List<CrimeAgainstWandCPerYear> cawpy) {
		this.cawpy = cawpy;
	}
	public List<CrimeAgainstWandCPerYear> getCacpy() {
		return cacpy;
	}
	public void setCacpy(List<CrimeAgainstWandCPerYear> cacpy) {
		this.cacpy = cacpy;
	}
	
}
