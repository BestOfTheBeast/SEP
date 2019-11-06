package com.student.enterprise.project.converter.jpa;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

  private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxx");

  @Override
  public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    return LocalDateTime.parse(jsonParser.getText(), dtf);
  }
}



