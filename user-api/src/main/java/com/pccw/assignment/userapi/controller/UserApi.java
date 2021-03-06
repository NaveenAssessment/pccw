/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.pccw.assignment.userapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pccw.assignment.userapi.model.CreateUserRequest;
import com.pccw.assignment.userapi.model.UpdateUserRequest;
import com.pccw.assignment.userapi.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "users")
public interface UserApi {

    @ApiOperation(value = "Register a new user", notes = "", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class) })
    
    @RequestMapping(value = "/users",
        produces = { "application/json;charset=UTF-8" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<User> createUsingPUT(@ApiParam(value = "request" ,required=true )  @Valid @RequestBody CreateUserRequest request);


    @ApiOperation(value = "Delete a user", notes = "", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class) })
    
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json;charset=UTF-8" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<User> deleteUsingDELETE(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id);


    @ApiOperation(value = "Find a user via id", notes = "", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class) })
    
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json;charset=UTF-8" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<User> getUsingGET(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id);


    @ApiOperation(value = "list all users", notes = "", response = User.class, responseContainer = "List", tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class, responseContainer = "List") })
    
    @RequestMapping(value = "/users",
        produces = { "application/json;charset=UTF-8" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<User>> listUsingGET1(@ApiParam(value = "page") @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "size") @RequestParam(value = "size", required = false) Integer size);


    @ApiOperation(value = "Update a user", notes = "", response = User.class, tags={ "User", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class) })
    
    @RequestMapping(value = "/users",
        produces = { "application/json;charset=UTF-8" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<User> updateUsingPOST1(@ApiParam(value = "request" ,required=true )  @Valid @RequestBody UpdateUserRequest request);

}
