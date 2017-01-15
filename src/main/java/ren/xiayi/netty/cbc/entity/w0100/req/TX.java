package ren.xiayi.netty.cbc.entity.w0100.req;

/**
 * 余额查询交易 請求對象-外联平台余额查询
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
