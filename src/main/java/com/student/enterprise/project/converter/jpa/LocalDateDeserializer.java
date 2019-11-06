package com.student.enterprise.project.converter.jpa;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

  private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    return LocalDate.parse(jsonParser.getText(), dtf);
  }
}
