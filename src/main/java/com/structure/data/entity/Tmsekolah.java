package com.structure.data.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.structure.data.util.CustomDateJsonDeserializer;
import com.structure.data.util.CustomDateJsonSerializer;

public class Tmsekolah {

	@JsonProperty("ID Sekolah")
	private String idSekolah;

	@JsonProperty("Nama Sekolah")
	private String namaSekolah;

	@JsonProperty("Alamat")
	private String alamat;

	@JsonSerialize(using = CustomDateJsonSerializer.class)
	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	@JsonProperty("Tanggal Berdiri")
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
