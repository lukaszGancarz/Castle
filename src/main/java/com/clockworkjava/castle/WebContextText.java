package com.clockworkjava.castle;

import com.clockworkjava.castle.controller.QuestController;
import com.clockworkjava.castle.domain.PlayerInformation;
import com.clockworkjava.castle.services.KnightService;
import com.clockworkjava.castle.services.QuestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class WebContextText {

    @Mock
    KnightService knightService;

    @Mock
    QuestService questService;

    @Mock
    PlayerInformation playerInformation;

    @InjectMocks   //będzie miał wstrzyknięte mocki trzeh serwisów
    QuestController questController;

    private MockMvc mockMvc;

    @Before  //Wykonuje się przed każdym testem
    public void setUp() {
        MockitoAnnotations.initMocks(this);  //aktywacja wszystkich mocków
        mockMvc = MockMvcBuilders.standaloneSetup(questController).build();   //buduje mocka
    }

    @Test
    public void testCheckQuest() throws Exception{

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/checkQuests");
        this.mockMvc.perform(builder)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/knights"));
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void questControllerTest(){

    }
}
