/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akvelon.web.validate;

/**
 *
 * @author Жека
 */
public enum ValidatePattern {
    name(){
    @Override
    public String pattern(){
        return "^[A-Z][a-z]+$";
     }
    },login_pass(){
      @Override
    public String pattern(){
        return "^[a-zA-Z0-9]{2,15}+$";
    }
     };
            
    public abstract String pattern();
    

}
