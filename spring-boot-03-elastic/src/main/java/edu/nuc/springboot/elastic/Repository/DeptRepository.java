package edu.nuc.springboot.elastic.Repository;

import edu.nuc.springboot.elastic.bean.Department;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DeptRepository extends ElasticsearchRepository<Department,Integer> {




}
