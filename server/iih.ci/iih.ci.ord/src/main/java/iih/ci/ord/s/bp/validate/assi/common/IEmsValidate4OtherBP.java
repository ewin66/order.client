package iih.ci.ord.s.bp.validate.assi.common;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import xap.mw.core.data.BizException;

public interface IEmsValidate4OtherBP {

	abstract public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException;
}
