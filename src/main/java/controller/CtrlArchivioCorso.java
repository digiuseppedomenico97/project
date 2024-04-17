package controller;

import model.dao.CorsoService;
import model.session.Corso;
import model.session.Docente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CtrlArchivioCorso
 *
 */
@WebServlet("/CtrlArchivioCorso")
public class CtrlArchivioCorso extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private CorsoService oCorsoService = new CorsoService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlArchivioCorso() {
        super();
        // TODO Auto-generated constructor stub
    }



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    //questo metodo gestisce quali azioni devono essere fatte, quindi quali pagine html devono esssere tornate indietgro all'utente
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String azione = request.getParameter("cmdAzione");
        if(azione == null)
        {
            visualizzaElenco(request, response);
        }
        else if(azione.equals("Torna alla Home"))
        {
            getServletContext().getRequestDispatcher("/CtrlMain").forward(request, response);
        }
        else if(azione.equals("Nuovo"))
        {
            nuovoCorso(request, response);
        }
        else if(azione.equals("Annulla"))
        {
            visualizzaElenco(request, response);
        }
        else if(azione.equals("Registra"))
        {
            salvaCorso(request, response);
            visualizzaElenco(request, response);
        }
        else if(azione.equals("Modifica"))
        {
            modificaCorso(request, response);
        }
        else if(azione.equals("Elimina"))
        {
            eliminaCorso(request, response);
        }
        else if(azione.equals("Conferma"))
        {
            cancellaCorso(request, response);
            visualizzaElenco(request, response);
        }
    }

    private void cancellaCorso(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        oCorsoService.delete(((Corso) request.getSession().getAttribute("beanCorso")));
    }

    private void eliminaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getSession().setAttribute("beanCorso", oCorsoService.findById(Integer.parseInt(request.getParameter("rdoIDCorso"))));
        getServletContext().getRequestDispatcher("/ArchivioCorso/PgsArchivioCorsoElimina.jsp").forward(request, response);
    }

    private void modificaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getSession().setAttribute("beanCorso", oCorsoService.findById(Integer.parseInt(request.getParameter("rdoIDCorso"))));
        getServletContext().getRequestDispatcher("/ArchivioCorso/PgsArchivioCorsoNuovoModifica.jsp").forward(request, response);
    }

    private void salvaCorso(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        Corso beanCorso = ((Corso) request.getSession().getAttribute("beanCorso"));
        beanCorso.setNome(request.getParameter("txtNome"));
        beanCorso.setDurata(Integer.parseInt(request.getParameter("txtDurata")));
        Docente oDocente= new Docente();
        oDocente.setChiave(Integer.parseInt(request.getParameter("rdoIDDocente")));
        beanCorso.setoDocente(oDocente);
        if(beanCorso.getChiave() == 0)
            oCorsoService.persist(beanCorso);
        else
            oCorsoService.update(beanCorso);
    }

    private void nuovoCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Corso oCorso = new Corso();
        HttpSession oSessione = request.getSession();
        oSessione.setAttribute("beanCorso", oCorso);
        getServletContext().getRequestDispatcher("/ArchivioCorso/PgsArchivioCorsoNuovoModifica.jsp").forward(request, response);
    }

    private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Corso> elenco = oCorsoService.findAll();

        request.setAttribute("elencoCorsi", elenco);
        //Definizione di un oggetto della classeServletContext
        ServletContext oContesto = getServletContext();
        //Definizione di un oggetto per la pubblicazione della PGS
        RequestDispatcher oDispatcher = oContesto.getRequestDispatcher("" +
                "/ArchivioCorso/PgsArchivioCorso.jsp");
        oDispatcher.forward(request, response);
    }
}
