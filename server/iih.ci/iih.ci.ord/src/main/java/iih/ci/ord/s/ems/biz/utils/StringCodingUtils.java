package iih.ci.ord.s.ems.biz.utils;

import java.io.UnsupportedEncodingException;

import xap.mw.core.data.BizException;

public class StringCodingUtils {
	/**
	 * 字符串Utf-8 + Base64 编码
	 * @param emsDocument
	 * @return
	 * @throws BizException
	 */
	public static String Utf8_Base64_Encode(String emsDocument) throws BizException{
		try {
			return (new String(xap.mw.core.base64.Base64.encode(emsDocument.getBytes("UTF-8")),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		}
	}
	
	/**
	 * 字符串Utf-8 + Base64 解码
	 * @param emsDocument
	 * @return
	 * @throws BizException
	 */
	public static String Utf8_Base64_Decode(String emsDocument) throws BizException{
		try {
			return (new String(xap.mw.core.base64.Base64.decode(emsDocument.getBytes("UTF-8")),"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new BizException(e.getMessage());
		}
	}
	
}
