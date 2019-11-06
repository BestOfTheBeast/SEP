package com.student.enterprise.project.converter.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.enterprise.project.exception.ConverterException;
import java.io.IOException;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ListJsonStringConverter implements AttributeConverter<List<String>, String> {

  private final ObjectMapper mapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(List<String> events) {
    try {
      if (events == null) {
        return null;
      }
      return mapper.writeValueAsString(events);
    } catch (JsonProcessingException e) {
      throw new ConverterException(String.format("Could not parse json events [%s].", events), e);
    }
  }

  @Override
  public List<String> convertToEntityAttribute(String events) {
    try {
      if (events == null) {
        return null;
      }
      return mapper.readValue(events, new TypeReference<List<String>>() {
      });
    } catch (IOException e) {
      throw new ConverterException(String.format("Could not parse json events [%s].", events), e);
    }
  }
}
