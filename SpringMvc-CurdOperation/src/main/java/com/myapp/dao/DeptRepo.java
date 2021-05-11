package com.myapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.myapp.department.Department;

public interface DeptRepo extends CrudRepository<Department, Integer> {

}
