package ren.xiayi.netty.cbc.entity.w0111.req;

/**
 * 获取下载明细
 */

public class TX extends ren.xiayi.netty.cbc.entity.req.TX {

	private TransactionBody TX_INFO;

	public TransactionBody getTX_INFO() {
		return TX_INFO;
	}

	public void setTX_INFO(TransactionBody tX_INFO) {
		TX_INFO = tX_INFO;
	}
}
