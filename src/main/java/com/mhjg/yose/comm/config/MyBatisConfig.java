package com.mhjg.yose.comm.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MyBatisConfig {
	
	@Bean(name = "yoseDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.yose.datasource")
	public DataSource yoseDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "yoseSqlSessionFactory")
	@Primary
	public SqlSessionFactoryBean yoseSqlSessionFactory(@Qualifier("yoseDataSource") DataSource dataSource
			, ApplicationContext context) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		
		sqlSessionFactory.setDataSource(dataSource);
		
		// typeAliasesPackage
		List<String> aliasesPackages = new ArrayList();
		// 모델 클래스 패키지 추가될 때마다 등록
		aliasesPackages.add("com.mhjg.yose.comm.vo");
		sqlSessionFactory.setTypeAliasesPackage(StringUtils.join(aliasesPackages, ","));
		
		String mapperPath = "classpath:/mapper/**/*Mapper.xml";
		sqlSessionFactory.setMapperLocations(context.getResources(mapperPath));
		
		String configPath = "classpath:/mybatis/mybatis-config.xml";
		sqlSessionFactory.setConfigLocation(context.getResource(configPath));
		
		return sqlSessionFactory;
	}
	
	@Bean(name = "yoseSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate yoseSqlSessionTemplate(
			@Qualifier("yoseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
