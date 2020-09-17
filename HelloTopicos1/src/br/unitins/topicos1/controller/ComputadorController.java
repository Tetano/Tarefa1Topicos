package br.unitins.topicos1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.topicos1.application.Util;
import br.unitins.topicos1.model.Computador;

@Named
@ViewScoped
public class ComputadorController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7748328763730744281L;
	private Computador computador;
	List<Computador> listaComputador;


	public void inserir() {
		if (computador.getPlacaMae().isEmpty() || computador.getProcessador().isEmpty()
				|| computador.getMemoria().isEmpty() || computador.getPlacaDeVideo().isEmpty()
				|| computador.getFonte().isEmpty()) {
			System.out.println("Não pode inserir valores nulos");

			Util.addMessage("Não pode inserir valores nulos");
			return;
		}
		System.out.println(computador.getPlacaMae().toString());
		System.out.println(computador.getProcessador().toString());
		System.out.println(computador.getMemoria().toString());
		System.out.println(computador.getPlacaDeVideo().toString());
		System.out.println(computador.getFonte().toString());
		System.out.println(computador.getId());

		getListaComputador().add(computador);
		limpar();
	}

	public void alterar() {
		int index = getListaComputador().indexOf(getComputador());
		getListaComputador().set(index, getComputador());
		return;
	}
	
	public void editar(Computador pc) {
		setComputador(pc);
	}

	public void excluir() {
		int index = getListaComputador().indexOf(getComputador());
		getListaComputador().remove(index);
		return;
	}

	public void limpar() {
		computador = null;

	}

	public Computador getComputador() {
		if (computador == null) {
			computador = new Computador();
		}
		return computador;
	}

	public void setComputador(Computador computador) {
		this.computador = computador;
	}

	public List<Computador> getListaComputador() {
		if (listaComputador == null) {
			listaComputador = new ArrayList<Computador>();
		}
		return listaComputador;
	}

	public void setListaComputador(List<Computador> listaComputador) {
		this.listaComputador = listaComputador;
	}

}
