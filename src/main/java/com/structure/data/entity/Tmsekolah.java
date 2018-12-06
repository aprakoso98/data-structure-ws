package com.structure.data.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.structure.data.util.CustomDateJsonDeserializer;
import com.structure.data.util.CustomDateJsonSerializer;

public class Tmsekolah {

	private String idSekolah;
	private String namaSekolah;
	private String alamat;
	@JsonSerialize(using = CustomDateJsonSerializer.class)
    @JsonDeserialize(using = CustomDateJsonDeserializer.class)
	private Date tglBerdiri;

	public String getIdSekolah() {
		return idSekolah;
	}

	public void setIdSekolah(String idSekolah) {
		this.idSekolah = idSekolah;
	}

	public String getNamaSekolah() {
		return namaSekolah;
	}

	public void setNamaSekolah(String namaSekolah) {
		this.namaSekolah = namaSekolah;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Date getTglBerdiri() {
		return tglBerdiri;
	}

	public void setTglBerdiri(Date tglBerdiri) {
		this.tglBerdiri = tglBerdiri;
	}

}
