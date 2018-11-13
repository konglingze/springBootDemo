package edu.nuc.springboot;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.test.context.junit4.SpringRunner;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJdbcApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //配置监控
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(
        ), "/druid/**");
        Map<String,String> initParameters =new HashMap<>();
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123");
        initParameters.put("allow","");
        //initParameters.put("deny","");
        bean.setInitParameters(initParameters);
        return bean;
    }
    //配置web监控的filter
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
        bean.setInitParameters(initParameters);
        bean.setUrlPatterns(Arrays.asList());
        return bean;
    }
}
