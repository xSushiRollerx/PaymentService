package com.xsushirollx.sushibyte.paymentservice.dto;

import java.util.List;

public class FoodOrderDTO {

	private Integer id;

	private Integer state;

	private Integer customerId;

	private Integer restaurantId;
	
	private Integer refunded;
	
	private String dateSubmitted;

	private List<OrderItemDTO> orderItems;

	private Integer stripe;

	public FoodOrderDTO() {
	}

	public FoodOrderDTO(Integer id, Integer state) {
		this.id = id;
		this.state = state;
	}

	public FoodOrderDTO(Integer id, Integer state, Integer customerId, List<OrderItemDTO> orderItems) {
		super();
		this.id = id;
		this.state = state;
		this.customerId = customerId;
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getRefunded() {
		return refunded;
	}

	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}

	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getStripe() {
		return stripe;
	}

	public void setStripe(Integer stripe) {
		this.stripe = stripe;
	}

	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", state=" + state + ", customerId=" + customerId + ", refunded=" + refunded
				+ ", orderItems=" + orderItems + ", stripe=" + stripe + "]";
	}
	
	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getDateSubmitted() {
		return dateSubmitted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodOrderDTO other = (FoodOrderDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
