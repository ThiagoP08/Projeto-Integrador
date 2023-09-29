package model;

public class Ingresso {
    private Integer id;
    private Integer valor;
    private Integer quantidade;
    private String descricao;
    private String qrcode;
    private Integer user_id;
    private Integer evento_id;

    

    public Ingresso() {
        
    }

    public Ingresso(Integer id, Integer valor, String descricao, Integer user_id, Integer evento_id) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.user_id = user_id;
        this.evento_id = evento_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Integer evento_id) {
        this.evento_id = evento_id;
    }

    @Override
    public String toString() {
        return "Ingresso [id=" + id + ", valor=" + valor + ", descricao=" + descricao + ", user_id=" + user_id
                + ", evento_id=" + evento_id + "]";
    }
}