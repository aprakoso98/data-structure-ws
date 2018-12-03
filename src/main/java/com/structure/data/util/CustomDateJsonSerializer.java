package com.structure.data.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateJsonSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date d, JsonGenerator json, SerializerProvider sp)
			throws IOException, JsonProcessingException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		String strSdf = sdf.format(d);
		json.writeString(strSdf);
	}

}
