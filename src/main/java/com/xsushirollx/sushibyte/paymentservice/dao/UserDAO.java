package com.xsushirollx.sushibyte.paymentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsushirollx.sushibyte.paymentservice.model.User;



@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
