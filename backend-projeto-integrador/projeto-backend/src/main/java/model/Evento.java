package model;

public class Evento {
	private Integer id;
	private String img_src;
	private String titulo;
	private String data_evento;
	private String hora;
	private String bairro;
	private String estado;
	private String rua;
	private String descricao;
	private String politica;
	private Integer min_lotacao;
	private Integer max_lotacao;
	private Boolean status;
	private Integer min_idade;
	private Integer categoria_id;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getImg_src() {
		return img_src;
	}
	
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getData_evento() {
		return data_evento;
	}

	public void setData_evento(String data_evento) {
		this.data_evento = data_evento;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getPolitica() {
		return politica;
	}

	public void setPolitica(String politica) {
		this.politica = politica;
	}
	
	public Integer getMin_lotacao() {
		return min_lotacao;
	}
	
	public void setMin_lotacao(Integer min_lotacao) {
		this.min_lotacao = min_lotacao;
	}
	
	public Integer getMax_lotacao() {
		return max_lotacao;
	}
	
	public void setMax_lotacao(Integer max_lotacao) {
		this.max_lotacao = max_lotacao;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Integer getMin_idade() {
		return min_idade;
	}
	
	public void setMin_idade(Integer min_idade) {
		this.min_idade = min_idade;
	}

	public Integer getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}

}
