package edu.nuc.springboot.elastic.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "nuc", type = "dept")
public class Department {

    //@JestId
    @Id
    private Integer id;
    private String departmentName;


    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Department(Integer id, String departmentName) {
        super();
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentName=" + departmentName + "]";
    }


}
