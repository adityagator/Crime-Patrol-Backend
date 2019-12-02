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
	
	public static final String CRIME_GROUP_QUERY = "SELECT s.name, c.year, SUM(no_of_crime) FROM crime c, state s, crime_group cg WHERE c.s_id = s.s_id AND s.name = ? AND cg.cg_id = c.cg_id AND cg.group_name = ? GROUP BY s.name, c.year";
	public static final String INDIA_CRIME_GROUP_QUERY = "SELECT c.year, SUM(no_of_crime) FROM crime c, crime_group cg WHERE cg.cg_id = c.cg_id AND cg.group_name = ? GROUP BY c.year";
	
	public static final String COMPLEX_HIGHEST_CRIME_GROUP_QUERY = "WITH MY_TABLE AS (SELECT YEAR,CG_ID,SUM(ARRESTED)as tots FROM PERSON_ARRESTED GROUP BY YEAR,CG_ID order by year) select year,group_name from crime_group join ( SELECT YEAR,CG_ID,SUM(ARRESTED) AS TOTS FROM PERSON_ARRESTED GROUP BY YEAR,CG_ID MINUS SELECT T1.YEAR,T1.CG_ID,T1.TOTS FROM MY_TABLE T1,MY_TABLE T2 WHERE T1.YEAR=T2.YEAR AND T1.TOTS<T2.TOTS ) X on X.cg_id= crime_group.cg_id Order by year";
	public static final String COMPLEX_JUVIE = "SELECT ROUND(((snc/c.ncc)*100), 2) AS \"Number of Crime by Juvenile\", s.name AS \"State Name\", year1 FROM (SELECT SUM(j.no_of_crime) snc, j.S_ID AS sid1,j.YEAR AS year1 FROM juvenile j GROUP BY j.S_ID, j.YEAR HAVING SUM(no_of_crime) > (SELECT SUM(no_of_crime)/10 FROM crime WHERE s_id = j.s_id AND year = j.year GROUP BY j.S_ID, j.YEAR) ORDER BY S_ID, YEAR ASC) nc,state s, (SELECT s.s_id AS s, c.year AS y, SUM(no_of_crime) AS ncc FROM crime c, state s WHERE c.s_id = s.s_id HAVING SUM(no_of_crime) != 0 GROUP BY s.s_id, c.year) c WHERE nc.sid1 = s.s_id AND c.s = nc.sid1 AND c.y = nc.year1";
	public static final String COMPLEX_DECREASE_CRIME = "SELECT name,F5Y AS \"First 5 Years\", S5Y \"Last 5 Years\", (PI* -1) AS \"Percentage Decrease\" FROM (SELECT name, F5Y, S5Y, PI FROM (SELECT s.name, a.sc AS \"F5Y\", b.sc AS \"S5Y\", ROUND(((b.sc-a.sc)/b.sc)*100,2) as \"PI\" FROM (SELECT SUM(no_of_crime) sc, S_ID FROM crime WHERE year BETWEEN 2001 AND 2005 GROUP BY S_ID) a, (SELECT sum(no_of_crime) sc, S_ID FROM crime WHERE year BETWEEN 2006 AND 2010 GROUP BY S_ID) b, state s WHERE a.S_ID = b.S_ID AND a.S_ID = s.S_ID) WHERE PI < 0 ORDER BY pi ASC) WHERE rownum < 11";
	public static final String COMPLEX_PRESENT_SUBLISTS = "SELECT s.name, a.sc AS \"Sum Of Crimes\", b.sk AS \"Total Police Casualties\", c.pc AS \"Total Police Nearing Retirement\" FROM (SELECT sc, S_ID FROM (SELECT SUM(no_of_crime) sc, S_ID FROM crime GROUP BY S_ID ORDER BY sc DESC) WHERE ROWNUM < 11) a, (SELECT sk,S_ID FROM (SELECT SUM(Num_killed) sk, S_ID FROM police_casualties GROUP BY S_ID ORDER BY sk DESC) WHERE ROWNUM < 11) b, (SELECT pc,S_ID FROM (SELECT SUM(pap.no_of_police) pc, pap.S_ID FROM p_age_profile pap, age_group ag WHERE pap.ag_id = ag.ag_id AND range_from = 55 AND category = 'Police' GROUP BY S_ID ORDER BY pc DESC) WHERE rownum < 11) c, state s WHERE a.s_id = b.s_id AND b.s_id = c.s_id AND c.s_id = s.s_id";
	public static final String COMPLEX_TOP10 = "SELECT NAME FROM STATE, ( Select s_id, sum(no_of_crime) from crime where year = (Select year y1 from crime group by year having sum(No_of_crime) IN (Select max(sum1) from (Select year y1,sum(No_of_crime) sum1 from crime group by year))) group by s_id Order by sum(No_of_crime) desc Fetch first 10 rows only ) T where state.s_id=T.s_id";
}
