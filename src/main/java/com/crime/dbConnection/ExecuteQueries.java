package com.crime.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crime.constants.QueryConstants;
import com.crime.entity.CrimeAgainstWandCPerYear;

public class ExecuteQueries {

	PreparedStatement ps = null;
	public List<CrimeAgainstWandCPerYear> getTotalCrimeAgainstWandC(String state, String against) {
		List<CrimeAgainstWandCPerYear> listWC = new ArrayList<CrimeAgainstWandCPerYear>();
		try {
			ps = DBconnection.getCon().prepareStatement(QueryConstants.TOTAL_CRIME_AGAINST_W_AND_C_PER_YEAR_QUERY);
			ps.setString(1, state);
			ps.setString(2, against);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				CrimeAgainstWandCPerYear cawc = new CrimeAgainstWandCPerYear();
				cawc.setName(state);
				cawc.setYear(rs.getInt(2));
				cawc.setNoCrime(rs.getInt(3));
				cawc.setAgainst(against);
				listWC.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listWC;
	}

//	public static void main(String[] args) {
//		DBconnection dbc  = new DBconnection();
//		ExecuteQueries eq = new ExecuteQueries();
//		eq.getTotalCrimeAgainstWomen("KARNATAKA", "Women");
//	}
	
}
