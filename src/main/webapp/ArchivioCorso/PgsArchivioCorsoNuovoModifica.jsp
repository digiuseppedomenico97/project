<%--
  Created by IntelliJ IDEA.
  User: domenico
  Date: 11/04/2024
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.session.Docente"%>
<%@page import="model.dao.DocenteService"%>
<HTML>
<HEAD>
    <%@ page
            language="java"
            contentType="text/html; charset=ISO-8859-1"
            pageEncoding="ISO-8859-1"
            import="java.util.*"
    %>
    <%@ page import="model.dao.DocenteService" %>
    <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <META name="GENERATOR" content="IBM WebSphere Studio">
    <TITLE>pgsArchivioCorsoNuovoModifica.jsp</TITLE>
</HEAD>
<BODY>

<jsp:useBean id="beanCorso" scope="session"
             class="model.session.Corso">
    <jsp:setProperty name="beanCorso" property="*" />
</jsp:useBean>

<P align="center"><FONT size="+2" color="green">Corso</FONT></P>


<FORM method="post" action="/WebProjectMavenized/CtrlArchivioCorso">


    <TABLE  align="center" >
        <tr>

            <td>
                Nome:
            </td>

            <td>
                <INPUT type="text" name="txtNome" value="<%= beanCorso.getNome()%>" size="20" maxlength="50">
            </td>

        </tr>

        <tr>

            <td>
                &nbsp;
            </td>

        </tr>

        <tr>

            <td>
                Durata:
            </td>

            <td>

                <INPUT type="number" name="txtDurata" value="<%= beanCorso.getDurata()%>" size="20" maxlength="50">

            </td>

        </tr>
    </TABLE >
    <%
        DocenteService oDocenteService = new DocenteService();
        List<Docente> elenco = oDocenteService.findAll();
        int numeroRighe = elenco.size();
        if(numeroRighe > 0){
            int i = 1;

    %>
    <TABLE border="1" >
        <TBODY>
        <TR>
            <TD> </TD>
            <TD>Cognome</TD>
            <TD>Nome</TD>
        </TR>
        <TR>
            <TD>
                <input type="radio" name="rdoIDDocente" value="<%=elenco.get(0).getChiave() %>" > </TD>
            <TD> <%= elenco.get(0).getCognome() %></TD>
            <TD> <%= elenco.get(0).getNome() %></TD>
        </TR>
        <%while(i< numeroRighe){
        %>
        <TR>
            <TD>
                <input type="radio" name="rdoIDDocente" value="<%= elenco.get(i).getChiave() %>" >
            </TD>
            <TD> <%= elenco.get(i).getCognome() %></TD>
            <TD> <%= elenco.get(i).getNome() %></TD>
        </TR>
        <% i++;
        } %>

        </TBODY>
    </TABLE>
    <P> </P>
    <% } else{%> Non ci sono Docenti<% } %> <BR>


    <BR/>
    <BR/>
    <DIV align="center">

        <INPUT type="submit" name="cmdAzione" value="Registra">
        <INPUT type="submit" name="cmdAzione" value="Annulla"> <BR>

    </DIV></FORM>



</BODY>
</HTML>

