package edu.nuc.springboot.elastic;

import edu.nuc.springboot.elastic.Repository.DeptRepository;
import edu.nuc.springboot.elastic.Repository.NewsRepository;
import edu.nuc.springboot.elastic.bean.Department;
import edu.nuc.springboot.elastic.bean.Employee;
import edu.nuc.springboot.elastic.bean.News;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetAddress;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    DeptRepository deptRepository;
    @Autowired
    NewsRepository newsRepository;

    @Test
    public void contextLoads() {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setdId(1);
        employee.setEmail("694458593@qq.com");
        employee.setGender(1);
        employee.setLastName("KongLingZe");

        Index index = new Index.Builder(employee).index("nuc").type("info").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextLoads2() {

        String string = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"lastName\" : \"KongLingZe\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(string).addIndex("nuc").addType("info").build();

        SearchResult result;
        try {
            result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void contextLoads3() {
        Department dept = new Department();
        dept.setId(2);
        dept.setDepartmentName("运维部");
        deptRepository.index(dept);


    }

    //netty3
    @Test
    public void contextLoads4() {
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name", "elasticsearch")
                    .build();
            TransportClient client = new PreBuiltTransportClient(settings).addTransportAddresses(
                    new InetSocketTransportAddress(InetAddress.getByName("192.168.159.131"), 9300),
                    new InetSocketTransportAddress(InetAddress.getByName("192.168.159.146"), 9300),
                    new InetSocketTransportAddress(InetAddress.getByName("192.168.159.147"), 9300));

            GetResponse response = client.prepareGet("news", "fulltext", "1")
                    .execute()
                    .actionGet();
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextLoads5() {
        Iterable<News> all = newsRepository.findAll();
        for (News news : all) {

            System.out.println(news);
        }

    }

}
