package com.crime.constants;

public final class QueryConstants {
	
	public static final String INDIA_TOTAL_CRIME_PER_YEAR_QUERY = "";
	public static final String INDIA_TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY = "";
	public static final String INDIA_TOTAL_SOLVE_RATE_PER_YEAR_QUERY = "";
	public static final String INDIA_TOTAL_POLICE_DEATHS_PER_YEAR_QUERY = "";
	public static final String INDIA_TOTAL_CRIME_AGAINST_WOMEN_PER_YEAR_QUERY = "";
	public static final String INDIA_TOTAL_CRIME_AGAINST_CHILDREN_PER_YEAR_QUERY = "";
	
	public static final String TOTAL_CRIME_PER_YEAR_QUERY = "";
	public static final String TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY = "";
	public static final String TOTAL_SOLVE_RATE_PER_YEAR_QUERY = "";
	public static final String TOTAL_POLICE_DEATHS_PER_YEAR_QUERY = "";
	public static final String TOTAL_CRIME_AGAINST_W_AND_C_PER_YEAR_QUERY = "SELECT s.name, c.year, SUM(no_of_crime) FROM crime c, state s WHERE c.s_id = s.s_id AND s.name = ? AND c.against = ? GROUP BY s.name, c.year";
	public static final String TOTAL_CRIME_AGAINST_CHILDREN_PER_YEAR_QUERY = "";
	
}
