/**
 * 
 */
package com.billionman.util;

/**
 * @author CTM
 *
 */
public class Constants {

	public static final int CONSTRUCTION_TYPE_ROAD = 1;
	public static final int CONSTRUCTION_TYPE_BUILDING = 2;
	public static final String CONSTRUCTION_TYPE_ROAD_STRING = "Road";
	public static final String CONSTRUCTION_TYPE_BUILDING_STRING = "Building";

	public static final String LOGIN_ROLE_ADMIN = "ROLE_ADMIN";
	public static final String LOGIN_ROLE_USER = "ROLE_USER";

	public static final int NATURAL_SAND = 1;
	public static final int MANUFACTURED_SAND = 2;
	public static final String NATURAL_SAND_STRING = "Natural";
	public static final String MANUFACTURED_SAND_STRING = "Manufactured";

	// Vehicle Related
	public static final int VEHICLE_FUEL = 0;
	public static final int VEHICLE_SPARE = 1;
	public static final String VEHICLE_FUEL_STRING = "Fuel";
	public static final String VEHICLE_SPARE_STRING = "Spare";
	public static final int TIPPER = 0;
	public static final int LORRY = 1;
	public static final int TRACTOR = 2;
	public static final int HITACHI = 3;
	public static final int JCB = 4;
	public static final int ROAD_ROLLER = 5;
	public static final int CAR = 6;
	public static final int MIXTURE = 7;
	public static final int BIKE = 8;
	public static final int BUS_TRAVELLING = 9;

	// Fuel
	public static final int FUEL_PETROL = 1;
	public static final int FUEL_OIL = 2;
	public static final int FUEL_GREASE = 3;
	public static final int FUEL_GAS = 4;
	public static final int FUEL_WASTE_OIL = 5;
	public static final int FUEL_DIESEL = 6;

	// Power
	public static final int POWER_ELECTRICITY = 1;
	public static final int POWER_GENERATOR = 2;
	public static final int POWER_DIESEL = 3;

	// User and Roles
	public static final String ADMIN = "ROLE_ADMIN";
	public static final String USER = "ROLE_USER";
	public static final int USER_ACTIVE = 1;

	// Exception codes MySql
	public static final int ERROR_DUPLICATE_DATA = 1062;

	// Result Sets
	public static final String SUCCESS = "saved";
	public static final String FAILURE = "failed";

	// Annonymous User
	public static final String ANNONYMOUS_USER = "annonymousUser";

	// Materials Enum
	public enum Materials {
		STEEL("Steel"), VEHICLE("Vehicle"), CEMENT("Cement"), POWER("Power"), WATER(
				"Water"), JELLY("Jelly"), SAND("Sand"), WOOD("Wood"), CENTERING(
				"Centering"), STONE("Size Stone"), BOULDERS("Boulders"), BRICKS(
				"Bricks"), DOORS("Group Doors"), LIME("Lime Rendering"), PLASTERING(
				"Plastering"), TILES("Tiles"), PAINTING("Painting"), PLUMBING(
				"Plumbing"), SANITARY("Sanitary"), GRILL("Grill"), LABOURS(
				"Labours");

		private final String label;

		private Materials(String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}

		public static Materials getEnumForValue(String val) {
			for (Materials enumData : Materials.values()) {
				if (enumData.name().equals(val)) {
					return enumData;
				}
			}
			return null;
		}
	}

	// material file paths
	public static String PATH_BOULDER = "/view/secure/report/boulders.xhtml";
	public static String PATH_BRICK = "/view/secure/report/bricks.xhtml";
	public static String PATH_CEMENT = "/view/secure/report/cement.xhtml";
	public static String PATH_CENTERING = "/view/secure/report/centering.xhtml";
	public static String PATH_DOORS = "/view/secure/report/doors.xhtml";
	public static String PATH_GRILL = "/view/secure/report/grill.xhtml";
	public static String PATH_JELLY = "/view/secure/report/jelly.xhtml";
	public static String PATH_LABOURS = "/view/secure/report/labours.xhtml";
	public static String PATH_LIME = "/view/secure/report/lime.xhtml";
	public static String PATH_PAINTING = "/view/secure/report/painting.xhtml";
	public static String PATH_PLASTERING = "/view/secure/report/plastering.xhtml";
	public static String PATH_PLUMBING = "/view/secure/report/plumbing.xhtml";
	public static String PATH_POWER = "/view/secure/report/power.xhtml";
	public static String PATH_SAND = "/view/secure/report/sand.xhtml";
	public static String PATH_SANITARY = "/view/secure/report/sanitary.xhtml";
	public static String PATH_STEEL = "/view/secure/report/steel.xhtml";
	public static String PATH_STONE = "/view/secure/report/stone.xhtml";
	public static String PATH_TILES = "/view/secure/report/tiles.xhtml";
	public static String PATH_VEHICLE = "/view/secure/report/vehicle.xhtml";
	public static String PATH_WATER = "/view/secure/report/water.xhtml";
	public static String PATH_WOOD = "/view/secure/report/wood.xhtml";
}
