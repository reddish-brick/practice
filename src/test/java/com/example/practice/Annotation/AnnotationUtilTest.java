package com.example.practice.Annotation;

import com.example.practice.Annotation.SerializableAnnotation.AnnotationUtil;
import com.example.practice.Annotation.SerializableAnnotation.Person;
import io.katharsis.errorhandling.exception.JsonSerializationException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnnotationUtilTest {

  @Test
  public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
    Person person = new Person("soufiane", "cheouati", 34, "wuhan");
    AnnotationUtil annotationUtil = new AnnotationUtil();
    String jsonString = annotationUtil.convertToJson(person);

    assertEquals("{\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\",\"address\":\"wuhan\",\"age\":\"34\"}", jsonString);
  }
}