
package com.recipebook.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.recipebook.api.dto.RecipeDto;
import com.recipebook.api.entity.Ingredient;
import com.recipebook.api.entity.Recipe;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class RecipeMapperTest {

    @Test
    void testRecipeEntityToRecipeDtoConversion() {
        Recipe recipe = new Recipe(100L, "awesome recipe", LocalDateTime.now(), true, 3,
                "instructions",
                new HashSet<Ingredient>(Arrays.asList(new Ingredient("item1", "quantity1"))));

        RecipeMapper recipeMapper = new RecipeMapper();
        RecipeDto recipeDto = recipeMapper.toDto(recipe);

        assertEquals(recipeDto.getId(), recipe.getId());
        assertEquals(recipeDto.getTitle(), recipe.getTitle());
        assertEquals(recipeDto.getCreationDateTime(), recipe.getCreationDateTime());
        assertEquals(recipeDto.isVegetarianDish(), recipe.isVegetarianDish());
        assertEquals(recipeDto.getNumberOfPeople(), recipe.getNumberOfPeople());
        assertEquals(recipeDto.getCookingInstructions(), recipe.getCookingInstructions());
    }

    @Test
    void testRecipeDtoToRecipeEntityConversion() {
        RecipeDto recipeDto = new RecipeDto(200L, "another awesome recipe", LocalDateTime.now(),
                false, 5, "instructions",
                new HashSet<Ingredient>(Arrays.asList(new Ingredient("item1", "quantity1"))));

        RecipeMapper recipeMapper = new RecipeMapper();
        Recipe recipe = recipeMapper.toEntity(recipeDto);

        assertEquals(recipe.getId(), recipeDto.getId());
        assertEquals(recipe.getTitle(), recipeDto.getTitle());
        assertEquals(recipe.getCreationDateTime(), recipeDto.getCreationDateTime());
        assertEquals(recipe.isVegetarianDish(), recipeDto.isVegetarianDish());
        assertEquals(recipe.getNumberOfPeople(), recipeDto.getNumberOfPeople());
        assertEquals(recipe.getCookingInstructions(), recipeDto.getCookingInstructions());
    }
}
