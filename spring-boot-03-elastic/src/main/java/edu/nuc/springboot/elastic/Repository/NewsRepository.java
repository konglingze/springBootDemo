package edu.nuc.springboot.elastic.Repository;

import edu.nuc.springboot.elastic.bean.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NewsRepository extends ElasticsearchRepository<News,Integer> {




}
