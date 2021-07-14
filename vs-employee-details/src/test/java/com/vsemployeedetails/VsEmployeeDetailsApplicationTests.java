package com.vsemployeedetails;

import static org.assertj.core.api.Assertions.assertThat;

import com.vsemployeedetails.entity.Employee;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.assertj.core.api.Assertions;
import org.h2.util.IOUtils;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@Ignore
class VsEmployeeDetailsApplicationTests {


  @Autowired
  private RestTemplate restTemplate;

  private String URL = "http://localhost:8890/employee/save";

  @Test
  @Ignore
  public void saveUser() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final String json = new StringBuilder().append("{\n").append("  \"name\" : \"Rohini Jasrotia\",\n")
        .append("  \"email\" : \"Rohini@gmail.com\",\n").append("  \"employee_details\" : {\n")
        .append("    \"state\" : \"J&K\",\n").append("    \"phoneNumber\" : \"95903219707\",\n")
        .append("    \"gender\": \"FEMALE\",\n").append("    \"zipCode\" : \"184148\",\n")
        .append("    \"street\" : \"Marheen\",\n").append("    \"dateOfBirth\" : \"29-05-1991\"\n").append("  }\n")
        .append("}").toString();
       // readFile("/post_request.json");
    HttpEntity<String> requestBody = new HttpEntity<>(json,httpHeaders);
    final Object response = restTemplate.postForObject(URL, requestBody, Object.class);
    System.out.println(response);
  }

  private String readFile(String filePath) {
    try {
      return new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException e) {
      throw new RuntimeException("Not able to Read");
    }
  }

  @Test
  @Ignore
  public void fetchUser() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    final ResponseEntity<String> forEntity =
        restTemplate.getForEntity("http://localhost:8890/employee/fetchAllEmployee", String.class, new HttpHeaders());
    System.out.println(" ***** FETCH ***** "+ forEntity.getBody());

  }

}
