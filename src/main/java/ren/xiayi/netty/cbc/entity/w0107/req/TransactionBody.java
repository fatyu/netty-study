package ren.xiayi.netty.cbc.entity.w0107.req;

public class TransactionBody {
	private String ACCNO1;//帐号 varChar(32) F 查询帐号
	private String FILE_LOCSTR;//文件编号

	public String getFILE_LOCSTR() {
		return FILE_LOCSTR;
	}

	public void setFILE_LOCSTR(String fILE_LOCSTR) {
		FILE_LOCSTR = fILE_LOCSTR;
	}

	private String FLAG = "0";//生成文件规则 0同步,1异步

	public String getFLAG() {
		return FLAG;
	}

	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}

	public String getACCNO1() {
		return ACCNO1;
	}

	public void setACCNO1(String aCCNO1) {
		ACCNO1 = aCCNO1;
	}

}
