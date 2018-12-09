package com.structure.data.util;

import java.util.List;

public class DataTablesResponse {

	private List<String> column;
	private List data;

	public List<String> getColumn() {
		return column;
	}

	public void setColumn(List<String> column) {
		this.column = column;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
