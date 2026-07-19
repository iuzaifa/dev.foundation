package com.movieflix.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieflix.dto.MovieDto;
import com.movieflix.entities.Movie;
import com.movieflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/vi/movie")
public class MovieController {


    @Autowired
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }



    @PostMapping("/add-movie")
    public ResponseEntity<MovieDto> addMovieHandler(@RequestPart("file") MultipartFile file,
                                                    @RequestPart("movieDto") String movieDto) throws IOException {
        MovieDto mvDto = convertMovieDto(movieDto);
        return new ResponseEntity<>(movieService.addMovies(mvDto, file), HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovieWithIdHandler(@PathVariable Integer movieId){
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<MovieDto>> getAllMoviesHandler(){
        return ResponseEntity.ok(movieService.getAllMovie());
    }


    @PutMapping("/update/{movieId}")
    public ResponseEntity<MovieDto> updateMovieHandler(@PathVariable Integer movieId,
                                                       @RequestPart("file") MultipartFile file,
                                                       @RequestPart("movieDtoObj") String movieDtoObj) throws IOException{
        if (file.isEmpty()) file = null;
        MovieDto movieDto = convertMovieDto(movieDtoObj);
        return ResponseEntity.ok(movieService.updateMovieWithId(movieId, movieDto, file));
    }


    @DeleteMapping("/delete/{movieId}")
    public ResponseEntity<String> deleteMovieHandler(@PathVariable Integer movieId) throws IOException {
        return  ResponseEntity.ok(movieService.deleteMovieWithId(movieId));
    }

    public MovieDto convertMovieDto(String movieDtoObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(movieDtoObject, MovieDto.class);
    }

}
