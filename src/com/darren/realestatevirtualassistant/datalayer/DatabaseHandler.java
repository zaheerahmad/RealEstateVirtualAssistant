package com.darren.realestatevirtualassistant.datalayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{

	String	tblName	= "";

	public DatabaseHandler( Context context/* , String tblName */)
	{

		super( context, "temp_db", null, 1 );
		// this.tblName = tblName;
	}

	@Override
	public void onCreate( SQLiteDatabase db )
	{

		/*
		 * String CREATE_FEEDBACK_TABLE = "CREATE TABLE " +
		 * AppGlobal.TABLE_FEEDBACK + "(" + AppGlobal.FEEDBACK_ID +
		 * " INTEGER PRIMARY KEY," + AppGlobal.ORGANIZATION_ID + " INTEGER," +
		 * AppGlobal.FNAME + " TEXT," + AppGlobal.LNAME + " TEXT," +
		 * AppGlobal.TELEPHONE + " TEXT," + AppGlobal.IS_ANONYMOUS + " TEXT," +
		 * AppGlobal.FEEDBACK_TEXT + " TEXT" + "," + AppGlobal.DATE_TIME +
		 * " TEXT" + ")";
		 * db.execSQL( CREATE_FEEDBACK_TABLE );
		 * String CREATE_FEEDBACK_ALCHEMY_TABLE = "CREATE TABLE " +
		 * AppGlobal.TABLE_FEEDBACK_ALCHEMY + "(" +
		 * AppGlobal.ALCHEMY_FEEDBACK_ID + " INTEGER PRIMARY KEY," +
		 * AppGlobal.FEEDBACK_ID_FK + " INTEGER," + AppGlobal.ALCHEMY_KEYWORD +
		 * " TEXT," + AppGlobal.ALCHEMY_CONCEPT + " TEXT," +
		 * AppGlobal.ALCHEMY_ENTITY + " TEXT," + AppGlobal.ALCHEMY_LANGUAGE +
		 * " TEXT," + AppGlobal.ALCHEMY_SENTIMENT + " TEXT" + ")";
		 * db.execSQL( CREATE_FEEDBACK_ALCHEMY_TABLE );
		 */

	}

	@Override
	public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
	{

		/*
		 * // Drop older table if existed
		 * db.execSQL( "DROP TABLE IF EXISTS " + AppGlobal.TABLE_FEEDBACK );
		 * db.execSQL( "DROP TABLE IF EXISTS " +
		 * AppGlobal.TABLE_FEEDBACK_ALCHEMY );
		 * // Create tables again
		 * onCreate( db );
		 */

	}

	/**
	 * Feedback Table Methods started
	 * 
	 * @param feedbackBO
	 */

	/*
	 * public void addFeedback( FeedbackBO feedbackBO )
	 * {
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * ContentValues values = new ContentValues();
	 * values.put( AppGlobal.ORGANIZATION_ID, feedbackBO.getOrganizationId() );
	 * values.put( AppGlobal.FNAME, feedbackBO.getFname() );
	 * values.put( AppGlobal.LNAME, feedbackBO.getLname() );
	 * values.put( AppGlobal.TELEPHONE, feedbackBO.getTelephone() );
	 * values.put( AppGlobal.IS_ANONYMOUS, feedbackBO.getIsAnonymous() );
	 * values.put( AppGlobal.FEEDBACK_TEXT, feedbackBO.getFeedbackText() );
	 * values.put( AppGlobal.DATE_TIME, feedbackBO.getDateTime() );
	 * db.insert( AppGlobal.TABLE_FEEDBACK, null, values );
	 * db.close(); // Closing database connection
	 * }
	 * public FeedbackBO getFeedback( int id )
	 * {
	 * SQLiteDatabase db = this.getReadableDatabase();
	 * Cursor cursor = db.query( AppGlobal.TABLE_FEEDBACK, new String[] {
	 * AppGlobal.FEEDBACK_ID, AppGlobal.ORGANIZATION_ID, AppGlobal.FNAME,
	 * AppGlobal.LNAME, AppGlobal.TELEPHONE, AppGlobal.IS_ANONYMOUS,
	 * AppGlobal.FEEDBACK_TEXT, AppGlobal.DATE_TIME }, AppGlobal.FEEDBACK_ID +
	 * "=?", new String[] { String.valueOf( id ) }, null, null, null, null );
	 * if( cursor != null )
	 * cursor.moveToFirst();
	 * FeedbackBO feedback = new FeedbackBO( Integer.parseInt( cursor.getString(
	 * 0 ) ), Integer.parseInt( cursor.getString( 1 ) ), cursor.getString( 2 ),
	 * cursor.getString( 3 ), cursor.getString( 4 ), cursor.getString( 5 ),
	 * cursor.getString( 6 ), cursor.getString( 7 ) );
	 * return feedback;
	 * }
	 * public List<FeedbackBO> getAllFeedbacksGreaterThanId( int id )
	 * {
	 * List<FeedbackBO> feedbackList = new ArrayList<FeedbackBO>();
	 * String selectQuery = "SELECT  * FROM " + AppGlobal.TABLE_FEEDBACK +
	 * " WHERE " + AppGlobal.FEEDBACK_ID + " > " + id + " ORDER BY " +
	 * AppGlobal.FEEDBACK_ID + " ASC";
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * Cursor cursor = db.rawQuery( selectQuery, null );
	 * // looping through all rows and adding to list
	 * if( cursor.moveToFirst() )
	 * {
	 * do
	 * {
	 * FeedbackBO feedback = new FeedbackBO( Integer.parseInt( cursor.getString(
	 * 0 ) ), Integer.parseInt( cursor.getString( 1 ) ), cursor.getString( 2 ),
	 * cursor.getString( 3 ), cursor.getString( 4 ), cursor.getString( 5 ),
	 * cursor.getString( 6 ), cursor.getString( 7 ) );
	 * feedbackList.add( feedback );
	 * }
	 * while ( cursor.moveToNext() );
	 * }
	 * return feedbackList;
	 * }
	 * public List<FeedbackBO> getAllFeedbacks()
	 * {
	 * List<FeedbackBO> feedbackList = new ArrayList<FeedbackBO>();
	 * // Select All Query
	 * String selectQuery = "SELECT  * FROM " + AppGlobal.TABLE_FEEDBACK;
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * Cursor cursor = db.rawQuery( selectQuery, null );
	 * // looping through all rows and adding to list
	 * if( cursor.moveToFirst() )
	 * {
	 * do
	 * {
	 * FeedbackBO feedback = new FeedbackBO( Integer.parseInt( cursor.getString(
	 * 0 ) ), Integer.parseInt( cursor.getString( 1 ) ), cursor.getString( 2 ),
	 * cursor.getString( 3 ), cursor.getString( 4 ), cursor.getString( 5 ),
	 * cursor.getString( 6 ), cursor.getString( 7 ) );
	 * feedbackList.add( feedback );
	 * }
	 * while ( cursor.moveToNext() );
	 * }
	 * return feedbackList;
	 * }
	 * public int getFeedbackCount()
	 * {
	 * String countQuery = "SELECT  * FROM " + AppGlobal.TABLE_FEEDBACK;
	 * SQLiteDatabase db = this.getReadableDatabase();
	 * Cursor cursor = db.rawQuery( countQuery, null );
	 * int count = -1;
	 * if( cursor != null && !cursor.isClosed() )
	 * {
	 * count = cursor.getCount();
	 * cursor.close();
	 * }
	 * return count;
	 * }
	 * public FeedbackBO getLastFeedbackInserted()
	 * {
	 * String countQuery = "SELECT * FROM " + AppGlobal.TABLE_FEEDBACK +
	 * " ORDER BY " + AppGlobal.FEEDBACK_ID + " DESC LIMIT 1";
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * Cursor cursor = db.rawQuery( countQuery, null );
	 * if( cursor != null )
	 * cursor.moveToFirst();
	 * return new FeedbackBO( Integer.parseInt( cursor.getString( 0 ) ),
	 * Integer.parseInt( cursor.getString( 1 ) ), cursor.getString( 2 ),
	 * cursor.getString( 3 ), cursor.getString( 4 ), cursor.getString( 5 ),
	 * cursor.getString( 6 ), cursor.getString( 7 ) );
	 * }
	 * public int updateFeedback( FeedbackBO feedback )
	 * {
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * ContentValues values = new ContentValues();
	 * values.put( AppGlobal.ORGANIZATION_ID, feedback.getOrganizationId() );
	 * values.put( AppGlobal.FNAME, feedback.getFname() );
	 * values.put( AppGlobal.LNAME, feedback.getLname() );
	 * values.put( AppGlobal.TELEPHONE, feedback.getTelephone() );
	 * values.put( AppGlobal.IS_ANONYMOUS, feedback.getIsAnonymous() );
	 * values.put( AppGlobal.FEEDBACK_TEXT, feedback.getFeedbackText() );
	 * values.put( AppGlobal.DATE_TIME, feedback.getDateTime() );
	 * // updating row
	 * return db.update( AppGlobal.TABLE_FEEDBACK, values, AppGlobal.FEEDBACK_ID
	 * + " = ?", new String[] { String.valueOf( feedback.getFeedbackId() ) } );
	 * }
	 * public void deleteFeedback( FeedbackBO feedback )
	 * {
	 * SQLiteDatabase db = this.getWritableDatabase();
	 * db.delete( AppGlobal.TABLE_FEEDBACK, AppGlobal.FEEDBACK_ID + " = ?", new
	 * String[] { String.valueOf( feedback.getFeedbackId() ) } );
	 * db.close();
	 * }
	 */

	/**
	 * Feedback Table Methods ended
	 */

}
