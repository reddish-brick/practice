package com.example.practice.PropertySourceByJson.test1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.practice.PracticeApplication;
import java.util.Arrays;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(
    classes = PracticeApplication.class)
public class JsonPropertiesTest {

  @Autowired
  private JsonProperties jsonProperties;

  @Test
  public void whenPropertiesLoadedViaJsonPropertySource_thenLoadFlatValues() {
    assertEquals("mailer@mail.com", jsonProperties.getHost());
    assertEquals(9090, jsonProperties.getPort());
    assertTrue(jsonProperties.isResend());
  }

  @Test
  public void whenPropertiesLoadedViaJsonPropertySource_thenLoadListValues() {
    assertThat(
        jsonProperties.getTopics(),
        Matchers.is(Arrays.asList("spring", "boot")));
  }

  @Test
  public void whenPropertiesLoadedViaJsonPropertySource_thenNestedLoadedAsMap() {
    assertEquals("sender", jsonProperties.getSender().get("name"));
    assertEquals("street", jsonProperties.getSender().get("address"));
  }
}