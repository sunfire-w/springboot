namespace java com.book.thrift.inout.common

/*基本返回参数*/
struct BaseResponse{
   /**
	* 本次请求的编号
	*/
	1:string seqNo,
	2:string respCode,
	3:string respDesc 
}

/*基本请求参数*/
struct BaseRequest{
   /**
	* 本次请求的编号
	*/
	1:string seqNo,
	2:string memo,
	3:string createdBy,
	/**
	* 来源系统
	*/
	4:string sourceSystem,
	5:i64 createdTime,
	6:string userType,
	/**
	* 登录信息，需要根据source判断来源取不同的登录信息
	*/
	7:SessionModel session,
	
	/**
	* 权限，多个时用";"隔开，一般是操作权限
	*/
	8:string jurisdiction,
	
	/**
	* 业务key，在BusinesKeyEnum里定义，根据数据权限检验配合适用(类:RpcInvokePrivilege)
	*/
	9:string businesKey,
	
	/**
	* 业务code,非特殊情况下传主键，如策略编号，订单号等，数据权限校验，多个时用";"隔开
	*/
	10:string businesCode
}

struct BoolResponse{
	1:BaseResponse baseResp,
	2:bool value
}

struct I64Response{
	1:BaseResponse baseResp,
	2:i64 value
}

struct I32Response{
	1:BaseResponse baseResp,
	2:i32 value
}

struct StringResponse{
	1:BaseResponse baseResp,
	2:string value
}

struct VoidResponse{
	1:BaseResponse baseResp
}

/* 缓存实体 */
struct SessionModel{
	/**
	* SessionId
	*/
	1:string sid,
	/**
	* android/ios/h5/weixin/customer/tmc/platform/callback
	*/
	2:string source,
	/**
	* 版本号
	*/
	3:string version,
}

/*修改状态请求参数 支持批量与单记录*/
struct UpdateStatusRequest {

   /**
	* 基础请求参数
	*/
  1:BaseRequest baseReq,

   /**
	* 状态(要把记录改成的目标状态)
	*/
  2:i32 useStatus,

   /**
	* 记录ID列表
	*/
  3:list<string> ids
}

/*通过ID获取信息的请求参数（如详情等）*/
struct GetInfoByIdRequest {

   /**
	* 基础请求参数
	*/
  1:BaseRequest baseReq,

   /**
	* 记录ID
	*/
  2:string id,
   /**
    * 日志编号（版本号）
    */
  3:i32 logNum

}

