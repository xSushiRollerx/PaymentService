package com.xsushirollx.sushibyte.paymentservice.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="food")
public class Food {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", insertable = false, updatable = false)
    private Long id;

    @Column(name="restaurant_id", insertable = false, updatable = false)
    private Long restaurantID;

    @Column(name="name", insertable = false, updatable = false)
    private String name;

    @Column(name="cost", insertable = false, updatable = false)
    private Double cost;

    @Column(name="summary", insertable = false, updatable = false)
    private String summary;

    @Column(name="is_active", insertable = false, updatable = false)
    private Integer isActive;

    @Column(name="category", insertable = false, updatable = false)
    private String category;

    public Food(){};
    

    public Food(Long restaurantID, String name, Double cost, String summary,
                Integer isActive, String category){
        this();
        this.restaurantID = restaurantID;
        this.name = name;
        this.cost = cost;
        this.summary = summary;
        this.isActive = isActive;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }



    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(restaurantID, food.restaurantID) && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
            this.cost = cost;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        if ((isActive != null) && (isActive == 0 || isActive == 1))
        {
            this.isActive = isActive;
        }
        else {
            this.isActive = 1;
        }
    }

	@Override
	public String toString() {
		return "Food [id=" + id + ", restaurantID=" + restaurantID + ", name=" + name + ", cost=" + cost + ", summary="
				+ summary + ", isActive=" + isActive + ", category=" + category + "]";
	}

}
