/**
 * 
 */
package com.billionman.util;

/**
 * @author CTM
 *
 */
public class ConstantsSQL {

	public static final String FETCH_STEEL = "FROM Steel s WHERE s.project = :proj_id";

	public static final String FETCH_CEMENT = "FROM Cement s WHERE s.projectCement = :proj_id";

	public static final String FETCH_BRICKS = "FROM Bricks s WHERE s.project = :proj_id";

	public static final String FETCH_BOULDERS = "FROM Boulders s WHERE s.project = :proj_id";

	public static final String FETCH_CENTERING = "FROM Centering s WHERE s.project = :proj_id";

	public static final String FETCH_DOORS = "FROM GroupDoors s WHERE s.project = :proj_id";

	public static final String FETCH_GRILL = "FROM Grill s WHERE s.project = :proj_id";

	public static final String FETCH_LABOURS = "FROM Labours s WHERE s.project = :proj_id";

	public static final String FETCH_JELLY = "FROM Jelly s WHERE s.project = :proj_id";

	public static final String FETCH_LIME = "FROM LimeRendering s WHERE s.project = :proj_id";
}
