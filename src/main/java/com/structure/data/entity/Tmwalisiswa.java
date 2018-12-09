package com.structure.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tmwalisiswa {

	@JsonProperty("NIS")
	private int nis;

	@JsonProperty("Nama Ayah")
	private String namaAyah;

	@JsonProperty("Tahun Lahir Ayah")
	private String tahunLahirAyah;

	@JsonProperty("Pendidikan Ayah")
	private String pendidikanAyah;

	@JsonProperty("Pekerjaan Ayah")
	private String pekerjaanAyah;

	@JsonProperty("Penghasilan Min Ayah")
	private Integer penghasilanMinAyah;

	@JsonProperty("Penghasilan Max Ayah")
	private Integer penghasilanMaxAyah;

	@JsonProperty("Nama Ibu")
	private String namaIbu;

	@JsonProperty("Tahun Lahir Ibu")
	private String tahunLahitIbu;

	@JsonProperty("Pendidikan Ibu")
	private String pendidikanIbu;

	@JsonProperty("Pekerjaan Ibu")
	private String pekerjaanIbu;

	@JsonProperty("Penghasilan Min Ibu")
	private Integer penghasilanMinIbu;

	@JsonProperty("Penghasilan Max Ibu")
	private Integer penghasilanMaxIbu;

	public int getNis() {
		return nis;
	}

	public void setNis(int nis) {
		this.nis = nis;
	}

	public String getNamaAyah() {
		return namaAyah;
	}

	public void setNamaAyah(String namaAyah) {
		this.namaAyah = namaAyah;
	}

	public String getTahunLahirAyah() {
		return tahunLahirAyah;
	}

	public void setTahunLahirAyah(String tahunLahirAyah) {
		this.tahunLahirAyah = tahunLahirAyah;
	}

	public String getPendidikanAyah() {
		return pendidikanAyah;
	}

	public void setPendidikanAyah(String pendidikanAyah) {
		this.pendidikanAyah = pendidikanAyah;
	}

	public String getPekerjaanAyah() {
		return pekerjaanAyah;
	}

	public void setPekerjaanAyah(String pekerjaanAyah) {
		this.pekerjaanAyah = pekerjaanAyah;
	}

	public Integer getPenghasilanMinAyah() {
		return penghasilanMinAyah;
	}

	public void setPenghasilanMinAyah(Integer penghasilanMinAyah) {
		this.penghasilanMinAyah = penghasilanMinAyah;
	}

	public Integer getPenghasilanMaxAyah() {
		return penghasilanMaxAyah;
	}

	public void setPenghasilanMaxAyah(Integer penghasilanMaxAyah) {
		this.penghasilanMaxAyah = penghasilanMaxAyah;
	}

	public String getNamaIbu() {
		return namaIbu;
	}

	public void setNamaIbu(String namaIbu) {
		this.namaIbu = namaIbu;
	}

	public String getTahunLahitIbu() {
		return tahunLahitIbu;
	}

	public void setTahunLahitIbu(String tahunLahitIbu) {
		this.tahunLahitIbu = tahunLahitIbu;
	}

	public String getPendidikanIbu() {
		return pendidikanIbu;
	}

	public void setPendidikanIbu(String pendidikanIbu) {
		this.pendidikanIbu = pendidikanIbu;
	}

	public String getPekerjaanIbu() {
		return pekerjaanIbu;
	}

	public void setPekerjaanIbu(String pekerjaanIbu) {
		this.pekerjaanIbu = pekerjaanIbu;
	}

	public Integer getPenghasilanMinIbu() {
		return penghasilanMinIbu;
	}

	public void setPenghasilanMinIbu(Integer penghasilanMinIbu) {
		this.penghasilanMinIbu = penghasilanMinIbu;
	}

	public Integer getPenghasilanMaxIbu() {
		return penghasilanMaxIbu;
	}

	public void setPenghasilanMaxIbu(Integer penghasilanMaxIbu) {
		this.penghasilanMaxIbu = penghasilanMaxIbu;
	}

}
