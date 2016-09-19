/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.service;

import akvelon.domain.Users;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface UsersService {
     public void update(Users o); 
    public void remove(List<Users> o); 
    public List<Users> getList();
    public int save(Users o);
    public Users getById(int id);
}
