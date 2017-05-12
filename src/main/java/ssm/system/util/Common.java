package ssm.system.util;

public class Common {
	
    /** Session相关 */
    public final static String SESSION_USER = "currentUser";
    public final static String SESSION_MENUS = "menus";
    public final static String SESSION_ALLMENUS = "allMenus";
    
    /** 刊物类别 */
	public final static int BZ = 1;//报纸
	public final static int QK = 2;//期刊
	public final static int TS = 3;//图书
//	public final static int QKXX = 4;//桥刊
//    public final static int NBZL = 5;//内部资料
//    public final static int QYB = 6;//企业报
	
	/** 状态*/
	public final static int ON = 0;    //启用
	public final static int OFF = 1;   //停用
	
	/** 是否 */
	public final static int TRUE = 1;  //是
	public final static int FALSE = 0; //否
	
	/** 评估项类型 */
	public final static int radio = 1;     //单选项
	public final static int check = 2;     //多选项
	public final static int range = 3;     //范围项
	
}
