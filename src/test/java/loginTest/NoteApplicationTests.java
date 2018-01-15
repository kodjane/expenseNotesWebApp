package loginTest;

import com.msf.ict.NoteApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Kodjane Aime Dieudonne
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=NoteApplication.class, loader=AnnotationConfigWebContextLoader.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
@AutoConfigureMockMvc
@PropertySource("classpath:application.properties")
public class NoteApplicationTests {
     @Autowired
    private MockMvc mvc; 
    private String username;
    private String password;
    @Before
    public void setUp() {
      username="user";
      password="password ";
    }
    @Test
    public void test() throws Exception {
      
         /*mvc.perform(MockMvcRequestBuilders.get("/login").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));*/
         
         /*mvc.perform(MockMvcRequestBuilders.get("/ajoutPizza").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(view().name("pizzaForm"));*/
              
               //Test  de login
                 mvc.perform(MockMvcRequestBuilders.post("/login").accept(MediaType.APPLICATION_JSON)
                    .param("username",username)
                    .param("password", password))
                    .andExpect(status().is(302))
                    .andExpect( redirectedUrl("/"));
                //Test avec erreur
               /* mvc.perform(MockMvcRequestBuilders.post("/ajoutPizza").accept(MediaType.APPLICATION_JSON)
                    .param("nom_type", nom_typeErrone))
                    .andExpect(status().is(200))
                    .andExpect(view().name("pizzaForm"))
                    .andExpect(model().attributeHasFieldErrors("pizza", "nom_type"));*/
               
    }
  
}
