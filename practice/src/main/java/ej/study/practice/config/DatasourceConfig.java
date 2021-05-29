package ej.study.practice.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class DatasourceConfig {

    @Autowired
    private ApplicationContext applicationContext;
    private DataSource dataSource;

    /**
     * hikari cp config 명시
     * conf prop -> application.yml
     */
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    /**
     * mybatis에 hikari cp 등록
     */
    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new HikariDataSource( hikariConfig() );
        return dataSource;
    }

    /**
     * @param dataSource
     * @return
     * @throws Exception
     * SqlFactoryBean에 dataSource와 mapper 경로 등록
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlFactoryBean = new SqlSessionFactoryBean();

        sqlFactoryBean.setDataSource(dataSource);
        Resource confiigLocation =  new PathMatchingResourcePatternResolver().getResource("classpath:/config/mybatis-config.xml");
        sqlFactoryBean.setConfigLocation(confiigLocation);
        sqlFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/**.xml"));
        return sqlFactoryBean.getObject();
    }

    /**
     * @param sqlSessionFactory
     * @return
     * SqlSessionFactory를 SqlSessionTemplate에 등록
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * Transaction Manager
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}