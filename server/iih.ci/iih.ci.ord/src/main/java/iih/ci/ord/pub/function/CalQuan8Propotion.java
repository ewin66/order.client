package iih.ci.ord.pub.function;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.IAssoSrvQuanMeduCal;

/**
 * 按比例系数计算用量计算公式类<br/>
 * Step1：quan=(quan_src-quan_prop_base)*factor<br/>
 * Step2：对Step1中的用量值按精度precise、舍位方式sd_round<br/>
 * Step3：根据是否超封顶值max_cal_value进行调整返回的用量
 */
public class CalQuan8Propotion implements IAssoSrvQuanMeduCal {
	private FDouble quan_src;
	private FDouble quan_prop_base;
	private String factor;
	private Integer precise;
	private String sd_roundmd;
	private FDouble max_cal_value;
	private String appscene;
	
	/**
	 * 构造函数   <br/>
	 * Step1：quan=(quan_src-quan_prop_base)*factor<br/>
	 * Step2：对Step1中的用量值按精度precise、舍位方式sd_round<br/>
	 * Step3：根据是否超封顶值max_cal_value进行调整返回的用量
	 * 
	 * @param quan_src  来源用量
	 * @param quan_prop_base 比例基准用量 
	 * @param factor       比例系数
	 * @param precise      精度
	 * @param sd_roundmd   舍位方式   <br/>01 舍位 <br/> 02 进位  <br/>03 四舍五入
	 * @param max_cal_value计算封顶用量值
	 * @param appscene 应用场景
	 */
	public CalQuan8Propotion(FDouble quan_src,FDouble quan_prop_base,String factor,Integer precise,String sd_roundmd,FDouble max_cal_value,String appscene){
		this.quan_src=quan_src;
		this.quan_prop_base=quan_prop_base;
		this.factor=factor;
		this.precise=precise;
		this.sd_roundmd=sd_roundmd;
		this.max_cal_value=max_cal_value;
		this.appscene=appscene;
	}
	
	/**
	 * 构造函数   <br/>
	 * Step1：quan=(quan_src-quan_prop_base)*factor<br/>
	 * Step2：对Step1中的用量值按精度precise、舍位方式sd_round<br/>
	 * Step3：根据是否超封顶值max_cal_value进行调整返回的用量
	 * 
	 * @param quan_src  来源用量
	 * @param quan_prop_base 比例基准用量 
	 * @param factor       比例系数
	 * @param precise      精度
	 * @param sd_roundmd   舍位方式   <br/>01 舍位 <br/> 02 进位  <br/>03 四舍五入
	 * @param max_cal_value计算封顶用量值
	 * @param appscene 应用场景
	 */
	public CalQuan8Propotion(String quan_src,String quan_prop_base,String factor,String precise,String sd_roundmd,String max_cal_value,String appscene){
		this.quan_src=new FDouble(quan_src);
		this.quan_prop_base=new FDouble(quan_prop_base);
		this.factor=factor;
		this.precise=new Integer(precise);
		this.sd_roundmd=sd_roundmd;
		if(CiOrdUtils.isEmpty(max_cal_value)){this.max_cal_value=null;
		}else{this.max_cal_value=new FDouble(max_cal_value);}
		this.appscene=appscene;
	}

	@Override
	public FDouble calculate() throws BizException {
		try{
			FDouble quan=CiOrdUtils.getQuan8Factor(getQuan_src().sub(getQuan_prop_base()),
					getFactor(), getPrecise(),
					getSd_roundmd(),getAppscene());
			if(!CiOrdUtils.isEmpty(this.max_cal_value) && (this.max_cal_value.sub(quan)).toDouble()<0)return this.max_cal_value;
			return quan;
		}catch(Exception e){
			throw new BizException(e.getMessage());
		}
	}

	public FDouble getQuan_src() {
		return this.quan_src;
	}

	public FDouble getQuan_prop_base() {
		return this.quan_prop_base;
	}

	public String getFactor() {
		return this.factor;
	}

	public Integer getPrecise() {
		return this.precise;
	}

	public String getSd_roundmd() {
		return this.sd_roundmd;
	}

	public FDouble getMax_cal_value() {
		return this.max_cal_value;
	}

	public String getAppscene() {
		return this.appscene;
	}
	

}
