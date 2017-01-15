package ren.xiayi.netty.cbc.entity.w0600.req;

public class TransactionBody {
	private String REQUEST_SN1;// 原请求序列号 varChar(16) F 原转账交易请求序列号
	private String CREDIT_NO1;// 原转账凭证号 varChar(12) T 原转账交易应答报文返回的凭证号

	public String getREQUEST_SN1() {
		return REQUEST_SN1;
	}

	public void setREQUEST_SN1(String rEQUEST_SN1) {
		REQUEST_SN1 = rEQUEST_SN1;
	}

	public String getCREDIT_NO1() {
		return CREDIT_NO1;
	}

	public void setCREDIT_NO1(String cREDIT_NO1) {
		CREDIT_NO1 = cREDIT_NO1;
	}

}
