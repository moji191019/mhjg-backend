package com.mhjg.yose.db.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(@Signature(
	type = Executor.class,
	method = "query", 
	args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
)
public class QueryInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		String statementId = ((MappedStatement) invocation.getArgs()[0]).getId();
		
		long start = System.currentTimeMillis();
		Object resultObj = invocation.proceed();
		long stop = System.currentTimeMillis() - start;
		
		System.out.println("- statement id : " + statementId);
		System.out.println("- execute time : " + stop);
		
		return resultObj;
	}

}
