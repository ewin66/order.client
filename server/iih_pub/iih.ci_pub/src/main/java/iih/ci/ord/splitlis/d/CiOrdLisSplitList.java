package iih.ci.ord.splitlis.d;


import java.util.List;

public class CiOrdLisSplitList {

	
	    // 标本类型
	    public String samptp;
	    // 标本类型
	    public String samptpcode;
	    public String getSamptpcode() {
			return samptpcode;
		}

		public void setSamptpcode(String samptpcode) {
			this.samptpcode = samptpcode;
		}

		// 检验分类
		public String srvca;
		//标本采集时间
		public String sampcoltime;
		//执行科室
		public String id_dep_mp;		
		//注意事项
		public String announcements;
		//医保
		public String fg_hp;
		public String getSamptp() {
			return samptp;
		}

		public void setSamptp(String samptp) {
			this.samptp = samptp;
		}

		public String getSrvca() {
			return srvca;
		}

		public void setSrvca(String srvca) {
			this.srvca = srvca;
		}

		public String getSampcoltime() {
			return sampcoltime;
		}

		public void setSampcoltime(String sampcoltime) {
			this.sampcoltime = sampcoltime;
		}

		public String getId_dep_mp() {
			return id_dep_mp;
		}

		public void setId_dep_mp(String id_dep_mp) {
			this.id_dep_mp = id_dep_mp;
		}

		public String getAnnouncements() {
			return announcements;
		}

		public void setAnnouncements(String announcements) {
			this.announcements = announcements;
		}

		public String getFg_hp() {
			return fg_hp;
		}

		public void setFg_hp(String fg_hp) {
			this.fg_hp = fg_hp;
		}

		public String getSpecialneed() {
			return specialneed;
		}

		public void setSpecialneed(String specialneed) {
			this.specialneed = specialneed;
		}

		public boolean isAppRule() {
			return isAppRule;
		}

		public void setAppRule(boolean isAppRule) {
			this.isAppRule = isAppRule;
		}

		public List<LisOrderSplitDTO> getOrderList() {
			return orderList;
		}

		public void setOrderList(List<LisOrderSplitDTO> orderList) {
			this.orderList = orderList;
		}

		//特需
		public String specialneed;
		// 是否使用规则
		public boolean isAppRule  = true;
		
		public List<LisOrderSplitDTO> orderList;
}
