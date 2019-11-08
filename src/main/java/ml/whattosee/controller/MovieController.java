package ml.whattosee.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ml.whattosee.dto.MovieDto;
import ml.whattosee.dto.ScoreDto;
import ml.whattosee.service.MovieService;
import ml.whattosee.util.CodeErrorResponse;
import ml.whattosee.util.CodeResponse;
import ml.whattosee.util.EndPointsConstant;
import ml.whattosee.util.ResponseDto;

@Controller
@CrossOrigin
public class MovieController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @GetMapping(EndPointsConstant.REST_GET_MOVIES_NAME + "/{name}")
    public ResponseDto getByName(@PathVariable String name) {
        try {
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), movieService.findByName(name));
        } catch (Exception ex) {
            LOGGER.error("ERROR GET MOVIES BY NAME: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_GET_GENDERS.getCode(), ex.getMessage());
        }
    }

    @ResponseBody
    @PostMapping(EndPointsConstant.REST_POST_MOVIES_SCORE)
    public ResponseDto setScoreMovie(@RequestBody ScoreDto scoreDto) {
        try {
            if(scoreDto.getIdMovie() < 0)
                throw new Exception("No existen la pelicula seleccionada");
            if(scoreDto.getScore() < 0 || scoreDto.getScore() > 5)
                throw new Exception(("El puntaje dado, no es valido"));
            MovieDto movieDto = movieService.findById(scoreDto.getIdMovie());
            if(movieDto == null || movieDto.getId() == null)
                throw new Exception("La pelicula seleccionada no existe");
            Long actualScore = movieDto.getScore();
            movieDto.setScore(actualScore + scoreDto.getScore());
            Long actualCounter = movieDto.getScoreCounter();
            movieDto.setScoreCounter(actualCounter + 1);
            return new ResponseDto(CodeResponse.OK_COMMON.getCode(), movieService.save(movieDto));
        } catch (Exception ex) {
            LOGGER.error("ERROR SCORE MOVIE: {} ", ExceptionUtils.getStackTrace(ex));
            return new ResponseDto(CodeErrorResponse.ERROR_GET_GENDERS.getCode(), ex.getMessage());
        }
    }
}
