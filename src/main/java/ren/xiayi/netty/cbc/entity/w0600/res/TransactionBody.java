package ren.xiayi.netty.cbc.entity.w0600.res;

public class TransactionBody {
	private String CREDIT_NO;//凭证号 Char(12) F
	private String DEAL_RESULT;// 交易处理结果 Char(1) F 返回状态为9时，调用6W0600查询处理结果；
	private String MESSAGE;// 错误原因 varChar(600) T
	private String REM1;// 备注1 varChar(32) T
	private String REM2;//备注2 varChar(32) T
	private String CST_PAY_NO;

	public String getCST_PAY_NO() {
		return CST_PAY_NO;
	}

	public void setCST_PAY_NO(String cST_PAY_NO) {
		CST_PAY_NO = cST_PAY_NO;
	}

	public String getCREDIT_NO() {
		return CREDIT_NO;
	}

	public void setCREDIT_NO(String cREDIT_NO) {
		CREDIT_NO = cREDIT_NO;
	}

	public String getDEAL_RESULT() {
		return DEAL_RESULT;
	}

	public void setDEAL_RESULT(String dEAL_RESULT) {
		DEAL_RESULT = dEAL_RESULT;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}

	public String getREM1() {
		return REM1;
	}

	public void setREM1(String rEM1) {
		REM1 = rEM1;
	}

	public String getREM2() {
		return REM2;
	}

	public void setREM2(String rEM2) {
		REM2 = rEM2;
	}
}
