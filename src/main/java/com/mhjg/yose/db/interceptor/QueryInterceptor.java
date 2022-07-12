package com.mhjg.yose.db.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

@Intercepts(
		@Signature(
				args = {}, 
				method = "", 
				type = Executor.class)
		)
public class QueryInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
