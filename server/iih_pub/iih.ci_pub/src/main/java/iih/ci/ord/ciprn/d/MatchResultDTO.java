package iih.ci.ord.ciprn.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class MatchResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/**
	 * Tmplurl
	 * @return String
	 */
	public String getTmplurl() {
		return ((String) getAttrVal("Tmplurl"));
	}
	/**
	 * Tmplurl
	 * @param Tmplurl
	 */
	public void setTmplurl(String tmplurl) {
		setAttrVal("Tmplurl", tmplurl);
	}
	
	/**
	 * Ids
	 * @return String
	 */
	public FArrayList getIds() {
		return ((FArrayList) getAttrVal("Ids"));
	}
	/**
	 * Ids
	 * @param Ids
	 */
	public void setIds(FArrayList ids) {
		setAttrVal("Ids", ids);
	}
}
