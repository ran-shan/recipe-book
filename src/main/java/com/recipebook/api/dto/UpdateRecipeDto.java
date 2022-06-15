
package com.recipebook.api.dto;

import com.recipebook.api.entity.Ingredient;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateRecipeDto {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Boolean vegetarianDish;

    @NotNull
    private Integer numberOfPeople;

    @NotBlank
    private String cookingInstructions;

    @NotEmpty
    private Set<Ingredient> ingredients = new HashSet<>();

    public UpdateRecipeDto() {}

    public UpdateRecipeDto(Long id, String title, Boolean vegetarianDish, Integer numberOfPeople,
            String cookingInstructions, Set<Ingredient> ingredients) {
        this.id = id;
        this.title = title;
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
        if (!(obj instanceof UpdateRecipeDto)) {
            return false;
        }
        UpdateRecipeDto other = (UpdateRecipeDto) obj;
        if (cookingInstructions == null) {
            if (other.cookingInstructions != null) {
                return false;
            }
        } else if (!cookingInstructions.equals(other.cookingInstructions)) {
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
        return "UpdateRecipeDto [id=" + id + ", title=" + title + ", vegetarianDish="
                + vegetarianDish + ", numberOfPeople=" + numberOfPeople + ", cookingInstructions="
                + cookingInstructions + ", ingredients=" + ingredients + "]";
    }
}
