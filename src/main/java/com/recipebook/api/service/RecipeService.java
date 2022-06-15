
package com.recipebook.api.service;

import com.recipebook.api.dto.CreateRecipeDto;
import com.recipebook.api.dto.RecipeDto;
import com.recipebook.api.dto.UpdateRecipeDto;
import java.util.List;

public interface RecipeService {

    List<RecipeDto> findAll();

    RecipeDto findById(Long id);

    RecipeDto save(CreateRecipeDto createRecipeDto);

    RecipeDto updateById(Long id, UpdateRecipeDto updateRecipeDto);

    void deleteById(Long id);
}
