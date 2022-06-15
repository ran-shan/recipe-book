
package com.recipebook.api.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipebook.api.dto.RecipeDto;
import com.recipebook.api.entity.Ingredient;
import com.recipebook.api.service.RecipeServiceImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Basic Unit tests for {@link RecipeController} API endpoints (in
 * Given-When-Then style).
 */
@WebMvcTest(controllers = RecipeController.class)
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RecipeServiceImpl recipeServiceImpl;

    @Test
    void findAll_success() throws Exception {
        RecipeDto recipeDto1 = new RecipeDto(100L, "recipe10", LocalDateTime.now(), true, 10,
                "instructions10",
                new HashSet<Ingredient>(Arrays.asList(new Ingredient("item10", "quantity10"))));
        RecipeDto recipeDto2 = new RecipeDto(110L, "recipe11", LocalDateTime.now(), true, 11,
                "instructions11",
                new HashSet<Ingredient>(Arrays.asList(new Ingredient("item11", "quantity11"))));
        List<RecipeDto> recipeDtos = new ArrayList<>();
        recipeDtos.add(recipeDto1);
        recipeDtos.add(recipeDto2);

        Mockito.when(recipeServiceImpl.findAll()).thenReturn(recipeDtos);

        mockMvc.perform(get("/api/v1/recipes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void findById_success() throws Exception {
        RecipeDto recipeDto = new RecipeDto(200L, "recipe20", LocalDateTime.now(), true, 20,
                "instructions20",
                new HashSet<Ingredient>(Arrays.asList(new Ingredient("item20", "quantity20"))));

        Mockito.when(recipeServiceImpl.findById(200L)).thenReturn(recipeDto);

        mockMvc.perform(get("/api/v1/recipes/200")).andDo(print()).andExpect(status().isOk());
    }
}
