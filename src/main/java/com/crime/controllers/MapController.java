package com.crime.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crime.dbConnection.ExecuteQueries;
import com.crime.entity.CrimeAgainstWandCPerYear;
import com.crime.entity.PoliceInjDeathsPerYear;
import com.crime.entity.PoliceStrengthPerYear;
import com.crime.entity.SolveRatePerYear;
import com.crime.entity.SummaryResult;
import com.crime.entity.TotalCrimePerYear;

@RestController
public class MapController {
	
	ExecuteQueries eq = new ExecuteQueries();
	
	@RequestMapping("/map/{state}")
	public SummaryResult summary(@PathVariable("state") String state) {
			SummaryResult st = new SummaryResult();
			List<TotalCrimePerYear> listTcpy = new ArrayList<TotalCrimePerYear>();
			List<PoliceStrengthPerYear> listPspy = new ArrayList<PoliceStrengthPerYear>();
			List<PoliceInjDeathsPerYear> listPdpy = new ArrayList<PoliceInjDeathsPerYear>();
			List<SolveRatePerYear> listSolve = new ArrayList<SolveRatePerYear>();
			List<CrimeAgainstWandCPerYear> listCawpy = new ArrayList<CrimeAgainstWandCPerYear>();
			List<CrimeAgainstWandCPerYear> listCacpy = new ArrayList<CrimeAgainstWandCPerYear>();
			
//			listTcpy = getTotalCrimePerYear(state);
//			listPspy = getTotalPoliceStrengthPerYear(state);
//			listPdpy = getTotalPoliceDeathsPerYear(state);
//			listSolve = getTotalSolveRate(state);
			listCawpy = eq.getTotalCrimeAgainstWandC(state, "Women");
			listCacpy = eq.getTotalCrimeAgainstWandC(state, "Children");
			
			st.setCacpy(listCacpy);
			st.setCawpy(listCawpy);
			st.setCrimePerYear(listTcpy);
			st.setName(state);
			st.setPidpy(listPdpy);
			st.setPspy(listPspy);
			st.setSolveRate(listSolve);
			
			//PreparedStatement ps = DBconnection.getCon().prepareStatement(ProjConstants.MAP_QUERY);
//			ps.setString(1, state);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//			st.setName(rs.getString("name"));
//			st.setArea(rs.getString("area"));
		
		return st;
	}
	
	//testing purposes only
	
}
 