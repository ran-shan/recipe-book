
package com.recipebook.api.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private LocalDateTime creationDateTime;

    @Column(nullable = false)
    private Boolean vegetarianDish;

    @Column(nullable = false)
    private Integer numberOfPeople;

    @Column(nullable = false)
    private String cookingInstructions;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipe() {}

    public Recipe(Long id, String title, LocalDateTime creationDateTime, Boolean vegetarianDish,
            Integer numberOfPeople, String cookingInstructions, Set<Ingredient> ingredients) {
        this.id = id;
        this.title = title;
        this.creationDateTime = creationDateTime;
        this.vegetarianDish = vegetarianDish;
        this.numberOfPeople = numberOfPeople;
        this.cookingInstructions = cookingInstructions;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Boolean isVegetarianDish() {
        return vegetarianDish;
    }

    public void setVegetarianDish(Boolean vegetarianDish) {
        this.vegetarianDish = vegetarianDish;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((cookingInstructions == null) ? 0 : cookingInstructions.hashCode());
        result = prime * result + ((creationDateTime == null) ? 0 : creationDateTime.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
        result = prime * result + ((numberOfPeople == null) ? 0 : numberOfPeople.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((vegetarianDish == null) ? 0 : vegetarianDish.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) obj;
        if (cookingInstructions == null) {
            if (other.cookingInstructions != null) {
                return false;
            }
        } else if (!cookingInstructions.equals(other.cookingInstructions)) {
            return false;
        }
        if (creationDateTime == null) {
            if (other.creationDateTime != null) {
                return false;
            }
        } else if (!creationDateTime.equals(other.creationDateTime)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (ingredients == null) {
            if (other.ingredients != null) {
                return false;
            }
        } else if (!ingredients.equals(other.ingredients)) {
            return false;
        }
        if (numberOfPeople == null) {
            if (other.numberOfPeople != null) {
                return false;
            }
        } else if (!numberOfPeople.equals(other.numberOfPeople)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        if (vegetarianDish == null) {
            if (other.vegetarianDish != null) {
                return false;
            }
        } else if (!vegetarianDish.equals(other.vegetarianDish)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + id + ", title=" + title + ", creationDateTime=" + creationDateTime
                + ", vegetarianDish=" + vegetarianDish + ", numberOfPeople=" + numberOfPeople
                + ", cookingInstructions=" + cookingInstructions + ", ingredients=" + ingredients
                + "]";
    }
}
