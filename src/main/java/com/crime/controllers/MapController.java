package com.crime.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime.constants.QueryConstants;
import com.crime.dbConnection.ExecuteQueries;
import com.crime.entity.Crime;
import com.crime.entity.Police;
import com.crime.entity.SolveRatePerYear;
import com.crime.entity.SummaryResult;

@RestController
public class MapController {

	ExecuteQueries eq = new ExecuteQueries();

	@RequestMapping("/map/{state}")
	public SummaryResult summary(@PathVariable("state") String state) {
		SummaryResult st = new SummaryResult();
		List<Crime> listTcpy = new ArrayList<Crime>();
		List<Police> listPspy = new ArrayList<Police>();
		List<Police> listPdpy = new ArrayList<Police>();
		List<SolveRatePerYear> listSolve = new ArrayList<SolveRatePerYear>();
		List<Crime> listCawpy = new ArrayList<Crime>();
		List<Crime> listCacpy = new ArrayList<Crime>();

		if (state.equalsIgnoreCase("India")) {
			listTcpy = eq.getTotalCrimeAgainstWandC(state, "%");
			listPspy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY);
			listPdpy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_DEATHS_PER_YEAR_QUERY);
//				listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrimeAgainstWandC(state, "Women");
			listCacpy = eq.getTotalCrimeAgainstWandC(state, "Children");
		} else {
			listTcpy = eq.getTotalCrimeAgainstWandC(state, "%");
			listPspy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY);
			listPdpy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_DEATHS_PER_YEAR_QUERY);
//			listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrimeAgainstWandC(state, "Women");
			listCacpy = eq.getTotalCrimeAgainstWandC(state, "Children");
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

	// testing purposes only

}
