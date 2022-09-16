package com.proyecto.FlujoDeCaja.controllers;
import com.proyecto.FlujoDeCaja.entities.Enterprise;
import com.proyecto.FlujoDeCaja.entities.User;
import com.proyecto.FlujoDeCaja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
        @Autowired
        UserService servicioUser;

        public UserController(UserService servicioUser) {
                this.servicioUser = servicioUser;
        }
        //Get
        @GetMapping("/users")

        public List<User> Userlist() {
                return servicioUser.getAll();

        }

        //POST
//        @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  //      @ResponseBody
    //    public User createUser(@RequestBody User user) {
      //          return servicioUser.createUser(user);
        //}

        //@RequestMapping(value = "(id)", method = RequestMethod.GET, produces = "application/json")
        //@ResponseBody
        //public User findById(@PathVariable long id) {
          //      return servicioUser.getById(id);
        //}

        //@RequestMapping(value = "(id)", method = RequestMethod.PATCH, produces = "application/json")
        //@ExceptionHandler
        //@ResponseBody
        //public User updateUser(@PathVariable long id, @RequestBody User user) {
          //      return servicioUser.updateUser(id, user);
        //}

        //@RequestMapping(value = "(id)", method = RequestMethod.DELETE, produces = "application/json")
        //@ResponseBody
        //public boolean delete(@PathVariable long id){
          //return servicioUser.delete(id);
        //}
        @GetMapping("/users/{id}")
        public User usuario (@PathVariable("id") Long id){
                System.out.print(id);
                return servicioUser.getUser(id);
                //return new ResponseEntity<>(servicio.getEnterprise(id), HttpStatus.OK);//getEnterprise(id);
        }


        @PostMapping("/users")
        public User createUser(@RequestBody User usuario){
                return this.servicioUser.createUser(usuario);
        }

        @DeleteMapping("/users/{id}")
        private boolean deleteUser(@PathVariable("id") Long id){
                return this.servicioUser.deleteUser(id);
        }

        @PatchMapping("/users/{id}")
        public User createEnterprise(@PathVariable("id") Long id, @RequestBody User usuario){
                return this.servicioUser.updateUser(id, usuario);
        }
}