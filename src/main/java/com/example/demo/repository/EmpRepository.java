package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.emp;


@Repository
/*public interface EmpRepository extends CrudRepository<emp,String> {*/
public interface EmpRepository extends JpaRepository<emp,String> {
	/*@Modifying
	 @Query("update emp e set e.fromdate = ?1 e.todate = ?1 where e.name = ?2")
*/
	//public boolean updateLeavebalance(String a);

}
