<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page 
language="java"
contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
%>

<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<TITLE>pgsMain.jsp</TITLE>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">    <link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet"  type="text/css" href="css/style.css">
</HEAD>
<BODY>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
	<div class="container">
		<a class="navbar-brand" href="#">Menù <i class="fa-solid fa-school"></i></a>
		<button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
		</button>
		<div class="collapse navbar-collapse" id="exCollapsingNavbar">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a href="#" class="nav-link">About</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Link</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Service</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Contact</a></li>
			</ul>
			<li class="nav navbar-nav flex-row justify-content-between ml-auto">
				<li class="nav-item order-2 order-md-1"><a href="#" class="nav-link" title="settings"><i class="fa fa-cog fa-fw fa-lg"></i></a></li>
				<li class="dropdown order-1">
					<button type="button" data-toggle="dropdown" class="btn btn-outline-secondary dropdown-toggle" style="">Login <span class="caret"></span></button>
					<ul class="dropdown-menu dropdown-menu-right mt-1">
						<li class="p-3">
							<form class="form" role="form">
								<div class="form-group">
									<input id="emailInput" placeholder="Email" class="form-control form-control-sm" type="text" required="">
								</div>
								<div class="form-group">
									<input id="passwordInput" placeholder="Password" class="form-control form-control-sm" type="text" required="">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">Login</button>
								</div>
								<div class="form-group text-xs-center">
									<small><a href="#">Forgot password?</a></small>
								</div>
							</form>
						</li>
					</ul>
				</li>
			</li>
			</ul>
		</div>
	</div>
</nav>

<div class="mt-5 containeruno"><h1 class="display-4 text-center">Gestionale Scuola</h1></div>
<DIV align="center">
<FORM method="post" action="/WebProjectMavenized/CtrlMain">
<TABLE class=" table table-dark table-stripe" style=" width: 30%">
	<TBODY>
		<TR>
			<TD><INPUT type="radio" name="rdoScelta" value="0"></TD>
			<TD><i class="fa-solid fa-user-tie"></i> Archivio&nbsp;Docente </TD>
		</TR>
		<TR>
			<TD><INPUT type="radio" name="rdoScelta" value="1" ></TD>
			<TD><i class="fa-solid fa-user-graduate"></i> Archivio&nbsp;Discente </TD>
		</TR>
		<TR>
			<TD><INPUT type="radio" name="rdoScelta" value="2" ></TD>
			<TD> <i class="fa-solid fa-brain"></i> Archivio&nbsp;Aula</TD>
		</TR>
		<TR>
			<TD><INPUT type="radio" name="rdoScelta" value="3" ></TD>
			<TD> <i class="fa-solid fa-building-user"></i> Gestione&nbsp;Corso</TD>
		</TR>
		<TR>

			<TD><INPUT type="radio" class="border border-3" name="rdoScelta" value="4"  ></TD>
			<TD><i class="fa-solid fa-file-export"></i> Ricerca&nbsp;Corso&nbsp;Per&nbsp;Discente </TD>
		</TR>
		<TR>
			<TD><INPUT type="radio" name="rdoScelta" value="5" ></TD>
			<TD><i class="fa-solid fa-file-export"></i> Ricerca&nbsp;Corso&nbsp;Per&nbsp;Docente </TD>
		</TR>

	</TBODY>

</TABLE>

<BR>
<INPUT type ="submit" name="cmdInvio" value="Invio"  class="btn btn-dark"></DIV>
</form>
</DIV>
<DIV ALIGN="center"><br>
</div>
<footer class="text-center bg-body-tertiary fixed-bottom">
	<!-- Grid container -->
	<div class="container pt-4">
		<!-- Section: Social media -->
		<section class="mb-4">
			<!-- Facebook -->
			<a
					data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1"
					href="#!"
					role="button"
					data-mdb-ripple-color="dark"
			><i class="fab fa-facebook-f"></i
			></a>

			<!-- Twitter -->
			<a
					data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1"
					href="#!"
					role="button"
					data-mdb-ripple-color="dark"
			><i class="fab fa-twitter"></i
			></a>

			<!-- Google -->
			<a
					data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1"
					href="#!"
					role="button"
					data-mdb-ripple-color="dark"
			><i class="fab fa-google"></i
			></a>

			<!-- Instagram -->
			<a
					data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1"
					href="#!"
					role="button"
					data-mdb-ripple-color="dark"
			><i class="fab fa-instagram"></i
			></a>

			<!-- Linkedin -->
			<a
					data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1"
					href="#!"
					role="button"
					data-mdb-ripple-color="dark"
			><i class="fab fa-linkedin"></i
			></a>
			<!-- Github -->
			<a
					data-mdb-ripple-init
					class="btn btn-link btn-floating btn-lg text-body m-1"
					href="#!"
					role="button"
					data-mdb-ripple-color="dark"
			><i class="fab fa-github"></i
			></a>
		</section>
		<!-- Section: Social media -->
	</div>
	<!-- Grid container -->

	<!-- Copyright -->
	<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05);">
		© 2024 Copyright:
		<a class="text-body" href="">DiGiuseppeDomenico97@gmail.com</a>
	</div>
	<!-- Copyright -->
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script></BODY>
</HTML>
