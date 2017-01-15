package ren.xiayi.netty.cbc.service.pay;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;

import ren.xiayi.netty.cbc.entity.w0201.res.BankInfo;
import ren.xiayi.netty.cbc.service.socket.CBCPayClient;
import ren.xiayi.netty.utils.XmlUtils;

public class CBCPayService {
	private static final int port = 18888;

	//	private static final String CBC_SERVER_STATUS = "cbc_server_status";
	//	private static final Logger logger = LoggerFactory.getLogger(CBCPayService.class);
	//	@Autowired
	//	private StringRedisTemplate stringRedisTemplate;

	private ScheduledExecutorService executors = Executors
			.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	//	private static final String REQUEST_SN = "cbc_request_sn";

	public void otherBankpay(ren.xiayi.netty.cbc.entity.w8060.req.TX tx) {
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w8060.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";//systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				System.out.println("other-bank-method-invoked=bank-response::::" + resData);
				resData = StringUtils.replace(resData, "<FEE></FEE>", "<FEE>0.00</FEE>");
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w8060.res.TX.class);
				ren.xiayi.netty.cbc.entity.w8060.res.TX resTx = (ren.xiayi.netty.cbc.entity.w8060.res.TX) xStream
						.fromXML(resData);
				if (null == resTx) {
					//					logger.error("建行返回数据异常,数据为空!");
				} else {
					//6W0860 response process
					String creditNo = resTx.getTX_INFO().getCREDIT_NO();
					//延迟三秒进行数据查询
					executors.schedule(() -> {
						ren.xiayi.netty.cbc.entity.w0600.req.TX _600ReqTx = new ren.xiayi.netty.cbc.entity.w0600.req.TX();
						fillRequest(_600ReqTx, "6W0600");//请求头信息
						ren.xiayi.netty.cbc.entity.w0600.req.TransactionBody body = new ren.xiayi.netty.cbc.entity.w0600.req.TransactionBody();
						body.setREQUEST_SN1(tx.getREQUEST_SN());
						body.setCREDIT_NO1(creditNo);
						_600ReqTx.setTX_INFO(body);
						//						statusCheck(_600ReqTx);
					}, 3, TimeUnit.SECONDS);
				}
			});
		} catch (InterruptedException e) {
			//logger.error("跨行自动打款失败:", e);
			e.printStackTrace();
		}

	}

	public void cbcPay(ren.xiayi.netty.cbc.entity.w8010.req.TX tx) {
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w8010.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";//systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				System.out.println("cbc-bank-method-invoked=bank-response::::" + resData);
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w8010.res.TX.class);
				ren.xiayi.netty.cbc.entity.w8010.res.TX resTx = (ren.xiayi.netty.cbc.entity.w8010.res.TX) xStream
						.fromXML(resData);
				if (null == resTx) {
					//					logger.error("建行返回数据异常,数据为空!");
				} else {
					//6W0810 response process
					if (resTx.getRETURN_CODE().equals("000000")) {
						//						String creditNo = resTx.getTX_INFO().getCREDIT_NO();
					} else {
					}
				}
			});
		} catch (InterruptedException e) {
			//			logger.error("建行转账自动打款失败:", e);
			e.printStackTrace();
		}

	}

	//	private static long initialValue = 100000000;
	//
	//	public String getNewRequestSN() {
	//		RedisAtomicLong requestSn = new RedisAtomicLong(REQUEST_SN, stringRedisTemplate.getConnectionFactory());
	//		if (requestSn.get() < initialValue) {
	//			requestSn.set(initialValue);
	//		}
	//		return String.valueOf(requestSn.incrementAndGet());
	//	}

	public String accountInfo(ren.xiayi.netty.cbc.entity.w0100.req.TX tx) {
		//		List<String> resultLeftBalance = Lists.newArrayList();
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0100.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";//systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0100.res.TX.class);
				ren.xiayi.netty.cbc.entity.w0100.res.TX resTx = (ren.xiayi.netty.cbc.entity.w0100.res.TX) xStream
						.fromXML(resData);
				if (null == resTx) {
					//					logger.error("查询账户余额信息,建行返回数据异常,数据为空!");
				} else if (resTx.getRETURN_CODE().equals("000000")) {
					//					String balance = resTx.getTX_INFO().getBALANCE();
					//					String leftBalance = resTx.getTX_INFO().getBALANCE1();
					//					String status = resTx.getTX_INFO().getACC_STATUS();
					//					resultLeftBalance.add(leftBalance);
					//					String result = "当前账户状态:" + status + ",余额为:" + balance + ",可用余额:" + leftBalance;
					//					logger.error("查询账户信息:{}", result);
				} else {
				}
			});
		} catch (InterruptedException e) {
			//			logger.error("查询余额信息失败:", e);
			e.printStackTrace();
		}
		return null;
	}

	public String bankInfo(ren.xiayi.netty.cbc.entity.w0201.req.TX tx) {
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0201.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";//systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0201.res.TX.class);
				ren.xiayi.netty.cbc.entity.w0201.res.TX resTx = (ren.xiayi.netty.cbc.entity.w0201.res.TX) xStream
						.fromXML(resData);
				if (resTx.getRETURN_CODE().equals("000000")) {
					List<BankInfo> bis = resTx.getTX_INFO().getList();
					for (BankInfo bInfo : bis) {
						String bc = bInfo.getBANK_CODE();
						String bn = bInfo.getBANK_NAME();
						System.out.println("银行信息:" + bn + "-" + bc);
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String tradeListFileOrder(ren.xiayi.netty.cbc.entity.w0106.req.TX tx) {
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0106.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";//systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0106.res.TX.class);
				ren.xiayi.netty.cbc.entity.w0106.res.TX resTx = (ren.xiayi.netty.cbc.entity.w0106.res.TX) xStream
						.fromXML(resData);
				if (resTx.getRETURN_CODE().equals("000000")) {
					String fileLocStr = resTx.getTX_INFO().getFILE_LOCSTR();
					if (StringUtils.isNotBlank(fileLocStr)) {
						ren.xiayi.netty.cbc.entity.w0107.req.TX tx_107 = new ren.xiayi.netty.cbc.entity.w0107.req.TX();
						fillRequest(tx_107, "6WY107");
						ren.xiayi.netty.cbc.entity.w0107.req.TransactionBody tBody = new ren.xiayi.netty.cbc.entity.w0107.req.TransactionBody();
						tBody.setACCNO1("ACCNO1");
						tBody.setFLAG("0");
						tBody.setFILE_LOCSTR(fileLocStr);
						tx_107.setTX_INFO(tBody);
						createTransFile(tx_107);
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void createTransFile(ren.xiayi.netty.cbc.entity.w0107.req.TX tx) {
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0107.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";// systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0107.res.TX.class);
				ren.xiayi.netty.cbc.entity.w0107.res.TX resTx = (ren.xiayi.netty.cbc.entity.w0107.res.TX) xStream
						.fromXML(resData);
				if (resTx.getRETURN_CODE().equals("000000")) {
					ren.xiayi.netty.cbc.entity.w0107.res.TransactionBody tx_INFO = resTx.getTX_INFO();
					String status = tx_INFO.getSTATUS();

					//0 文件已生成 1 文件生成中 2 无此单记录 3 其它错误 4没有明细
					if (StringUtils.equals(status, "0")) {
						ren.xiayi.netty.cbc.entity.w0111.req.TX tx_111 = new ren.xiayi.netty.cbc.entity.w0111.req.TX();
						fillRequest(tx_111, "6W0111");
						ren.xiayi.netty.cbc.entity.w0111.req.TransactionBody tb = new ren.xiayi.netty.cbc.entity.w0111.req.TransactionBody();
						tb.setSOURCE(tx_INFO.getFILE_NAME());
						tx_111.setTX_INFO(tb);
						downloadFile(tx_111);
					} else {
						try {
							Thread.sleep(1000 * 60 * 1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						createTransFile(tx);
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void downloadFile(ren.xiayi.netty.cbc.entity.w0111.req.TX tx) {
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0111.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, tx);
		try {
			String ip = "";// systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0111.res.TX.class);
				ren.xiayi.netty.cbc.entity.w0111.res.TX resTx = (ren.xiayi.netty.cbc.entity.w0111.res.TX) xStream
						.fromXML(resData);
				System.out.println(resTx.getREQUEST_SN());
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void fillRequest(ren.xiayi.netty.cbc.entity.req.TX reqTx, String txCode) {
		reqTx.setPASSWORD("PASSWORD");
		reqTx.setUSER_ID("USER_ID");
		reqTx.setCUST_ID("CUST_ID");
		reqTx.setLANGUAGE("CN");
		reqTx.setTX_CODE(txCode);
		reqTx.setREQUEST_SN("");//reqTx.setREQUEST_SN(getNewRequestSN());
	}

	//	public int serverStatus() {
	//		RedisAtomicInteger status = new RedisAtomicInteger(CBC_SERVER_STATUS,
	//				stringRedisTemplate.getConnectionFactory());
	//		return status.get();
	//	}
	//
	//	private void updateServerStatus(int state) {
	//		RedisAtomicInteger status = new RedisAtomicInteger(CBC_SERVER_STATUS,
	//				stringRedisTemplate.getConnectionFactory());
	//		status.set(state);
	//
	//	}

	public int toCBCPay() {
		String bankCardId = "";
		String bankName = "";
		String bankUsername = "";
		if (StringUtils.equals("中国建设银行", bankName)) {
			ren.xiayi.netty.cbc.entity.w8010.req.TX tx = new ren.xiayi.netty.cbc.entity.w8010.req.TX();
			fillRequest(tx, "6W8010");
			ren.xiayi.netty.cbc.entity.w8010.req.TransactionBody tBody = new ren.xiayi.netty.cbc.entity.w8010.req.TransactionBody();
			tBody.setAMOUNT(0.0);
			tBody.setCUR_TYPE("01");
			tBody.setPAY_ACCNO("33050161883509888887");//支付账号
			tBody.setRECV_ACC_NAME(bankUsername);//转入账号姓名
			tBody.setRECV_ACCNO(bankCardId);//转入账号
			tBody.setRECV_OPENACC_DEPT(bankName);//银行名称
			//tBody.setRECV_UBANKNO(bankBranchName);//联号
			//tBody.setSIGN_INFO("");
			//tBody.setSIGNCERT("");
			tBody.setUSEOF("建行自动支付");
			//tBody.setREM1("");
			//tBody.setREM2("");
			//tBody.setCHK_RECVNAME("0");
			tx.setTX_INFO(tBody);
			cbcPay(tx);
		}
		return 200;
	}

	public String queryOrderStatus() {
		ren.xiayi.netty.cbc.entity.w0600.req.TX _600ReqTx = new ren.xiayi.netty.cbc.entity.w0600.req.TX();
		fillRequest(_600ReqTx, "6W0600");//请求头信息
		ren.xiayi.netty.cbc.entity.w0600.req.TransactionBody body = new ren.xiayi.netty.cbc.entity.w0600.req.TransactionBody();
		body.setREQUEST_SN1("REQUEST_SN1");
		body.setCREDIT_NO1("CREDIT_NO1");
		_600ReqTx.setTX_INFO(body);
		XStream xStream = XmlUtils.getXStream();
		XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0600.req.TX.class);
		String xmlData = XmlUtils.toXml(xStream, _600ReqTx);
		List<String> result = Lists.newArrayList();
		try {
			String ip = "";//systemConfig.getCbcAutoPayServerIp();
			new CBCPayClient(ip, port).send(xmlData, resData -> {
				System.out.println(resData);
				XmlUtils.setAliasType(xStream, "TX", ren.xiayi.netty.cbc.entity.w0600.res.TX.class);
				ren.xiayi.netty.cbc.entity.w0600.res.TX resTx = (ren.xiayi.netty.cbc.entity.w0600.res.TX) xStream
						.fromXML(resData);
				if (null == resTx) {
					//					logger.error("建行返回数据异常,数据为空!");
				} else {
					String dealResult = resTx.getTX_INFO().getDEAL_RESULT();
					if (StringUtils.equals("2", dealResult) || StringUtils.equals("3", dealResult)
							|| StringUtils.equals("4", dealResult)) {
						//成功
						result.add("2||3||4");
					} else if (StringUtils.equals("5", dealResult) || StringUtils.equals("A", dealResult)) {
						result.add("5||A");
					}
				}
			});
		} catch (InterruptedException e) {
			//			logger.error("查询转账状态失败:", e);
			e.printStackTrace();
		}
		if (result.size() > 0) {
			return result.get(0);
		}
		return "no response";

	}
}
