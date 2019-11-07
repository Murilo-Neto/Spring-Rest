package com.murilo.teste.exception;

import java.io.Serializable;

public class ErroDTO implements Serializable {
	
	private String erro;
	private String codigo;
	
	public ErroDTO(String erro, String codigo) {
		super();
		this.erro = erro;
		this.codigo = codigo;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
