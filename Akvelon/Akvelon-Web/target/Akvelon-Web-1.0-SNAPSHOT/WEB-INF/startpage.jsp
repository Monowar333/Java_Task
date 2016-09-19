<%-- 
    Document   : listusers
    Created on : 13.09.2016, 22:51:43
    Author     : Жека
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.js"></script>
        <script> 
            function btn1(idb){
               var button = document.getElementById(idb);
                var act = document.getElementById("Action");
                
              if(button.id == 'b3'){
                act.action =  "startpage";
              } else  if(button.id == 'b4'){
                   if(($(':input:checked').length) == 0) { 
                    window.alert('please select rows to be deleted');
                    act.action =  "startpage";
                }else if(($(':input:checked').length) > 0){
                  act.action =  "delete";}
              }else  if(button.id == 'b5'){
                  if(($(':input:checked').length) > 1) { 
                    window.alert('please select just one row to be edited');
                    act.action =  "startpage";
                }else if(($(':input:checked').length) == 0){
                  act.action =  "addusers";
                }else if(($(':input:checked').length) == 1){
                  act.action =  "update";}
                }
                   act.submit();              
            }
        </script>
         <form id = "Action" action="" method="POST">
            <input type="submit" id ="b3" value="refresh" onclick = "btn1(this.id)">
                <input type="submit" id ="b4" value="delete" onclick = "btn1(this.id)">
                <input type="submit" id ="b5" value="edit" onclick = "btn1(this.id)">
           
        

        <table border="1" id="table1">
                    <thead>
                        <tr>
                             <th></th>
                            <th>id</th>
                            <th>name</th>
                            <th>username</th>
                            <th>status registr</th>
                            <th>password</th>
                            <th>register date</th>
                            <th>role</th>
                            <th>age</th>
                            <th>weight</th>
                           
                            
                        </tr>
                    </thead>
                    
                    <tbody>
                       
                        <c:forEach var="item" items="${users}">
                        
                        <tr>
                            <td>
                          <input type="checkbox" name="check" value="${item.id}" />
                           </td>  
                           <td>
                        <c:out value="${item.id}"/> 
                          </td>
                           <td>
                        <c:out value="${item.name}"/> 
                          </td>
                           <td>
                        <c:out value="${item.username}"/> 
                          </td>
                           <td>
                        <c:out value="${item.statusregistr}"/> 
                          </td>
                           <td>
                        <c:out value="${item.password}"/> 
                          </td>
                           <td>
                        <c:out value="${item.registerDate}"/> 
                          </td>
                           <td>
                        <c:out value="${item.role}"/> 
                          </td>
                           <td>
                        <c:out value="${item.age}"/> 
                          </td>
                           <td>
                        <c:out value="${item.weight}"/> 
                          </td>
                      </tr>
                        </c:forEach>
                        
                        
                    </tbody>
                    
                </table>
                </form>
    </body>
</html>
