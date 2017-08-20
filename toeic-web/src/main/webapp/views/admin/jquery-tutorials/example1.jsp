<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<input>
<head>

    <style>
        .blue{
            color: blue;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>


<input type="text" value = "Tô Thái" id ="textValue"/>

<input type="button" value="Ấn Vào Đây" class="demo1" onclick="myFunction()">

<p id="demo">Minh Quang</p>

<p class ="blue" style="color: red;">Minh Quang</p>
<input type="button" value="Ấn Vào Đây" class="demo2" onclick="changeColor()">

<p style="color: red;" id="blue">Minh Quang</p>
<input type="button" value="Ấn Vào Đây"  onclick="changeColor1()">


<script>



    $(document).ready(function(){

    });


    function myFunction() {


//        $('#demo').hide();
        var abc =$('#textValue').val();
        $('#demo').html(abc);
    }



    function changeColor1() {
        $('#blue').css('color', 'blue');
    }
</script>

</body>
</html>