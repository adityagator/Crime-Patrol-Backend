package com.crime.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime.constants.QueryConstants;
import com.crime.dbConnection.ExecuteQueries;
import com.crime.entity.Complex;
import com.crime.entity.Crime;
import com.crime.entity.DecreaseCrime;
import com.crime.entity.HighestCrimeGroup;
import com.crime.entity.JuviePercent;
import com.crime.entity.PresentSublists;
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
			listTcpy = eq.getTotalCrime("%", QueryConstants.INDIA_TOTAL_CRIME_PER_YEAR_QUERY);
			listPspy = eq.exxecQuery(QueryConstants.INDIA_TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY);
			listPdpy = eq.exxecQuery(QueryConstants.INDIA_TOTAL_POLICE_DEATHS_PER_YEAR_QUERY);
//				listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrime("Women", QueryConstants.INDIA_TOTAL_CRIME_PER_YEAR_QUERY);
			listCacpy = eq.getTotalCrime("Children", QueryConstants.INDIA_TOTAL_CRIME_PER_YEAR_QUERY);
		} else {
			listTcpy = eq.getTotalCrime(state, "%", QueryConstants.TOTAL_CRIME_PER_YEAR_QUERY);
			listPspy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY);
			listPdpy = eq.getTotalPoliceStrengthPerYear(state, QueryConstants.TOTAL_POLICE_DEATHS_PER_YEAR_QUERY);
//			listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrime(state, "Women", QueryConstants.TOTAL_CRIME_PER_YEAR_QUERY);
			listCacpy = eq.getTotalCrime(state, "Children", QueryConstants.TOTAL_CRIME_PER_YEAR_QUERY);
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
			listTcpy = eq.getTotalCrime(crime, QueryConstants.INDIA_CRIME_GROUP_QUERY);
		} else {
			listTcpy = eq.getTotalCrime(state, crime, QueryConstants.CRIME_GROUP_QUERY);
		}

		return listTcpy;
	}

	@RequestMapping("/complex")
	public Complex summary() {
		Complex c = new Complex();
		List<HighestCrimeGroup> highCrimeList = new ArrayList<HighestCrimeGroup>();
		List<JuviePercent> jpList = new ArrayList<JuviePercent>();
		List<DecreaseCrime> dcList = new ArrayList<DecreaseCrime>();
		List<PresentSublists> psList = new ArrayList<PresentSublists>();
		List<String> top10List = new ArrayList<String>();
		
		highCrimeList = eq.execComplexQuery1(QueryConstants.COMPLEX_HIGHEST_CRIME_GROUP_QUERY);
		jpList = eq.execComplexQuery2(QueryConstants.COMPLEX_HIGHEST_CRIME_GROUP_QUERY);
		dcList = eq.execComplexQuery3(QueryConstants.COMPLEX_HIGHEST_CRIME_GROUP_QUERY);
		psList = eq.execComplexQuery4(QueryConstants.COMPLEX_HIGHEST_CRIME_GROUP_QUERY);
		top10List = eq.execComplexQuery5(QueryConstants.COMPLEX_HIGHEST_CRIME_GROUP_QUERY);
		
		c.setCgList(highCrimeList);
		c.setDc(dcList);
		c.setJp(jpList);
		c.setPs(psList);
		c.setTpp10(top10List);
		
		//listTcpy = eq.getTotalCrimeAgainstWandC(state, crime, QueryConstants.CRIME_GROUP_QUERY);

		return c;
	}

	// testing purposes only

}
