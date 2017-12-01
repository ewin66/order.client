package iih.ci.ord.dto.newordertemplatedto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FMap;

public class OrderTemplateRstDTO extends BaseDTO{
	/**
	 * 频次
	 * @return FMap
	 */
	public FMap getFreqdefdo() {
		return ((FMap) getAttrVal("Freqdefdo"));
	}
	/**
	 * 频次
	 * @param Freqdefdo
	 */
	public void setFreqdefdo(FMap Freqdefdo) {
		setAttrVal("Freqdefdo", Freqdefdo);
	}
	/**
	 * 模板项目
	 * @return FMap
	 */
	public FMap getTemplItm() {
		return ((FMap) getAttrVal("TemplItm"));
	}
	/**
	 * 模板项目
	 * @param Freqdefdo
	 */
	public void setTemplItm(FMap TemplItm) {
		setAttrVal("TemplItm", TemplItm);
	}
}
