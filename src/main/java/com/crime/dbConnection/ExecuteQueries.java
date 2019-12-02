package com.crime.dbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crime.constants.QueryConstants;
import com.crime.entity.Crime;
import com.crime.entity.DecreaseCrime;
import com.crime.entity.HighestCrimeGroup;
import com.crime.entity.JuviePercent;
import com.crime.entity.Police;
import com.crime.entity.PresentSublists;

public class ExecuteQueries {

	PreparedStatement ps = null;
	
	public List<Crime> getTotalCrime(String state, String against, String query) {
		List<Crime> listWC = new ArrayList<Crime>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			ps.setString(1, state);
			ps.setString(2, against);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Crime cawc = new Crime();
				//cawc.setName(state);
				cawc.setYear(rs.getInt(2));
				cawc.setNoCrime(rs.getInt(3));
				//cawc.setAgainst(against);
				listWC.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listWC;
	}
	
	public List<Crime> getTotalCrime(String against, String query) {
		List<Crime> listWC = new ArrayList<Crime>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			ps.setString(1, against);
			//ps.setString(2, against);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Crime cawc = new Crime();
				//cawc.setName("India");
				cawc.setYear(rs.getInt(1));
				cawc.setNoCrime(rs.getInt(2));
				//cawc.setAgainst(against);
				listWC.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listWC;
	}
	
	
	public List<Crime> getTotalPoliceStrengthPerYear(String state, String query) {
		List<Crime> listPspy = new ArrayList<Crime>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Crime cawc = new Crime();
				//cawc.setName(state);
				cawc.setYear(rs.getInt(2));
				cawc.setNoCrime(rs.getInt(3));
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}
	
	public List<Crime> exxecQuery(String query) {
		List<Crime> listPspy = new ArrayList<Crime>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			//ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Crime cawc = new Crime();
				//cawc.setName("India");
				cawc.setYear(rs.getInt(1));
				cawc.setNoCrime(rs.getInt(2));
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}

	public List<HighestCrimeGroup> execComplexQuery1(String query) {
		List<HighestCrimeGroup> listPspy = new ArrayList<HighestCrimeGroup>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			//ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				HighestCrimeGroup cawc = new HighestCrimeGroup();
				//cawc.setName("India");
				cawc.setYear(rs.getInt(1));
				cawc.setGroup(rs.getString(2));
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}

	public List<JuviePercent> execComplexQuery2(String query) {
		List<JuviePercent> listPspy = new ArrayList<JuviePercent>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			//ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				JuviePercent cawc = new JuviePercent();
				cawc.setPercent(rs.getDouble(1));
				cawc.setName(rs.getString(2));
				cawc.setYear(rs.getInt(3));
				
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}

	public List<DecreaseCrime> execComplexQuery3(String query) {
		List<DecreaseCrime> listPspy = new ArrayList<DecreaseCrime>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			//ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DecreaseCrime cawc = new DecreaseCrime();
				cawc.setName(rs.getString(1));
				cawc.setFfy(rs.getInt(2));
				cawc.setLfy(rs.getInt(3));
				cawc.setPercentDecrease(rs.getDouble(4));
				
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}

	public List<PresentSublists> execComplexQuery4(String query) {
		List<PresentSublists> listPspy = new ArrayList<PresentSublists>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			//ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PresentSublists cawc = new PresentSublists();
				cawc.setName(rs.getString(1));
				cawc.setCrimes(rs.getInt(2));
				cawc.setCasualties(rs.getInt(3));
				cawc.setRetirement(rs.getInt(4));
				
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}

	public List<String> execComplexQuery5(String query) {
		List<String> listPspy = new ArrayList<String>();
		try {
			ps = DBconnection.getCon().prepareStatement(query);
			//ps.setString(1, state);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String cawc = rs.getString(1);
				
				listPspy.add(cawc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPspy;
	}
	
	//public List<Crime> get
	
	

//	public static void main(String[] args) {
//		DBconnection dbc  = new DBconnection();
//		ExecuteQueries eq = new ExecuteQueries();
//		eq.getTotalCrimeAgainstWomen("KARNATAKA", "Women");
//	}
	
}
