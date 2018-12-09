package com.structure.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tmguru {

	@JsonProperty("ID Guru")
	private String idGuru;

	@JsonProperty("NIP")
	private String nip;

	@JsonProperty("Nama Guru")
	private String namaGuru;

	@JsonProperty("Alamat")
	private String alamat;

	public String getIdGuru() {
		return idGuru;
	}

	public void setIdGuru(String idGuru) {
		this.idGuru = idGuru;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNamaGuru() {
		return namaGuru;
	}

	public void setNamaGuru(String namaGuru) {
		this.namaGuru = namaGuru;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

}
