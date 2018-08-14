package com.icims.tony.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icims.tony.demo.entities.DemoEntity;

@Repository
public interface DemoRepository extends CrudRepository<DemoEntity, Long>{

}
