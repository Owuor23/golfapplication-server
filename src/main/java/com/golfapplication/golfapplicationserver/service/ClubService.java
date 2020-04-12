 package com.golfapplication.golfapplicationserver.service;

 import com.golfapplication.golfapplicationserver.models.Club;
 import org.springframework.data.repository.CrudRepository;
 import java.util.List;
 import java.util.Optional;

 public interface ClubService extends CrudRepository<Club,Integer> {

      List<Club> findByClubNameStartingWithAndClubLocation(String clubName, String clubLocation);
      List<Club> findByLatitudeIsNotAndLongitudeIsNot(double latitude, double longitude);
      Optional<Club> findById(Integer id);


      Iterable<Club>  findByFirstNameAndLastName(String firstName,String lastName);

      Iterable<Club> findByFirstName(String firstName);
      Iterable<Club> findByLastName(String lastName);
  }
