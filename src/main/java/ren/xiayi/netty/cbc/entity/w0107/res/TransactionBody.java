package ren.xiayi.netty.cbc.entity.w0107.res;

public class TransactionBody {

	private String STATUS;//生成文件定位串 0 文件已生成 1 文件生成中 2 无此单记录 3 其它错误 4没有明细
	private String INFO;//生成文件出错原因
	private String FILE_NAME;//文件名

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getINFO() {
		return INFO;
	}

	public void setINFO(String iNFO) {
		INFO = iNFO;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}

}
