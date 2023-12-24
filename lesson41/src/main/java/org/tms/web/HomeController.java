package org.tms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.tms.domain.FilmEntity;
import org.tms.dto.FilmCreateDto;
import org.tms.dto.FilmSearchDto;
import org.tms.mapper.FilmMapper;
import org.tms.service.FilmService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class HomeController {
    private final FilmMapper mapper;
    private final FilmService service;
    private final String HOME_PAGE = "home";

    @GetMapping("/")
    public ModelAndView homePage(@ModelAttribute(name="film") FilmEntity film,
                                 @ModelAttribute(name="searchDto") FilmSearchDto searchDto) {
        ModelAndView modelAndView = new ModelAndView(HOME_PAGE);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save (@ModelAttribute(name="film") FilmCreateDto filmDto, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        FilmEntity film = mapper.toEntity(filmDto);
        service.save(film);
        modelAndView.addObject("film", new FilmCreateDto());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search (FilmSearchDto dto) {
        List<FilmEntity> result = service.findByCriteria(dto);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("film", new FilmEntity());
        modelAndView.addObject("searchDto", new FilmSearchDto());
        modelAndView.addObject("films", result);

        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestParam(name="id", required = true) Integer id,
                               @RequestParam(name="newrating", required = false) Integer rating) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        service.updateRating(id, rating);
        List<FilmEntity> all = service.findAll();
        modelAndView.addObject("film", all);
        return modelAndView;
    }
}