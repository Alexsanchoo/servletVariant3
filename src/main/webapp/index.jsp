<%@page contentType="text/html; charset=UTF-8" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script language="JavaScript">
            function fun1(){
               document.all.form1.text.value;
               document.all.form1.Symbol.value=document.all.form1.symbol.value;
               document.all.form1.submit();
           }

        </script>
        <title>Change symbol</title>
    </head>

    <style>

        h1
        {
            font-family: 'Calibri';
        }

    </style>


    <form action="servlet" method="post" id="form1">
        <hr width = 65%>
        <table align = "center">
            <tr>
            <center><textarea name="text" type="text" style="width: 60%; height: 200px;" value = "" disabled="true">Advertisers study how people learn so that they can teach them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition. If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may be interested and note the name of the tea … Here the same technique is being used as with the cool, refreshing drink.</textarea></center>
            </tr>
            <tr>
                <td>
                    <b>Enter character: </b>
                    <input id="symbol" type="text" name="Symbol">
                </td>
            </tr>
        </table>
        <hr width = 65%>
        <center><input type="button" value="View Result" onclick = "fun1();"></center>
    </form>
</html>
