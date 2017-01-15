package ren.xiayi.netty.cbc.entity.w0300.res;

import java.util.List;

public class TransactionBody {
	private String ACC_NO;// 帐号 varChar(32) F 同请求报文中的帐号
	private String CUR_TYPE;// 币种 Char(2) F 代码表示
	private String ACC_NAME;// 本方帐户名称 varChar(60) F 30个汉字
	private String ACC_DEPT;// 本方帐户开户机构 varChar(40) F 20个汉字
	private String ACC_STATUS;// 本方账户状态 varChar(20) F 10个汉字：正常、冻结等
	private String INTEREST_RATE;// 本方帐户利率 Decimal(6,4) T
	private String CUR_PAGE;// 当前页次 Int T 整数>0
	private String PAGE_COUNT;// 总页次 Int F 整数>0
	private String POSTSTR;// 查询定位串 (252定位串) varChar(40) T 分行可选，对应于必输分行则必须输入
	private String INDIVIDUAL_NAME1;// 自定义输出名称1 varChar(99) 　 分行自定义输出名称1
	private String INDIVIDUAL_NAME2;// 自定义输出名称2 varChar(99) 　 分行自定义输出名称2
	private String REM1;// 备注1 varChar(32) T
	private String REM2;// 备注2 varChar(32) T
	private List<Detail> detail;

	public String getACC_NO() {
		return ACC_NO;
	}

	public void setACC_NO(String aCC_NO) {
		ACC_NO = aCC_NO;
	}

	public String getCUR_TYPE() {
		return CUR_TYPE;
	}

	public void setCUR_TYPE(String cUR_TYPE) {
		CUR_TYPE = cUR_TYPE;
	}

	public String getACC_NAME() {
		return ACC_NAME;
	}

	public void setACC_NAME(String aCC_NAME) {
		ACC_NAME = aCC_NAME;
	}

	public String getACC_DEPT() {
		return ACC_DEPT;
	}

	public void setACC_DEPT(String aCC_DEPT) {
		ACC_DEPT = aCC_DEPT;
	}

	public String getACC_STATUS() {
		return ACC_STATUS;
	}

	public void setACC_STATUS(String aCC_STATUS) {
		ACC_STATUS = aCC_STATUS;
	}

	public String getINTEREST_RATE() {
		return INTEREST_RATE;
	}

	public void setINTEREST_RATE(String iNTEREST_RATE) {
		INTEREST_RATE = iNTEREST_RATE;
	}

	public String getCUR_PAGE() {
		return CUR_PAGE;
	}

	public void setCUR_PAGE(String cUR_PAGE) {
		CUR_PAGE = cUR_PAGE;
	}

	public String getPAGE_COUNT() {
		return PAGE_COUNT;
	}

	public void setPAGE_COUNT(String pAGE_COUNT) {
		PAGE_COUNT = pAGE_COUNT;
	}

	public String getPOSTSTR() {
		return POSTSTR;
	}

	public void setPOSTSTR(String pOSTSTR) {
		POSTSTR = pOSTSTR;
	}

	public String getINDIVIDUAL_NAME1() {
		return INDIVIDUAL_NAME1;
	}

	public void setINDIVIDUAL_NAME1(String iNDIVIDUAL_NAME1) {
		INDIVIDUAL_NAME1 = iNDIVIDUAL_NAME1;
	}

	public String getINDIVIDUAL_NAME2() {
		return INDIVIDUAL_NAME2;
	}

	public void setINDIVIDUAL_NAME2(String iNDIVIDUAL_NAME2) {
		INDIVIDUAL_NAME2 = iNDIVIDUAL_NAME2;
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

	public List<Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<Detail> detail) {
		this.detail = detail;
	}

	class Detail {
		private String CREDIT_TYPE;// 凭证种类 varChar(10) F 5个汉字
		private String CREDIT_NO;// 凭证号码 Char(12) F
		private String TRAN_DATE;// 发生日期 YYYY/MM/DD F 交易发生日期（Char）
		private String TRAN_TIME;// 发生时间 HHMISS T 交易发生时间（Char）
		private String ABSTRACT;// 摘要 varChar(12) F 6个汉字
		private String AMOUNT; //发生金额 Decimal(16,2) F
		private String BALANCE; //余额 Decimal(16,2) F
		private String dORc; //借贷标志 Char(1) F 0:借 1:贷
		private String ACC_NO1; //对方账号 varChar(32) T
		private String ACC_NAME1;//对方账户名称 varChar(40) T 20个汉字
		private String INDIVIDUAL1; //自定义输出内容1 varChar(99) T
		private String INDIVIDUAL2;//自定义输出内容2 varChar(99) T
		private String PAY_SEQ_NUM; //企业流水号 varChar(65) T

		public String getCREDIT_TYPE() {
			return CREDIT_TYPE;
		}

		public void setCREDIT_TYPE(String cREDIT_TYPE) {
			CREDIT_TYPE = cREDIT_TYPE;
		}

		public String getCREDIT_NO() {
			return CREDIT_NO;
		}

		public void setCREDIT_NO(String cREDIT_NO) {
			CREDIT_NO = cREDIT_NO;
		}

		public String getTRAN_DATE() {
			return TRAN_DATE;
		}

		public void setTRAN_DATE(String tRAN_DATE) {
			TRAN_DATE = tRAN_DATE;
		}

		public String getTRAN_TIME() {
			return TRAN_TIME;
		}

		public void setTRAN_TIME(String tRAN_TIME) {
			TRAN_TIME = tRAN_TIME;
		}

		public String getABSTRACT() {
			return ABSTRACT;
		}

		public void setABSTRACT(String aBSTRACT) {
			ABSTRACT = aBSTRACT;
		}

		public String getAMOUNT() {
			return AMOUNT;
		}

		public void setAMOUNT(String aMOUNT) {
			AMOUNT = aMOUNT;
		}

		public String getBALANCE() {
			return BALANCE;
		}

		public void setBALANCE(String bALANCE) {
			BALANCE = bALANCE;
		}

		public String getdORc() {
			return dORc;
		}

		public void setdORc(String dORc) {
			this.dORc = dORc;
		}

		public String getACC_NO1() {
			return ACC_NO1;
		}

		public void setACC_NO1(String aCC_NO1) {
			ACC_NO1 = aCC_NO1;
		}

		public String getACC_NAME1() {
			return ACC_NAME1;
		}

		public void setACC_NAME1(String aCC_NAME1) {
			ACC_NAME1 = aCC_NAME1;
		}

		public String getINDIVIDUAL1() {
			return INDIVIDUAL1;
		}

		public void setINDIVIDUAL1(String iNDIVIDUAL1) {
			INDIVIDUAL1 = iNDIVIDUAL1;
		}

		public String getINDIVIDUAL2() {
			return INDIVIDUAL2;
		}

		public void setINDIVIDUAL2(String iNDIVIDUAL2) {
			INDIVIDUAL2 = iNDIVIDUAL2;
		}

		public String getPAY_SEQ_NUM() {
			return PAY_SEQ_NUM;
		}

		public void setPAY_SEQ_NUM(String pAY_SEQ_NUM) {
			PAY_SEQ_NUM = pAY_SEQ_NUM;
		}

	}

}
