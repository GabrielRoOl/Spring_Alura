package br.com.alura.screenmatch.model;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeParseException;
/**
 * Representa um episódio de uma série, contendo informações como título, número do episódio,
 * temporada, data de lançamento e avaliação.
 * A instância é construída com base nos dados recebidos da API OMDB.
 */
public class Episodio {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodios dadosEpisodios) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodios.titulo();
        this.numeroEpisodio = dadosEpisodios.numero();
        this.avaliacao = parseAvaliacao(dadosEpisodios.avaliacao());
        this.dataLancamento = parseDataLancamento(dadosEpisodios.data());

//        try{
//            this.avaliacao = Double.valueOf(dadosEpisodios.avaliacao());
//            this.dataLancamento = LocalDate.parse(dadosEpisodios.data());
//        } catch (NumberFormatException ex){
//            this.avaliacao = 0.0;
//        } catch (DateTimeParseException e){
//            this.dataLancamento = null;
//        }


    }
    private Double parseAvaliacao(String avaliacao) {
        try {
            return Double.valueOf(avaliacao);
        } catch (NumberFormatException e) {
            return 0.0; // Valor padrão
        }
    }

    private LocalDate parseDataLancamento(String data) {
        try {
            return LocalDate.parse(data);
        } catch (DateTimeParseException e) {
            return null; // Indica que a data é inválida
        }
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return String.format("Episódio %d da temporada %d: '%s'\nAvaliação: %.1f\nLançamento: %s",
                numeroEpisodio, temporada, titulo, avaliacao,
                dataLancamento != null ? dataLancamento : "Data desconhecida");
    }

}
