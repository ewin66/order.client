package iih.ci.ord.s.bp;

import iih.ci.ord.dto.ordinput.d.OrdInputDto;
import xap.mw.core.data.BizException;

/**
 * 医嘱B画面录入  todo
 * @author li_zheng
 *
 */
public class getOrdInputDtoBP {
	
	public OrdInputDto[] exec(String id_ent,String id_doctor)throws BizException{
		
		OrdInputDto[] inputDTO = new OrdInputDto[4];
		OrdInputDto pat = new 	OrdInputDto();
		pat.setId("pat");
		pat.setName("患者常用");
		inputDTO[0] =pat;
		OrdInputDto person = new OrdInputDto();
		person.setId("1001AA100000000007U1");
		person.setName("个人常用");
		inputDTO[1] =person;
		
		OrdInputDto Knowledge = new OrdInputDto();
		Knowledge.setId("Knowledge");
		Knowledge.setName("知识库");
		inputDTO[2] =Knowledge;
		
		OrdInputDto cp = new OrdInputDto();
		cp.setId("cp");
		cp.setName("临床路径");
		inputDTO[3] =cp;
		
		return inputDTO;
		 
	}

}
