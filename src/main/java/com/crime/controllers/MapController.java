package com.crime.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime.constants.QueryConstants;
import com.crime.dbConnection.ExecuteQueries;
import com.crime.entity.Crime;
import com.crime.entity.SummaryResult;

@RestController
public class MapController {

	ExecuteQueries eq = new ExecuteQueries();

	@RequestMapping("/map/{state}")
	public SummaryResult summary(@PathVariable("state") String state) {
		SummaryResult st = new SummaryResult();
		List<Crime> listTcpy = new ArrayList<Crime>();
		List<Crime> listPspy = new ArrayList<Crime>();
		List<Crime> listPdpy = new ArrayList<Crime>();
		List<Crime> listSolve = new ArrayList<Crime>();
		List<Crime> listCawpy = new ArrayList<Crime>();
		List<Crime> listCacpy = new ArrayList<Crime>();

		if (state.equalsIgnoreCase("India")) {
			listTcpy = eq.getTotalCrimeAgainstWandC("%", QueryConstants.INDIA_TOTAL_CRIME_PER_YEAR_QUERY);
			listPspy = eq.getTotalPoliceStrengthPerYear(QueryConstants.INDIA_TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY);
			listPdpy = eq.getTotalPoliceStrengthPerYear(QueryConstants.INDIA_TOTAL_POLICE_DEATHS_PER_YEAR_QUERY);
//				listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrimeAgainstWandC("Women", QueryConstants.INDIA_TOTAL_CRIME_PER_YEAR_QUERY);
			listCacpy = eq.getTotalCrimeAgainstWandC("Children", QueryConstants.INDIA_TOTAL_CRIME_PER_YEAR_QUERY);
		} else {
			listTcpy = eq.getTotalCrimeAgainstWandC(state, "%", QueryConstants.TOTAL_CRIME_PER_YEAR_QUERY);
			listPspy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY);
			listPdpy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_DEATHS_PER_YEAR_QUERY);
//			listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrimeAgainstWandC(state, "Women", QueryConstants.TOTAL_CRIME_PER_YEAR_QUERY);
			listCacpy = eq.getTotalCrimeAgainstWandC(state, "Children", QueryConstants.TOTAL_CRIME_PER_YEAR_QUERY);
		}

		st.setCacpy(listCacpy);
		st.setCawpy(listCawpy);
		st.setCrimePerYear(listTcpy);
		st.setName(state);
		st.setPidpy(listPdpy);
		st.setPspy(listPspy);
		st.setSolveRate(listSolve);

		return st;
	}
	
	@RequestMapping("/map/{state}/{crime}")
	public List<Crime> summary(@PathVariable("state") String state, @PathVariable("crime") String crime) {
		List<Crime> listTcpy = new ArrayList<Crime>();

		if (state.equalsIgnoreCase("India")) {
			listTcpy = eq.getTotalCrimeAgainstWandC(crime, QueryConstants.INDIA_CRIME_GROUP_QUERY);
		} else {
			listTcpy = eq.getTotalCrimeAgainstWandC(state, crime, QueryConstants.CRIME_GROUP_QUERY);
		}

		return listTcpy;
	}

	// testing purposes only

}
