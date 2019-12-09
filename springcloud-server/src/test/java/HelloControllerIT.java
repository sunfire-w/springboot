
import com.platform.SpringBootExampleApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.platform.properties.ConfigProperties;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootExampleApplication.class )
public class HelloControllerIT {
    private URL base;
//    @Autowired
//    private TestRestTemplate restTemplate;
    @Autowired
    private ConfigProperties configProperties;
//    @Bean
//    public TestRestTemplate restTemplate(){
//       return new TestRestTemplate();
//   }
    @Before
    public void setup() throws Exception {
        this.base = new URL("http://localhost:8080/apis/v1.0/hello");
    }
    @Test
    public void getHello() throws Exception {
        //SpringCould调用restTemplate远程调用
        ResponseEntity<String> response =new TestRestTemplate().getForEntity(base.toString(),String.class);
        System.out.println(response.getBody());
        System.out.println("Hi"+configProperties.getName());
    }
}
