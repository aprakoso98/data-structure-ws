package com.structure.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tmkelas {

	@JsonProperty("ID Kelas")
	private String idKelas;

	@JsonProperty("ID Wali Kelas")
	private String idWalikelas;

	@JsonProperty("Jumlah Kursi")
	private Integer jumlahKursi;

	@JsonProperty("Jumlah Meja")
	private Integer jumlahMeja;

	public String getIdKelas() {
		return idKelas;
	}

	public void setIdKelas(String idKelas) {
		this.idKelas = idKelas;
	}

	public String getIdWalikelas() {
		return idWalikelas;
	}

	public void setIdWalikelas(String idWalikelas) {
		this.idWalikelas = idWalikelas;
	}

	public Integer getJumlahKursi() {
		return jumlahKursi;
	}

	public void setJumlahKursi(Integer jumlahKursi) {
		this.jumlahKursi = jumlahKursi;
	}

	public Integer getJumlahMeja() {
		return jumlahMeja;
	}

	public void setJumlahMeja(Integer jumlahMeja) {
		this.jumlahMeja = jumlahMeja;
	}

}
