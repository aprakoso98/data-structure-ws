package com.structure.data.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateJsonDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			return sdf.parse(jp.getText());
		} catch (ParseException ex) {
			Logger.getLogger(CustomDateJsonDeserializer.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

}
