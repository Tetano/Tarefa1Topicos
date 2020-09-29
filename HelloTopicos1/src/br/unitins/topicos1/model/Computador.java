package br.unitins.topicos1.model;

import java.time.LocalDate;

public class Computador {
	private Integer id;
	private String cpf;
	private String placaMae;
	private LocalDate dataCompra;
	private String placaDeVideo;
	private String memoria;
	private String processador;
	private String fonte;
	private String objetivo;
	private boolean limpo;
	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlacaMae() {
		return placaMae;
	}
	public void setPlacaMae(String placaMae) {
		this.placaMae = placaMae;
	}
	public String getPlacaDeVideo() {
		return placaDeVideo;
	}
	public void setPlacaDeVideo(String placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}
	public String getMemoria() {
		return memoria;
	}
	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}
	public String getProcessador() {
		return processador;
	}
	public void setProcessador(String processador) {
		this.processador = processador;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public boolean isLimpo() {
		return limpo;
	}
	public void setLimpo(boolean limpo) {
		this.limpo = limpo;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	



}
