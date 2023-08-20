package com.storage.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@OneToMany
	private List<Ingredient> ingredients;
	private String name;
	private Instant time;

	public Recipe(List<Ingredient> ingredients, String name, Instant time) {
		this.ingredients = ingredients;
		this.name = name;
		this.time = time;
	}

	public Recipe() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ingredients, name, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		return Objects.equals(id, other.id) && Objects.equals(ingredients, other.ingredients)
				&& Objects.equals(name, other.name) && Objects.equals(time, other.time);
	}

}
