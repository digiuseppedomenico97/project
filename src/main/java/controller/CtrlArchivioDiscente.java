package controller;

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

import model.dao.DiscenteService;

import model.session.Discente;


/**
 * Servlet implementation class CtrlArchivioDocente
 *
 */
@WebServlet("/CtrlArchivioDiscente")
public class CtrlArchivioDiscente extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private DiscenteService oDiscenteService = new DiscenteService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CtrlArchivioDiscente() {
        super();
        // TODO Auto-generated constructor stub
    }



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
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
            nuovoDiscente(request, response);
        }
        else if(azione.equals("Annulla"))
        {
            visualizzaElenco(request, response);
        }
        else if(azione.equals("Registra"))
        {
            salvaDiscente(request, response);
            visualizzaElenco(request, response);
        }
        else if(azione.equals("Modifica"))
        {
            modificaDiscente(request, response);
        }
        else if(azione.equals("Elimina"))
        {
            eliminaDiscente(request, response);
        }
        else if(azione.equals("Conferma"))
        {
            cancellaDiscente(request, response);
            visualizzaElenco(request, response);
        }
    }

    private void cancellaDiscente(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        oDiscenteService.delete(((Discente) request.getSession().getAttribute("beanDiscente")));
    }

    private void eliminaDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getSession().setAttribute("beanDiscente", oDiscenteService.findById(Integer.parseInt(request.getParameter("rdoIDDiscente"))));
        getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteElimina.jsp").forward(request, response);
    }

    private void modificaDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.getSession().setAttribute("beanDiscente", oDiscenteService.findById(Integer.parseInt(request.getParameter("rdoIDDiscente"))));
        getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteNuovoModifica.jsp").forward(request, response);
    }

    private void salvaDiscente(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        ((Discente) request.getSession().getAttribute("beanDiscente")).setCognome(request.getParameter("txtCognome"));
        ((Discente) request.getSession().getAttribute("beanDiscente")).setNome(request.getParameter("txtNome"));
        if(((Discente) request.getSession().getAttribute("beanDiscente")).getChiave() == 0)
            oDiscenteService.persist(((Discente) request.getSession().getAttribute("beanDiscente")));
        else
            oDiscenteService.update(((Discente) request.getSession().getAttribute("beanDiscente")));
    }

    private void nuovoDiscente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Discente oDiscente = new Discente();
        HttpSession oSessione = request.getSession();
        oSessione.setAttribute("beanDiscente", oDiscente);
        getServletContext().getRequestDispatcher("/ArchivioDiscente/PgsArchivioDiscenteNuovoModifica.jsp").forward(request, response);
    }

    private void visualizzaElenco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Discente> elenco = oDiscenteService.findAll();

        request.setAttribute("elencoDiscenti", elenco);
        //Definizione di un oggetto della classeServletContext
        ServletContext oContesto = getServletContext();
        //Definizione di un oggetto per la pubblicazione della PGS
        RequestDispatcher oDispatcher = oContesto.getRequestDispatcher("" +
                "/ArchivioDiscente/PgsArchivioDiscente.jsp");
        oDispatcher.forward(request, response);
    }
}
