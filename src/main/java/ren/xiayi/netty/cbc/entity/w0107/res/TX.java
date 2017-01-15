package ren.xiayi.netty.cbc.entity.w0107.res;

public class TX {
	private String REQUEST_SN;// 请求序列号		varChar(16) F 同请求报文中的序列号
	private String CUST_ID;//客户号 varChar(21) F 同请求报文中的客户号
	private String TX_CODE;// 交易码 varChar(6) F 同请求报文中的交易码
	private String RETURN_CODE;// 响应码 varChar(12) F 交易响应码
	private String RETURN_MSG;// 响应信息 varChar(600) T 交易响应信息
	private String LANGUAGE;// 语言 varChar(2) F CN，同请求报文
	private TransactionBody TX_INFO;

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

	public String getRETURN_CODE() {
		return RETURN_CODE;
	}

	public void setRETURN_CODE(String rETURN_CODE) {
		RETURN_CODE = rETURN_CODE;
	}

	public String getRETURN_MSG() {
		return RETURN_MSG;
	}

	public void setRETURN_MSG(String rETURN_MSG) {
		RETURN_MSG = rETURN_MSG;
	}

	public String getLANGUAGE() {
		return LANGUAGE;
	}

	public void setLANGUAGE(String lANGUAGE) {
		LANGUAGE = lANGUAGE;
	}

	public TransactionBody getTX_INFO() {
		return TX_INFO;
	}

	public void setTX_INFO(TransactionBody tX_INFO) {
		TX_INFO = tX_INFO;
	}

}
