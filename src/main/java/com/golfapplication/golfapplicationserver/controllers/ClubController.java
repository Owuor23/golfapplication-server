//package com.golfapplication.golfapplicationserver.controllers;

//import com.golfapplication.golfapplicationserver.models.Club;
//import com.golfapplication.golfapplicationserver.service.ClubService;
//import javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;

//  import java.util.List

//@RestController
//@RequestMapping(value = "clubs")
//public class ClubController {
//@Autowired
 //   private ClubService clubService;
 //   @GetMapping
 //   public List<Club> getAllClubs() {
   //     return clubService.findAll();
   // }

  //  @PostMapping
 //   public Club createClub(@RequestBody Club club) {
 //       return clubService.save(club);
 //   }

 //   @PatchMapping(value = "{id}")
//    public Club updateClub(@PathVariable Long id,
 //                                      @RequestBody Club club) {
 //       Club foundClub = findOneById(id);

 //       foundClub.setClubName(club.getClubName());
  //      foundClub.setLatitude(club.getLatitude());
    //    foundClub.setClubLocation(club.getClubLocation());
  //      foundClub.setLongitude(club.getLongitude());

 //       return clubService.save(foundClub);
 //   }
//
   // @GetMapping(value = "{id}")
  //  public Club findOneById(@PathVariable Long id) {
 //       Club club = clubService.findById(id).orElseThrow(() ->
 //               new NotFoundException("No university with the id " + id + " was found."));
//        return club;
//    }

//     @GetMapping(value = "{clubId}/users")
//     public List<Club> findByUniversityId(@PathVariable Long clubId) {
//          return clubService.findByClubId(clubId);
//     }

//     @GetMapping(value = "search")
//     public List<Club> search(@RequestParam String name,
//                                    @RequestParam(required = false) String location) {
//         if (location != null)
//             return clubService.findByClubNameStartingWithAndClubLocation( clubName,clubLocation);
//         else
//             return clubService.findByClubNameStartingWith(clubName);
//      }

//  }
