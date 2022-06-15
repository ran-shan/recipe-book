
package com.recipebook.api.mapper;

import com.recipebook.api.dto.CreateRecipeDto;
import com.recipebook.api.dto.RecipeDto;
import com.recipebook.api.dto.UpdateRecipeDto;
import com.recipebook.api.entity.Recipe;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 * <code>RecipeMapper</code> is a dedicated converter class which is used to
 * convert an Entity to a DTO and vice versa.<br>
 */
@Component
public class RecipeMapper {

    public RecipeMapper() {}

    public RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setTitle(recipe.getTitle());
        recipeDto.setCreationDateTime(recipe.getCreationDateTime());
        recipeDto.setVegetarianDish(recipe.isVegetarianDish());
        recipeDto.setNumberOfPeople(recipe.getNumberOfPeople());
        recipeDto.setCookingInstructions(recipe.getCookingInstructions());
        recipeDto.setIngredients(recipe.getIngredients());
        return recipeDto;
    }

    public Recipe toEntity(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setTitle(recipeDto.getTitle());
        recipe.setCreationDateTime(recipeDto.getCreationDateTime());
        recipe.setVegetarianDish(recipeDto.isVegetarianDish());
        recipe.setNumberOfPeople(recipeDto.getNumberOfPeople());
        recipe.setCookingInstructions(recipeDto.getCookingInstructions());
        recipe.setIngredients(recipeDto.getIngredients());
        return recipe;
    }

    public Recipe toEntity(CreateRecipeDto createRecipeDto) {
        Recipe recipe = new Recipe();
        recipe.setTitle(createRecipeDto.getTitle());
        recipe.setCreationDateTime(LocalDateTime.now());
        recipe.setVegetarianDish(createRecipeDto.isVegetarianDish());
        recipe.setNumberOfPeople(createRecipeDto.getNumberOfPeople());
        recipe.setCookingInstructions(createRecipeDto.getCookingInstructions());
        recipe.setIngredients(createRecipeDto.getIngredients());
        return recipe;
    }

    public Recipe toEntity(UpdateRecipeDto updateRecipeDto, LocalDateTime localDateTime) {
        Recipe recipe = new Recipe();
        recipe.setId(updateRecipeDto.getId());
        recipe.setTitle(updateRecipeDto.getTitle());
        recipe.setCreationDateTime(localDateTime);
        recipe.setVegetarianDish(updateRecipeDto.isVegetarianDish());
        recipe.setNumberOfPeople(updateRecipeDto.getNumberOfPeople());
        recipe.setCookingInstructions(updateRecipeDto.getCookingInstructions());
        recipe.setIngredients(updateRecipeDto.getIngredients());
        return recipe;
    }
}
