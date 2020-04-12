package com.golfapplication.golfapplicationserver.controllers;

import com.golfapplication.golfapplicationserver.models.Club;
import com.golfapplication.golfapplicationserver.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Optional;


@RestController
public class ClubController {
       @Autowired
    private ClubService clubService;



      @PostMapping
   public Club createClub( @RequestBody Club club) {
       return clubService.save(club);
   }

   // @PatchMapping(value = "{id}")
  // public Club updateClub(@PathVariable Long id, @RequestBody Club club) {
          //Club foundClub = findOneById(id);

     //  foundClub.setClubName(club.getClubName());
      //  foundClub.setLatitude(club.getLatitude());
      //  foundClub.setClubLocation(club.getClubLocation());
      // foundClub.setLongitude(club.getLongitude());

      //  return clubService.save(foundClub);
    //}
      //@PatchMapping( "/club")
     // ResponseEntity<Club>update(@RequestBody Club club){

     // }


    @GetMapping("/club")
    public Iterable<Club> read(){
        return clubService.findAll();
    }
    @PutMapping("/club")
    ResponseEntity<Club> update(@RequestBody Club club){
        if (clubService.findById(club.getId()).isPresent())
            return new  ResponseEntity(clubService.save(club), HttpStatus.OK);
        else

            return new ResponseEntity(club,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/club/{id}")
    public    void delete(@PathVariable Integer id){
        clubService.deleteById(id);
    }
    @GetMapping("/club/{id}")
    Optional<Club> findById(@PathVariable Integer id){
        return clubService.findById(id);
    }

    @GetMapping("/club/search")
    Iterable<Club> findByQuery(@RequestParam(value = "first",required = false)String fisrtName,@RequestParam(value = "las",required = false)String lastName){
        if (fisrtName!=null && lastName !=null){
            return clubService.findByFirstNameAndLastName(fisrtName,lastName);
        }else if (fisrtName!=null){
            return clubService. findByFirstName(fisrtName);
        }else if (lastName!=null){
            return clubService.findByLastName(lastName);
        }else
            return clubService.findAll();

    }

    @GetMapping("/wrong")
    Club somethingIsWrong() throws ValidationException { throw new ValidationException("Something is Wrong");

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    String exceptionHandler(ValidationException e){
        return e.getMessage();
    }


}
