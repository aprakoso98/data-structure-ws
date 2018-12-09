package com.structure.data.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.structure.data.util.CustomDateJsonDeserializer;
import com.structure.data.util.CustomDateJsonSerializer;

public class MutasiSiswa {

	@JsonProperty("NIS")
	private String nis;

	@JsonProperty("NISN")
	private String nisn;

	@JsonProperty("Nama")
	private String nama;

	@JsonProperty("Jenis Kelamin")
	private String jenisKelamin;

	@JsonProperty("Tempat Lahir")
	private String tempatLahir;

	@JsonProperty("Tanggal Lahir")
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	private Date tglLahir;

	@JsonProperty("Agama")
	private String agama;

	@JsonProperty("Alamat")
	private String alamat;

	@JsonProperty("Kelas")
	private String kelas;

	@JsonProperty("Asal Sekolah")
	private String asalSekolah;

	@JsonProperty("Created Date")
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	private Date createdDt;

	@JsonProperty("Modified Date")
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	private Date modifiedDt;

	@JsonProperty("Status")
	private String status;

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

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
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

	public String getAsalSekolah() {
		return asalSekolah;
	}

	public void setAsalSekolah(String asalSekolah) {
		this.asalSekolah = asalSekolah;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
