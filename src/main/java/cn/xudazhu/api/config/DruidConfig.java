package cn.xudazhu.api.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //注册druid数据源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //注册druid管理页面servlet
    @Bean
    public ServletRegistrationBean registrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String , String> map = new HashMap<>();
        map.put("loginUsername" , "admin");
        map.put("loginPassword" , "api.xudazhu.cn");
        servletRegistrationBean.setInitParameters(map);
        return  servletRegistrationBean;

    }

    //注册druid拦截器
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter() );
        Map<String , String> map = new HashMap<>();
        map.put("exclusions" , "*.js,*.gif,*.jpg,*.png,*.ico,*.css,*.ico,*.jsp,*.eot,*.woff,/druid/*,/download/*");
        filterRegistrationBean.setInitParameters(map);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return  filterRegistrationBean;

    }


}
