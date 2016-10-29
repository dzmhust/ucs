package com.dzmsoft.ucs.base.common;

public abstract class UcsBaseConstant {
    
    public interface UserType{
        /**
         * 超级用户
         */
        public static final String SUPERUSER = "00";
        /**
         * 内部管理用户
         */
        public static final String INNERUSER = "01";
    }
	
	public interface Session{
		public static final String USER = "user";
	}
	
	/**
	 * 用户角色
	 * @author dzm
	 * @date 2015年11月12日 
	 *
	 */
	public interface Role{
	    public static final String ADMIN = "admin";
	    public static final String USER = "user";
	    public static final String GUEST = "guest";
	}

	/**
	 * 菜单类型
	 * @author dzm
	 *
	 */
	public interface PermissionType{
		/**
		 * 主菜单
		 */
		public static final String MAIN = "00";
		
		/**
		 * 子菜单
		 */
		public static final String SUB= "01";
		
		/**
		 * 动作
		 */
		public static final String BUTTON= "02";
	}
}
