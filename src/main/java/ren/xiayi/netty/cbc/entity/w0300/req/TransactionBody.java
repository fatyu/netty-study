package ren.xiayi.netty.cbc.entity.w0300.req;

public class TransactionBody {
	private String ACC_NO;// 帐号 varChar(32) F 查询帐号
	private String START_DATE;// 起始日期 YYYYMMDD F 查询起始日期（Char）
	private String END_DATE;// 结束日期 YYYYMMDD F 查询截至日期（Char）
	private String START_PAGE;// 起始页次 Int F 整数>0
	private String POSTSTR;//查询定位串(252定位串) varChar(40) T 分行可选，对应于必输分行则必须输入
	private String CONDITION1;//  备注1 varChar(32) T 备注1
	private String CONDITION2;// 备注2 varChar(32) T 备注2

	public String getACC_NO() {
		return ACC_NO;
	}

	public void setACC_NO(String aCC_NO) {
		ACC_NO = aCC_NO;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}

	public String getSTART_PAGE() {
		return START_PAGE;
	}

	public void setSTART_PAGE(String sTART_PAGE) {
		START_PAGE = sTART_PAGE;
	}

	public String getPOSTSTR() {
		return POSTSTR;
	}

	public void setPOSTSTR(String pOSTSTR) {
		POSTSTR = pOSTSTR;
	}

	public String getCONDITION1() {
		return CONDITION1;
	}

	public void setCONDITION1(String cONDITION1) {
		CONDITION1 = cONDITION1;
	}

	public String getCONDITION2() {
		return CONDITION2;
	}

	public void setCONDITION2(String cONDITION2) {
		CONDITION2 = cONDITION2;
	}
}
