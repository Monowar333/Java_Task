<%-- 
    Document   : addupdateuser
    Created on : 14.09.2016, 23:07:56
    Author     : Жека
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script> 
            function btn1(idb){
               var button = document.getElementById(idb);
                var act = document.getElementById("Action");
                
              if(button.id == 'b3'){
                act.action =  "savenewuser";
              } else  if(button.id == 'b4'){
                    act.action =  "saveuser";
              }else  if(button.id == 'b5'){
                  act.action =  "startpage";}
                   act.submit();              
            }
        </script>
        <form:form id = "Action" method="post" action="saveuser" commandName="user">


                    <table>
                            <tr>
                                    <td><form:input path="id" type = "hidden"/></td>                                    
                            </tr>
                            <tr>
                                    <td>name:</td>
                                    <td><form:input path="name" /></td>
                                    <td><span class="error" ><form:errors path="name" /></span></td>
                            </tr>
                            <tr>
                                    <td>username:</td>
                                    <td><form:input path="username" /></td>
                                    <td><span class="error"><form:errors path="username" /></span></td>
                            </tr>
                            <tr>
                                    <td>statusregistr:</td>
                                    <td><form:input path="statusregistr" /></td>
                                    <td><span class="error"><form:errors path="statusregistr" /></span></td>
                            </tr>
                           
                                   
                            <tr>
                                    <td>password:</td>
                                    <td><form:input path="password" /></td>
                                    <td><span class="error"><form:errors path="password" /></span></td>
                            </tr>
                            <tr>
                                    <td>registerDate:</td>
                                    <td> <input type="text" name="date" value="${date}" readonly=""/></td>

                            </tr>

                            <tr>
                                    <td>role:</td>
                                    <td><form:input path="role" /></td>
                                    <td><span class="error"><form:errors path="role" /></span></td>
                            </tr>

                            <tr>
                                    <td>age:</td>
                                    <td><form:input path="age" /></td>
                                    <td><span class="error"><form:errors path="age" /></span></td>
                            </tr>
                            <tr>
                                    <td>weight:</td>
                                    <td><form:input path="weight" /></td>
                                    <td><span class="error"><form:errors path="weight" /></span></td>
                            </tr>
                            <tr>    
                                <c:if test="${contr eq 'true'}">
                                    <td colspan="1"><input type="submit" id ="b3" value="Add" onclick = "btn1(this.id)"></td>
                                </c:if>
                                <c:if test="${contr eq 'false'}">
                                      <td colspan="1"><input type="submit" id ="b4" value="Save" onclick = "btn1(this.id)"></td>
                                </c:if>
                                     <td colspan="1"><input type="submit" id ="b5" value="Chanel" onclick = "btn1(this.id)"></td>
   
                            </tr>
                    </table>
            </form:form>
    </body>
</html>
