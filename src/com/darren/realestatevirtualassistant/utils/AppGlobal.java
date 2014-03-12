package com.darren.realestatevirtualassistant.utils;

public class AppGlobal
{
	public static final boolean	isDebugMode											= false;
	public static final boolean	shouldMaintainLogOfFeeds							= true;

	// Response Statuses
	public static final int		RESPONSE_STATUS_FAIL								= 1;
	public static final String	RESPONSE_STATUS_FAIL_MESSAGE						= "Some error occured while processing request.";

	public static final int		RESPONSE_STATUS_SUCCESS								= 2;
	public static final String	RESPONSE_STATUS_SUCCESS_MESSAGE						= "Request succefully completed!";

	public static final int		RESPONSE_STATUS_FAIL_NO_INTERNET_CONNECTION			= 3;
	public static final String	RESPONSE_STATUS_FAIL_NO_INTERNET_CONNECTION_MESSAGE	= "No network connection found!";

	public static final int		RESPONSE_STATUS_FAIL_RANDOM_EXCEPTION				= 4;
	public static final String	RESPONSE_STATUS_FAIL_RANDOM_EXCEPTION_MESSAGE		= "Some random error occured, please try again later!";

	public static final long	SERVICE_DELAY										= 2 * 60 * 1000;

	public static final String	APP_PREF_IS_DATA_DIRTY								= "_isDataDirty_";
	public static final String	APP_PREF_LAST_INSERTED_ID							= "_lastInsertedId_";
	public static final String	APP_PREF_NAME										= "REAL_ESTATE_VIRTUAL_ASSISTANT_APP_PREFS";

	public static final String	APP_PREF_KEY_COSMETIC_ACQUISITION_COST_PERCENTAGE	= "_acquisition_cost_percentage_costmetic";
	public static final String	APP_PREF_KEY_ADVANCED_ACQUISITION_COST_PERCENTAGE	= "_acquisition_cost_percentage_advanced";
	public static final String	APP_PREF_KEY_COSMETIC_RENOVATION_PERCENTAGE			= "_renovation_percentage_costmetic";
	public static final String	APP_PREF_KEY_ADVANCED_RENOVATION_PERCENTAGE			= "_renovation_percentage_advanced";
	public static final String	APP_PREF_KEY_COSMETIC_HOLDING_COST_PERCENTAGE		= "_holding_cost_percentage_costmetic";
	public static final String	APP_PREF_KEY_ADVANCED_HOLDING_COST_PERCENTAGE		= "_holding_cost_percentage_advanced";
	public static final String	APP_PREF_KEY_COSMETIC_SELLING_COST_PERCENTAGE		= "_selling_cost_percentage_costmetic";
	public static final String	APP_PREF_KEY_ADVANCED_SELLING_COST_PERCENTAGE		= "_selling_cost_percentage_advanced";
	public static final String	APP_PREF_KEY_COSMETIC_PROFIT_MARGIN_PERCENTAGE		= "_profit_margin_percentage_costmetic";
	public static final String	APP_PREF_KEY_ADVANCED_PROFIT_MARGIN_PERCENTAGE		= "_profit_margin_percentage_advanced";

}
