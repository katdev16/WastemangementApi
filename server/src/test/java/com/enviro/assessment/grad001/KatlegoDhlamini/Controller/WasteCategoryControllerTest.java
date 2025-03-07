package com.enviro.assessment.grad001.KatlegoDhlamini.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WasteCategoryControllerTest {

    @Autowired
    private RestTemplate restTemplate;  // Autowired RestTemplate to make HTTP requests

    private final String baseUrl = "http://localhost:8080/api/waste-categories";
    private int createdCategoryId;
    @BeforeEach
    public void setUp() {
        // Create a category before each test
        String categoryJson = "{"
                + "\"name\": \"Plastic\","
                + "\"description\": \"Plastic waste category\","
                + "\"recyclingTip\": \"Clean before recycling\","
                + "\"disposalGuideline\": \"Recycle\""
                + "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(categoryJson, headers);

        // Create the category by sending the POST request
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.POST, request, String.class);

        // Check if the response status is CREATED (201), and retrieve the created category ID
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Response status should be CREATED");

        // Assuming the response contains the ID of the created category (if returned by the API)
        // For now, we can assume it is the first category in the database.
        createdCategoryId = 0;  // You can adjust this based on the response or test DB
    }
//    @AfterEach
//    public void tearDown() {
//        // Clean up after each test by deleting the category
//        if (createdCategoryId > 0) {
//            restTemplate.exchange(baseUrl + "/" + createdCategoryId, HttpMethod.DELETE, null, Void.class);
//        }
//    }

    @Test
    public void testGetAllCategories() {
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be OK");
    }

    @Test
    public void testGetCategoryById() {
        int testCategoryId = 2;  // Use a valid category ID from your DB
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/" + testCategoryId, HttpMethod.GET, null, String.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be OK");
    }

    @Test
    public void testCreateCategory() {
        // Prepare the JSON payload for the request
        String categoryJson = "{"
                + "\"name\": \"Plastic\","
                + "\"description\": \"Plastic waste category\","
                + "\"recyclingTip\": \"Clean before recycling\","
                + "\"disposalGuideline\": \"Recycle\""
                + "}";
        // Debug point 1: Before sending the request
        System.out.println("Creating category with the following JSON: " + categoryJson);



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(categoryJson, headers);

        // Debug point 2: Inspecting the request entity
        System.out.println("Request Entity: " + request);

        // Send the HTTP POST request to create a new category
        ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.POST, request, String.class);

        // Debug point 3: After sending the request, inspect the response
        System.out.println("Response: " + response);

        // Assert that the response status is OK (HTTP 200)
        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Response status should be OK");
    }


    @Test
    public void testUpdateCategory() {
        // Define the category ID for the existing category.
        // Define the JSON string representing the updated category details.
        String categoryJson = "{"
                + "\"name\": \"Updated Plastic\","
                + "\"description\": \"Updated plastic waste category\","
                + "\"disposalGuideline\": \"Recycle Updated\","
                + "\"recyclingTip\": \"Clean before recycling Updated\""
                + "}";
        int categoryId = 1; // Use an existing ID
        System.out.println("Category ID: " + categoryId);  // Debug point to verify the categoryId


        System.out.println("Request Body (Category JSON): " + categoryJson);  // Debug point to verify the category JSON

        // Create headers for the request, including content type.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("Request Headers: " + headers);  // Debug point to verify the headers

        // Create the request entity with the body and headers.
        HttpEntity<String> request = new HttpEntity<>(categoryJson, headers);
        System.out.println("Request Entity: " + request);  // Debug point to inspect the full request entity

        // Make the PUT request using RestTemplate to update the category.
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/" + categoryId, HttpMethod.PUT, request, String.class);
        System.out.println("Response Status Code: " + response.getStatusCode());  // Debug point to check the status code of the response
        System.out.println("Response Body: " + response.getBody());  // Debug point to inspect the response body
        System.out.println(response.getStatusCode());
        // Verify that the response status is OK (200).
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be OK");
    }


    @Test
    public void testDeleteCategory() {
        int categoryId = 1;  // Use a valid category ID
        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/" + categoryId, HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode(), "Response status should be NO_CONTENT");
    }
    @Test
    public void testGetCategoryByName() {
        String categoryName = "Plastic";  // Use the name of the category to query
        String url = baseUrl + "/lookup?name=" + categoryName;

        // Send GET request with query parameter to look up by category name
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

        // Output the status code to debug
        System.out.println(response.getStatusCode());

        // Assert that the response status is OK (200)
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Response status should be OK");

        // Optional: Assert that the response body contains the expected category name
        String responseBody = response.getBody();
        assertNotNull(responseBody, "Response body should not be null");
        assertTrue(responseBody.contains(categoryName), "Response body should contain the category name");
    }
}
