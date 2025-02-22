package br.com.alura.screenmatch.controllers;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<SerieDTO> findAll(){
        return serieService.findAll();
    }

    @GetMapping(value = "/top5")
    public List<SerieDTO> findTop5Series(){
        return serieService.findTop5Series();
    }

    @GetMapping(value = "/lancamentos")
    public List<SerieDTO> findTop5Lancamento(){
        return serieService.findByLancamento();
    }

    @GetMapping(value = "/{id}")
    public SerieDTO findById(@PathVariable Long id){
        return serieService.findById(id);
    }

    @GetMapping(value = "/{id}/temporadas/todas")
    public List<EpisodioDTO> findTemporadas(@PathVariable Long id){
        return serieService.getAllTemporadas(id);
    }

    @GetMapping(value = "/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numero){
        return serieService.obterTemporadasPorNumero(id, numero);
    }

    @GetMapping(value = "/categoria/{nome}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String nome){
        return serieService.obterSeriesPorCategoria(nome);
    }

}
