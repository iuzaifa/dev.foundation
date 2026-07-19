package com.movieflix.service;

import com.movieflix.dto.MovieDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {

    MovieDto addMovies (MovieDto movieDto, MultipartFile file) throws IOException;

    MovieDto getMovie(Integer movieId);

    List<MovieDto> getAllMovie();

    MovieDto updateMovieWithId(Integer movieId, MovieDto movieDto, MultipartFile file) throws IOException;

    String deleteMovieWithId(Integer movieId) throws IOException;

}
