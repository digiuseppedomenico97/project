<%--
  Created by IntelliJ IDEA.
  User: domenico
  Date: 11/04/2024
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>pgsArchivioDiscenteElimina</title>
</head>
<body>
<jsp:useBean id="beanDiscente" scope="session"
             class="model.session.Discente">
    <jsp:setProperty name="beanDiscente" property="*" />
</jsp:useBean>


<FORM method="post" action="/WebProjectMavenized/CtrlArchivioDiscente">
    <TABLE>
        <tr>
            <td>Vuoi eliminare il Discente?</td>

            <td><INPUT type="submit" name="cmdAzione" value="Conferma">
            </td>

            <td><INPUT type="submit" name="cmdAzione" value="Annulla">
            </td>
        </tr>
    </TABLE>
</FORM>
</body>
</html>