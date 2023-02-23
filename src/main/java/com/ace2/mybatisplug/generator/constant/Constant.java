package com.ace2.mybatisplug.generator.constant;

public class Constant {


	//users_description
	public static final String administrator = "administrator";
//	public static final String Editor = "Editor"; // part of read update insert
	public static final String disable = "disable";
	public static final String user = "user"; // read update
	public static final String Viewer = "viewer"; // read only

	//roles_rolesCode
	public static final String ROLECODE_ADMIN = "ADMIN";
	public static final String ROLECODE_DISABLE = "DISABLE";
	public static final String ROLECODE_USER = "USER";
	public static final String ROLECODE_VIEWER = "VIEWER";


	//permission_permissionCode
	public static final String ALL = "0";
	public static final String INSERT = "1";
	public static final String UPDATE = "2";
	public static final String DELETE = "3";
	public static final String SELECT = "4";
	public static final String SELECT_UPDATE_INSERT = "8";
	public static final String DENY = "10";

	public static final String ACTIVE = "ACTIVE";
	public static final String INACTIVE = "INACTIVE";



}
