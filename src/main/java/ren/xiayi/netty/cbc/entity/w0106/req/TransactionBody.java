package ren.xiayi.netty.cbc.entity.w0106.req;

public class TransactionBody {
	private String ACCNO1;//帐号 varChar(32) F 查询帐号
	private String TRANDATE;//交易日期 YYYYMMDD F

	public String getTRANDATE() {
		return TRANDATE;
	}

	public void setTRANDATE(String tRANDATE) {
		TRANDATE = tRANDATE;
	}

	public String getACCNO1() {
		return ACCNO1;
	}

	public void setACCNO1(String aCCNO1) {
		ACCNO1 = aCCNO1;
	}

}
