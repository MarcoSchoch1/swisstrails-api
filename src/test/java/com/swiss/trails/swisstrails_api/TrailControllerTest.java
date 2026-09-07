package com.swiss.trails.swisstrails_api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.swiss.trails.swisstrails_api.controller.TrailController;
import com.swiss.trails.swisstrails_api.service.TrailService;

@WebMvcTest  (TrailController.class)
public class TrailControllerTest {
    @Autowired  
    MockMvc mockMvc;

    @MockitoBean  
    TrailService trailService;

    @Test 
    void getTrailsReturns200() throws Exception {
        mockMvc.perform(get("/api/trails")).andExpect(status().isOk());
    }
}
