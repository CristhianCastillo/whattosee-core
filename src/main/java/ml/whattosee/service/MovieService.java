package ml.whattosee.service;

import ml.whattosee.dto.GenderDto;
import ml.whattosee.dto.MovieDto;
import ml.whattosee.model.MovieEntity;
import ml.whattosee.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository service;

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntity = modelMapper.map(movieDto, MovieEntity.class);
        return modelMapper.map(service.save(movieEntity), MovieDto.class);
    }

    @Transactional
    public List<MovieDto> findByName(String name) {
        List<MovieDto> result = new ArrayList<>();
        service.findByNameContaining(name).forEach(e -> result.add(modelMapper.map(e, MovieDto.class)));
        return result;
    }

    @Transactional
    public MovieDto findById(Long id) {
        return modelMapper.map(service.findById(id).get(), MovieDto.class);
    }
}
