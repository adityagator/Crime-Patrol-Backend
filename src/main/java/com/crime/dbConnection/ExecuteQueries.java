package com.crime.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crime.constants.QueryConstants;
import com.crime.entity.Crime;
import com.crime.entity.Police;

public class ExecuteQueries {

	PreparedStatement ps = null;
	
	public List<Crime> getTotalCrimeAgainstWandC(String state, String against) {
		List<Crime> listWC = new ArrayList<Crime>();
		try {
			ps = DBconnection.getCon().prepareStatement(QueryConstants.TOTAL_CRIME_AGAINST_W_AND_C_PER_YEAR_QUERY);
			ps.setString(1, state);
			ps.setString(2, against);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Crime cawc = new Crime();
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
	
	public List<Police> getTotalPoliceStrengthPerYear(String state, String query) {
		List<Police> listPspy = new ArrayList<Police>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Police cawc = new Police();
				cawc.setName(state);
				cawc.setYear(rs.getInt(2));
				cawc.setTotal(rs.getInt(3));
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}

//	public static void main(String[] args) {
//		DBconnection dbc  = new DBconnection();
//		ExecuteQueries eq = new ExecuteQueries();
//		eq.getTotalCrimeAgainstWomen("KARNATAKA", "Women");
//	}
	
}
