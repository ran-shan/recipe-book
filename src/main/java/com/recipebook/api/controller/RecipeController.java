
package com.recipebook.api.controller;

import com.recipebook.api.dto.CreateRecipeDto;
import com.recipebook.api.dto.RecipeDto;
import com.recipebook.api.dto.UpdateRecipeDto;
import com.recipebook.api.entity.Recipe;
import com.recipebook.api.service.RecipeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>RecipeController</code> is rest controller that provides CRUD
 * operations to manipulate {@link Recipe} entity.
 */
@RestController
public class RecipeController {
    private final RecipeServiceImpl recipeService;

    RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Call to this endpoint will return list of all Recipes.
     *
     * @return {@link ResponseEntity} with {@link HttpStatus#OK} and Recipes list
     */
    @Operation(summary = "Get all Recipes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "All Recipes in 'Content-Type: application/json' format."),
            @ApiResponse(responseCode = "400", description = "", content = @Content),
            @ApiResponse(responseCode = "404", description = "", content = @Content)})
    @GetMapping("/api/v1/recipes")
    ResponseEntity<List<RecipeDto>> findAll() {
        List<RecipeDto> recipesDto = recipeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(recipesDto);
    }

    /**
     * Call to this endpoint will return a Recipe by ID.
     *
     * @param id Id of a Recipe
     * @return {@link ResponseEntity} with {@link HttpStatus#OK} and single Recipe
     */
    @Operation(summary = "Get a Recipe")
    @GetMapping("/api/v1/recipes/{id}")
    ResponseEntity<RecipeDto>
            findById(@Parameter(description = "Recipe id") @PathVariable Long id) {
        RecipeDto recipeDto = recipeService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(recipeDto);
    }

    /**
     * Call to this endpoint will persist a Recipe to database.
     *
     * @param createRecipeDto Recipe data to persist
     * @return {@link ResponseEntity} with {@link HttpStatus#CREATED} and newly
     *     created Recipe
     */
    @Operation(summary = "Create a Recipe")
    @PostMapping("/api/v1/recipes")
    ResponseEntity<RecipeDto> save(@Valid @RequestBody CreateRecipeDto createRecipeDto) {
        RecipeDto savedRecipeDto = recipeService.save(createRecipeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipeDto);
    }

    /**
     * Call to this endpoint will update a Recipe data.
     *
     * @param id Id of a Recipe
     * @param updateRecipeDto Recipe data to persist
     * @return {@link ResponseEntity} with {@link HttpStatus#CREATED} and updated
     *     Recipe
     */
    @Operation(summary = "Update a Recipe")
    @PutMapping("/api/v1/recipes/{id}")
    ResponseEntity<RecipeDto> updateById(
            @Parameter(description = "Recipe id") @PathVariable Long id,
            @Valid @RequestBody UpdateRecipeDto updateRecipeDto) {
        RecipeDto updatedRecipeDto = recipeService.updateById(id, updateRecipeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedRecipeDto);
    }

    /**
     * Call to this endpoint will delete a Recipe.
     *
     * @param id Id of a Recipe
     * @return {@link ResponseEntity} with {@link HttpStatus#NO_CONTENT}
     */
    @Operation(summary = "Delete a Recipe")
    @DeleteMapping("/api/v1/recipes/{id}")
    ResponseEntity<Void> deleteById(@Parameter(description = "Recipe id") @PathVariable Long id) {
        recipeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
