package com.movieflix.service;

import com.movieflix.dto.MovieDto;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{


    private final MovieRepository movieRepository;
    private final FileService fileService;


    @Value("${project.poster}")
    private String path;
    @Value("${project.base-url}")
    private String baseUrl;

    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }

    @Override
    public MovieDto addMovies(MovieDto movieDto, MultipartFile file) throws IOException{

        // 1. upload image
        String uploadFileName = fileService.uploadFile(path, file);

        // 2. set the value of field 'poster' as filename
        movieDto.setPoster(uploadFileName);


        // 3. map dto to movie object
        Movie movie = new Movie(
                movieDto.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        // 4. Save movie object -> saved movie Object
        Movie savedMovie = movieRepository.save(movie);

        // 5. Generate the porter orl
        String posterUrl = baseUrl + "/file/" + uploadFileName;

        // 6. map movie object to Dto object and  return it
        MovieDto response = new MovieDto(
                null,
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );


        return response;
    }

    @Override
    public MovieDto getMovie(Integer movieId) {
        // 1. check data in DB if exits , fetch the data of given ID
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new RuntimeException("Movie not Found with this id" + movieId));

        // 2. Generate Poster-url
        String posterUrl = baseUrl + "/file/" + movie.getPoster();

        //3. map to movieDto object and return it
        MovieDto response = new MovieDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getMovieCast(),
                movie.getReleaseYear(),
                movie.getPoster(),
                posterUrl
        );
        return response;
    }

    @Override
    public List<MovieDto> getAllMovie() {
        // 1. fetch all data form DB
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();
        // 2. Iterate through the list,   generate a poster URL od each movie .;
        // 3. map to movieDto object
        for (Movie movie : movieList){
            // 4. Generate Poster-url
            String posterUrl = baseUrl + "/file/" + movie.getPoster();
            MovieDto response = new MovieDto(
                    movie.getMovieId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getStudio(),
                    movie.getMovieCast(),
                    movie.getReleaseYear(),
                    movie.getPoster(),
                    posterUrl
            );
            movieDtoList.add(response);
        }
        return movieDtoList;
    }


    @Override
    public MovieDto updateMovieWithId(Integer movieId, MovieDto movieDto, MultipartFile file) throws IOException {
        // 1. check if movie object exits with given MovieId;
        Movie mv = movieRepository.findById(movieId).orElseThrow(()-> new RuntimeException("Movie not found with this ID" + movieDto));


        // 2. if file is null do nothing
        // if file is not null, then delete existing file associate with the record
        // and upload the new file
        String fileName = mv.getPoster();
        if (file != null ){
            Files.deleteIfExists(Paths.get(path + File.separator + fileName));
            fileName = fileService.uploadFile(path, file);
        }
        // 3. set movieDto's poster value , according step 2
        movieDto.setPoster(fileName);
        // 4. map it movie Object
        Movie movie = new Movie(
                mv.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        // 5. save the movie object -> and return movie object
        Movie updatedMovie = movieRepository.save(movie);
        // 6. generate poster ulr of it
        String posterUrl = baseUrl + "/file/" + fileName;
        // 7. map to movie Dto and return it ;
        MovieDto response = new MovieDto(
            movie.getMovieId(),
            movie.getTitle(),
            movie.getDirector(),
            movie.getStudio(),
            movie.getMovieCast(),
            movie.getReleaseYear(),
            movie.getPoster(),
            posterUrl

        );
        return response;
    }


    @Override
    public String deleteMovieWithId(Integer movieId) throws IOException {
        // 1. check if movie object exits in DB  !!
        Movie mv = movieRepository.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found with this ID" + movieId));
        Integer id = mv.getMovieId();
        // 2. delete file with associate with this object
        Files.deleteIfExists(Paths.get(path , File.separator + mv.getPoster()));
        // 3. delete the movie object
        movieRepository.delete(mv);
        return "Movie Deleted with ID" +id;
    }
}
