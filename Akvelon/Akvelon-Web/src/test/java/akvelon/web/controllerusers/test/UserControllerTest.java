/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.web.controllerusers.test;

import akvelon.domain.Users;
import akvelon.service.UsersService;
import akvelon.web.userscomtroller.UsersController;
import akvelon.web.validate.UsersValidate;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.validation.Errors;


//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration( classes = {WebAppIntitializer.class})
public class UserControllerTest {
    @Mock
    private UsersService usersService;
    
    @Mock
    private UsersValidate usersValidate;
 
    @InjectMocks
    private UsersController userController = new UsersController();
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
 
    }
        
    @Test
    public void getUsersListTest() throws Exception {
        

        mockMvc.perform(get("/","/startpage"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("startpage"));
    }
    
    
    @Test
    public void deleteUsersTest() throws Exception {

        mockMvc.perform(post("/delete")
            .param("check","5"))
            .andExpect(status().is(302))
            .andExpect(view().name("redirect:/startpage"));
    }
    
     @Test
    public void addUsersTest() throws Exception {
        mockMvc.perform(post("/addusers"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("addupdateuser"));
    }
    
    @Test
    public void updateUsersTest() throws Exception {
        when(usersService.getById(5)).thenReturn(new Users());
        mockMvc.perform(post("/update")
            .param("check","5"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("addupdateuser"));
    }
    
     @Test
    public void updateUserTest() throws Exception {
        mockMvc.perform(post("/saveuser")
            .param("id","5")
            .param("date","2016-09-13 23:08:44.0")
            .param("name", "Yevhen")
            .param("username", "Admin")
            .param("statusregistr", "true")
            .param("password", "Admin")
            .param("role", "Admin")
            .param("age", "24")
            .param("weight", "81.300"))
            .andExpect(status().is(302))
            .andExpect(view().name("redirect:/startpage"));
    }
    
     @Test
    public void saveUserTest() throws Exception {
//        Users o = new Users();
//        o.setId(5);
      // when(usersValidate.validate((Users.class, Errors.class)));
       when(usersService.save(any(Users.class))).thenReturn(5);
        mockMvc.perform(post("/savenewuser")
            .param("date","2016-09-13 23:08:44.0")
            .param("name", "Yevhen")
            .param("username", "Admin")
            .param("statusregistr", "true")
            .param("password", "Admin")
            .param("role", "Admin")
            .param("age", "24")
            .param("weight", "81.3"))
            .andExpect(status().is(302))
            .andExpect(view().name("redirect:/startpage"));
    }
}
    
    
    
