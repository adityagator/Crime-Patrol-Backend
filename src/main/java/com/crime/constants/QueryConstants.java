package com.crime.constants;

public final class QueryConstants {
	
	public static final String INDIA_TOTAL_CRIME_PER_YEAR_QUERY = "SELECT year, SUM(no_of_crime) FROM crime WHERE against LIKE ? GROUP BY year";
	public static final String INDIA_TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY = "SELECT year, SUM(no_of_police) FROM police_strength c GROUP BY year";
	public static final String INDIA_TOTAL_SOLVE_RATE_PER_YEAR_QUERY = "";
	public static final String INDIA_TOTAL_POLICE_DEATHS_PER_YEAR_QUERY = "SELECT year, SUM(num_injured + num_killed) FROM police_casualties GROUP BY year";
	
	
	public static final String TOTAL_CRIME_PER_YEAR_QUERY = "SELECT s.name, c.year, SUM(no_of_crime) FROM crime c, state s WHERE c.s_id = s.s_id AND s.name = ? AND c.against LIKE ? GROUP BY s.name, c.year";
	public static final String TOTAL_POLICE_STRENGTH_PER_YEAR_QUERY = "SELECT s.name, c.year, SUM(no_of_police) FROM police_strength c, state s WHERE c.s_id = s.s_id AND s.name = ? GROUP BY s.name, c.year";
	public static final String TOTAL_SOLVE_RATE_PER_YEAR_QUERY = "";
	public static final String TOTAL_POLICE_DEATHS_PER_YEAR_QUERY = "SELECT s.name, c.year, SUM(c.num_injured+c.num_killed) FROM police_casualties c, state s WHERE c.s_id = s.s_id AND s.name = ? GROUP BY s.name, c.year";
	
}
