package com.enviro.assessment.grad001.KatlegoDhlamini.Services;

import com.enviro.assessment.grad001.KatlegoDhlamini.Entity.WasteCategory;
import com.enviro.assessment.grad001.KatlegoDhlamini.Repo.WasteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WasteCategoryServiceTest {

    @Mock
    private WasteRepository wasteRepository;

    @InjectMocks
    private WasteCategoryService wasteCategoryService;

    private WasteCategory wasteCategory;

    @BeforeEach
    void setUp() {
        wasteCategory = new WasteCategory();
        wasteCategory.setId(1);
        wasteCategory.setName("Plastic");
        wasteCategory.setDescription("Plastic waste category");
        wasteCategory.setRecyclingTip("Clean before recycling");
        wasteCategory.setDisposalGuideline("Recycle");
    }

    @Test
    void testGetAllCategories() {
        when(wasteRepository.findAll()).thenReturn(Arrays.asList(wasteCategory));

        List<WasteCategory> categories = wasteCategoryService.getAllCategories();

        assertNotNull(categories);
        assertEquals(1, categories.size());
        assertEquals("Plastic", categories.get(0).getName());
        verify(wasteRepository, times(1)).findAll();
    }

    @Test
    void testGetCategoryById() {
        when(wasteRepository.findById(1)).thenReturn(Optional.of(wasteCategory));

        WasteCategory result = wasteCategoryService.getCategoryById(1);

        assertNotNull(result);
        assertEquals("Plastic", result.getName());
        verify(wasteRepository, times(1)).findById(1);
    }

    @Test
    void testGetCategoryById_NotFound() {
        when(wasteRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            wasteCategoryService.getCategoryById(1);
        });

        assertEquals("Category not found", exception.getMessage());
        verify(wasteRepository, times(1)).findById(1);
    }

    @Test
    void testSaveCategory() {
        when(wasteRepository.save(any(WasteCategory.class))).thenReturn(wasteCategory);

        WasteCategory savedCategory = wasteCategoryService.saveCategory(wasteCategory);

        assertNotNull(savedCategory);
        assertEquals("Plastic", savedCategory.getName());
        verify(wasteRepository, times(1)).save(wasteCategory);
    }

    @Test
    void testUpdateCategory() {
        WasteCategory updatedCategory = new WasteCategory();
        updatedCategory.setName("Metal");
        updatedCategory.setDescription("Metal waste category");
        updatedCategory.setRecyclingTip("Sort before recycling");
        updatedCategory.setDisposalGuideline("Recycle separately");

        when(wasteRepository.findById(1)).thenReturn(Optional.of(wasteCategory));
        when(wasteRepository.save(any(WasteCategory.class))).thenReturn(updatedCategory);

        WasteCategory result = wasteCategoryService.updateCategory(1, updatedCategory);

        assertNotNull(result);
        assertEquals("Metal", result.getName());
        verify(wasteRepository, times(1)).findById(1);
        verify(wasteRepository, times(1)).save(wasteCategory);
    }

    @Test
    void testDeleteCategory_Success() {
        when(wasteRepository.existsById(1)).thenReturn(true);
        doNothing().when(wasteRepository).deleteById(1);

        boolean result = wasteCategoryService.deleteCategory(1);

        assertTrue(result);
        verify(wasteRepository, times(1)).existsById(1);
        verify(wasteRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteCategory_NotFound() {
        when(wasteRepository.existsById(1)).thenReturn(false);

        boolean result = wasteCategoryService.deleteCategory(1);

        assertFalse(result);
        verify(wasteRepository, times(1)).existsById(1);
        verify(wasteRepository, never()).deleteById(1);
    }

    @Test
    void testFindCategoryByName() {
        when(wasteRepository.findByNameIgnoreCase("Plastic")).thenReturn(Optional.of(wasteCategory));

        Optional<WasteCategory> result = wasteCategoryService.findCategoryByName("Plastic");

        assertTrue(result.isPresent());
        assertEquals("Plastic", result.get().getName());
        verify(wasteRepository, times(1)).findByNameIgnoreCase("Plastic");
    }

    @Test
    void testFindCategoryByName_NotFound() {
        when(wasteRepository.findByNameIgnoreCase("Plastic")).thenReturn(Optional.empty());

        Optional<WasteCategory> result = wasteCategoryService.findCategoryByName("Plastic");

        assertFalse(result.isPresent());
        verify(wasteRepository, times(1)).findByNameIgnoreCase("Plastic");
    }
}
