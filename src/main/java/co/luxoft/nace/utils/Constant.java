package co.luxoft.nace.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
	public static final String NACE_INFO_SAVE_URL = "/nace-details/save";
	public static final String NACE_GET_ORDER = "/nace-details/orders/{order}";
	
	//CSV Headers
	public static final String ORDER = "Order";
	public static final String LEVEL = "Level";
	public static final String CODE = "Code";
	public static final String PARENT = "Parent";
	public static final String DESCRIPTION = "Description";
	public static final String ITEM_INCLUDES = "This item includes";
	public static final String ITEM_ALSO_INCLUDES = "This item also includes";
	public static final String RULINGS = "Rulings";
	public static final String ITEM_EXCLUDES = "This item excludes";
	public static final String REFERENCE_TO_ISIC = "Reference to ISIC Rev. 4";
	
	public enum ResponseStatus {
		SUCCESS,
		FAIL
	}
}
