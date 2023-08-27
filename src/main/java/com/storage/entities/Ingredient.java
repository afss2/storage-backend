package com.storage.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String name;
	private int quantity;
	private int idealQuantity;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Ingredient(String name, int quantity, int idealQuantity, User user) {
		this.name = name;
		this.quantity = quantity;
		this.idealQuantity = idealQuantity;
		this.user = user;
	}

	public Ingredient() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIdealQuantity() {
		return idealQuantity;
	}

	public void setIdealQuantity(int idealQuantity) {
		this.idealQuantity = idealQuantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idealQuantity, name, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		return Objects.equals(id, other.id) && idealQuantity == other.idealQuantity && Objects.equals(name, other.name)
				&& quantity == other.quantity;
	}

}