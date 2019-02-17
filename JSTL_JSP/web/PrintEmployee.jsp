<%-- 
    Document   : PrintEmployee
    Created on : Feb 4, 2019, 2:45:11 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--'items' is the collection for looping and 'temp' is a temporary variable to store value in each iteration--> 
        <core:forEach items="${emp}" var="temp">
            <core:out value="${temp.id}"/>
            <br>
            <core:out value="${temp.name}"/>
            <br>
            
            <!--Putting Condition-->
            <core:if test="${temp.name == 'Ratanawan'}">
                <core:out value=" Welcome ${temp.name}"/>
                <br>
            </core:if>
            
            <core:if test="${temp.name != 'Lynan'}">
                <core:out value="Not Lynan"/>
                <br>
            </core:if> 
        </core:forEach>
        
        <br>        
        <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mysql" user="root" password=""></sql:setDataSource>
  
        <!--To insert records into database-->
        <sql:update dataSource="${ds}" var="rows">
            INSERT INTO bank VALUES ('1', 'Ratanawan', '9999');
            INSERT INTO bank VALUES ('2', 'Lynan', '8000');
            INSERT INTO bank VALUES ('3', 'Sothea', '7000');
            INSERT INTO bank VALUES ('4', 'Jenny', '7900');
            INSERT INTO bank VALUES ('5', 'Dane', '5000');
            INSERT INTO bank VALUES ('6', 'Panha', '2000');
            INSERT INTO bank VALUES ('7', 'Seavpor', '2500');
            INSERT INTO bank VALUES ('8', 'V', '600');
            INSERT INTO bank VALUES ('9', 'NyNy', '1000');
            INSERT INTO bank VALUES ('10', 'Stupid', '3000');
        </sql:update>
            
        <!--To get all records from database-->
        <sql:query var="rs" dataSource="${ds}">
            SELECT * FROM bank;
        </sql:query> 
            
        <core:forEach items="${rs.rows}" var="record">
            ***********************************
            <br>
            <core:out value="ID: ${record.id}"/>
            <br>
            <core:out value="Name: ${record.name}"/>
            <br>
            <core:out value="${record.amount}"/>
            <br>
            ***********************************
        </core:forEach>
        
        <core:import url="school.xml" var="sch"/>
        
        <xml:parse xml="${sch}" var="details"/>
        <xml:forEach select="$details/school/section" var="record">
            <xml:out select="$record/s_id"/>
            <xml:out select="$record/s_name" />
        </xml:forEach>
    </body>
</html>
