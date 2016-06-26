package com.cat.demo.constant;

/**
 * Created by Archimedes on 2016/6/26.
 */
public class SqlPackage {

	/**
	 * entity->sql.xml->namespace
	 */
	public final static String DAO_SUFFIX = "Dao";
	public final static String SQL_SEPARATOR = ".";

	/**
	 * sql.xml id name standard
	 */
	// save
	public final static String SQL_SAVE = "save";
	public final static String SQL_SAVES = "saves";
	// delete
	public final static String SQL_DELETEBYID = "deleteById";
	public final static String SQL_DELETEBYENTITY = "deleteByEntity";
	public final static String SQL_DELETEBYIDS = "deleteByIds";
	public final static String SQL_DELETEBYENTITIES = "deleteByEntities";
	// update
	public final static String SQL_UPDATE = "update";
	public final static String SQL_UPDATES = "updates";
	// find
	public final static String SQL_FINDBYID = "findById";
	public final static String SQL_FINDALL = "findAll";
	public final static String SQL_FINDLIST = "findList";
	public final static String SQL_COUNT = "count";
}
