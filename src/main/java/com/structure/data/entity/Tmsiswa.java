package com.structure.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tmsiswa {

	@JsonProperty("NIS")
	private String nis;
	@JsonProperty("NISN")
	private String nisn;
	@JsonProperty("Nama")
	private String nama;
	@JsonProperty("Jenis Kelamin")
	private Character jenisKelamin;
	@JsonProperty("Tempat Lahir")
	private String tempatLahir;
	@JsonProperty("Agama")
	private String agama;
	@JsonProperty("Alamat")
	private String alamat;
	@JsonProperty("Kelas")
	private String kelas;

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getNisn() {
		return nisn;
	}

	public void setNisn(String nisn) {
		this.nisn = nisn;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Character getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(Character jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

}
