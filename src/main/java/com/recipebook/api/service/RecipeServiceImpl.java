
package com.recipebook.api.service;

import com.recipebook.api.dto.CreateRecipeDto;
import com.recipebook.api.dto.RecipeDto;
import com.recipebook.api.dto.UpdateRecipeDto;
import com.recipebook.api.entity.Recipe;
import com.recipebook.api.exception.ApiEntityNotFoundException;
import com.recipebook.api.exception.ApiMalformedRequestException;
import com.recipebook.api.exception.RecipeTitleDuplicateException;
import com.recipebook.api.mapper.RecipeMapper;
import com.recipebook.api.repository.RecipeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    private static final String RECIPE = "Recipe";
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDto> findAll() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto findById(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ApiEntityNotFoundException(RECIPE, id.toString()));
        return recipeMapper.toDto(recipe);
    }

    @Override
    public RecipeDto save(CreateRecipeDto createRecipeDto) {
        try {
            Recipe recipe = recipeRepository.save(recipeMapper.toEntity(createRecipeDto));
            return recipeMapper.toDto(recipe);
        } catch (DataIntegrityViolationException e) {
            throw new RecipeTitleDuplicateException(e);
        }
    }

    @Override
    public RecipeDto updateById(Long id, UpdateRecipeDto updateRecipeDto) {
        if (updateRecipeDto.getId() == null || !updateRecipeDto.getId().equals(id)) {
            throw new ApiMalformedRequestException(RECIPE);
        }
        Recipe savedRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new ApiEntityNotFoundException(RECIPE, id.toString()));
        Recipe recipe = recipeRepository
                .save(recipeMapper.toEntity(updateRecipeDto, savedRecipe.getCreationDateTime()));
        return recipeMapper.toDto(recipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.findById(id)
                .orElseThrow(() -> new ApiEntityNotFoundException(RECIPE, id.toString()));
        recipeRepository.deleteById(id);
    }
}
