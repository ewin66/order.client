package iih.ci.ord.pub.util.tools;

import java.util.List;

/**
 * 消息转换工具类
 * 
 * @author HUMS
 *
 */
public class MessageConvertUtil {

	/**
	 * 将消息List集合转为字符串
	 * 
	 * @param messageList
	 *            消息集合
	 * @return
	 */
	public static String convertListToString(List<String> msgList) {

		StringBuffer msgBuffer = new StringBuffer();
		if (msgList != null && msgList.size() > 0) {

			for (String msg : msgList) {
				msgBuffer.append(msg).append(System.getProperty("line.separator", "\n"));
			}
		}

		return msgBuffer.toString();

	}
}
