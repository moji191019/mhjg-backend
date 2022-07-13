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
		String queryId = ((MappedStatement) invocation.getArgs()[0]).getId();
		
		Object param = invocation.getArgs()[1];
		//Query String
        String queryString = ((MappedStatement)invocation.getArgs()[0]).getBoundSql(param).getSql();
		System.out.println("- Query String : \n" + queryString);
		
		long start = System.currentTimeMillis();
		Object resultObj = invocation.proceed();
		long stop = System.currentTimeMillis() - start;
		
		System.out.println("- Query ID : " + queryId);
		System.out.println("- Query Exec Time : " + stop);
		
		return resultObj;
	}

}
