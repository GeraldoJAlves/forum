package br.com.geraldo.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.geraldo.forum.model.Curso;
import br.com.geraldo.forum.model.Topico;
import br.com.geraldo.forum.repository.CursoRepository;

public class TopicoForm {

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String titulo;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String mensagem;
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		
		return new Topico(titulo, mensagem, curso);
	}

}
