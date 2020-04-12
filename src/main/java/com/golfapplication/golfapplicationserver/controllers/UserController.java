package com.golfapplication.golfapplicationserver.controllers;

import com.golfapplication.golfapplicationserver.Util.FieldErrorMessage;
import com.golfapplication.golfapplicationserver.models.User;
import com.golfapplication.golfapplicationserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/User")
     public User createUser(@RequestBody User user){
        return userService.save(user);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError>fieldErrors=e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage>fieldErrorMessages=fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(),fieldError.getDefaultMessage() )).collect(Collectors.toList());
        return fieldErrorMessages;

    }

    @GetMapping("/user")
    public Iterable<User> read(){
        return userService.findAll();
    }
    @PutMapping("/user")
    ResponseEntity<User> update(@RequestBody User user){
        if (userService.findById(user.getId()).isPresent())
            return new  ResponseEntity(userService.save(user), HttpStatus.OK);
        else

            return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/user/{id}")
    public    void delete(@PathVariable Integer id){
        userService.deleteById(id);
    }
    @GetMapping("/user/{id}")
    Optional<User> findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @GetMapping("/club/search")
    Iterable<User> findByQuery(@RequestParam(value = "first",required = false)String fisrtName,@RequestParam(value = "las",required = false)String lastName){
        if (fisrtName!=null && lastName !=null){
            return userService.findByFirstNameAndLastName(fisrtName,lastName);
        }else if (fisrtName!=null){
            return userService. findByFirstName(fisrtName);
        }else if (lastName!=null){
            return userService.findByLastName(lastName);
        }else
            return userService.findAll();

    }

    @GetMapping("/wrong")
    User somethingIsWrong() throws ValidationException { throw new ValidationException("Something is Wrong");

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    String exceptionHandler(ValidationException e){
        return e.getMessage();
    }


    //@Autowired
  //  private SecurityService securityService;

   // @Autowired
   // private UserValidator userValidator;

  //  @GetMapping("/registration")
  //  public String registration(Model model) {
  //      model.addAttribute("userForm", new User());

   //     return "registration";
   // }

   // @PostMapping("/registration")
  //  public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
   //     userValidator.validate(userForm, bindingResult);

  //      if (bindingResult.hasErrors()) {
   //         return "registration";
   //     }

   //     userService.save(userForm);

   //     securityService.autoLogin(userForm.getUsername(), userForm.getPasswordCornfirm());

   //     return "redirect:/welcome";
  //  }

 //   @GetMapping("/login")
 //   public String login(Model model, String error, String logout) {
 //       if (error != null)
 //           model.addAttribute("error", "Your username and password is invalid.");

  //      if (logout != null)
  //          model.addAttribute("message", "You have been logged out successfully.");

   //     return "login";
   // }

  //  @GetMapping({"/", "/welcome"})
  //  public String welcome(Model model) {
       // return "welcome to this wonderfull golf club experinece";
 //   }
}
