package com.xsushirollx.sushibyte.paymentservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xsushirollx.sushibyte.paymentservice.model.Food;

@Repository
public interface FoodDAO extends JpaRepository<Food, Long> {

}
