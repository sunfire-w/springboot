package com.book.domain.utils;

import com.book.common.base.entity.SessionEntity;
import com.book.common.base.web.TraceData;
import com.book.thrift.inout.common.BaseRequest;
import com.book.thrift.inout.common.SessionModel;

import java.util.Date;

/**
 *  RPC客户端自定义请求基础信息
 */

public class RequestUtils {
	
	/**
	 * 获取基础请求参数，每个方法都必须调用此方法获取
	* @param sessionVo 登录信息，不需要登录的接口传 NULL
	 * @param businesKey 业务类型;只能传单个业务类型，用于数据权限校验具体值在interface的BusinesKeyEnum里定义；不需要验证时请与businesCode同时传NULL
	 * @param businesCode 业务单据主键；不同RPC系统可能不一样，多个用“;”分隔；格式：LOGS201700001;LOGS201700002；不需要验证时请与businesKey同时传NULL
	 * @param jurisdiction 需要进行的权限验证编号（菜单权限、按钮权限、工作流权限、对象权限），多个用“;”分隔；格式：objectId;objectId;objectId；不需要验证传NULL
	 * @return 返回基础请求参数
	 */
	public static BaseRequest genBaseRequest(SessionEntity sessionVo, String businesKey, String businesCode, String jurisdiction){
		BaseRequest req = new BaseRequest();
		
		req.setCreatedTime(new Date().getTime());
		req.setCreatedBy("system");
		req.setSourceSystem("book");
		req.setSeqNo(String.valueOf(TraceData.traceId.get()));
		if (sessionVo != null){
			SessionModel session = new SessionModel();
			session.setSid(sessionVo.getSid());
			session.setVersion(sessionVo.getVersion());
			session.setSource(sessionVo.getSource());
			req.setSession(session);
		}
		req.setJurisdiction(jurisdiction);
		req.setBusinesKey(businesKey);
		req.setBusinesCode(businesCode);
		return req;
	}

}
