package com.example.practice.PropertySourceByJson.test2;

import com.example.practice.PracticeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(
    classes = PracticeApplication.class)
public class ConfigTest {

  @Autowired
  private PersonCfg personCfg;

  @Test
  public void testConfigBeans() throws Exception {
    System.out.printf("Use '@Configuration' autowired beans : %s%n", personCfg);
  }
}