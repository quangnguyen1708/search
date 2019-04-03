<%-- 
    Document   : searchHoaDonInt
    Created on : Apr 3, 2019, 8:51:12 AM
    Author     : Admin
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="controller.SearchHoaDonIntseverlet"%>
<%@page import="entity.HoaDonInternet"%>
<%@page import="dao.HoaDonIntDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Chung cư Ple Ple Ple....!!!</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/sea.css" rel="stylesheet" type="text/css">

    </head>
    <%  SearchHoaDonIntseverlet li = new SearchHoaDonIntseverlet();

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumIntegerDigits(0);%>

    <body>
        <form action="SearchHoaDonIntseverlet">
            <h2 style=" text-align: center; ">HÓA ĐƠN INTERNET</h2> 
            <div class="box">                

                <div class="pod">
                    <input type="text" name="txtsearch" class="search" placeholder="Search ID" value="" required >

                    <input type="submit" class="button1" value="Search" name="action" />
                </div> <br>


                <c:forEach var="hd" items="${listForeach}">  
                    <div class="colum1" style="border-radius:5px ;padding: 15px;box-shadow: 0px 0px 5px gray;
                         margin: 10px auto;
                         margin-left: 35px;
                         text-align: left;
                         ">

                        <p>Mã Hóa Đơn Internet: ${hd.getHoaDonInternetId()}</p>                      
                        <p>Mã Căn Hộ: ${hd.getCanHo().getCanHoId()}</p>                       
                        <p>Ngày Lập: ${hd.getNgayThang()}</p>   
                        <p>Tổng Tiền: ${hd.getTien()} VNĐ</p> 
                        
                    </div>
                </c:forEach>

            </div>
            <footer style="color:black; margin-top: 478px; text-align: center;" id="foot1"> Chung cư Ple Ple Ple....!!!</footer>
        </form>
      
    </body>
</html>
