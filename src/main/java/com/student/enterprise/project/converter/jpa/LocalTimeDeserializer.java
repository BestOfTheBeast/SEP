package com.student.enterprise.project.converter.jpa;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {

  private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

  @Override
  public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    return LocalTime.parse(jsonParser.getText(), dtf);
  }
}
