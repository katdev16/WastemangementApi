package com.enviro.assessment.grad001.KatlegoDhlamini.Entity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class WasteCategoryTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testWasteCategory_SetAndGetFields() {
        WasteCategory category = new WasteCategory();
        category.setId(1);
        category.setName("Plastic");
        category.setDescription("Recyclable plastic waste");
        category.setDisposalGuideline("Dispose in recycling bins");
        category.setRecyclingTip("Clean before recycling");

        assertEquals(1, category.getId());
        assertEquals("Plastic", category.getName());
        assertEquals("Recyclable plastic waste", category.getDescription());
        assertEquals("Dispose in recycling bins", category.getDisposalGuideline());
        assertEquals("Clean before recycling", category.getRecyclingTip());
    }

    @Test
    void testValidation_ValidWasteCategory() {
        WasteCategory category = new WasteCategory();
        category.setName("Paper");
        category.setDescription("Used paper products");
        category.setDisposalGuideline("Recycle in paper bins");
        category.setRecyclingTip("Avoid wet paper");

        Set<ConstraintViolation<WasteCategory>> violations = validator.validate(category);
        assertTrue(violations.isEmpty(), "No validation errors expected for a valid entity");
    }

    @Test
    void testValidation_BlankName_ShouldFail() {
        WasteCategory category = new WasteCategory();
        category.setName(""); // Invalid
        category.setDescription("Recyclable glass");
        category.setDisposalGuideline("Use glass recycling bins");
        category.setRecyclingTip("Avoid broken glass");

        Set<ConstraintViolation<WasteCategory>> violations = validator.validate(category);
        assertFalse(violations.isEmpty(), "Expected validation errors for blank name");
    }

    @Test
    void testValidation_LongName_ShouldFail() {
        WasteCategory category = new WasteCategory();
        category.setName("A".repeat(101)); // Exceeds 100 characters
        category.setDescription("Recyclable metal");
        category.setDisposalGuideline("Separate by type");
        category.setRecyclingTip("Check for rust");

        Set<ConstraintViolation<WasteCategory>> violations = validator.validate(category);
        assertFalse(violations.isEmpty(), "Expected validation errors for name exceeding 100 characters");
    }
}
