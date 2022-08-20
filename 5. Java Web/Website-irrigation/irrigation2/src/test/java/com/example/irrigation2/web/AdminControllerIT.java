package com.example.irrigation2.web;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//    @Test
//    @WithMockUser(roles = "ADMIN")
//    void testGetSprinkler() throws Exception {
//        mockMvc.perform(get("/admin/sprinklers")
//                        .with(user("stoev.stefan@.gmail.com").password("123")))
//                .andExpect(status().isOk());
//
////        mockMvc.perform(get("/admin/sprinklers")
////                        .with(user("stoev.stefan@.gmail.com").password("123")))
////                .andExpect(status().isOk())
////                .andExpect(view().name("add-sprinklers"));
//    }
//
//    @Test
//    void testAddSprinkler() throws Exception {
//        mockMvc.perform(post("/admin/sprinklers")
//                        .param("kind", "Роторен разпръсквач")
//                        .param("model", "Drip-39")
//                        .param("make", "Late")
//                        .param("code", "01002")
//                )
//                .andExpect(status().isOk())
//                .andExpect(redirectedUrl("/admin/sprinklers"));
//    }
//
//    @Test
//    void testAddPump() throws Exception {
//        mockMvc.perform(get("/admin/sprinklers"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("add-sprinklers"));
//    }
}
