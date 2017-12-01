package iih.ci.ord.s.ems.define;

/**
 * 医嘱图片状态索引
 * @author Administrator
 *
 */
public interface OrdPicStatusIndex {
	/**
	 * 开立
	 */
	public static final Integer OPEN = 0;
	/**
	 * 签署
	 */
	public static final Integer SIGN = 10;
	/**
	 * 确认
	 */
	public static final Integer CONFIRM = 20;
	/**
	 * 执行中
	 */
	public static final Integer EXEC = 21;
	/**
	 * 确认+预停
	 */
	public static final Integer CONFRIM_PRESTOP = 22;
	/**
	 * 执行中+预停
	 */
	public static final Integer EXEC_PRESTOP = 23;
	/**
	 * 确认+停止
	 */
	public static final Integer CONFIRM_STOP = 50;
	/**
	 * 执行中+停止
	 */
	public static final Integer EXEC_STOP = 51;
	/**
	 * 完成
	 */
	public static final Integer OVER = 60;
	/**
	 * 取消
	 */
	public static final Integer CANCEL = 61;
	/**
	 * 不执行
	 */
	public static final Integer NOTEXEC = 62;
	/**
	 * 作废
	 */
	public static final Integer OBSOLETE = 70;
	/**
	 * 已作废
	 */
	public static final Integer CANCELLED = 80;
	/**
	 * 未知状态
	 */
	public static final Integer UNKNOW = 11;
}
