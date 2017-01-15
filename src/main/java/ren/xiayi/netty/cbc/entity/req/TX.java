package ren.xiayi.netty.cbc.entity.req;

public class TX {
	private String REQUEST_SN;// 请求序列号 varChar(16) F 只可以使用数字
	private String CUST_ID;//客户号 varChar(21) F 字符型char，网银客户号
	private String USER_ID;//操作员号 varChar(6) F 20051210后必须使用
	private String PASSWORD;// 密码 varChar(32) F 操作员密码
	private String TX_CODE;//交易码 varChar(6) F 交易请求码
	private String LANGUAGE;// 语言 varChar(2) F CN

	public String getREQUEST_SN() {
		return REQUEST_SN;
	}

	public void setREQUEST_SN(String rEQUEST_SN) {
		REQUEST_SN = rEQUEST_SN;
	}

	public String getCUST_ID() {
		return CUST_ID;
	}

	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}

	public String getTX_CODE() {
		return TX_CODE;
	}

	public void setTX_CODE(String tX_CODE) {
		TX_CODE = tX_CODE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getLANGUAGE() {
		return LANGUAGE;
	}

	public void setLANGUAGE(String lANGUAGE) {
		LANGUAGE = lANGUAGE;
	}

}
