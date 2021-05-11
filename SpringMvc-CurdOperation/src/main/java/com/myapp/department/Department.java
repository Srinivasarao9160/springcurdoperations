package com.myapp.department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id")
    private int id;
    @Column(name = "department_name")
    private String name;
    @Column(name = "location_id")
    private String location;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
    }
    
    

 

}